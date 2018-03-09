package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ctr.Controller;
import model.Line;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class GroceryListView extends JDialog {
	public class GroceryListViewListCellRenderer implements ListCellRenderer<Line> {
		@Override
		public Component getListCellRendererComponent(JList<? extends Line> list, Line obj, int arg2, boolean isSelected,
				boolean arg4) {
			JLabel res = new JLabel();
			res.setText(obj.getName() + ": " + obj.getQuantity());
			
			// make it selectable
			res.setOpaque(true);
			if(isSelected) {
				res.setForeground(list.getSelectionForeground());
				res.setBackground(list.getSelectionBackground());
			} else {
				res.setForeground(list.getForeground());
				res.setBackground(list.getBackground());
				//res.setBackground(Color.PINK);
			}
			return res;
		}
		
	}
	
	private static final long serialVersionUID = 1L;
	private Controller controller;
	private JPanel contentPane;
	private JList<Line> list;
	private JLabel lblName;



	/**
	 * Create the frame.
	 * @param controller 
	 */
	public GroceryListView(Controller controller) {
		setModal(true);
		setMinimumSize(new Dimension(300, 200));
		setTitle("Indk\u00F8bsliste");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewLine = new JButton("Ny Linie");
		btnNewLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddLineClicked();
			}
		});
		panel.add(btnNewLine);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		list = new JList<>();
		scrollPane.setViewportView(list);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		lblName = new JLabel("Name");
		panel_1.add(lblName);
		
		init(controller);
	}

	private void btnAddLineClicked() {
		GroceryLineView groceryLineView = new GroceryLineView(controller);
		groceryLineView.setVisible(true);
		updateLineList();
	}

	private void updateLineList() {
		List<Line> lines = controller.getCurrentGroceryList().getLines();
		lblName.setText(controller.getCurrentGroceryList().getName());
		DefaultListModel<Line> dlm = new DefaultListModel<>();
		for(int i = 0 ; i < lines.size(); i++) {
			dlm.addElement(lines.get(i));
		}
		list.setModel(dlm);
	}

	private void init(Controller controller) {
		this.controller = controller;
		//controller.createNewList("Indkøb");
		this.list.setCellRenderer(new GroceryListViewListCellRenderer());
		updateLineList();
	}

}
