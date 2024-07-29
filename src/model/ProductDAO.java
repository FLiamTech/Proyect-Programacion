package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import libreriaVersion3.Files;

public class ProductDAO implements Path, Settings
{
	private Files file;
	
	public ProductDAO ()
	{
		file = new Files (Path2);
		file.create(0);
	}
	
	public boolean insertBBDD (Product p)
	{
		boolean value = conn.setQuery(
						String.format("INSERT INTO electrotech.products VALUES (null, '%s','%s',%d,'%.2f','%s')", 
								p.getName(), p.getDescription(), p.getStock(), p.getPrice(), p.getSupplier()));
		return value;
	}
	
	public boolean writeProducts (Product p) throws IOException
	{
		file.setFile(new File(Path2, infoProducts));
		return file.writeFile(p.saveProducts(), false);
	}
	
	public List <Product> readerProducts () throws IOException
	{
		List <Product> products = new ArrayList();
		file.setFile(new File (Path2, infoProducts));
		
		BufferedReader reader = new BufferedReader(new FileReader(file.getFile()));
		String line;
		while ((line = reader.readLine())  != null)
		{
			if (line.trim().isEmpty()) continue;
			
			String [] info = line.split(";");
			Product p = new Product ();
			p.setName(info[0]);
			p.setDescription(info[1]);
			p.setStock(Integer.valueOf(info[2]));
			p.setPrice(Double.valueOf(info[3]));
			p.setSupplier(info[4]);
			
			products.add(p);
		}
		return products;
	}
	
	public int numProducts () throws IOException
	{
		List <Product> products = readerProducts();
		return products.size();
	}
	
	public boolean replaceProducts (Product p) throws IOException
	{
		List <Product> products = readerProducts();
//		file.setFile(new File(Path2, infoProducts));
		boolean found = false;
		for (int i=0 ; i<products.size() ; i++)
		{
			if (products.get(i).getName().equals(p.getName()))
			{
				products.set(i, p);
				found = true;
				break;
			}
		}
		if (found)
		{
			file.setFile(new File(Path2, infoProducts));
			FileWriter writer = new FileWriter(file.getFile(), false);
			for (Product pd : products) 
            {
                writer.write(pd.saveProducts() + "\n");
            }
			writer.close();
		}
		return found;
	}
}