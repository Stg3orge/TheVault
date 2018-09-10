package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Ctr.PersonCtr;
import Model.Person;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonGUI frame = new PersonGUI();
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
	public PersonGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 11, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 36, 46, 14);
		contentPane.add(lblName);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(78, 8, 197, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(78, 33, 197, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JButton btnGem = new JButton("Gem");
		btnGem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				/*------------------------------
				 *------------------------------
				//Create the appropriate code to insert a person in the Db 
				 * -----------------------------
				 * -----------------------------*/
				
			}
		});
		btnGem.setBounds(78, 64, 89, 23);
		contentPane.add(btnGem);
		
		JButton btnHent = new JButton("Hent");
		btnHent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				//call the getPersonMethod from the controller
				
				/*------------------------------
				 *------------------------------
				//What about cohesion in this eventHandler?
				//What about Coupling in this eventHandler?
				 * -----------------------------
				 * -----------------------------*/
				PersonCtr pCtr = new PersonCtr();
				Person per = new Person();
				per = pCtr.getPerson(Integer.parseInt(textFieldId.getText()));
				textFieldName.setText(per.getName());				
				
				
			}
		});
		btnHent.setBounds(186, 64, 89, 23);
		contentPane.add(btnHent);
	}
}
