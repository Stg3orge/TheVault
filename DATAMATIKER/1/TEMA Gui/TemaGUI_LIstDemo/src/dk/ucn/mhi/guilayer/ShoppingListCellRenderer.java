package dk.ucn.mhi.guilayer;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import dk.ucn.mhi.modellayer.GroceryItem;

public class ShoppingListCellRenderer implements ListCellRenderer<GroceryItem> {
	@Override
	public Component getListCellRendererComponent(JList<? extends GroceryItem> list, GroceryItem item, int index,
			boolean isSelected, boolean cellHasFocus) {
		JLabel label = new JLabel();
		String textToShow = item.getName() + "  " + item.getQuantity();
		label.setText(textToShow.toString());
		label.setOpaque(true);
		if(isSelected) {
			label.setBackground(list.getSelectionBackground());
			label.setForeground(list.getSelectionForeground());
		} else {
			label.setBackground(list.getBackground());
			label.setForeground(list.getForeground());
		}
		return label;
	}
}
