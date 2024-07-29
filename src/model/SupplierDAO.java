package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import libreriaVersion3.Files;

public class SupplierDAO implements Path, Settings
{
	private Files file;
	
	public SupplierDAO ()
	{
		file = new Files(PATH_SUPPLIER);
		file.create(0);
	}
	
	public boolean insertBBDD (Suppliers s)
	{
		boolean value = conn.setQuery(
						String.format("INSERT INTO electrotech.suppliers VALUES (null, '%s','%s','%s','%s','%s','%s')", 
								s.getName(), s.getEmail(), s.getDni(), s.getCode(), s.getPhone(), s.getBusinessName()));
		return value;
	}
	
	public boolean writeSupplier (Suppliers s) throws IOException
	{
		file.setFile(new File (PATH_SUPPLIER, infoSupplier));
		
		return file.writeFile(s.infoSupplier(), false);
	}
	
	public List <Suppliers> readerSupplier () throws IOException
	{
		List <Suppliers> suppliers = new ArrayList ();
		file.setFile(new File (PATH_SUPPLIER, infoSupplier));
		
		BufferedReader reader = new BufferedReader(new FileReader(file.getFile()));
		String line;
		
		while ((line = reader.readLine()) != null)
		{
			String [] info = line.split(";");
			Suppliers s = new Suppliers();
			
			s.setName(info[0]);
			s.setEmail(info[1]);
			s.setDni(info[2]);
			s.setPhone(info[3]);
			s.setBusinessName(info[4]);
			s.setCode(info[5]);
			
			suppliers.add(s);
		}
		return suppliers;
	}
}
