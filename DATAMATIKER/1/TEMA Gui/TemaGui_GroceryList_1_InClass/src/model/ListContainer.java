package model;

import java.util.ArrayList;
import java.util.List;

public class ListContainer {
	private static ListContainer instance;
	private List<GroceryList> lists;
	private ListContainer() {
		lists = new ArrayList<>();
	}
	public static ListContainer getInstance() {
		if(instance == null) {
			instance = new ListContainer();
		}
		return instance;
	}
	public void addList(GroceryList l) {
		lists.add(l);		
	}
}
