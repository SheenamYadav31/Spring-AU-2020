package com.session.dto;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
@Table(name="ORDER_DETAILS")
public class Order {
	
	@Id
	long orderId;
	int orderBill=0;

	@ElementCollection(fetch=FetchType.EAGER)
	@GenericGenerator(name="s",strategy="sequence")
	@CollectionId(columns= {@Column(name="Address_Id")}, generator="s", type=@Type(type="long"))
	private static Map<Integer,Cart> allOrders = new HashMap<Integer, Cart>();
	
	public Order() {
		
	}
	
	public void placeOrder(User user, Cart myCart){
		for(Map.Entry<Integer, Cart> i: allOrders.entrySet()) {
			if(i.getKey() == user.getId()) {
				for(Item item : myCart.getMyItems()) {
					i.getValue().addItem(item);
					orderBill += item.getPrice();
				}
				System.out.println("The Order bill is: "+this.orderBill);
				user.getMyOrder().orderId = (System.nanoTime());
				user.setMyCart(null);
				return;
			}
		}
		user.setMyCart(null);
		allOrders.put(user.getId(), myCart);
	}
	
	public void cancelOrder(Market market,User user, Cart myCart) {
		for(Map.Entry<Integer, Cart> i: allOrders.entrySet()) {
			if(i.getKey() == user.getId()) {
				for(Item item : i.getValue().getMyItems()) {
					market.returnItem(item);
				}
			}
		}
	}
	
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long l) {
		this.orderId = l;
	}

	public int getOrderBill() {
		return orderBill;
	}

	public void setOrderBill(int orderBill) {
		this.orderBill = orderBill;
	}

	public static Map<Integer, Cart> getAllOrders() {
		return allOrders;
	}

	public static void setAllOrders(Map<Integer, Cart> allOrders) {
		Order.allOrders = allOrders;
	}

}
