package viewer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

import controller.Logic_view_addStock;

import javax.swing.JButton;

public class AddStock extends JFrame
{
	public JButton btn_Return;
	public JButton btn_accept;
	public JSpinner spn_stock;
	public JComboBox cmb_products;
	public JLabel lbl_numStock;
	public AddStock ()
	{
		setResizable(true);
		this.addWindowListener(new WindowAdapter() 
		{
			public void WindowClosed (WindowEvent e)
			{
				Main_viewer mv = new Main_viewer();
				mv.setVisible(true);
				mv.setLocationRelativeTo(null);
			}
		});
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 206);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 281, 156);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_product = new JLabel("Product:");
		lbl_product.setBounds(10, 27, 84, 14);
		panel.add(lbl_product);
		
		cmb_products = new JComboBox();
		cmb_products.setBounds(104, 23, 162, 22);
		panel.add(cmb_products);
		
		JLabel lbl_stock = new JLabel("Add stock:");
		lbl_stock.setBounds(10, 97, 84, 14);
		panel.add(lbl_stock);
		
		spn_stock = new JSpinner();
		spn_stock.setBounds(104, 94, 59, 20);
		panel.add(spn_stock);
		
		btn_accept = new JButton("Accept");
		btn_accept.setBounds(10, 122, 89, 23);
		panel.add(btn_accept);
		
		btn_Return = new JButton("Return");
		btn_Return.setBounds(177, 122, 89, 23);
		panel.add(btn_Return);
		
		lbl_numStock = new JLabel("Desconocido");
		lbl_numStock.setBounds(10, 72, 185, 14);
		panel.add(lbl_numStock);
		
		Logic_view_addStock lv = new Logic_view_addStock(this);
	}
}
