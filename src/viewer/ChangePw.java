package viewer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class ChangePw extends JFrame
{
	public JPasswordField pwf_previousPW;
	public JPasswordField pwf_currentPW;
	public JButton btn_return;
	public JButton btn_accept;
	public JButton btn_findOut;
	public ChangePw ()
	{
		setResizable(true);
		this.addWindowListener(new WindowAdapter() 
		{
			public void WindowClosed (WindowEvent e)
			{
				Main_viewer mv = new Main_viewer();
				mv.setVisible(true);
				mv.setLocationRelativeTo(null);
			}
		});
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 409, 157);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 393, 107);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_pwd = new JLabel("Enter your pw:");
		lbl_pwd.setBounds(10, 11, 105, 14);
		panel.add(lbl_pwd);
		
		pwf_previousPW = new JPasswordField();
		pwf_previousPW.setBounds(125, 8, 168, 20);
		panel.add(pwf_previousPW);
		
		JLabel lbl_password = new JLabel("New password:");
		lbl_password.setBounds(10, 45, 105, 14);
		panel.add(lbl_password);
		
		pwf_currentPW = new JPasswordField();
		pwf_currentPW.setBounds(125, 39, 168, 20);
		panel.add(pwf_currentPW);
		
		btn_return = new JButton("Return");
		btn_return.setBounds(198, 70, 89, 23);
		panel.add(btn_return);
		
		btn_accept = new JButton("Accept");
		btn_accept.setBounds(294, 70, 89, 23);
		panel.add(btn_accept);
		
		btn_findOut = new JButton("Find out");
		btn_findOut.setBounds(299, 7, 84, 23);
		panel.add(btn_findOut);
	}
}
