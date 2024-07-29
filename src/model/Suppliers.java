package model;

import libreriaVersion3.Generica;

public class Suppliers 
{
	private Generica <String, String> dt_s;
	private Generica <String, String> dt_s2;
	
	public Suppliers ()
	{
		dt_s = new Generica<> ();
		dt_s2 = new Generica<> ();
	}
	
	public Suppliers (String name, String email, String dni, String code, String phone, String businessName)
	{
		dt_s = new Generica<> (name, email, dni, phone);
		dt_s2 = new Generica<> (businessName, code); 
	}
	
	public String getName ()
	{
		return this.dt_s.getAttribute1();
	}
	
	public void setName (String name)
	{
		this.dt_s.setAttribute1(name);
	}
	
	public String getEmail ()
	{
		return this.dt_s.getAttribute2();
	}
	
	public void setEmail (String email)
	{
		this.dt_s.setAttribute2(email);
	}
	
	public String getDni ()
	{
		return this.dt_s.getAttribute3();
	}
	
	public void setDni (String dni)
	{
		this.dt_s.setAttribute3(dni);
	}
	
	public String getPhone ()
	{
		return this.dt_s.getAttribute4();
	}
	
	public void setPhone (String phone)
	{
		this.dt_s.setAttribute4(phone);
	}
	
	public String getBusinessName ()
	{
		return this.dt_s2.getAttribute1();
	}
	
	public void setBusinessName (String businessName)
	{
		this.dt_s2.setAttribute1(businessName);
	}
	
	public String getCode ()
	{
		return this.dt_s2.getAttribute3();
	}
	
	public void setCode (String code)
	{
		this.dt_s2.setAttribute3(code);
	}
	
	public String infoSupplier ()
	{
		return String.format("%s;%s;%s;%s;%s;%s", 
				getName(), getEmail(), getDni(), getPhone(), getBusinessName(), getCode());
	}
}
