package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import model.Admin;
import model.AdminDAO;
import viewer.Admin_viewer;
import viewer.Login;
import viewer.Main_viewer;

public class Logic_view_register implements ActionListener
{
	private Main_viewer mv;
	private Login log;
	Admin_viewer av = new Admin_viewer();
	Admin admin = new Admin();
	AdminDAO adao = new AdminDAO();
	List <Admin> employees = new ArrayList();
	
	public Logic_view_register (Login log, Admin_viewer av, Main_viewer mv)
	{
		this.mv = mv;
		this.av = av;
		this.log = log;
		this.av.btn_searchEmployee.addActionListener(this);
		this.av.btn_accept.addActionListener(this);
		this.av.btn_create.addActionListener(this);
		this.log.btn_enter.addActionListener(this);
	}
	
//	public Logic_view_register (Admin_viewer av)
//	{
//		this.av = av;
//		this.av.btn_create.addActionListener(this);
//	}
	public Logic_view_register ()
	{

	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == log.btn_enter)
		{
			String enteredUser = log.txt_user.getText();
            String enteredPassword = new String(log.pwf_pasword.getPassword());
            if (enteredUser.equals(Admin.adminUser) && enteredPassword.equals(Admin.adminPassword))
			{
				av.setVisible(true);
				av.setLocationRelativeTo(null);
				log.dispose();
				return;
			}
            employees = adao.readerEmployees();
    		for (Admin ad : employees)
    		{
    			if (enteredUser.equals(ad.getUser()) && enteredPassword.equals(ad.getPassword()))
    			{
    					mv.setVisible(true);
    					mv.setLocationRelativeTo(null);
    					log.dispose();
    					return;
    			}
    		}
    		JOptionPane.showMessageDialog(log, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
		}
		if (e.getSource() == av.btn_create)
		{
			if (validate())
			{
				admin.setName(av.txt_nameEmplod.getText());
				admin.setDni(av.txt_dniEmplod.getText());
				admin.setCode(new String(av.pwf_codeEmplod.getPassword()));
				admin.setDate(av.txt_dateEmplod.getText());
				admin.setUser(JOptionPane.showInputDialog(av, "Ingrese un User: "));
				JPasswordField passwordField = new JPasswordField();
	            Object[] message = {
	                "Ingrese un password:", passwordField
	            };
	            int option = JOptionPane.showConfirmDialog(av, message, "Password", JOptionPane.OK_CANCEL_OPTION);
	            if (option == JOptionPane.OK_OPTION) 
	            {
	                admin.setPassword(new String(passwordField.getPassword()));
	            }
				try {
					adao.writeEmployees(admin);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(av, "Datos guardados");
				
			}
		}
		if(e.getSource() == av.btn_searchEmployee)
		{
			admin.setDni(av.txt_dniEmployeeAux.getText());
			employees = adao.readerEmployees();
			for (Admin ad : employees)
			{
				if (ad.getDni().equals(admin.getDni()))
				{
					av.lbl_estate.setText("Encontrado");
					av.lbl_estate.setForeground(Color.green);
					
				}
				else
				{
					av.lbl_estate.setText("No encontrado");
					av.lbl_estate.setForeground(Color.red);
				}
			}
		}
		if (e.getSource() == av.btn_accept)
		{
			admin.setDni(av.txt_dniEmployeeAux.getText());
			employees = adao.readerEmployees();
			
			for (Admin ad : employees)
			{
				System.out.println("Entro");
				if (ad.getDni().equals(admin.getDni()))
				{
					System.out.println("Entro");
					String newPassword = new String (av.pwd_newPassword.getPassword());
					ad.setPassword(newPassword);
					JOptionPane.showMessageDialog(av, "Password changed");

				}
			}
		}
		
	}
	
	public boolean validate()
	{
	    boolean estate = true;

	    if (ValidateFields.validateNames(av.txt_nameEmplod.getText()))
	    {
	        av.txt_nameEmplod.setBackground(Color.green);
	    }
	    else
	    {
	        av.txt_nameEmplod.setBackground(Color.red);
	        estate = false;
	    }

	    if (ValidateFields.validateDni(av.txt_dniEmplod.getText()))
	    {
	        av.txt_dniEmplod.setBackground(Color.green);
	    }
	    else
	    {
	        av.txt_dniEmplod.setBackground(Color.red);
	        estate = false;
	    }

	    if (ValidateFields.validateCode(new String(av.pwf_codeEmplod.getPassword())))
	    {
	        av.pwf_codeEmplod.setBackground(Color.green);
	    }
	    else
	    {
	        av.pwf_codeEmplod.setBackground(Color.red);
	        estate = false;
	    }

	    if (ValidateFields.validateDate(av.txt_dateEmplod.getText()))
	    {
	        av.txt_dateEmplod.setBackground(Color.green);
	    }
	    else
	    {
	        av.txt_dateEmplod.setBackground(Color.red);
	        estate = false;
	    }

	    return estate;
	}
	
}
