package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import libreriaVersion1.Files;

public class RegisterDAO implements Path
{
	private Files file;
	
	public RegisterDAO ()
	{
		file = new Files (PATH_REGISTER);
		file.create(0);
	}
	
	public boolean writeRegister (Register r) throws IOException
	{
		file.setFile(new File (PATH_REGISTER, infoRegister));
		
		return file.writeFile(r.registry(), false);
	}
	
	public List <Register> readerRegister () throws IOException
	{
		List <Register> registry = new ArrayList();
		file.setFile(new File (PATH_REGISTER, infoRegister));
		
		BufferedReader reader = new BufferedReader(new FileReader(file.getFile()));
		String line;
		
		while ((line = reader.readLine()) != null)
		{
			String [] info = line.split(";");
			Register r = new Register();
			
			r.setDate(info[0]);
			r.setNameProduct(info[1]);
			r.setStockEgree(Integer.valueOf(info[2]));
			r.setClient(info[3]);
			
			registry.add(r);
		}
		return registry;
	}
}
