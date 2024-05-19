package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import libreriaVersion1.Files;

public class ProductDAO implements Path
{
	private Files file;
	
	public ProductDAO ()
	{
		file = new Files (Path2);
		file.create(0);
	}
	
	public boolean writeProducts (Product p) throws IOException
	{
		file.setFile(new File(Path2, infoProducts));
		return file.writeFile(p.saveProducts(), false);
	}
	
	public List <Product> readerProducts ()
	{
		List <Product> products = new ArrayList();
		file.setFile(new File (Path2, infoProducts));
		
		String [] data = file.readerFile().split("\n");
		for (String dataProducts : data)
		{
			String [] info = dataProducts.split(";");
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
	
	public int numProducts ()
	{
		file.setFile(new File(Path2, infoProducts));
	    String fileContent = file.readerFile();
	    System.out.println("Contenido del archivo: " + fileContent);
	    String[] products = fileContent.split("\n");
	    System.out.println("Número de productos: " + products.length);
	    return products.length;
	}
}