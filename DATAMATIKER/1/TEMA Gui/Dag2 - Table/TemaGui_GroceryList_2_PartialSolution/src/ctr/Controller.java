package ctr;

import java.util.List;

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

	public void updateGroceryList(String oldName, String newName) {
		GroceryList list = findByName(oldName);
		list.setName(newName);
	}

	private GroceryList findByName(String oldName) {
		GroceryList res = ListContainer.getInstance().findByName(oldName);
		return res;
	}

	public List<GroceryList> findAll() {
		return ListContainer.getInstance().findAll();
	}

	public void setCurrentGroceryListByName(String name) {
		GroceryList gl = ListContainer.getInstance().findByName(name);
		if(gl != null) {
			this.currList = gl;
		}
	}

	public void deleteByName(String name) {
		ListContainer.getInstance().deleteByName(name);
	}
}
