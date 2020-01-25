package com.session.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Market {
	
	@Id
	private int marketId;
	
	
	@OneToMany
	@JoinTable(name="MARKET_CUSTOMERS", joinColumns=@JoinColumn(name="MARKET_ID"),inverseJoinColumns=@JoinColumn(name="USER_ID"))
	private List<User> users = new ArrayList<User>();
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id", column =@Column(name="ITEM_ID")),
		@AttributeOverride(name="name", column =@Column(name="ITEM_QTY"))
	})
	private static List<Item> inventory = new ArrayList<Item>();
	
	public static void sellItem(Item item) {
		inventory.remove(item);
	}
	
	public static void returnItem(Item item) {
		inventory.add(item);
	}
	
	public void addToCart(User user,Item item) {
		this.sellItem(item);
		if(user.getMyCart()!=null)user.getMyCart().addItem(item);
		else {
			List<Item> li = new ArrayList<Item>();
			li.add(item);
			Cart cart = new Cart();
			cart.setMyItems(li);
			user.setMyCart(cart);
		}
	}
	
	public void removeFromCart(User user,Item item) {
		user.getMyCart().removeItem(item);
	}
	
	public void placeOrder(User user) {
		if(user.getMyOrder()!=null) {
			user.getMyOrder().placeOrder(user, user.getMyCart());
		}
		else {
			//order cannot be placed for null cart
		}
		
	}
	
	public void cancelOrder(User user) {
		user.getMyOrder().cancelOrder(this, user, user.getMyCart());
	}
	
	public Order getOrder(User user){
		return user.getMyOrder();
	}

	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Item> getInventory() {
		return inventory;
	}
	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}

	public int getMarketId() {
		return marketId;
	}

	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}
	
	
}
