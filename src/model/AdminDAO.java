package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import libreriaVersion1.Files;

public class AdminDAO implements Path
{
	private Files file;
	
	public AdminDAO ()
	{
		file = new Files (Path);
		file.create(0);
	}
	
	public boolean writeEmployees (Admin a) throws IOException
	{
		String fileName = a.getDni() + ".txt";
		file.setFile(new File(Path, infoEmployees));
		return file.writeFile(a.infoDates() + "\n", true);
	}
	
	public List <Admin> readerEmployees ()
	{
		List <Admin> employee = new ArrayList();
		file.setFile(new File (Path, infoEmployees));
		
		String [] data = file.readerFile().split("\n");
		for (String dataEmployee : data)
		{
			String [] info = dataEmployee.split(";");
			Admin a = new Admin();
			a.setName(info[0]);
			a.setDni(info[1]);
			a.setCode(info[2]);
			a.setDate(info[3]);
			a.setUser(info[4]);
			a.setPassword(info[5]);
			
			employee.add(a);
		}
		return employee;
	}
}
