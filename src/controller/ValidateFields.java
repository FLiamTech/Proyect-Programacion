package controller;

public class ValidateFields implements Parametrizable
{
	public static boolean validateNames (String name)
	{
		return name.matches(ERName);
	}
	
	public static boolean validateDni (String dni)
	{
		return dni.matches(ERDni);
	}
	
	public static boolean validateCode (String code)
	{
		return code.matches(ERCode);
	}
	
	public static boolean validateDate (String date)
	{
		return date.matches(ERDate);
	}
	
	public static boolean validateNameProduct (String name)
	{
		return name.matches(ERNameProduct);
	}
	
	public static boolean validateAddress (String address)
	{
		return address.matches(ERAddress);
	}
	
	public static boolean validateContact (String contact)
	{
		return contact.matches(ERContact);
	}
	
	public static boolean validateNameSup (String nameSup)
	{
		return nameSup.matches(ERNameSup);
	}
	
	public static boolean validateEmail (String email)
	{
		return email.matches(EREmail);
	}
	
	public static boolean validateBusinessName (String businessName)
	{
		return businessName.matches(ERBusinessName);
	}
}
