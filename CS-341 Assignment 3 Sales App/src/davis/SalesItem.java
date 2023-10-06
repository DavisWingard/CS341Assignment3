package davis;

public class SalesItem {
	private String item;
	private double price;
	private int quantity;
	
	public SalesItem(String itemName, int quantity, double price) {
		item = itemName;
		this.quantity = quantity;
		this.price = price;
	}
	
	public double getTotal() {
		return quantity * price;
	}
	
	public String toString() {
		return item + "\t$" + String.format("%.2f", price) + "\t" + quantity;
	}
}
