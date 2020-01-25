package ThePackage;

import java.util.Scanner;

public class Farmer implements Runnable{

	private fruit currentFruit;
	private boolean success=false;
	
	public void sellMyFruit() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Fruit Name: ");
		String fruitname  = in.nextLine();
		System.out.println("Enter Quantity: ");
		int fruitqty = in.nextInt();
		this.currentFruit = new fruit(fruitname, fruitqty);
	}
	
	public fruit getMatchedFruit(fruit currentfruit) {
		for(fruit f : Supermarket.fruits) {
			if(f.getName().equals(currentFruit.getName())){
				return f;
			}
		}
		fruit temp = new fruit(currentfruit.getName(),0);
		Supermarket.fruits.add(temp);
		return temp;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
		
		try {
			Thread.sleep(1000);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		fruit matchedfruit = getMatchedFruit(currentFruit);
		synchronized (Supermarket.fruits) {
			if(!success && !Supermarket.isFull(Supermarket.total+currentFruit.getQuantity()+matchedfruit.getQuantity())) {
				for(fruit f : Supermarket.fruits) {
					if(f.getName().equals(currentFruit.getName())){
						f.setQuantity(currentFruit.getQuantity()+f.getQuantity());
						Supermarket.total = Supermarket.total+currentFruit.getQuantity()+f.getQuantity();
						System.out.println("Hello, Farmer (Thread)"+Thread.currentThread().getName()+" ,Your fruit stock is sold.");
						break;
					}
				}
			}
			System.out.println("---------------Updated Inventory---------------------");
			Supermarket.ViewSupermarket();
		}
	}
}
