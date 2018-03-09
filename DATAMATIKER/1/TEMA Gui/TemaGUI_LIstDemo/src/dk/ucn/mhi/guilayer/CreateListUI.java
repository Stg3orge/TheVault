package dk.ucn.mhi.guilayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dk.ucn.mhi.controllerlayer.GroceryListController;
import dk.ucn.mhi.modellayer.GroceryList;

public class CreateListUI extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField createListNameField;
	private GroceryListController controller;
	private GroceryList currentList;

	/**
	 * Create the dialog.
	 */
	public CreateListUI(GroceryListController ctr) {
		controller = ctr;
		initGUI();
	}

	/**
	 * 
	 */
	private void initGUI() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			JLabel createListLabel = new JLabel("Please enter list name");
			contentPanel.add(createListLabel);
		}
		{
			createListNameField = new JTextField();
			contentPanel.add(createListNameField);
			createListNameField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						okButtonClicked();
					}

				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						closeDialog();
					}

				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void okButtonClicked() {
		String name = createListNameField.getText();
		currentList = controller.addGroceryList(name);
		closeDialog();
	}

	public GroceryList getCurrentList() {
		return currentList;
	}

	/**
	 * 
	 */
	private void closeDialog() {
		this.setVisible(false);
		this.dispose();
	}

}
