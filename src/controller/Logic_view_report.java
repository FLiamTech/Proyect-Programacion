package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Client;
import model.ClientDAO;
import model.Register;
import model.RegisterDAO;
import viewer.Report;

public class Logic_view_report implements ActionListener
{
	private Report rp;
	private Register reg = new Register();
	private Client client = new Client ();
	ResultSet res;
	
	private ClientDAO cdao;
	private RegisterDAO rdao;
	
	public Logic_view_report (Report rp)
	{
		this.rp = rp;
		this.rdao  = new RegisterDAO();
		this.cdao = new ClientDAO();
		
		this.rp.btn_accept.addActionListener(this);
		this.rp.btn_return.addActionListener(this);
		this.rp.rbt_customers.addActionListener(this);
		this.rp.rbt_forDate.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == rp.rbt_forDate)
		{
			rp.cmb_customer.setEnabled(false);
			rp.cmb_date.setEnabled(true);
			
			rp.cmb_customer.removeAllItems();
			loadComboBoxDates ();
		}
		else if (e.getSource() == rp.rbt_customers)
		{
			rp.cmb_date.setEnabled(false);
			rp.cmb_customer.setEnabled(true);
			
			rp.cmb_date.removeAllItems();
			loadComboBoxCustomers ();
		}
		
		if (e.getSource() == rp.btn_accept)
		{
			operation();
		}
		else if (e.getSource() == rp.btn_return)
		{
			rp.dispose();
		}
	}
	public void loadComboBoxCustomers ()
	{
		List <Client> clients = new ArrayList ();
		try {
			clients = cdao.readerCustomers();
			rp.cmb_customer.removeAllItems();
			for (Client c : clients)
			{
				rp.cmb_customer.addItem(c.getName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void loadComboBoxDates ()
	{
		rp.cmb_date.addItem("Diarias");
		rp.cmb_date.addItem("Semanales");
		rp.cmb_date.addItem("Mensuales");
		rp.cmb_date.addItem("Anuales");
	}
	public void operation ()
	{
		if (rp.rbt_forDate.isSelected())
		{
			if (rp.cmb_date.getSelectedIndex() == 0)
			{
				try {
					rdao.filterDate(1, rp);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if (rp.cmb_date.getSelectedIndex() == 1)
			{
				try {
					rdao.filterDate(2, rp);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if (rp.cmb_date.getSelectedIndex() == 2)
			{
				try {
					rdao.filterDate(3, rp);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if (rp.cmb_date.getSelectedIndex() == 3)
			{
				try {
					rdao.filterDate(4, rp);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		else if (rp.rbt_customers.isSelected())
		{
			String client = (String) rp.cmb_customer.getSelectedItem();
			try {
				rdao.filterClients(client, rp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
