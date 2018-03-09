package ui;

import ctr.Controller;
import ctr.NoGroceryListException;
import model.GroceryList;
import model.Line;

public class SimulatedUI {
	public static void main(String[] args) throws NoGroceryListException {
		System.out.println("creating a new list");;

		Controller ctr = new Controller();
		GroceryList l = ctr.createNewList("Julefrokost");
		
		displayList(l);
		
		// tilf�j ting til indk�bslisten
		
		System.out.println("\nTilf�jer And, Svesker og R�dk�l\n");
		ctr.addLine("And", 3.4);
		ctr.addLine("Svesker", 2d);
		ctr.addLine("R�dk�l", 2d);
		displayList(l);
	}

	private static void displayList(GroceryList l) {
		System.out.println("Printing list " + (l != null ? l.getName() : "?"));
		for(Line line : l.getLines()) {
			System.out.println(line.getName() + ": " + line.getQuantity());
		}
		
	}

}
