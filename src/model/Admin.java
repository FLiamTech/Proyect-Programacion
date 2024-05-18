package model;

import libreriaVersion1.Generica;

public class Admin implements Account
{
	private Generica <String, String> dt_e1;
	private Generica <String, String> dt_e2;
	
	public Admin ()
	{
		super();
		dt_e1 = new Generica<> ();
		dt_e2 = new Generica<> ();
	}
	
	public Admin (String name, String dni, String code, String date, String user, String password)
	{
		dt_e1 = new Generica<> (name, dni, code, date);
		dt_e2 = new Generica<> (user, password);
	}
	
	public String getName ()
	{
		return this.dt_e1.getAttribute1();
	}
	
	public void setName(String name)
	{
		this.dt_e1.setAttribute1(name);
	}
	
	public String getDni ()
	{
		return this.dt_e1.getAttribute2();
	}
	
	public void setDni (String dni)
	{
		this.dt_e1.setAttribute2(dni);
	}
	
	public String getCode ()
	{
		return this.dt_e1.getAttribute3();
	}
	
	public void setCode (String code)
	{
		this.dt_e1.setAttribute3(code);
	}
	
	public String getDate ()
	{
		return this.dt_e1.getAttribute4();
	}
	
	public void setDate (String date)
	{
		this.dt_e1.setAttribute4(date);
	}
	
	public String getUser ()
	{
		return this.dt_e2.getAttribute1();
	}
	
	public void setUser (String user)
	{
		this.dt_e2.setAttribute1(user);
	}
	
	public String getPassword ()
	{
		return this.dt_e2.getAttribute2();
	}
	
	public void setPassword (String password)
	{
		this.dt_e2.setAttribute2(password);
	}
	public String infoDates ()
	{
		return String.format("%s;%s;%s;%s;%s;%s",
				getName(), getDni(), getCode(), getDate(), getUser(), getPassword());
	}
}
