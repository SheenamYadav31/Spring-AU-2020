package ShoppingCart;

import java.util.*;
import ShoppingCart.item;
import ShoppingCart.myuser;

public class ShoppingCartClass extends myuser {
	
	List<item> itemarr = new ArrayList<item>();
	public Map <myuser, ArrayList> myCart = new HashMap <myuser, ArrayList>();
	private myuser user;
	private int OrderPayment=0;
	
	public ShoppingCartClass(myuser user){
		super (user.user_id, user.user_name);
		this.user = user;
	}
	
	public item getItemFromList(int id) {
		for(item i: itemarr) {
			if(i.getItemId() == id) return i;
		}
		return null;
	}
	
	public void AddNewItem(item i, boolean flg) {
		
		if(itemarr.contains(i)) {if(flg)System.out.println("Item Updated: "+i);} //i.setQty(i.getQty()+1);
		else {
			itemarr.add(i);
			if(flg)System.out.println("Item Added: "+i);
		}
	}
	
	public void AddtoCart(item i) {
		myuser u = this.user;
		if(i.itemAvailable()) {
			int qty = i.getQty();
			i.setQty(qty-1); 
			ArrayList<item> temp = new ArrayList<item>();
			if(myCart.get(u)!=null)temp = myCart.get(u);
			temp.add(i);
			myCart.put(u,temp);
		}
		else {
			System.out.println("Sorry this item is not available at the moment.");
		}
		
	}
	
	public void ViewItems() {
		int cntr = 1;
		for(item i: itemarr) {
			System.out.println(cntr+". "+i);
			cntr++;
		}
		
	}
	
	public void ViewCart() {
		Set s = this.myCart.entrySet();
		Iterator i = s.iterator();
		if(!i.hasNext()) 
			System.out.println("Shopping cart of this user is Empty.");
		while(i.hasNext()) {
			Map.Entry m = (Map.Entry)i.next();
			myuser u = (myuser)m.getKey();
			ArrayList<item> li = (ArrayList<item>)m.getValue();
			System.out.println("======================================"+this.user.getUserName()+"'s Shopping Cart======================================");
			if(li.size()>0) {
				System.out.println();
				int cnt=1;
				for(item curr_itm:li) {
					System.out.println(cnt+". "+"Item Id: "+curr_itm.getItemId()+" Item name: "+curr_itm.getItemName());
					cnt++;
				}
				System.out.println("---------------------------------------------------------------------------------------------------");
			}
			else {
				System.out.println("Shopping Cart  of User is Empty."); return;
			}
		}
	}
	
	public void RemoveFromCart(item i) {
		myuser u = this.user;
		if(myCart.get(u)!=null) {
			ArrayList<item> temp = new ArrayList<item>();
			temp = myCart.get(u);
			boolean removed_itm =temp.remove(i);
			if(removed_itm) System.out.println(i+" was removed from the Shopping Cart of the user "+u);
			else System.out.println("Item: "+i+"could not be removed.");
			
		}
		else {
			System.out.println("This user has no items to remove from cart.");
		}
	}
	
	public void placeOrder() {
		int cnt =0 ;
		ArrayList<item> temp = new ArrayList<item>();
		temp = myCart.get(user);
		if(temp.size()<=0) {
			System.out.println("Cannot Place order. Cart Empty!!");
			return;
		}
		for(item i : temp) {
			OrderPayment += i.getPrice();
		}
		System.out.println("Thakyou! "+this.user+" for placing the order. Order placed successfully!");
		System.out.println("==========================ORDER DETAILS==========================");
		for(item i:temp) {
			System.out.println(cnt+". "+i);
			cnt++;
		}
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Total Amount Payable : "+OrderPayment);
		myCart.remove(user);
	}
	
	public void cancelOrder() {
		ArrayList<item> temp = new ArrayList<item>();
		temp = myCart.get(user);
		for(item i:temp) {
			for(item j:itemarr) {
				if(i.getItemId() == j.getItemId()) {
					j.setQty(j.getQty()+i.getQty());
				}
			}
		}
		myCart.remove(user);
		System.out.println("----------------------------ORDER CANCELLED---------------------------");
	}
	
	
	
	public static void main(String[] args) {
		
		item I1 = new item(10, "Fruit", 30,100);
		item I2 = new item(20, "Chocolate", 28, 50);
		item I3 = new item(30, "Pen", 3, 5);
		item I4 = new item(40, "Juice", 16, 90);
		item I5 = new item(50, "Biscuits", 19, 40);
		item I6 = new item(60, "Shoe", 4, 1000);
		item I7 = new item(70, "Bag", 2, 3000);
		item I8 = new item(100, "Mobile",0, 10000);
		item I9 = new item(70, "Jam", 1, 150);
		
		Scanner in = new Scanner(System.in);
		int ch1;
		System.out.println("Please enter your details: ");
		System.out.println("User Id: ");
		int id = in.nextInt();
		in.nextLine();
		System.out.println("User Name: ");
		String name = in.nextLine();
	
		myuser newUser = new myuser(id,name);
		ShoppingCartClass cart = new ShoppingCartClass(newUser);
		cart.AddNewItem(I1,false);
		cart.AddNewItem(I2,false);
		cart.AddNewItem(I3,false);
		cart.AddNewItem(I4,false);
		cart.AddNewItem(I5,false);
		cart.AddNewItem(I6,false);
		cart.AddNewItem(I7,false);
		cart.AddNewItem(I8,false);
		cart.AddNewItem(I9,false);
		
		System.out.println("Hello! "+name);
		
		String ch2 = "Y";
		
		do {
			System.out.println("Please enter your choice: ");
			System.out.println("1. View Items");
			System.out.println("2. View My Cart");
			System.out.println("3. Add Item to Cart");
			System.out.println("4. Remove Item From Cart");
			System.out.println("5. Place Order");
			System.out.println("6. Add Items (this feature is for SELLERS only)");
			System.out.println("7. Cancel Order");
			
			
			ch1 = in.nextInt();
			in.nextLine();
		
			switch(ch1) {
			
				case 1: cart.ViewItems();
						break;
						
				case 2: cart.ViewCart();
						break;
						
				case 3: System.out.println("Enter Item id: ");
						int i_id = in.nextInt();
						in.nextLine();
						item i = cart.getItemFromList(i_id);
						if(i!=null) {
							cart.AddtoCart(i);
							cart.ViewCart();
						}
						else System.out.println("Sorry this item is not available");
						break;
						
				case 4: System.out.println("Enter Item id: ");
						int i_id2 = in.nextInt();
						in.nextLine();
						item i2 = cart.getItemFromList(i_id2);
						if(i2!=null) cart.RemoveFromCart(i2);
						else System.out.println("Item can not be removed");
						cart.ViewCart();
						break;
						
				case 5: cart.placeOrder();
						break;
						
				case 6: System.out.println("Enter Item id: ");
						int i_id3 = in.nextInt();
						in.nextLine();
						System.out.println("Enter Item name: ");
						String i_name = in.nextLine();
						in.nextLine();
						System.out.println("Enter Item quantity: ");
						int i_qty3 = in.nextInt();
						in.nextLine();
						System.out.println("Enter Item price: ");
						int i_price = in.nextInt();
						in.nextLine();
						item itm = new item(i_id3,i_name,i_qty3,i_price);
						cart.AddNewItem(itm,true);
						break;
						
				case 7: cart.cancelOrder();
						System.out.println("Order Cancelled. Your Cart is empty now.");
						break;
						
				default: System.out.println("Enter Correct choice!!");
				
			}
		System.out.println("Do you want to continue? (Y/N): ");
		//in.nextLine();
		ch2 = in.nextLine();
		}while(ch2.equals("Y")||ch2.equals("y"));
		
		System.out.println("Bye Bye!!");
		
//		myuser A = new myuser(1, "Sheenam");
//		
//		myuser B = new myuser(2, "Yadav");
//		myuser C = new myuser(3,"Person");
//		myuser D = new myuser(4, "Random");
//		
//		item I1 = new item(10, "Fruit", 30);
//		item I2 = new item(20, "Chocolate", 28);
//		item I3 = new item(30, "Pen", 3);
//		item I4 = new item(40, "Juice", 16);
//		item I5 = new item(50, "Biscuits", 19);
//		item I6 = new item(60, "Shoe", 4);
//		item I7 = new item(70, "Bag", 2);
//		item I8 = new item(100, "Mobile",0);
//		item I9 = new item(70, "Jam", 1);
//		
//		ShoppingCartClass objA = new ShoppingCartClass(A);
//		ShoppingCartClass objB = new ShoppingCartClass(B);
//		ShoppingCartClass objC = new ShoppingCartClass(C);
//		ShoppingCartClass objD = new ShoppingCartClass(D);
//		
//		System.out.println("USER  A: ");
//		objA.AddtoCart(I1);
//		objA.ViewCart();
//		objA.AddtoCart(I2);
//		objA.AddtoCart(I4);
//		objA.AddtoCart(I7);
//		objA.AddtoCart(I6);
//		objA.AddtoCart(I9);
//		objA.ViewCart();
//		
//		System.out.println("USER  B: ");
//		objB.ViewCart();
//		
//		System.out.println("USER  C: ");
//		objC.AddtoCart(I8);
//		
//		
//		System.out.println("USER  D: ");
//		objD.AddtoCart(I2);
//		objD.AddtoCart(I4);
//		objD.AddtoCart(I5);
//		objD.AddtoCart(I6);
//		objD.ViewCart();
//		objD.RemoveFromCart(I5);
//		
//		
//		
//		//item details
//		I1.displayDetails();
//		I7.displayDetails();
//		I8.displayDetails();
//		I9.displayDetails();
//		
//		System.out.println("Add new item to Item List. (Update if already present.)");
//		objD.AddNewItem(90, "Peacock", 1);
//		
//		//System.out.println(objA.myCart.get(A));
//		
	}

}
