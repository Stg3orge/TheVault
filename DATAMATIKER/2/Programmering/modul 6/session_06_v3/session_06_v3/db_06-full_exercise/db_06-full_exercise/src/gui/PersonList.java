package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.PersonGroupCtrIF;
import db.HorribleException;
import model.Person;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonList extends JFrame {
	private PersonGroupCtrIF pgCtr; 

	private JPanel contentPane;
	private JList<Person> lstPerson;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonList frame = new PersonList();
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
	public PersonList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		lstPerson = new JList<>();
		lstPerson.setCellRenderer(new PersonListCellRenderer());
		scrollPane.setViewportView(lstPerson);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnEdit = new JButton("Edit...");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showPerson();
			}
		});
		panel.add(btnEdit);
		
		
		// hey!
		init();
	}
	
	private void init() {lstPerson.setCellRenderer(new PersonListCellRenderer());
//		try {
		// FIXME	this.pgCtr = new PersonGroupCtr();
//		} catch (HorribleException e) {
//			JOptionPane.showInternalMessageDialog(null, "Problems initializing the system " + e.getMessage());
//		}
		updatePersonList();
	}
	
	private void updatePersonList() {
		try {
			List<Person> ppl = pgCtr.showPersons();
			DefaultListModel<Person> dlm = new DefaultListModel<>();
			for(int i = 0 ; i < ppl.size(); i++) {
				dlm.addElement(ppl.get(i));
			}
			this.lstPerson.setModel(dlm);
		} catch (HorribleException e) {
			JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
		}
	}
	
	private void showPerson() {
		Person p = lstPerson.getSelectedValue();
		if(p != null) {
			PersonView pw = new PersonView();
			pw.setPerson(p);
			pw.setVisible(true);
			System.out.println("PersonView should have been closed now according to PersonList");
			updatePersonList();
		}
	}

}
