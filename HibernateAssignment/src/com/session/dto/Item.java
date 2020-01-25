package com.session.dto;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQueries({ 
	@NamedNativeQuery(name = "SQL_GET_ALL_ITEMS", 
					   query = "select id, Item_name, price, qty from Item") })

public class Item {
	@Id
	private int id;
	
	@Basic
	@Column(name="Item_name")
	private String name;
	private int qty;
	private int price;
	public int getId() {
		return id;
	}
	
	public Item() {
		
	}
	public Item(int id, String name, int qty, int price) {
		super();
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", qty=" + qty + ", price=" + price + "]";
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
