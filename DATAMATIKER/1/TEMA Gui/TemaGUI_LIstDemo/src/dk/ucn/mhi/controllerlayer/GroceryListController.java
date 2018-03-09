package dk.ucn.mhi.controllerlayer;



import dk.ucn.mhi.modellayer.GroceryItem;
import dk.ucn.mhi.modellayer.GroceryList;
import dk.ucn.mhi.modellayer.GroceryListContainer;

public class GroceryListController {
	private GroceryListContainer groceryListContainer;

	public GroceryListController() {
		groceryListContainer = GroceryListContainer.getInstance();
	}
	
	public GroceryList addGroceryList(String name) {
		GroceryList newList = new GroceryList(name);
		groceryListContainer.addGroceryList(newList);
		return newList;
	}
	
	/* not used yet
	 * public GroceryList findList(String name) {
		return groceryListContainer.findList(name);
	}*/
	
	public GroceryItem addItem(GroceryList list, String itemName, double quantity) {
		GroceryItem item = new GroceryItem(itemName, quantity);
		list.addGroceryItem(item);
		return item;
	}





}
