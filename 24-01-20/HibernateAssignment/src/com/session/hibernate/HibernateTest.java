package com.session.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.session.dto.Item;
import com.session.dto.Market;
import com.session.dto.Order;
import com.session.dto.User;

public class HibernateTest {
	public static void main(String[] args) {
		
		Item item1 = new Item(10,"Orange",5,50);
		Item item2 = new Item(20,"Moblie",4,100000);
		Item item3 = new Item(30,"Mug",8,680);
		Item item4 = new Item(40,"Bag",15,900);
		Item item5 = new Item(50,"Pen",9,50);
		
		Market market = new Market();
		market.setMarketId(999);
		
		List<Item> inventory = new ArrayList<Item>();
		inventory.add(item1);
		inventory.add(item2);
		inventory.add(item3);
		inventory.add(item4);
		inventory.add(item5);
		market.setInventory(inventory);
		
		List<User> users = new ArrayList<User>();
		
		User user1 = new User(1,"Sheenam");
		User user2 = new User(2,"Peacock");
		users.add(user1);
		users.add(user2);
		market.setUsers(users);
		
		market.addToCart(user1, item1);
		market.addToCart(user1, item2);
		market.removeFromCart(user1, item1);
		market.addToCart(user1, item3);
		
		market.addToCart(user2, item3);
		market.addToCart(user2, item4);
		market.addToCart(user2, item5);
		market.placeOrder(user2);
		
		Order order1 = market.getOrder(user1);
		Order order2 = market.getOrder(user2);
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(item1);
		session.save(item2);
		session.save(item3);
		session.save(item4);
		session.save(item5);
		session.save(user1);
		session.save(user2);
		session.save(market);
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		//1.HQL Query
		List<User> result = session2.createQuery("from User", User.class).getResultList();
		System.out.println("HQL Query");
		for(User u: result) {
			System.out.println(u.getName());
		}
		
		List<Item> result2 = session2.createQuery("from Item", Item.class).getResultList();
		for(Item i: result2) {
			System.out.println(i.getName()+" Qty: "+i.getQty()+" Price: "+i.getPrice());
		}
		
		//2. See HQL Named Query in User.
		Query query = session2.getNamedQuery("HQL_GET_ALL_NAMES");
		result = query.getResultList();
		System.out.println("Named Query");
		for(User u: result) {
			System.out.println(u.getName());
		}
		
		//3. See Native Query in Item
		Query query2 = session2.getNamedNativeQuery("SQL_GET_ALL_ITEMS");
		List<Object[]> ItemObjArray = query2.getResultList();
		System.out.println("Named Native Query (List of item objects)");
		for(Object[] i: ItemObjArray) {
//			Item item = (Item) i[0];
//			Item item = (Item) i[0];
			System.out.println(i);
		}
	}

}
