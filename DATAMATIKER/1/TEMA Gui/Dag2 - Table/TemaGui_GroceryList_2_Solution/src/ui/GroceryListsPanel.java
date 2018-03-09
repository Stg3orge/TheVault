package ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import ctr.Controller;
import model.GroceryList;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GroceryListsPanel extends JPanel {
	private class GroceryListTableModel extends DefaultTableModel {
		private static final long serialVersionUID = 1L;
		private List<GroceryList> gLists;

		public void setData(List<GroceryList> data) {
			super.fireTableDataChanged(); // notify JTable that it's time to update what it displays
			gLists = data;
		}

		public GroceryList getSelectedGroceryList(int row) {
			GroceryList res = null;
			if (gLists != null && row >= 0 && row < gLists.size()) {
				res = gLists.get(row);
			}
			return res; // returns null if selection was outside index range
		}

		@Override
		public int getColumnCount() {
			return 2;
		}

		@Override
		public String getColumnName(int col) {
			switch (col) {
			case 0:
				return "Name";
			case 1:
				return "Lines";
			default:
				return "UNKNOWN COL: " + col;
			}
		}

		@Override
		public int getRowCount() {
			int res = 0;
			if (gLists != null) {
				res = gLists.size();
			}
			return res;
		}

		@Override
		public Object getValueAt(int row, int col) {
			GroceryList currGroceryList = gLists.get(row);
			switch (col) {
			case 0:
				return currGroceryList.getName();
			case 1:
				return currGroceryList.getLines().size();
			default:
				return "UNKNOWN COL: " + col;
			}
		}
	}

	private Controller controller;
	
	private JTable table;
	private GroceryListTableModel model;
	private final JPanel panel = new JPanel();
	private JButton btnDelete;
	private JButton btnShow;
	private JButton btnNew;

	/**
	 * Create the panel.
	 */
	public GroceryListsPanel(Controller controller) {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(panel, BorderLayout.SOUTH);

		btnNew = new JButton("Ny liste...");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNewClicked();
			}
		});
		panel.add(btnNew);

		btnShow = new JButton("Vis");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShowClicked();
			}
		});
		panel.add(btnShow);

		btnDelete = new JButton("Slet");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteClicked();
			}
		});
		panel.add(btnDelete);

		
		init(controller);
	}

	private void btnDeleteClicked() {
		int row = table.getSelectedRow();
		GroceryList currList = model.getSelectedGroceryList(row);
		if(currList != null) {
			controller.deleteByName(currList.getName());
			updateList();
		}
	}

	private void btnShowClicked() {
		int row = table.getSelectedRow();
		GroceryList currList = model.getSelectedGroceryList(row);
		if(currList != null) {
			controller.setCurrentGroceryListByName(currList.getName());
			GroceryListView glv = new GroceryListView(controller);
			glv.setVisible(true);
			updateList(); // line count may have changed
		}
	}

	private void init(Controller controller) {
		this.controller = controller;
		this.model = new GroceryListTableModel();
		this.table.setModel(model);
		updateList();
	}

	private void btnNewClicked() {
		GroceryListObjectView glov = new GroceryListObjectView(controller, null);
		glov.setVisible(true);
		updateList();
	}

	private void updateList() {
		if(controller != null) {
			List<GroceryList> lists = controller.findAll();
			this.model.setData(lists);
		}
	}
}
