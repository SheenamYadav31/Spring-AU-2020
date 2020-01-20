package ThePackage;

import java.util.Scanner;

public class Consumer implements Runnable{
	
	private fruit selectedfruit;
	private boolean success=false;
	
	public boolean buyFruit() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Fruit Name: ");
		String fruitname  = in.nextLine();
		System.out.println("Enter Quantity: ");
		int fruitqty = in.nextInt();
		this.selectedfruit = new fruit(fruitname, fruitqty);
		return Supermarket.canSell(this.selectedfruit);
	}

	public void run() {
		while(true) {	
			//buyFruit();
			synchronized(Supermarket.fruits) {
				if(Supermarket.canSell(selectedfruit) && !success) {
					
					System.out.println("Hello Customer: "+Thread.currentThread().getName() + Supermarket.sellThisFruit(selectedfruit));
					success=true;
					Supermarket.fruits.notify();
					try {
						Thread.sleep(1000);
					}catch(Exception e) {
						System.out.println(e);
					}
				}else {
					try {
						Supermarket.fruits.wait();
					}catch(InterruptedException e) {
						System.out.println(e);
					}
					System.out.println("Customer Thread - "+Thread.currentThread().getName()+" : received 'notify()'");
				}
			}
		}
		
	}

}
