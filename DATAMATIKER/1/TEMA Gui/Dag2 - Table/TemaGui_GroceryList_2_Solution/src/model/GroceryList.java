package model;

import java.util.ArrayList;
import java.util.List;

public class GroceryList {
	private List<Line> lines;
	private String name;
	
	public GroceryList() {
		lines = new ArrayList<>();
	}
	
	public GroceryList(String name) {
		this();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	

	
	public void addLine(Line line) {
		lines.add(line);
	}
	
	public List<Line> getLines() {
		return new ArrayList<>(lines);
	}
}
