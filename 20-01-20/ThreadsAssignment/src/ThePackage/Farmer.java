package ThePackage;

import java.util.Scanner;

public class Farmer implements Runnable{

	private fruit currentFruit;
	
	public void sellMyFruit() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Fruit Name: ");
		String fruitname  = in.nextLine();
		System.out.println("Enter Quantity: ");
		int fruitqty = in.nextInt();
		this.currentFruit = new fruit(fruitname, fruitqty);
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
		
		try {
			Thread.sleep(1000);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		synchronized (Supermarket.fruits) {
			
			for(int i=1;i<=5;i++) {
				Supermarket.fruits.add(currentFruit);
				//Flipcart.inventory.notify();
				Supermarket.fruits.notifyAll();
			}
			System.out.println("Size of Inventory: "+ Supermarket.fruits.size());
			
		}
	}
}
