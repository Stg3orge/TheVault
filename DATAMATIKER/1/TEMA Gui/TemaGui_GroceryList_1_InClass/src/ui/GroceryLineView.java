package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ctr.Controller;
import ctr.NoGroceryListException;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class GroceryLineView extends JDialog {
	private Controller controller;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtGrocery;
	private JTextField txtQty;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Controller c = new Controller();
			c.createNewList("Indkøb");
			GroceryLineView dialog = new GroceryLineView(c);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GroceryLineView(Controller controller) {
		setMinimumSize(new Dimension(300, 200));
		setTitle("Grocery List Item View Special For You My Friend Only");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblGrocery = new JLabel("Grocery:  ");
			GridBagConstraints gbc_lblGrocery = new GridBagConstraints();
			gbc_lblGrocery.anchor = GridBagConstraints.EAST;
			gbc_lblGrocery.insets = new Insets(0, 0, 5, 5);
			gbc_lblGrocery.gridx = 0;
			gbc_lblGrocery.gridy = 0;
			contentPanel.add(lblGrocery, gbc_lblGrocery);
		}
		{
			txtGrocery = new JTextField();
			txtGrocery.setText("grocery");
			GridBagConstraints gbc_txtGrocery = new GridBagConstraints();
			gbc_txtGrocery.insets = new Insets(0, 0, 5, 0);
			gbc_txtGrocery.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtGrocery.gridx = 1;
			gbc_txtGrocery.gridy = 0;
			contentPanel.add(txtGrocery, gbc_txtGrocery);
			txtGrocery.setColumns(10);
		}
		{
			JLabel lblQty = new JLabel("Qty:  ");
			GridBagConstraints gbc_lblQty = new GridBagConstraints();
			gbc_lblQty.anchor = GridBagConstraints.EAST;
			gbc_lblQty.insets = new Insets(0, 0, 0, 5);
			gbc_lblQty.gridx = 0;
			gbc_lblQty.gridy = 1;
			contentPanel.add(lblQty, gbc_lblQty);
		}
		{
			txtQty = new JTextField();
			txtQty.setText("qty");
			GridBagConstraints gbc_txtQty = new GridBagConstraints();
			gbc_txtQty.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtQty.gridx = 1;
			gbc_txtQty.gridy = 1;
			contentPanel.add(txtQty, gbc_txtQty);
			txtQty.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnOKClicked();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnCancelClicked();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
		init(controller);
	}

	private void init(Controller controller) {
		this.controller = controller;
		clearFields();
	}

	private void btnOKClicked() {	
		try {
			String name = this.txtGrocery.getText();
			double quantity = Double.parseDouble(this.txtQty.getText());
			this.controller.addLine(name, quantity);
		} catch (NoGroceryListException e) {
			JOptionPane.showMessageDialog(this, "Fejl 40 - Du mangler at oprette en indkøbsliste, ...");
			clearFields();
		} catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "Fejl id-10t - Antal skal være et tal!");
			clearFields();
		}
		btnCancelClicked();
	}

	private void clearFields() {
		txtGrocery.setText("");
		txtQty.setText("");
	}

	private void btnCancelClicked() {
		this.setVisible(false);
		this.dispose();
	}

}
