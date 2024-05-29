package model;

import libreriaVersion1.Generica;

public class Client 
{
	private Generica <String, String> dt_c;
	
	public Client ()
	{
		dt_c = new Generica<> ();
	}
	
	public Client (String name, String address, String contact)
	{
		dt_c = new Generica <> (name, address, contact);
	}
	
	public String getName ()
	{
		return this.dt_c.getAttribute1();
	}
	
	public void setName (String name)
	{
		this.dt_c.setAttribute1(name);
	}
	
	public String getAddress ()
	{
		return this.dt_c.getAttribute2();
	}
	
	public void setAddress (String address)
	{
		this.dt_c.setAttribute2(address);
	}
	
	public String getContact ()
	{
		return this.dt_c.getAttribute3();
	}
	
	public void setContact (String contact)
	{
		this.dt_c.setAttribute3(contact);
	}
	
	public String infoDates ()
	{
		return String.format("%s;%s;%s", getName(), getAddress(), getContact());
	}
}
