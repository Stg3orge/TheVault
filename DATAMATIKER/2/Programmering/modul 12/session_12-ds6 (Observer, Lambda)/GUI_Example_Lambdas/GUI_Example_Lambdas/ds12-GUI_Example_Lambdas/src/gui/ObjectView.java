package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import controller.MemberController;
import model.Member;

public class ObjectView extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JLabel lblId;
	private JTextField txtSince;

	private Member member;

	public ObjectView(int memberId) {
		this();
		fillInFields(memberId);
	}

	/**
	 * Create the dialog.
	 */
	public ObjectView() {
		setTitle("Member");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 335, 231);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel somelabel = new JLabel("ID:");
		somelabel.setBounds(10, 11, 77, 14);
		contentPanel.add(somelabel);

		lblId = new JLabel("");
		lblId.setBounds(109, 11, 46, 14);
		contentPanel.add(lblId);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 36, 77, 14);
		contentPanel.add(lblName);

		txtName = new JTextField();
		txtName.setSize(new Dimension(0, 5));
		txtName.setBounds(109, 33, 172, 25);
		contentPanel.add(txtName);
		txtName.setColumns(10);

		JLabel lblSince = new JLabel("Since:");
		lblSince.setBounds(10, 61, 77, 14);
		contentPanel.add(lblSince);

		txtSince = new JTextField();
		txtSince.setSize(new Dimension(0, 5));
		txtSince.setBounds(109, 58, 172, 25);
		contentPanel.add(txtSince);
		txtSince.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.scrollbar);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSave = new JButton("Save");
				btnSave.addActionListener((e) -> handleSaveEvent());
				// btnSave.addActionListener(new ActionListener() {
				// public void actionPerformed(ActionEvent arg0) {
				// handleSaveEvent();
				// }
				// });
				btnSave.setActionCommand("OK");
				buttonPane.add(btnSave);
				getRootPane().setDefaultButton(btnSave);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener((e) -> handleCancelEvent());
				// btnCancel.addActionListener(new ActionListener() {
				// public void actionPerformed(ActionEvent e) {
				// handleCancelEvent();
				// }
				// });
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}

		init();
	}

	private void init() {

		// Fix small fonts on Windows desktops
		Font f = contentPanel.getFont();
		Font newF = new Font(f.getFontName(), f.getStyle(), f.getSize() + 5);
		setFont(contentPanel, newF);
	}

	private void setFont(Component c, Font f) { // recursively update font
		c.setFont(f);
		if (c instanceof Container) {
			Container cont = (Container) c;
			for (Component child : cont.getComponents()) {
				setFont(child, f);
			}
		}
	}

	private void fillInFields(int memberId) {
		this.member = new MemberController().findMemberById(memberId);
		if (member != null) {
			this.txtName.setText(member.getName());
			this.txtSince.setText("" + member.getSince());
			this.lblId.setText("" + member.getId());
		}
	}

	private void handleSaveEvent() {
		String name = this.txtName.getText();
		int since = -1;
		String sinceStr = this.txtSince.getText();
		try {
			since = Integer.parseInt(sinceStr);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "The since value must be a whole number,\n as it represents a year.",
					"Input Error", JOptionPane.ERROR_MESSAGE);
			txtSince.setText("");
			// FIXME if member exists, reset to original value
			return;
		}
		if (member == null) {
			new MemberController().createMember(name, since);
		} else {
			// member exists
			new MemberController().updateMember(this.member.getId(), name, since);
		}
		handleCancelEvent();
	}

	private void handleCancelEvent() {
		this.setVisible(false);
		this.dispose();

	}
}
