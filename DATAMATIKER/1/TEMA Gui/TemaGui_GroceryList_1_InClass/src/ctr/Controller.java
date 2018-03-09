package ctr;

import model.GroceryList;
import model.Line;
import model.ListContainer;

public class Controller {
	private GroceryList currList;

	public GroceryList createNewList(String name) {
		currList = new GroceryList(name);
		ListContainer.getInstance().addList(currList);
		return currList;
	}

	public void addLine(String name, double quantity) throws NoGroceryListException {
		if(currList != null) {
			currList.addLine(new Line(name, quantity));
		}
		else {
			throw new NoGroceryListException("Yo!");
		}
	}

	public GroceryList getCurrentGroceryList() {
		return currList;
	}

}
