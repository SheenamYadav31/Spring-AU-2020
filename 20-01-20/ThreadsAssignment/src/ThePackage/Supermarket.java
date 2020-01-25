package ThePackage;

import java.util.*;

public class Supermarket {
	
	public static List<fruit> fruits = new ArrayList<fruit>(); 
	
	public static int total;
	
	public List<Thread> consumers = new ArrayList<Thread>(); 
	
	public List<Thread> farmers = new ArrayList<Thread>(); 
	
	public static boolean isFull(int s) {
		if(total >= 40) return true;
		return false;
	}
	
	public static boolean canSell(fruit fru) {
		for(fruit f :fruits) {
			if(fru.getName().equals(f.getName()) && f.isAvailable(fru.getQuantity())) return true;
		}
		return false;
	}
	
	public void createCustomers() {
		
		Scanner in = new Scanner(System.in);
		String ch3;
		
		Consumer c = new Consumer();
		Thread tc = new Thread(c,String.valueOf(consumers.size() + 1));
		consumers.add(tc);
		System.out.println("Customer ID (Thread): "+ String.valueOf(consumers.size() + 1));
		
		System.out.println("Buy a fruit? (Y/N)");
		ch3 = in.nextLine();
		
		if(ch3.equals("Y")||ch3.equals("y")) {
			c.buyFruit();
			//tc.start();
		}
	}
	
	public void createFarmers() {
		
		Scanner in = new Scanner(System.in);
		String ch3;
		
		Farmer f = new Farmer();
		Thread tf = new Thread(f, String.valueOf(farmers.size()+1));
		farmers.add(tf);
		System.out.println("Farmer ID (Thread): "+String.valueOf(farmers.size()+1));
		
		System.out.println("Sell your fruit? (Y/N)");
		ch3 = in.nextLine();
		if(ch3.equals("Y")||ch3.equals("y")) {
			f.sellMyFruit();
			tf.start();
		}
	}
	
	public static String sellThisFruit(fruit fru) {
		for(fruit f: fruits) {
			if(fru.getName().equals(f.getName())) {
				f.setQuantity(f.getQuantity() - fru.getQuantity());
				return ", You will receive "+fru.getQuantity()+" "+fru.getName()+".";
			}
		}
		return "This fruit is unavailable.";
	}
	
	public static void ViewSupermarket() {
		int i=0;
		System.out.println("-------------------------The Supermarket-------------------------");
		System.out.println("Current Inventory");
		for(fruit f : fruits) {
			i++;
			System.out.println(i+". We have "+f.getQuantity()+" "+f.getName());
		}
	}
	
	public Supermarket(){
		this.fruits.add(new fruit("Mango",10));
		this.fruits.add(new fruit("Apple",7));
		this.fruits.add(new fruit("Orange",9));
		this.fruits.add(new fruit("Kiwi",4));
		this.fruits.add(new fruit("Papaya",5));
	}
	
	public static void main(String[] args) {
		
		Supermarket market = new Supermarket();	
		Scanner in = new Scanner(System.in);
//		int ch1;
//		String ch2;
//		String ch3;
//		String fruitname;
//		int fruitqty;
//		int id;
		
		
		market.ViewSupermarket();
		
		System.out.println("========================WELCOME===========================");
		
		System.out.println("Enter no. of Customers: ");
		int m = in.nextInt();
		
		System.out.println("Enter no. of Farmers: ");
		int n = in.nextInt();
		
		System.out.println("Creating Customers");
		for(int i=0;i<m;i++) {
			market.createCustomers();
		}
		
		System.out.println("Creating Farmers");
		for(int i=0;i<n;i++) {
			market.createFarmers();
		}
		
		for( Thread cust : market.consumers) {
			if(!cust.isAlive())
			{
			cust.start();
			}
		}
		
		for(Thread far : market.farmers) {
			if(!far.isAlive())
			{
			far.start();
			}
		}
		
		
//		do {
//			System.out.println("1. Enter as New Consumer");
//			System.out.println("2. Enter as New Farmer");
//			System.out.println("3. Enter as Existing Consumer");
//			System.out.println("4. Enter as Existing Farmer");
//			System.out.println("5. View Supermarket Inventory");
//			System.out.println("Enter your choice: ");
//			ch1 = in.nextInt();in.nextLine();
//			
//			switch(ch1) {
//				case 1: Consumer c = new Consumer();
//						Thread tc = new Thread(c,String.valueOf(market.consumers.size() + 1));
//						market.consumers.add(tc);
//						System.out.println("Customer ID (Thread): "+ String.valueOf(market.consumers.size() + 1));
//						
//						System.out.println("Buy a fruit? (Y/N)");
//						ch3 = in.nextLine();
//						
//						if(ch3.equals("Y")||ch3.equals("y")) {
//							c.buyFruit();
//							tc.start();
//						}
//						break;
//				
//				case 2: Farmer f = new Farmer();
//						Thread tf = new Thread(f, String.valueOf(market.farmers.size()+1));
//						market.farmers.add(tf);
//						System.out.println("Farmer ID (Thread): "+String.valueOf(market.farmers.size()+1));
//						
//						System.out.println("Sell your fruit? (Y/N)");
//						ch3 = in.nextLine();
//						if(ch3.equals("Y")||ch3.equals("y")) {
//							f.sellMyFruit();
//							tf.start();
//						}
//						break;
//						
//				case 3: System.out.println("Enter your ID: ");
//						id = in.nextInt(); in.nextInt();
//				
//				case 4: break;
//				
//				case 5: market.ViewSupermarket();
//				
//				default: System.out.println("Please enter a valid choice.");
//			}
//			
//			System.out.println("Do you want to continue: (Y/N)");
//			ch2 = in.nextLine();
//			
//		}while(ch2.equals("Y")||ch2.equals("y"));
		System.out.println("Goodbye!!!");
	}

}

