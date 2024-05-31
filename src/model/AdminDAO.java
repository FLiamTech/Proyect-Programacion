package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
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
		file.setFile(new File(Path, infoEmployees));
		return file.writeFile(a.infoDates() + "\n", false);
	}	
	public boolean replaceEmployees(Admin a) throws IOException
	{
        List<Admin> employees = readerEmployees();
        boolean found = false;

        // Actualizar la lista de empleados
        for (int i = 0; i < employees.size(); i++)
        {
            if (employees.get(i).getDni().equals(a.getDni())) 
            {
                employees.set(i, a);
                found = true;
                break;
            }
        }
        if (found) 
        {
            // Escribir toda la lista de nuevo en el archivo
            file.setFile(new File(Path, infoEmployees));
            try (FileWriter writer = new FileWriter(file.getFile(), false))
            {
                for (Admin ad : employees) 
                {
                    writer.write(ad.infoDates() + "\n");
                }
            }
        }
        
        return found;
    }
	public List<Admin> readerEmployees() throws IOException {
	    List<Admin> employee = new ArrayList<>();
	    file.setFile(new File(Path, infoEmployees));
	    
	    BufferedReader reader = new BufferedReader(new FileReader(file.getFile()));
	        String line;
	        while ((line = reader.readLine()) != null) 
	        {
	            if (line.trim().isEmpty()) continue; // Ignorar líneas vacías
	            
	            String[] info = line.split(";");
	            if (info.length >= 6)
	            {
	                Admin a = new Admin();
	                a.setName(info[0]);
	                a.setDni(info[1]);
	                a.setCode(info[2]);
	                a.setDate(info[3]);
	                a.setUser(info[4]);
	                a.setPassword(info[5]);
	                a.setPathImage(info[6]);
	                employee.add(a);
	            }

	        }
	    return employee;
	}
}
