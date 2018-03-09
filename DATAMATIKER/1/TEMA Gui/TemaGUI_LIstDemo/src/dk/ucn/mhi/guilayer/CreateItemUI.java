package dk.ucn.mhi.guilayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.InternationalFormatter;

import dk.ucn.mhi.controllerlayer.GroceryListController;
import dk.ucn.mhi.modellayer.GroceryItem;
import dk.ucn.mhi.modellayer.GroceryList;

public class CreateItemUI extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nameField;
	private JFormattedTextField quantityField;
	private GroceryListController controller;
	private GroceryList currentList;
	private InternationalFormatter textFormat;
	private DecimalFormat format;
	private GroceryItem groceryItem;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public CreateItemUI(GroceryListController ctr, GroceryList list) {
		controller = ctr;
		currentList = list;
		configureFieldToDouble();
		initGUI();
	}

	private void initGUI() {
		setTitle("Enter information about new item");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 60, 0, 240, 0 };
		gbl_contentPanel.rowHeights = new int[] { 20, 20, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		JLabel nameOfItem = new JLabel("Merchandise");
		GridBagConstraints gbc_nameOfItem = new GridBagConstraints();
		gbc_nameOfItem.anchor = GridBagConstraints.WEST;
		gbc_nameOfItem.insets = new Insets(0, 0, 5, 5);
		gbc_nameOfItem.gridx = 0;
		gbc_nameOfItem.gridy = 0;
		contentPanel.add(nameOfItem, gbc_nameOfItem);

		nameField = new JTextField();
		nameField.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.anchor = GridBagConstraints.NORTH;
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.insets = new Insets(0, 0, 5, 0);
		gbc_nameField.gridx = 2;
		gbc_nameField.gridy = 0;
		contentPanel.add(nameField, gbc_nameField);
		nameField.setColumns(10);

		JLabel quantityOfItem = new JLabel("Quantity");
		GridBagConstraints gbc_quantityOfItem = new GridBagConstraints();
		gbc_quantityOfItem.anchor = GridBagConstraints.WEST;
		gbc_quantityOfItem.insets = new Insets(0, 0, 0, 5);
		gbc_quantityOfItem.gridx = 0;
		gbc_quantityOfItem.gridy = 1;
		contentPanel.add(quantityOfItem, gbc_quantityOfItem);

		quantityField = new JFormattedTextField(textFormat);
		quantityField.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_quantityField = new GridBagConstraints();
		gbc_quantityField.anchor = GridBagConstraints.NORTH;
		gbc_quantityField.fill = GridBagConstraints.HORIZONTAL;
		gbc_quantityField.gridx = 2;
		gbc_quantityField.gridy = 1;
		contentPanel.add(quantityField, gbc_quantityField);
		quantityField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Add Item");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addItemClicked();
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

	private void configureFieldToDouble() {
		// create a formatter to use on the number field

		format = new DecimalFormat("#.##");
		format.setMinimumFractionDigits(2);
		format.setMaximumFractionDigits(2);
		format.setRoundingMode(RoundingMode.FLOOR);
		textFormat = new InternationalFormatter(format);
		textFormat.setMinimum(0.00);
		textFormat.setMaximum(Double.MAX_VALUE);
		textFormat.setAllowsInvalid(false);
		textFormat.setCommitsOnValidEdit(true);
	}

	private void closeDialog() {
		this.setVisible(false);
		this.dispose();
	}

	private void addItemClicked() {
		String name = nameField.getText();
		String quant = quantityField.getText();
		Number number = 0;
		try {
			number = format.parse(quant);
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		// quant = quant.replace(",", ".");
		// double quantity = Double.parseDouble(quant);
		double quantity = number.doubleValue();

		groceryItem = controller.addItem(currentList, name, quantity);
		closeDialog();
	}

	public GroceryItem getGroceryItem() {
		return groceryItem;
	}
}
