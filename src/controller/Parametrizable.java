package controller;

public interface Parametrizable 
{
	public final String ERName = "^([A-Z][a-zá-ú]{2,}\s?){2,4}$";
	public final String ERDni = "^[0-2][0-9]{8}[-]?[0-9]$";
	public final String ERCode = "^[0-9]{4}$";
	public final String ERDate = "^[0-1][1-9][/][0-3][0-9][/](202)[1-9]$";
	
	public final String ERNameProduct = "^([A-Z][a-z]{2,}\s?){1,2}$";
}
