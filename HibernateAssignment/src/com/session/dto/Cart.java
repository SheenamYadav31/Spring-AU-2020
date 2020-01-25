package com.session.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Embeddable
public class Cart {
	@Id
	private User user;

	
	@OneToMany
	@JoinTable(name="USER_CART", joinColumns=@JoinColumn(name="USER_ID"),inverseJoinColumns=@JoinColumn(name="ITEM_ID"))
	private List<Item> myItems = new ArrayList<Item>();
	
	public void addItem(Item item) {
		this.myItems.add(item);
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Item> getMyItems() {
		return myItems;
	}

	public void setMyItems(List<Item> myItems) {
		this.myItems = myItems;
	}

	public void removeItem(Item item) {
		this.myItems.remove(item);
	}

}
