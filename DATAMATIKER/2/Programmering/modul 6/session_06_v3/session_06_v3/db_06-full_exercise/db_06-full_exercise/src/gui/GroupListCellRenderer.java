package gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Group;

public class GroupListCellRenderer implements ListCellRenderer<Group>{

	@Override
	public Component getListCellRendererComponent(JList<? extends Group> arg0, Group arg1, int arg2, boolean arg3,
			boolean arg4) {
		JLabel l = (JLabel)new DefaultListCellRenderer().getListCellRendererComponent(arg0, arg1.getName(), arg2, arg3, arg4);
		return l;
	}

}
