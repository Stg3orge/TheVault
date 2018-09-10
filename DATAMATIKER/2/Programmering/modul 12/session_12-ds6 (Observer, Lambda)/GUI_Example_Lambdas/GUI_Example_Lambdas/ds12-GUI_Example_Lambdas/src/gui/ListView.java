package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.JList;
import javax.swing.JButton;

import controller.MemberController;
import model.Member;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

public class ListView extends JFrame {
	private Font newF;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<Member> list;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnRemove;

	private class CustomCellRenderer extends JLabel implements ListCellRenderer<Member> {
		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(JList<? extends Member> list, Member value,
				int index, boolean isSelected,	boolean cellHasFocus) {
			
			super.setFont(newF);
			super.setOpaque(true);
			super.setText(value.getName());
			if(isSelected) {
				super.setBackground(new Color(220, 220, 255));
				super.setForeground(new Color(100, 50, 50));
			}
			else {
				super.setBackground(Color.WHITE);
				super.setForeground(Color.BLACK);
			}
			return this;
		}
		
	}
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new MemberController().createMember("Test Person", 1999);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListView frame = new ListView();
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
	public ListView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		Font f = contentPane.getFont();									//fix small fonts on windows
		newF = new Font(f.getFontName(), f.getStyle(), f.getSize() + 5);//fix small fonts on windows
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		list = new JList<>();
		scrollPane.setViewportView(list);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(e -> handleAddEvent());
//		btnAdd.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				handleAddEvent();
//			}
//		});
		panel.add(btnAdd);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener((e) -> handleEditEvent());
//		btnEdit.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				handleEditEvent();
//			}
//		});
		panel.add(btnEdit);
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener((e) -> handleRemoveEvent());
//		btnRemove.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				handleRemoveEvent();
//			}
//		});
		panel.add(btnRemove);
		
		///// after initisalization
		
		init();
	}
	
	private void init() {
		this.list.setCellRenderer(new CustomCellRenderer());
		updateList();
	
		// Fix small fonts on Windows desktops
		setFont(contentPane, newF);
	}
	
	private void setFont(Component c, Font f) { // recursively update font 
		c.setFont(f);
		if(c instanceof Container) {
			Container cont = (Container)c;
			for(Component child : cont.getComponents()) {
				setFont(child, f);
			}
		}
	}	
		
		
		
	
	protected void handleRemoveEvent() {
		Member m = this.list.getSelectedValue();
		if(m != null) {
			m = new MemberController().removeMemberById(m.getId());
			if(m != null) {
				//new MemberController().removeMemberById(m.getId());
				JOptionPane.showMessageDialog(this, m.getName() + " was removed.", "Info", JOptionPane.OK_OPTION);
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "You must select a member to remove before removing \nthe meber that you want to remove", "Error", JOptionPane.ERROR_MESSAGE);
		}
		updateList();
	}

	private void handleEditEvent() {
		Member m = this.list.getSelectedValue();
		int mId = m.getId();
		
		ObjectView ov = new ObjectView(mId);
		ov.setVisible(true);
		
		updateList();
	}

	private void handleAddEvent() {
		ObjectView ov = new ObjectView();
		ov.setVisible(true);
		
		// this only happens after the dialog is closed, as the ObjectView is modal
		updateList();
	}

	private void updateList() {
		List<Member> members = new MemberController().getAll();
		DefaultListModel<Member> listModel = new DefaultListModel<>();
		for(int i = 0 ; i < members.size(); i++) {
			listModel.addElement(members.get(i));
		}
		this.list.setModel(listModel);
	}

}
