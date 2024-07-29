package controller;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
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

import com.mysql.cj.log.Log;

import libreriaVersion3.Files;
import model.Admin;
import model.AdminDAO;
import model.Client;
import model.ClientDAO;
import model.Product;
import model.ProductDAO;
import model.Register;
import model.RegisterDAO;
import model.SupplierDAO;
import model.Suppliers;
import viewer.AddStock;
import viewer.Admin_viewer;
import viewer.ChangePw;
import viewer.Customers;
import viewer.Egress;
import viewer.Inventory;
import viewer.Login;
import viewer.Main_viewer;
import viewer.Record;
import viewer.Report;
import viewer.Supplier;

public class Logic_view_register implements ActionListener
{
	private Main_viewer mv;
	private Login log;
	private Inventory iv;
	private Customers cs;
	private Egress eg;
	private Record rc;
	private Supplier sp;
	private Files photo = new Files ("");
	private Admin_viewer av = new Admin_viewer();
	private Admin admin = new Admin();
	private AdminDAO adao = new AdminDAO();
	// List que contrendran la lectura de cada archivo de texto
	List <Admin> employees = new ArrayList();
	List <Client> customers = new ArrayList();
	List <Product> products = new ArrayList();
	List <Register> record = new ArrayList();
	List <Suppliers> suppliers = new ArrayList();
	
	private Product product = new Product ();
	private ProductDAO pdao = new ProductDAO ();
	
	private Client client = new Client ();
	private ClientDAO cdao = new ClientDAO ();
	
	private int discount;
	private DecimalFormat decimalFormat = new DecimalFormat("0.00");
	
	private int countEgree = 0;
	private Register register = new Register ();
	private RegisterDAO rdao = new RegisterDAO ();
	
	private Suppliers supplier = new Suppliers ();
	private SupplierDAO sdao = new SupplierDAO();
	
	private ChangePw cp;
	private int attempts = 0;
	
	public Logic_view_register (Login log, Admin_viewer av, Main_viewer mv, Inventory iv, Customers cs, Egress eg, Record rc, Supplier sp, ChangePw cp)
	{
		this.iv = iv;	// Inventario
		this.mv = mv;	// Main_viewer
		this.av = av;	// Inventario
		this.log = log;	// Login
		this.cs = cs;	// Customers
		this.eg = eg;	// Egree
		this.rc = rc;	// Register
		this.sp = sp;	// Supplier
		this.cp = cp;	// Change pw
		
		// Botones del main Viewer
		this.mv.btn_inventory.addActionListener(this);
		this.mv.btn_customers.addActionListener(this);
		this.mv.btn_signOut.addActionListener(this);
		this.mv.btn_Egress.addActionListener(this);
		this.mv.btn_record.addActionListener(this);
		this.mv.btn_supplier.addActionListener(this);
		this.mv.btn_changePassword.addActionListener(this);
		// Botones change Pw
		this.cp.btn_accept.addActionListener(this);
		this.cp.btn_findOut.addActionListener(this);
		this.cp.btn_return.addActionListener(this);
		// Botones del admin Viewer
		this.av.btn_singOut.addActionListener(this);
		this.av.btn_searchEmployee.addActionListener(this);
		this.av.btn_accept.addActionListener(this);
		this.av.btn_create.addActionListener(this);
		this.av.btn_photo.addActionListener(this);
		this.av.btn_gitHub.addActionListener(this);
		// Botones del login
		this.log.btn_enter.addActionListener(this);
		this.log.btn_goOut.addActionListener(this);
		// Botones del inventario
		this.iv.btn_addProduct.addActionListener(this);
		this.iv.btn_return.addActionListener(this);
		this.iv.btn_addStock.addActionListener(this);
		// Botones de customers
		this.cs.btn_addClient.addActionListener(this);
		this.cs.btn_searchClient.addActionListener(this);
		this.cs.btn_changeDatesClient.addActionListener(this);
		this.cs.btn_returnClient.addActionListener(this);
		// Botones del egreso
		this.eg.btn_discount.addActionListener(this);
		this.eg.btn_calculateTotal.addActionListener(this);
		this.eg.btn_acceptEgress.addActionListener(this);
		this.eg.btn_returnEgress.addActionListener(this);
		// Funcion que actualiza el stock de cada producto
		this.eg.cmb_products.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) 
            {
                stock();
            }
		});
		// Botones del register
		this.rc.btn_returnRegister.addActionListener(this);
		this.rc.btn_report.addActionListener(this);
		// Botones del supllier
		this.sp.btn_addSupplier.addActionListener(this);
		this.sp.btn_returnSupplier.addActionListener(this);
		
		ProcessStock hilo = new ProcessStock(pdao);
		hilo.start();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		/*--------------------------------------------------------
		 * Funciones de la ventana de logeo, incluido el sing out del main Viewer
		 * --------------------------------------------------------
		 * */
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
            try {
				employees = adao.readerEmployees();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
			}
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
    					mv.lbl_nameEmployee.setForeground(Color.blue);
    					mv.lbl_dniEmployee.setForeground(Color.blue);
    					mv.lbl_codeEmployee.setForeground(Color.magenta);
    					loadPhoto(ad.getPathImage());
    					return;
    			}
    		}
    		JOptionPane.showMessageDialog(log, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
		}
		if (e.getSource() == log.btn_goOut)
		{
			int response = JOptionPane.showConfirmDialog(log, "Seguro que desea salir?", "Go Out", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (response == JOptionPane.YES_OPTION) {
                log.dispose();
            }
		}
		if (e.getSource() == mv.btn_signOut)
		{
			log.setVisible(true);
			log.setLocationRelativeTo(null);
			mv.dispose();
			cleanLogin();
		}
		/*--------------------------------------------------------
		 * Funciones de la interfaz del administrador
		 * --------------------------------------------------------
		 * */
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
					adao.insertBBDD(admin);
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
			try {
				employees = adao.readerEmployees();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(mv, "no Employees created", "First", JOptionPane.INFORMATION_MESSAGE);
			}
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
	        
	        try {
				employees = adao.readerEmployees();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(mv, "First Time to enter", "First", JOptionPane.ERROR_MESSAGE);
			}
	        
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
		/*--------------------------------------------------------
		 * Inicio de la interfaz de cambiar pasword
		 * --------------------------------------------------------
		 * */
		if (e.getSource() == mv.btn_changePassword)
		{
			cp.setVisible(true);
			cp.setLocationRelativeTo(null);
			mv.dispose();
			
			cp.pwf_currentPW.setEnabled(false);
			cp.btn_accept.setEnabled(false);
		}
		else if (e.getSource() == cp.btn_findOut)
		{
		    String previousPassword = new String(cp.pwf_previousPW.getPassword());
		    String password = new String (log.pwf_pasword.getPassword());
		    try {
		        employees = adao.readerEmployees();
		        boolean flag = false;
		        

		        if (password.equals(previousPassword))
	            {
	                cp.pwf_currentPW.setEnabled(true);
	                cp.btn_accept.setEnabled(true);
	                flag = true;
	               
	            }
		        if (!flag)
		        {
		            attempts++;
		            if (attempts <= 3)
		            {
		                JOptionPane.showMessageDialog(cp, "Incorrect Password", "Attempt " + attempts + "/3", JOptionPane.WARNING_MESSAGE);
		            }
		            else
		            {
		                JOptionPane.showMessageDialog(cp, "Excess!!!", "Coming out", JOptionPane.WARNING_MESSAGE);
		                cp.dispose();
		                log.setVisible(true);
		                cleanLogin();
		                attempts = 0;
		            }
		        }
		    } catch (IOException e1) {
		        e1.printStackTrace();
		    }
		}
		else if (e.getSource() == cp.btn_accept)
		{
			String newPassword = new String (cp.pwf_currentPW.getPassword());
			String previousPassword = new String(cp.pwf_previousPW.getPassword());
			boolean flag = false;
			try {
				employees = adao.readerEmployees();
				for (Admin a : employees)
				{
					if (a.getPassword().equals(previousPassword))
					{
						a.setPassword(newPassword);
						
						adao.replaceEmployees(a);
						flag = true;
					}
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (flag)
			{
				JOptionPane.showMessageDialog(cp, "Password changed");
			}
		}
		else if (e.getSource() == cp.btn_return)
		{
			mv.setVisible(true);
			mv.setLocationRelativeTo(null);
			
			cp.dispose();
		}
		/*--------------------------------------------------------
		 * Inicio de la interfaz de inventario
		 * --------------------------------------------------------
		 * */
		if (e.getSource() == mv.btn_inventory)
		{
			iv.setVisible(true);
			iv.setLocationRelativeTo(null);
			mv.dispose();
			cleanProductsField ();
			loadSuppliers();
			
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
				String supplier = (String) iv.cmb_supplier.getSelectedItem();
				product.setSupplier(supplier);
				try {
					pdao.writeProducts(product);
					pdao.insertBBDD(product);
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
		if (e.getSource() == iv.btn_addStock)
		{
			AddStock as = new AddStock();
			
			as.setVisible(true);
			as.setLocationRelativeTo(null);

		}
		if(e.getSource() == iv.btn_return)
		{
			mv.setVisible(true);
			mv.setLocationRelativeTo(null);
			iv.dispose();
		}
		/*--------------------------------------------------------
		 * Fin de la interfaz de inventario
		 * --------------------------------------------------------
		 * */
		
		/*--------------------------------------------------------
		 * Inicio de la interfaz de Clientes
		 *-------------------------------------------------------- 
		 * */
		if (e.getSource() == mv.btn_customers)
		{
			cs.setVisible(true);
			cs.setLocationRelativeTo(null);
			mv.dispose();
			cleanCustomers();
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
					cdao.insertBBDD(client);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(cs, "Cliente agregado");
				cleanCustomers ();
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
				JOptionPane.showMessageDialog(mv, "First Time to enter", "First", JOptionPane.INFORMATION_MESSAGE);
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
				JOptionPane.showMessageDialog(mv, "no customers created", "First", JOptionPane.INFORMATION_MESSAGE);
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
			cleanEgree();
			loadProducts();
			loadCustomers();
			stock();
		}
		
		if (e.getSource() == eg.btn_discount)
		{
			if (eg.cmb_customers.getSelectedItem() != null || eg.cmb_products.getSelectedItem() != null)
			{
				discount = discountType();
				
				eg.lbl_discountType.setText("<html><font color='blue'>des: <font color='purple'>" + discount + "%</font></html>");
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
				JOptionPane.showMessageDialog(eg, "Error al procesar la venta", "Error", JOptionPane.ERROR_MESSAGE);
			}	
		}
		
		if (e.getSource() == eg.btn_acceptEgress)
		{
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
		        				rdao.insertBBDD(register);
		        			} catch (IOException e1) {
		        				// TODO Auto-generated catch block
		        				e1.printStackTrace();
		        			}
		        			
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
		if (e.getSource() == rc.btn_report)
		{
			Report rp = new Report();
			
			rp.setVisible(true);
			rp.setLocationRelativeTo(null);
		}
		if (e.getSource() == rc.btn_returnRegister)
		{
			mv.setVisible(true);
			mv.setLocationRelativeTo(null);
			rc.dispose();
		}
		/*--------------------------------------------------------
		 * Fin de la interfaz de registro de ventas
		 * --------------------------------------------------------
		 * */
		/*--------------------------------------------------------
		 * Inicio de la interface de Proveedores
		 * --------------------------------------------------------
		 * */
		if (e.getSource() == mv.btn_supplier)
		{
			sp.setVisible(true);
			sp.setLocationRelativeTo(null);
			mv.dispose();
			cleanSupplier();
			updateListSuppliers();
		}
		
		if (e.getSource() == sp.btn_addSupplier)
		{
			if (validateSupplier())
			{
				supplier.setName(sp.txt_nameSupplier.getText());
				supplier.setEmail(sp.txt_emailSupplier.getText());
				supplier.setDni(sp.txt_dniSupplier.getText());
				supplier.setPhone(sp.txt_phoneSupplier.getText());
				supplier.setBusinessName(sp.txt_businessName.getText());
				supplier.setCode(new String (sp.pwf_codeSupplier.getPassword()));
				
				try {
					sdao.writeSupplier(supplier);
					JOptionPane.showMessageDialog(sp, "Proveedor agregado correctamente");
					mv.setVisible(true);
					mv.setLocationRelativeTo(null);
					sp.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if (e.getSource() == sp.btn_returnSupplier)
		{
			mv.setVisible(true);
			mv.setLocationRelativeTo(null);
			sp.dispose();
		}
		/*--------------------------------------------------------
		 * Fin de la interfaz de proveedor
		 * --------------------------------------------------------
		 * */
		/*--------------------------------------------------------
		 * Pagina de GITHUB
		 * --------------------------------------------------------
		 * */
		if (e.getSource() == av.btn_gitHub) 
		{
		    int response = JOptionPane.showConfirmDialog(av, "Desea ir al repositorio?", "Confirmar", JOptionPane.YES_NO_OPTION);
		    if (response == JOptionPane.YES_OPTION) 
		    {
		        try {
		            Desktop.getDesktop().browse(new URI("https://github.com/FLiamTech/Proyect-Programacion"));
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		}
	}
	/*--------------------------------------------------------
	 * Carga los datos en las diferentes tablas de las interfaces
	 * --------------------------------------------------------
	 * */
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
	    	JOptionPane.showMessageDialog(mv, "First Time to enter", "First", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
	
	private void listEgree ()
	{
		DefaultListModel<String> listModel = new DefaultListModel<>();
		int indice = 1;
		
		try {
	        record = rdao.readerRegister();
	        
	        for (Register rg : record) 
	        {
	            String listItem = "<html><b>Registro " + indice + "</b><br>";
	            listItem += "<font color='brown'>Fecha:</font> " + rg.getDate() + "<br>";
	            listItem += "<font color='yellow'>Producto:</font> " + rg.getNameProduct() + "<br>";
	            listItem += "<font color='blue'>Stock:</font> " + rg.getStockEgree() + "<br>";
	            listItem += "<font color='red'>Cliente:</font> " + rg.getClient() + "<br>";
	            listItem += "</html>";
	            
	            listModel.addElement(listItem);
	            indice++;
	        }
	        indice = 0;
	        rc.lst_register.setModel(listModel);
	    } catch (IOException e) {
	    	JOptionPane.showMessageDialog(mv, "First Time to enter", "First", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
	
	private void updateListSuppliers ()
	{
		DefaultListModel<String> listModel = new DefaultListModel<>();
		int indice = 1;
		
		try {
			suppliers = sdao.readerSupplier();
			for (Suppliers sp : suppliers)
			{
				listModel.addElement(indice + ". " + sp.getName() + " ; " + sp.getBusinessName());
				indice ++;
			}
			indice = 0;
			sp.lst_suppliers.setModel(listModel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		}
	}
	/*--------------------------------------------------------
	 * Carga los datos en los combo box de las ventanas que lo requieran
	 * --------------------------------------------------------
	 * */
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
	private void loadSuppliers ()
	{
		try {
			suppliers = sdao.readerSupplier();
			iv.cmb_supplier.removeAllItems();
			for (Suppliers sp : suppliers)
			{
				iv.cmb_supplier.addItem(sp.getName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(eg, "Non-existent Suppliers", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	/*--------------------------------------------------------
	 * Operaciones de la ventana de Egreso
	 * --------------------------------------------------------
	 * */
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

	private double calculateIva(double price, int discount) 
	{
	    double discountedPrice = price - (price * (discount / 100));
	    double iva = discountedPrice * 0.12; // IVA del 12%
	    return iva;
	}
	private double total(double price, int discount, int quantity) 
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
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return formatter.format(date);
    }
	
	/*--------------------------------------------------------
	 * Validar los campos con su respectiva expresion regular
	 * --------------------------------------------------------
	 * */
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
	
	public boolean validateSupplier ()
	{
		boolean estate = true;
		if (ValidateFields.validateNameSup(sp.txt_nameSupplier.getText()))
		{
			sp.txt_nameSupplier.setBackground(Color.yellow);
		}
		else
		{
			sp.txt_nameSupplier.setBackground(Color.magenta);
			estate = false;
		}
		if (ValidateFields.validateEmail(sp.txt_emailSupplier.getText()))
		{
			sp.txt_emailSupplier.setBackground(Color.yellow);
		}
		else
		{
			sp.txt_emailSupplier.setBackground(Color.magenta);
			estate = false;
		}
		if (ValidateFields.validateDni(sp.txt_dniSupplier.getText()))
		{
			sp.txt_dniSupplier.setBackground(Color.yellow);
		}
		else
		{
			sp.txt_dniSupplier.setBackground(Color.magenta);
			estate = false;
		}
		if (ValidateFields.validateContact(sp.txt_phoneSupplier.getText()))
		{
			sp.txt_phoneSupplier.setBackground(Color.yellow);
		}
		else
		{
			sp.txt_phoneSupplier.setBackground(Color.magenta);
			estate = false;
		}
		if (ValidateFields.validateBusinessName(sp.txt_businessName.getText()))
		{
			sp.txt_businessName.setBackground(Color.yellow);
		}
		else
		{
			sp.txt_businessName.setBackground(Color.magenta);
			estate = false;
		}
		if (ValidateFields.validateCode(new String (sp.pwf_codeSupplier.getPassword())))
		{
			sp.pwf_codeSupplier.setBackground(Color.yellow);
		}
		else
		{
			sp.pwf_codeSupplier.setBackground(Color.magenta);
			estate = false;
		}
		return estate;
	}
	/*--------------------------------------------------------
	 * Cargar, mostrar y guardar la foto
	 * --------------------------------------------------------
	 * */
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
	/*--------------------------------------------------------
	 * Funciones de limpieza de campos de cada interfaz
	 * --------------------------------------------------------
	 * */
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
	
	public void cleanSupplier ()
	{
		sp.txt_nameSupplier.setText("");
		sp.txt_emailSupplier.setText("");
		sp.txt_dniSupplier.setText("");
		sp.txt_phoneSupplier.setText("");
		sp.txt_businessName.setText("");
		sp.pwf_codeSupplier.setText("");
		sp.txt_nameSupplier.setBackground(Color.white);
		sp.txt_emailSupplier.setBackground(Color.white);
		sp.txt_dniSupplier.setBackground(Color.white);
		sp.txt_phoneSupplier.setBackground(Color.white);
		sp.txt_businessName.setBackground(Color.white);
		sp.pwf_codeSupplier.setBackground(Color.white);
	}
	
	public void cleanCustomers ()
	{
		cs.txt_addressClient.setText("");
		cs.txt_contactClient.setText("");
		cs.txt_nameClient.setText("");
		cs.txt_nameSearchClient.setText("");
		cs.lbl_findClient.setText("Desconocido");
		cs.txt_addressClient.setBackground(Color.white);
		cs.txt_contactClient.setBackground(Color.white);
		cs.txt_nameClient.setBackground(Color.white);
		cs.lbl_findClient.setForeground(Color.black);
	}
	
	public void cleanEgree ()
	{
		eg.spn_stock.setValue(0);
		eg.lbl_discountType.setText("Descuento");
		eg.lbl_tax.setText("Descuento");
		eg.lbl_total.setText("Total");
		
		eg.lbl_discountType.setForeground(Color.black);
		eg.lbl_tax.setForeground(Color.black);
		eg.lbl_total.setForeground(Color.black);
	}
	/*--------------------------------------------------------
	 * Fin
	 * --------------------------------------------------------
	 * */
}
