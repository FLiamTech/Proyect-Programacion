package controller;

public interface Parametrizable 
{
	public final String ERName = "^([A-Z][a-zá-ú]{2,}\s?){2,4}$";
	public final String ERDni = "^[0-2][0-9]{8}[-]?[0-9]$";
	public final String ERCode = "^[0-9]{4}$";
	public final String ERDate = "^[0-1][1-9][/][0-3][0-9][/](202)[1-9]$";
	
	public final String ERNameProduct = "^([A-Z][a-z]{2,}\s?){1,2}$";
	
	public final String ERAddress = "^[A-Za-z\s]+,\s?[A-Za-z\s]+,\s?[A-Za-z\s]+$";
	public final String ERContact = "^(09|10)[0-9]{8}$";
	
	public final String ERNameSup = "^([A-Z][a-zá-ú]{2,}\s?){4}$";
	public final String EREmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$";
	public final String ERBusinessName = "^([A-Za-zá-úÁ-Ú]+(s[A-Za-zá-úÁ-Ú]+)?.?s?){1,4}$";
}
