package dk.ucn.mhi.modellayer;

import java.util.ArrayList;

public class GroceryList {
	private ArrayList<GroceryItem> groceryList;
	private String name;

	public GroceryList(String name) {
		groceryList = new ArrayList<>();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addGroceryItem(GroceryItem item) {
		groceryList.add(item);
	}
	
	public GroceryItem getLatestGroceryItem() {
		return groceryList.get(groceryList.size()-1);
		
	}


	
}
