package controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import libreriaVersion1.Files;
import model.Admin;
import model.AdminDAO;
import model.Client;
import model.ClientDAO;
import model.Product;
import model.ProductDAO;
import model.Register;
import model.RegisterDAO;
import viewer.Admin_viewer;
import viewer.Customers;
import viewer.Egress;
import viewer.Inventory;
import viewer.Login;
import viewer.Main_viewer;
import viewer.Record;

public class Logic_view_register implements ActionListener
{
	private Main_viewer mv;
	private Login log;
	private Inventory iv;
	private Customers cs;
	private Egress eg;
	private Record rc;
	private Files photo = new Files ("");
	Admin_viewer av = new Admin_viewer();
	Admin admin = new Admin();
	AdminDAO adao = new AdminDAO();
	
	List <Admin> employees = new ArrayList();
	List <Client> customers = new ArrayList();
	List <Product> products = new ArrayList();
	List <Register> record = new ArrayList();
	
	Product product = new Product ();
	ProductDAO pdao = new ProductDAO ();
	
	Client client = new Client ();
	ClientDAO cdao = new ClientDAO ();
	
	private int discount;
	private DecimalFormat decimalFormat = new DecimalFormat("#.00");
	
	private int countEgree = 0;
	Register register = new Register ();
	RegisterDAO rdao = new RegisterDAO ();
	
	public Logic_view_register (Login log, Admin_viewer av, Main_viewer mv, Inventory iv, Customers cs, Egress eg, Record rc)
	{
		this.iv = iv;
		this.mv = mv;
		this.av = av;
		this.log = log;
		this.cs = cs;
		this.eg = eg;
		this.rc = rc;
		this.mv.btn_inventory.addActionListener(this);
		this.mv.btn_customers.addActionListener(this);
		this.mv.btn_signOut.addActionListener(this);
		this.mv.btn_Egress.addActionListener(this);
		this.mv.btn_record.addActionListener(this);
		
		this.av.btn_singOut.addActionListener(this);
		this.av.btn_searchEmployee.addActionListener(this);
		this.av.btn_accept.addActionListener(this);
		this.av.btn_create.addActionListener(this);
		this.av.btn_photo.addActionListener(this);
		
		this.log.btn_enter.addActionListener(this);
		
		this.iv.btn_addProduct.addActionListener(this);
		this.iv.btn_return.addActionListener(this);
		
		this.cs.btn_addClient.addActionListener(this);
		this.cs.btn_searchClient.addActionListener(this);
		this.cs.btn_changeDatesClient.addActionListener(this);
		this.cs.btn_returnClient.addActionListener(this);
		
		this.eg.btn_discount.addActionListener(this);
		this.eg.btn_calculateTotal.addActionListener(this);
		this.eg.btn_acceptEgress.addActionListener(this);
		this.eg.btn_returnEgress.addActionListener(this);
		this.eg.cmb_products.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) 
            {
                stock();
            }
		});
		
		this.rc.btn_returnRegister.addActionListener(this);
		
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
				cleanAddEmployee();
				cleanResetPass();
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
    					loadPhoto(ad.getPathImage());
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
		if(e.getSource() == av.btn_photo)
		{
			photo.getFileChooser(av, "jpeg");
			loadPhoto(photo.getFile().getAbsolutePath());
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
	            saveFilePhoto();
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
			boolean find = false;
			for (Admin ad : employees)
			{
				if (ad.getDni().equals(admin.getDni()))
				{
					find = true;
				}
			}
			if (find)
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
	                    adao.replaceEmployees(ad);
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
			cleanProductsField ();
			
			int numProductos;
			try {
				numProductos = pdao.numProducts();
				iv.lbl_products.setText("<html>N. productos registrados: <font color='red'>" + numProductos + "</font></html>");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(mv, "First Time to enter", "First", JOptionPane.INFORMATION_MESSAGE);
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
		if(e.getSource() == iv.btn_return)
		{
			mv.setVisible(true);
			mv.setLocationRelativeTo(null);
			iv.dispose();
		}
		
		/*--------------------------------------------------------
		 * Inicio de la interfaz de Clientes
		 *-------------------------------------------------------- 
		 * */
		if (e.getSource() == mv.btn_customers)
		{
			cs.setVisible(true);
			cs.setLocationRelativeTo(null);
			mv.dispose();
			updateListClients();
		}
		if (e.getSource() == cs.btn_addClient)
		{
			if (validateFClient())
			{
				client.setName(cs.txt_nameClient.getText());
				client.setAddress(cs.txt_addressClient.getText());
				client.setContact(cs.txt_contactClient.getText());
				
				try {
					cdao.writeCustomers(client);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(cs, "Cliente agregado");
				updateListClients();
			}
		}
		if (e.getSource() == cs.btn_searchClient)
		{
			client.setName(cs.txt_nameSearchClient.getText());
			boolean found = false;
			try {
				customers = cdao.readerCustomers();
				for (Client cl : customers)
				{
					if (cl.getName().equals(client.getName()))
					{
						found = true;
						break;
					}
				}
					if (found)
					{
						cs.lbl_findClient.setText("Encontrado");
						cs.lbl_findClient.setForeground(Color.green);
					}
					else
					{
						cs.lbl_findClient.setText("No encontrado");
						cs.lbl_findClient.setForeground(Color.red);
					}
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == cs.btn_changeDatesClient)
		{
			String name = cs.txt_nameSearchClient.getText();
			try {
				customers = cdao.readerCustomers();
				boolean found = false;
				
				for (Client cl : customers)
				{
					if (cl.getName().equals(name))
					{
						if(cs.rbd_addressClientChange.isSelected())
						{
							cl.setAddress(JOptionPane.showInputDialog(cs, "Nueva Direccion: "));
						}
						if(cs.rbd_contactClientChange.isSelected())
						{
							cl.setContact(JOptionPane.showInputDialog(cs, "Nuevo Contacto: "));
						}
						cdao.refreshClient(cl);
						found = true;
						break;
					}
				}
				if (found)
				{
					JOptionPane.showMessageDialog(cs, "Datos cambiados correctamente");
					updateListClients();
				}
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == cs.btn_returnClient)
		{
			mv.setVisible(true);
			mv.setLocationRelativeTo(null);
			cs.dispose();
		}
		/*--------------------------------------------------------
		 * Fin de La interfaz Cliente
		 *-------------------------------------------------------- 
		 * */
		
		/*-------------------------------------------------------- 
		 * Inicio de la interfaz de Punto de venta
		 * -------------------------------------------------------- 
		 * */
		if (e.getSource() == mv.btn_Egress)
		{
			eg.setVisible(true);
			eg.setLocationRelativeTo(null);
			mv.dispose();
			loadProducts();
			loadCustomers();
			stock();
		}
		
		if (e.getSource() == eg.btn_discount)
		{
			if (eg.cmb_customers.getSelectedItem() != null || eg.cmb_products.getSelectedItem() != null)
			{
				discount = discountType();
				
				eg.lbl_discountType.setText("<html><font color='blue'>Descuento: <font color='purple'>" + discount + "</font></html>");
			}
			else
			{
				JOptionPane.showMessageDialog(eg, "Debe seleccionar un producto y un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if (e.getSource() == eg.btn_calculateTotal) 
		{
			String productName = (String) eg.cmb_products.getSelectedItem();
			int quantity = (int) eg.spn_stock.getValue();
			try {
				products = pdao.readerProducts();
				for (Product pd : products)
				{
					if (pd.getName().equals(productName))
					 {
							 double total = total(pd.getPrice(), discount, quantity);
							 eg.lbl_tax.setText("<html>IVA: <font color='purple'>" + decimalFormat.format(calculateIva(pd.getPrice(), discount)) + "$</font></html>");
				             eg.lbl_total.setText(decimalFormat.format(total) + "$");
				             eg.lbl_total.setForeground(Color.blue);
				             break;
						 
					 }
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(eg, "Error al procesar la venta", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			
		}
		
		if (e.getSource() == eg.btn_acceptEgress)
		{
			String getSelectItem = (String) eg.cmb_products.getSelectedItem();
			String getSelectClient = (String) eg.cmb_customers.getSelectedItem();
			int getStock = (int) eg.spn_stock.getValue();
			String date = getDate();
			
			register.setNameProduct(getSelectItem);
			register.setClient(getSelectClient);
			register.setStockEgree(getStock);
			register.setDate(date);
			
			try {
				rdao.writeRegister(register);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    String productName = (String) eg.cmb_products.getSelectedItem();
		    int quantitySold = (int) eg.spn_stock.getValue();

		    try {
		        products = pdao.readerProducts();

		        for (Product pd : products) 
		        {
		            if (pd.getName().equals(productName)) 
		            {
		            	if(pd.getStock() < quantitySold)
						{
							JOptionPane.showMessageDialog(eg, "Error al procesar, el stock supera al numero del inventario", "Error", JOptionPane.ERROR_MESSAGE);
							stock();
							break;
						}
		            	else
		            	{
		            		int updatedStock = pd.getStock() - quantitySold;
			                pd.setStock(updatedStock);

			                pdao.replaceProducts(pd);

			                JOptionPane.showMessageDialog(eg, "Venta procesada correctamente");
							mv.setVisible(true);
							mv.setLocationRelativeTo(null);
							eg.dispose();
							countEgree += 1;
			                break;
		            	}
		            }
		        }
		    } catch (IOException e1) {
		        e1.printStackTrace();
		        JOptionPane.showMessageDialog(eg, "Error al procesar la venta", "Error", JOptionPane.ERROR_MESSAGE);
		    }
		}
		if (e.getSource() == eg.btn_returnEgress)
		{
			mv.setVisible(true);
			mv.setLocationRelativeTo(null);
			eg.dispose();
		}
		/*--------------------------------------------------------
		 * Fin de la interfaz de Egreso
		 * --------------------------------------------------------
		 * */
		/*--------------------------------------------------------
		 * Inicio de la interfaz del registro de ventas
		 * --------------------------------------------------------
		 * */
		if (e.getSource() == mv.btn_record)
		{
			rc.setVisible(true);
			rc.setLocationRelativeTo(null);
			mv.dispose();
			rc.lbl_numEgree.setText(String.valueOf(countEgree));
			rc.lbl_numEgree.setForeground(Color.magenta);
			listEgree();
		}
		if (e.getSource() == rc.btn_returnRegister)
		{
			mv.setVisible(true);
			mv.setLocationRelativeTo(null);
			rc.dispose();
		}
	}
	
	private void updateListClients() 
	{
	    DefaultListModel<String> listModel = new DefaultListModel<>();
	    int indice = 1;
	    try {
	        customers = cdao.readerCustomers();
	        for (Client cl : customers) 
	        {
	            listModel.addElement(indice+ ". " + cl.getName() +" | "+ cl.getContact());
	            indice++;
	        }
	        indice = 0;
	        cs.lst_customers.setModel(listModel);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	private void listEgree ()
	{
		DefaultListModel<String> listModel = new DefaultListModel<>();
		int indice = 1;
		
		try {
	        record = rdao.readerRegister();
	        
	        for (Register rg : record) {
	            String listItem = "<html><b>Registro " + indice + "</b><br>";
	            listItem += "<font color='blue'>Fecha:</font> " + rg.getDate() + "<br>";
	            listItem += "<font color='green'>Producto:</font> " + rg.getNameProduct() + "<br>";
	            listItem += "<font color='red'>Stock:</font> " + rg.getStockEgree() + "<br>";
	            listItem += "<font color='purple'>Cliente:</font> " + rg.getClient() + "<br>";
	            listItem += "</html>";
	            
	            listModel.addElement(listItem);
	            indice++;
	        }
	        indice = 0;
	        rc.lst_register.setModel(listModel);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	private void loadProducts ()
	{
		try {
			products = pdao.readerProducts();
			eg.cmb_products.removeAllItems();
			for (Product pd : products)
			{
				eg.cmb_products.addItem(pd.getName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(eg, "Non-existent products", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void loadCustomers ()
	{
		try {
			customers = cdao.readerCustomers();
			eg.cmb_customers.removeAllItems();
			for (Client cl : customers)
			{
				eg.cmb_customers.addItem(cl.getName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(eg, "Non-existent customers", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	private int discountType ()
	{
		int type = (int) (Math.random() * 3) + 1;
		int discount = 0;
		
		if (type == 1)
		{
			discount = 5;
			JOptionPane.showMessageDialog(eg, "[1] Asombroso, tu descuento es de: " + discount);
		}
		else if (type == 2)
		{
			discount = 7;
			JOptionPane.showMessageDialog(eg, "[2] Asombroso, tu descuento es de: " + discount);
		}
		else
		{
			discount = 9;
			JOptionPane.showMessageDialog(eg, "[3] Asombroso, tu descuento es de: " + discount);
		}
		return discount;
	}

	private double calculateIva(double price, double discount) 
	{
	    double discountedPrice = price - (price * (discount / 100));
	    double iva = discountedPrice * 0.12; // IVA del 12%
	    return iva;
	}
	private double total(double price, double discount, int quantity) 
	{
	    double discountedPrice = price - (price * (discount / 100));
	    double iva = calculateIva(price, discount);
	    return (discountedPrice + iva) * quantity;
	}
	private void stock ()
	{
		String selectedProduct = (String) eg.cmb_products.getSelectedItem();
	    if (selectedProduct != null) 
	    {
	        try {
	            products = pdao.readerProducts();
	            for (Product pd : products) 
	            {
	                if (pd.getName().equals(selectedProduct)) 
	                {
	                    eg.lbl_numStock.setText(String.valueOf(pd.getStock()));
	                    break;
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(eg, "Error al leer los productos", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}
	private String getDate()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        return formatter.format(date);
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
	
	public boolean validateFClient ()
	{
		boolean estate = true;
		if (ValidateFields.validateNames(cs.txt_nameClient.getText()))
		{
			cs.txt_nameClient.setBackground(Color.green);
		}
		else
		{
			cs.txt_nameClient.setBackground(Color.red);
			estate = false;
		}
		if (ValidateFields.validateAddress(cs.txt_addressClient.getText()))
		{
			cs.txt_addressClient.setBackground(Color.green);
		}
		else
		{
			cs.txt_addressClient.setBackground(Color.red);
			estate = false;
		}
		if (ValidateFields.validateContact(cs.txt_contactClient.getText()))
		{
			cs.txt_contactClient.setBackground(Color.green);
		}
		else
		{
			cs.txt_contactClient.setBackground(Color.red);
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
	
	private void loadPhoto (String path)
	{
		ImageIcon photo = new ImageIcon (path);
		Image img = photo.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		mv.lbl_photo.setIcon(new ImageIcon(img));
	}
	
	private void saveFilePhoto ()
	{
		Files photoDest = new Files (adao.Path + "/" + admin.getDni() + ".jpg");
		try {
			java.nio.file.Files.copy(photo.getFile().toPath(), photoDest.getFile().toPath());
			admin.setPathImage(photoDest.getFile().getAbsolutePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		av.lbl_estate.setForeground(Color.black);
	}
	
	public void cleanProductsField ()
	{
		iv.txt_nameProduct.setText("");
		iv.txt_nameProduct.setBackground(Color.white);
		iv.txtp_description.setText("");
		iv.spn_price.setValue(0);
		iv.spn_stock.setValue(0);
	}
}
