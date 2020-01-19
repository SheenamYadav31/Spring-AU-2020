package ShoppingCart;

import java.util.*;
public class myuser {
	
	int user_id;
	String user_name;
	
	public myuser(int id, String name) {
		this.user_id=id;
		this.user_name=name;
	}
	
	public int getUserId() {
		return user_id;
	}
	public String getUserName() {
		return user_name;
	}
	public void setUserName(String user_name) {
		this.user_name = user_name;
	}
	public void setUserId(int id) {
		this.user_id = id;
	}
	
	@Override
	public String toString() {
		return "USER with User_id: "+this.user_id+" user_name: "+this.user_name;
	}
	
//	public static void main(String[] args) {
//		System.out.println("USEr");
//	}
}
