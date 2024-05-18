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
}
