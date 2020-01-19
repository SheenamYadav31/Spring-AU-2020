package ShoppingCart;

import java.util.*;

public class item {
	private int item_id;
	private String item_name;
	private int item_count;
	
	public item(int id, String name, int cnt) {
		this.item_id = id;
		this.item_name = name;
		this.item_count = cnt;
	}
	
	public int getItemId() {
		return this.item_id;
	}
	
	public String getItemName() {
		return this.item_name;
	}
	
	public int getQty() {
		return this.item_count;
	}
	
	public void setId(int id) {
		this.item_id = id;
	}
	public void setName(String name) {
		this.item_name = name;
	}
	
	public void setQty(int qty) {
		this.item_count = qty;
	}
	
	public boolean itemAvailable(){
		if(this.item_count > 0) return true;
		else return false;
	}
	
	public void displayDetails() {
		System.out.println("Item Details: ");
		System.out.print("Item with id: "+this.getItemId()+" , Item Name: "+this.getItemName());
		if(this.itemAvailable()) System.out.println(" is available with quantity: "+this.getQty());
		else System.out.println(" is not available presently.");
	}
	
	@Override
	public String toString() {
		return "Item: Item_id: "+this.item_id+" Item Name: "+this.item_name;
	}
}
