import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblPointer;
	private JLabel lblLambda;
	private JButton btnAnonInnerClass;
	private JLabel lblAnonInnerClass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AWindow frame = new AWindow();
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
	public AWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLambda = new JButton("Lambda");
		btnLambda.setBounds(12, 96, 166, 25);
		contentPane.add(btnLambda);
		
		JButton btnPointer = new JButton("Pointer");
		btnPointer.setBounds(12, 134, 166, 25);
		contentPane.add(btnPointer);
		
		lblLambda = new JLabel("New label");
		lblLambda.setBounds(205, 100, 161, 16);
		contentPane.add(lblLambda);
		
		lblPointer = new JLabel("New label");
		lblPointer.setBounds(205, 138, 215, 16);
		contentPane.add(lblPointer);
		
		btnAnonInnerClass = new JButton("Anon. Inner Class"); 
		btnAnonInnerClass.setBounds(12, 58, 166, 25);
		contentPane.add(btnAnonInnerClass);
		
		lblAnonInnerClass = new JLabel("New label");
		lblAnonInnerClass.setBounds(205, 62, 161, 16);
		contentPane.add(lblAnonInnerClass);
		
		
		
		
		// Our usual init method that separates our own initialization code from the 
		// generated code from WindowBuilder
		init();
	}
	
	private void init() {
		lblLambda.setText("");
		lblPointer.setText("");
		lblAnonInnerClass.setText("");
		
		// Fix small fonts on Windows desktops
		/*
		Font f = contentPane.getFont();
		Font newF = new Font(f.getFontName(), f.getStyle(), f.getSize() + 5);
		setFont(contentPane, newF);
		*/
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
	

	// 3 methods that implement functionality for the 3 buttons
	private void anonInnerClassClicked() {
		lblAnonInnerClass.setText("You clicked me!");
	}
	
	private void lambdaClicked() {
		lblLambda.setText("CLICK!!!");
	}
	
	private void pointerClicked(ActionEvent e) {
		lblPointer.setText("A click was detected...");
	}
}
















