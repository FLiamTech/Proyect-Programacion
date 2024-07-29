package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import libreriaVersion3.Files;
import viewer.Report;

public class RegisterDAO implements Path, Settings
{
	private Files file;
	ResultSet res;
	public RegisterDAO ()
	{
		file = new Files (PATH_REGISTER);
		file.create(0);
	}
	
	public boolean insertBBDD (Register r)
	{
		boolean value = conn.setQuery(
						String.format("INSERT INTO electrotech.registros VALUES (null, '%s','%s',%d,'%s')", 
								r.getDate(), r.getNameProduct(), r.getStockEgree(), r.getClient()));
		return value;
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
	
	public void filterDate(int opt, Report rp) throws SQLException 
	{
	    switch (opt) 
	    {
	        case 1:
	            res = conn.getQuery("SELECT * FROM electrotech.registros WHERE date = CURDATE()");
	            rp.txa_data.setText("");
	            String str1 = "<html>";
	            int index1 = 1;
	            while (res.next()) 
	            {
	                str1 += "<b>Registro " + index1 + "</b><br>"
	                      + "<font color='brown'>ID:</font> " + res.getInt(1) + "<br>"
	                      + "<font color='green'>Fecha:</font> " + res.getDate(2) + "<br>"
	                      + "<font color='yellow'>Nombre del Producto:</font> " + res.getString(3) + "<br>"
	                      + "<font color='blue'>Stock:</font> " + res.getInt(4) + "<br>"
	                      + "<font color='red'>Cliente:</font> " + res.getString(5) + "<br>"
	                      + "<hr>"; 
	                index1++;
	            }
	            str1 += "</html>";
	            rp.txa_data.setText(str1);
	            break;

	        case 2:
	            res = conn.getQuery("SELECT * FROM electrotech.registros WHERE date >= CURDATE() - INTERVAL 7 DAY");
	            rp.txa_data.setText("");
	            String str2 = "<html>";
	            int index2 = 1;
	            while (res.next()) {
	                str2 += "<b>Registro " + index2 + "</b><br>"
	                      + "<font color='brown'>ID:</font> " + res.getInt(1) + "<br>"
	                      + "<font color='green'>Fecha:</font> " + res.getDate(2) + "<br>"
	                      + "<font color='yellow'>Nombre del Producto:</font> " + res.getString(3) + "<br>"
	                      + "<font color='blue'>Stock:</font> " + res.getInt(4) + "<br>"
	                      + "<font color='red'>Cliente:</font> " + res.getString(5) + "<br>"
	                      + "<hr>";
	                index2++;
	            }
	            str2 += "</html>";
	            rp.txa_data.setText(str2);
	            break;

	        case 3:
	            res = conn.getQuery("SELECT * FROM electrotech.registros WHERE date >= CURDATE() - INTERVAL 1 MONTH");
	            rp.txa_data.setText("");
	            String str3 = "<html>";
	            int index3 = 1; 
	            while (res.next()) {
	                str3 += "<b>Registro " + index3 + "</b><br>"
	                      + "<font color='brown'>ID:</font> " + res.getInt(1) + "<br>"
	                      + "<font color='green'>Fecha:</font> " + res.getDate(2) + "<br>"
	                      + "<font color='yellow'>Nombre del Producto:</font> " + res.getString(3) + "<br>"
	                      + "<font color='blue'>Stock:</font> " + res.getInt(4) + "<br>"
	                      + "<font color='red'>Cliente:</font> " + res.getString(5) + "<br>"
	                      + "<hr>";
	                index3++;
	            }
	            str3 += "</html>";
	            rp.txa_data.setText(str3);
	            break;

	        case 4:
	            res = conn.getQuery("SELECT * FROM electrotech.registros WHERE date >= CURDATE() - INTERVAL 1 YEAR");
	            rp.txa_data.setText("");
	            String str4 = "<html>";
	            int index4 = 1;
	            while (res.next()) {
	                str4 += "<b>Registro " + index4 + "</b><br>"
	                      + "<font color='brown'>ID:</font> " + res.getInt(1) + "<br>"
	                      + "<font color='green'>Fecha:</font> " + res.getDate(2) + "<br>"
	                      + "<font color='yellow'>Nombre del Producto:</font> " + res.getString(3) + "<br>"
	                      + "<font color='blue'>Stock:</font> " + res.getInt(4) + "<br>"
	                      + "<font color='red'>Cliente:</font> " + res.getString(5) + "<br>"
	                      + "<hr>";
	                index4++;
	            }
	            str4 += "</html>";
	            rp.txa_data.setText(str4);
	            break;
	    }
	}
	public void filterClients(String client, Report rp) throws SQLException
	{
	    res = conn.getQuery(String.format(
	            "SELECT * FROM electrotech.registros WHERE client = '%s'", client));
	    rp.txa_data.setText("");
	    StringBuilder str4 = new StringBuilder("<html>");
	    int index4 = 1;
	    while (res.next()) {
	        String clientName = res.getString(5);
	        // Resaltar el nombre del cliente
	        String highlightedClient = client.equals(clientName) ? 
	            "<font color='white' style='background-color: #ff6600;'><b>" + clientName + "</b></font>" :
	            clientName;
	        
	        str4.append("<b>Registro ").append(index4).append("</b><br>")
	            .append("<font color='brown'>ID:</font> ").append(res.getInt(1)).append("<br>")
	            .append("<font color='green'>Fecha:</font> ").append(res.getDate(2)).append("<br>")
	            .append("<font color='yellow'>Nombre del Producto:</font> ").append(res.getString(3)).append("<br>")
	            .append("<font color='blue'>Stock:</font> ").append(res.getInt(4)).append("<br>")
	            .append("<font color='red'>Cliente:</font> ").append(highlightedClient).append("<br>")
	            .append("<hr>");
	        index4++;
	    }
	    str4.append("</html>");
	    rp.txa_data.setText(str4.toString());
	}
}
