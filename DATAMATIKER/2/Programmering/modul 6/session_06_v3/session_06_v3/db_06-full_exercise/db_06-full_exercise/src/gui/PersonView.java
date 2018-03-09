package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.PersonGroupCtrIF;
import db.HorribleException;
import model.Group;
import model.Person;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonView extends JDialog {
	private PersonGroupCtrIF pgc;
	private Person p;

	private final JPanel contentPane = new JPanel();
	private JLabel lblId;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtBirthdate;
	private JTextField txtEmail;
	private JComboBox<Group> cmbGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PersonView dialog = new PersonView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PersonView() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("id:");
			lblNewLabel.setBounds(22, 19, 46, 14);
			contentPane.add(lblNewLabel);
		}
		
		JLabel lblNewLabel_1 = new JLabel("name:");
		lblNewLabel_1.setBounds(22, 52, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblEmail = new JLabel("email:");
		lblEmail.setBounds(22, 151, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("phone:");
		lblPhone.setBounds(22, 85, 46, 14);
		contentPane.add(lblPhone);
		
		JLabel lblBirthdate = new JLabel("birthdate:");
		lblBirthdate.setBounds(22, 118, 68, 14);
		contentPane.add(lblBirthdate);
		
		JLabel lblGroup = new JLabel("group:");
		lblGroup.setBounds(22, 184, 46, 14);
		contentPane.add(lblGroup);
		
		lblId = new JLabel("New label");
		lblId.setBounds(120, 15, 46, 14);
		contentPane.add(lblId);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setBounds(120, 44, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setEditable(false);
		txtPhone.setBounds(120, 79, 86, 20);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);
		
		txtBirthdate = new JTextField();
		txtBirthdate.setEditable(false);
		txtBirthdate.setBounds(120, 114, 86, 20);
		contentPane.add(txtBirthdate);
		txtBirthdate.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setBounds(120, 149, 86, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		cmbGroup = new JComboBox<Group>();
		cmbGroup.setBounds(120, 184, 125, 20);
		contentPane.add(cmbGroup);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						savePerson();
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
						cancel();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	
	
		init();
	
	}
	
	private void init() {
//		try {
		// FIXME:	this.pgc = new PersonGroupCtr();
//		} catch (HorribleException e) {
//			JOptionPane.showInternalMessageDialog(null, "Problems initializing the system: " + e.getMessage());
//		}
	}

	public void setPerson(Person p) {
		this.p= p;
		this.lblId.setText("" + p.getId());
		this.txtBirthdate.setText(p.getBirthDate().format(DateTimeFormatter.ofPattern("YYYY-MM-dd")));
		this.txtEmail.setText(p.getEmail());
		this.txtName.setText(p.getName());
		this.txtPhone.setText(p.getPhone());
		fillGroupList();
		this.cmbGroup.setSelectedItem(p.getGroup());
		
	}
	
	private void fillGroupList() {
		this.cmbGroup.setRenderer(new GroupListCellRenderer());
		try {
			List<Group> gs = pgc.showGroups();
			DefaultComboBoxModel<Group> dlm = new DefaultComboBoxModel<>();
			for(int i = 0; i < gs.size(); i++) {
				dlm.addElement(gs.get(i));
			}
			this.cmbGroup.setModel(dlm);
		} catch (HorribleException e) {
			JOptionPane.showMessageDialog(null, "Oh noes! Something went wrong " + e.getMessage());
		}
		
	}
	
	private void savePerson() {
		try {
			this.pgc.pickPerson(p.getId()); // hack?
			
			int newId = ((Group)cmbGroup.getSelectedItem()).getId();
			this.pgc.pickNewGroup(newId);
			this.setVisible(false);
			this.dispose();
		} catch (HorribleException e) {
			JOptionPane.showMessageDialog(null, "Panic, the operation failed " + e.getMessage());
		}
	}
	
	private void cancel() {
		this.setVisible(false);
		this.dispose();
	}
}
