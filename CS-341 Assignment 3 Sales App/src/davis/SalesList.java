package davis;

import java.util.ArrayList;

public class SalesList {
	private String itemName;
	private double price;
	private int quantity;
	private ArrayList<SalesItem> items;
	
	public SalesList() {
		items = new ArrayList<SalesItem>();
	}
	
	public void addNewItem(SalesItem salesItem) {
		items.add(salesItem);
	}
	
	public String getSalesList() {
		String str = "";
		for (int i = 0; i < items.size(); i++) {
			str += items.get(i).toString() + "\n";
		}
		return str;
	}
	
	public Double computeTotalAmount() {
		double totalAmount = 0;
		for (int i = 0; i < items.size(); i++) {
			totalAmount += items.get(i).getTotal();
		}
		return totalAmount;
 	}
}
