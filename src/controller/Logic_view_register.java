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
import model.Product;
import model.ProductDAO;
import viewer.Admin_viewer;
import viewer.Inventory;
import viewer.Login;
import viewer.Main_viewer;

public class Logic_view_register implements ActionListener
{
	private Main_viewer mv;
	private Login log;
	private Inventory iv;
	Admin_viewer av = new Admin_viewer();
	Admin admin = new Admin();
	AdminDAO adao = new AdminDAO();
	List <Admin> employees = new ArrayList();
	
	Product product = new Product ();
	ProductDAO pdao = new ProductDAO ();
	
	public Logic_view_register (Login log, Admin_viewer av, Main_viewer mv, Inventory iv)
	{
		this.iv = iv;
		this.mv = mv;
		this.av = av;
		this.log = log;
		this.mv.btn_inventory.addActionListener(this);
		this.mv.btn_signOut.addActionListener(this);
		
		this.iv.btn_addProduct.addActionListener(this);
		
		this.av.btn_singOut.addActionListener(this);
		this.av.btn_searchEmployee.addActionListener(this);
		this.av.btn_accept.addActionListener(this);
		this.av.btn_create.addActionListener(this);
		
		this.log.btn_enter.addActionListener(this);
	}
	
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
    					
    					mv.lbl_nameEmployee.setText(ad.getName());
    					mv.lbl_dniEmployee.setText(ad.getDni());
    					mv.lbl_codeEmployee.setText(ad.getCode());
    					mv.lbl_nameEmployee.setForeground(Color.green);
    					mv.lbl_dniEmployee.setForeground(Color.green);
    					mv.lbl_codeEmployee.setForeground(Color.magenta);
    					return;
    			}
    		}
    		JOptionPane.showMessageDialog(log, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
		}
		if (e.getSource() == mv.btn_signOut)
		{
			log.setVisible(true);
			log.setLocationRelativeTo(null);
			mv.dispose();
			cleanLogin();
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
				cleanAddEmployee();
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
		if (e.getSource() == av.btn_accept) {
	        String dni = av.txt_dniEmployeeAux.getText();
	        String newPassword = new String(av.pwd_newPassword.getPassword());
	        
	        employees = adao.readerEmployees();
	        
	        boolean found = false;
	        for (Admin ad : employees) 
	        {
	            if (ad.getDni().equals(dni)) 
	            {
	                ad.setPassword(newPassword);
	                try {
	                    adao.replaceEmployees(ad); // Asegúrate de que este método realmente actualice el empleado
	                    found = true;
	                } catch (IOException e1) {
	                    e1.printStackTrace();
	                }
	                break;
	            }
	        }
	        
	        if (found) 
	        {
	            JOptionPane.showMessageDialog(av, "Password changed");
	            cleanResetPass();
	        } else 
	        {
	            JOptionPane.showMessageDialog(av, "Employee not found", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
		if (e.getSource() == av.btn_singOut)
		{
			log.setVisible(true);
			log.setLocationRelativeTo(null);
			av.dispose();
			cleanLogin();
			return;
		}
		if (e.getSource() == mv.btn_inventory)
		{
			iv.setVisible(true);
			iv.setLocationRelativeTo(null);
			mv.dispose();
			
			int numProductos;
			try {
				numProductos = pdao.numProducts();
				iv.lbl_products.setText("<html>N. productos registrados: <font color='red'>" + numProductos + "</font></html>");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if (e.getSource() == iv.btn_addProduct)
		{
			if (validateProduct())
			{
				product.setName(iv.txt_nameProduct.getText());
				product.setDescription(iv.txtp_description.getText());
				int stock = (int) iv.spn_stock.getValue();
				product.setStock(stock);
				double price = (double) iv.spn_price.getValue();
				product.setPrice(price);
				product.setSupplier("La favorita");
				try {
					pdao.writeProducts(product);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(iv, "Producto agregado");
				
				mv.setVisible(true);
				mv.setLocationRelativeTo(null);
				iv.dispose();
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
	
	public boolean validateProduct ()
	{
		boolean estate = true;
		if (ValidateFields.validateNameProduct(iv.txt_nameProduct.getText()))
		{
			iv.txt_nameProduct.setBackground(Color.green);
		}
		else
		{
			iv.txt_nameProduct.setBackground(Color.red);
			estate = false;
		}
		return estate;
	}
	
	public void cleanLogin ()
	{
		log.txt_user.setText("");
		log.pwf_pasword.setText("");
	}
	
	public void cleanAddEmployee ()
	{
		av.txt_nameEmplod.setText("");
		av.txt_nameEmplod.setBackground(Color.white);
		av.txt_dniEmplod.setText("");
		av.txt_dniEmplod.setBackground(Color.white);
		av.txt_dateEmplod.setText("");
		av.txt_dateEmplod.setBackground(Color.white);
		av.pwf_codeEmplod.setText("");
		av.pwf_codeEmplod.setBackground(Color.white);
	}
	
	public void cleanResetPass ()
	{
		av.txt_dniEmployeeAux.setText("");
		av.pwd_newPassword.setText("");
		av.lbl_estate.setText("Desconocido");
		av.lbl_estate.setForeground(Color.white);
	}
}
