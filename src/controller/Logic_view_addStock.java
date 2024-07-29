package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Product;
import model.ProductDAO;
import viewer.AddStock;
import viewer.Inventory;

public class Logic_view_addStock implements ActionListener
{
	private AddStock as;
	private Product product = new Product();
	private ProductDAO pdao;
	
	public Logic_view_addStock (AddStock as)
	{
		this.as = as;
		this.pdao = new ProductDAO();
		
		this.as.btn_accept.addActionListener(this);
		this.as.btn_Return.addActionListener(this);
		
		this.as.cmb_products.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) 
            {
                stock();
            }
		});
		
		loadComboBox();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if (e.getSource() == as.btn_accept)
		{
			addStock();
			as.dispose();
		}
		else if (e.getSource() == as.btn_Return)
		{		
			as.dispose();
		}
	}
	
	public void loadComboBox ()
	{
		List <Product> products = new ArrayList ();
		
		try {
			products = pdao.readerProducts();
			
			as.cmb_products.removeAllItems();
			for (Product p : products)
			{
				as.cmb_products.addItem(p.getName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(as, "Non-existent products", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void addStock ()
	{
		String product = (String) as.cmb_products.getSelectedItem();
		int newStock = (int) as.spn_stock.getValue();
		List <Product> products = new ArrayList ();
		try {
			products = pdao.readerProducts();
			for (Product p : products)
			{
				if (p.getName().equals(product))
				{
					int updateStock = p.getStock() + newStock;
					
					p.setStock(updateStock);
					
					pdao.replaceProducts(p);
					System.out.println("agregado correctamente");
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	private void stock ()
	{
		List <Product> products = new ArrayList ();
		
		String selectedProduct = (String) as.cmb_products.getSelectedItem();
	    if (selectedProduct != null) 
	    {
	        try {
	            products = pdao.readerProducts();
	            for (Product pd : products) 
	            {
	                if (pd.getName().equals(selectedProduct)) 
	                {
	                    as.lbl_numStock.setText("Current Stock: " + String.valueOf(pd.getStock()));
	                    break;
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(as, "Error al leer los productos", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}
}
