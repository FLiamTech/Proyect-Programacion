package model;

public interface Path 
{
	// Path main
	
	public final String PathMain = "C:/registroEmpleados";
	
	// Path de empleados
	
	public final String Path = PathMain + "/empleados";
	public final String infoEmployees = "Registro_Empleados.txt";
	
	// path de productos
	
	public final String Path2 = PathMain + "/productos";
	public final String infoProducts = "Registro_productos.txt";
	
	// path de Clientes
	
	public final String PATH_CUSTOMERS = PathMain + "/clientes";
	public final String infoCustomers = "Registro_clientes.txt";
	
	// path de Registro
	
	public final String PATH_REGISTER = PathMain + "/registro";
	public final String infoRegister = "Registro_egreso.txt";
	
	// path de Proveedores
	
	public final String PATH_SUPPLIER = PathMain + "/proveedores";
	public final String infoSupplier = "Registro_proveedores.txt";
}
