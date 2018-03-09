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
	public GroceryList findByName(String name) {
		GroceryList res = null;
		for(int i = 0 ; i < this.lists.size() && res == null; i++) {
			if(lists.get(i).getName().equalsIgnoreCase(name)) {
				res = lists.get(i);
			}
		}
		return res;
	}
	public List<GroceryList> findAll() {
		return new ArrayList<>(lists);
	}
	public void deleteByName(String name) {
		boolean found = false;
		for(int i = 0; i < lists.size() && !found; i++) {
			if(lists.get(i).getName().equalsIgnoreCase(name)) {
				lists.remove(i);
				found = true;
			}
		}
	}
}
