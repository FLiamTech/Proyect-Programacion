package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Admin;
import viewer.Admin_viewer;
import viewer.Login;
import viewer.Main_viewer;

public class Logic_view_register implements ActionListener
{
	private Main_viewer mv;
	private Login log;
	public Logic_view_register (Login log)
	{
		this.log = log;
		this.log.btn_enter.addActionListener(this);
	}
	public Logic_view_register (Main_viewer mv)
	{
		this.mv = mv;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == log.btn_enter)
		{
			String enteredUser = log.txt_user.getText();
            String enteredPassword = new String(log.pwf_pasword.getPassword());
			if(enteredUser.equals(Admin.adminUser) && enteredPassword.equals(Admin.adminPassword))
			{
				Admin_viewer av = new Admin_viewer();
				av.setVisible(true);
				av.setLocationRelativeTo(null);
				log.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(log, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
			}

		}
		
	}
	
}
