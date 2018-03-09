package gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Person;

public class PersonListCellRenderer implements ListCellRenderer<Person> {

	private DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
	@Override
	public Component getListCellRendererComponent(JList<? extends Person> list, Person value, int index,
			boolean isSelected, boolean cellHasFocus) {
		//return new JLabel(value.getName() + " (" + value.getEmail() + ")");
		JLabel renderer = (JLabel) dlcr.getListCellRendererComponent(list, value.getName(), index, isSelected, cellHasFocus);
		return renderer;
	}

}
