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
		
		// tilføj ting til indkøbslisten
		
		System.out.println("\nTilføjer And, Svesker og Rødkål\n");
		ctr.addLine("And", 3.4);
		ctr.addLine("Svesker", 2d);
		ctr.addLine("Rødkål", 2d);
		displayList(l);
	}

	private static void displayList(GroceryList l) {
		System.out.println("Printing list " + (l != null ? l.getName() : "?"));
		for(Line line : l.getLines()) {
			System.out.println(line.getName() + ": " + line.getQuantity());
		}
		
	}

}
