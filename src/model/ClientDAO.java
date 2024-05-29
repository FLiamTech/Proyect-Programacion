package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import libreriaVersion1.Files;

public class ClientDAO implements Path
{
	private Files file;
	
	public ClientDAO ()
	{
		file = new Files(PATH_CUSTOMERS);
		file.create(0);
	}
	
	public boolean writeCustomers (Client c) throws IOException
	{
		file.setFile(new File(PATH_CUSTOMERS, infoCustomers));
		return file.writeFile(c.infoDates(), false);
	}
	
	public List <Client> readerCustomers () throws IOException
	{
		List <Client> customers = new ArrayList();
		file.setFile(new File(PATH_CUSTOMERS, infoCustomers));
		
		BufferedReader reader = new BufferedReader(new FileReader(file.getFile()));
		
		String line;
		while ((line = reader.readLine()) != null)
		{
			String [] info = line.split(";");
			Client c = new Client();
			c.setName(info[0]);
			c.setAddress(info[1]);
			c.setContact(info[2]);
			
			customers.add(c);
		}
		return customers;
	}
	
	public boolean refreshClient(Client c) throws IOException 
	{
	    List<Client> customers = readerCustomers();
	    boolean found = false;

	    for (int i = 0; i < customers.size(); i++) 
	    {
	        if (customers.get(i).getName().equals(c.getName())) 
	        {
	            customers.set(i, c);
	            found = true;
	            break;
	        }
	    }

	    if (found) 
	    {
	        file.setFile(new File(PATH_CUSTOMERS, infoCustomers));
	        FileWriter writer = new FileWriter(file.getFile(), false);
	        for (Client cl : customers) 
	        {
	            writer.write(cl.infoDates() + "\n");
	        }
	        writer.close();
	    }

	    return found;
	}
}
