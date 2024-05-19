package model;

import libreriaVersion1.Generica;

public class Product 
{
	Generica <String, String> dt_p1;
	Generica <Integer, Double> dt_p2;
	public Product ()
	{
		super();
		dt_p1 = new Generica<> ();
		dt_p2 = new Generica<> ();
	}
	
	public Product (String name, String description, Integer stock, Double price, String supplier)
	{
		dt_p1 = new Generica <> (name, description, supplier);
		dt_p2 = new Generica <> (stock, price);
	}
	
	public String getName ()
	{
		return dt_p1.getAttribute1();
	}
	
	public void setName (String name)
	{
		this.dt_p1.setAttribute1(name);
	}
	
	public String getDescription ()
	{
		return dt_p1.getAttribute2();
	}
	
	public void setDescription (String description)
	{
		this.dt_p1.setAttribute2(description);
	}
	
	public String getSupplier ()
	{
		return dt_p1.getAttribute3();
	}
	
	public void setSupplier (String supplier)
	{
		this.dt_p1.setAttribute3(supplier);
	}
	
	public int getStock ()
	{
		return dt_p2.getAttribute1();
	}
	
	public void setStock (int stock)
	{
		this.dt_p2.setAttribute1(stock);
	}
	
	public double getPrice ()
	{
		return dt_p2.getAttribute3();
	}
	
	public void setPrice (double price)
	{
		this.dt_p2.setAttribute3(price);
	}
	
	public String saveProducts ()
	{
		return String.format("%s;%s;%d;%.2f;%s", getName(), getDescription(), getStock(), getPrice(), getSupplier());
	}
	
}
