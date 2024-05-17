package viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Logic_view_register;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_user;
	public JPasswordField pwf_pasword;
	public JButton btn_enter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 353, 164);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_User = new JLabel("User:");
		lbl_User.setBounds(24, 27, 46, 14);
		contentPane.add(lbl_User);
		
		JLabel lbl_pasword = new JLabel("Pasword:");
		lbl_pasword.setBounds(24, 62, 68, 14);
		contentPane.add(lbl_pasword);
		
		txt_user = new JTextField();
		txt_user.setBounds(90, 24, 237, 20);
		contentPane.add(txt_user);
		txt_user.setColumns(10);
		
		pwf_pasword = new JPasswordField();
		pwf_pasword.setBounds(90, 59, 237, 20);
		contentPane.add(pwf_pasword);
		
		btn_enter = new JButton("Go!");
		btn_enter.setBounds(238, 90, 89, 23);
		contentPane.add(btn_enter);
		
		Logic_view_register lg = new Logic_view_register(this);
	}
}
