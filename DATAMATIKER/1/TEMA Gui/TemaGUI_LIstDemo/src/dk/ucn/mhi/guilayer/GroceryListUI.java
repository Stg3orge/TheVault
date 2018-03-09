package dk.ucn.mhi.guilayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dk.ucn.mhi.controllerlayer.GroceryListController;
import dk.ucn.mhi.modellayer.GroceryItem;
import dk.ucn.mhi.modellayer.GroceryList;

public class GroceryListUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GroceryListController controller;
	private JButton addItemButton;
	private JLabel listName;
	private GroceryList myList;
	private JList<GroceryItem> groceryList;
	private DefaultListModel<GroceryItem> listRepresentation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroceryListUI frame = new GroceryListUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GroceryListUI() {
		controller = new GroceryListController();

		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel southPanel = new JPanel();
		contentPane.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JButton newListButton = new JButton("New list");
		newListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createList();
			}
		});
		southPanel.add(newListButton);

		addItemButton = new JButton("Add item");
		addItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItem();
			}
		});
		setAddItemVisibility();
		southPanel.add(addItemButton);

		JPanel northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		listName = new JLabel("List Name");
		northPanel.add(listName);

		groceryList = new JList<GroceryItem>();
		listRepresentation = new DefaultListModel<GroceryItem>();
		groceryList.setModel(listRepresentation);
		ShoppingListCellRenderer cellRenderer = new ShoppingListCellRenderer();
		groceryList.setCellRenderer(cellRenderer);
		contentPane.add(groceryList, BorderLayout.CENTER);
	}

	private void setAddItemVisibility() {
		boolean enabled = false;
		if (!(myList == null)) {
			enabled = true;
		}
		addItemButton.setEnabled(enabled);

	}

	private void createList() {
		CreateListUI createListUI = new CreateListUI(controller);
		createListUI.setVisible(true);
		String name = "no list yet";
		myList = createListUI.getCurrentList();
		setAddItemVisibility();
		if (myList != null) {
			name = myList.getName();
			listRepresentation.clear();
		}
		listName.setText(name);
	}

	private void addItem() {
		CreateItemUI createItemUI = new CreateItemUI(controller, myList);
		createItemUI.setVisible(true);
		GroceryItem groceryItem = createItemUI.getGroceryItem();
		updateCurrentList(groceryItem);
	}

	private void updateCurrentList(GroceryItem groceryItem) {

		listRepresentation.addElement(groceryItem);

	}

}
