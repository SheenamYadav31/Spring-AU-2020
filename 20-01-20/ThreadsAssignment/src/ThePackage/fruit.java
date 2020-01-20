package ThePackage;

public class fruit {

	private String name;
	private int quantity;
	
	public fruit(String name, int qty) {
		this.name = name;
		this.quantity = qty;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setQuantity(int qty) {
		this.quantity = qty;
	}
	
	public String getName() {
		return this.name;
	}
	public int getQuantity() {
		return this.quantity;
	}
	
	public boolean isAvailable(int qty) {
		return this.quantity>=qty;
	}
}
