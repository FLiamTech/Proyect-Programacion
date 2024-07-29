package viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Logic_view_register;
import libreriaVersion3.Files;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JToggleButton;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_user;
	public JPasswordField pwf_pasword;
	public JButton btn_enter;
	public JButton btn_goOut;

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
		setTitle("Login");
		setResizable(false);
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
		
		btn_goOut = new JButton("Go out");
		btn_goOut.setBounds(90, 90, 89, 23);
		contentPane.add(btn_goOut);
		
		Files file = new Files ("C:/registroEmpleados");
		file.create(0);
		Inventory iv = new Inventory();
		Customers cs = new Customers();
		Egress eg = new Egress();
		Record rc = new Record();
		Supplier sp = new Supplier();
		Main_viewer mv = new Main_viewer();
		Admin_viewer av = new Admin_viewer();
		ChangePw cp = new ChangePw();
		Logic_view_register lg = new Logic_view_register(this, av, mv, iv, cs, eg, rc, sp, cp);
	}
}
