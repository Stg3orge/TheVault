package dk.ucn.mhi.modellayer;

import java.util.ArrayList;

public class GroceryListContainer {
	private static GroceryListContainer instance;
	private ArrayList<GroceryList> groceryLists;
	
	private GroceryListContainer() {
		groceryLists = new ArrayList<GroceryList>();
	}
	/**
	 * Singleton method for obtaining the container
	 * @return the container instance
	 */
	public static GroceryListContainer getInstance() {
		if (instance == null) {
			instance = new GroceryListContainer();
		}
		return instance;
	}

	/**
	 * Method to add a list to our collection
	 * @param list the List to add 
	 */
	public void addGroceryList(GroceryList list) {
		groceryLists.add(list);
	}
	
	/**
	 * Method for searching for a grocery list based on name
	 * @param name
	 * @return the first found list or null if no list is found 
	 */

	/*not used yet
	 * public GroceryList findList(String name) {
		int index = 0;
		int size = groceryLists.size();
		boolean found = false;
		GroceryList foundElement = null;
		while (index < size && !found) {
			GroceryList element = groceryLists.get(index);
			if (element.getName().equals(name)) {
				found = true;
				foundElement = element;
			}
			else {
				index++;
			}
		}
		return foundElement;
	}*/
	
	

	

}
