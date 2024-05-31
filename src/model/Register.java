package model;

import libreriaVersion1.Generica;

public class Register 
{
	private Generica <String, Integer> dt_r;
	private Generica <String, ?> dt_r2;
	
	public Register ()
	{
		dt_r = new Generica<> ();
		dt_r2 = new Generica<> ();
	}
	
	public Register (String date, String nameProduct, int stockEgree, String client)
	{
		dt_r = new Generica <> (date, nameProduct, stockEgree);
		dt_r2 = new Generica <> (client);
	}
	
	public String getDate ()
	{
		return this.dt_r.getAttribute1();
	}
	
	public void setDate (String date)
	{
		this.dt_r.setAttribute1(date);
	}
	
	public String getNameProduct ()
	{
		return this.dt_r.getAttribute2();
	}
	
	public void setNameProduct (String numProduct)
	{
		this.dt_r.setAttribute2(numProduct);
	}
	
	public int getStockEgree ()
	{
		return this.dt_r.getAttribute3();
	}
	
	public void setStockEgree (int stockEgree)
	{
		this.dt_r.setAttribute3(stockEgree);
	}
	
	public String getClient ()
	{
		return this.dt_r2.getAttribute1();
	}
	
	public void setClient (String client)
	{
		this.dt_r2.setAttribute1(client);
	}
	public String registry ()
	{
		return String.format("%s;%s;%d;%s", getDate(), getNameProduct(), getStockEgree(), getClient());
	}
}
