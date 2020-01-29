package com.session.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="USER_DETAILS")
@NamedQueries({
	@NamedQuery(name="HQL_GET_ALL_NAMES",
				query="from User")
})
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)    //surogate key
	private int id;
	private String name;
	
	@Embedded
	private static Cart myCart;

	@OneToOne
	@JoinColumn(name="ORDER_ID")
	private Order myOrder;
	
	public User() {
		
	}
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
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

	public static Cart getMyCart() {
		return myCart;
	}

	public Order getMyOrder() {
		return myOrder;
	}
	public void setMyOrder(Order myOrder) {
		this.myOrder = myOrder;
	}
	public void setMyCart(Cart myCart) {
		this.myCart = myCart;
	}

}
