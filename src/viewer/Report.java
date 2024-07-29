package viewer;

import java.awt.Button;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import controller.Logic_view_register;
import controller.Logic_view_report;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Report extends JFrame
{
	public JComboBox cmb_customer;
	public JComboBox cmb_date;
	public JRadioButton rbt_customers;
	public JRadioButton rbt_forDate;
	public JButton btn_accept;
	public JButton btn_return;
	public JTextPane txa_data;
    public JScrollPane scrollPane;
	public Report ()
	{
		setResizable(true);
		this.addWindowListener(new WindowAdapter() 
		{
			public void WindowClosed (WindowEvent e)
			{
				Record rc = new Record();
				
				rc.setVisible(true);
				rc.setLocationRelativeTo(null);
			}
		});
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 507, 345);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Specifications", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 11, 491, 92);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_Consulta = new JLabel("query type:");
		lbl_Consulta.setBounds(10, 38, 86, 14);
		panel.add(lbl_Consulta);
		
		rbt_forDate = new JRadioButton("Dates");
		rbt_forDate.setBounds(102, 7, 109, 23);
		panel.add(rbt_forDate);
		
		rbt_customers = new JRadioButton("Customers");
		rbt_customers.setBounds(102, 49, 109, 23);
		panel.add(rbt_customers);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbt_customers);
		group.add(rbt_forDate);
		
		cmb_date = new JComboBox();
		cmb_date.setBounds(217, 7, 170, 22);
		panel.add(cmb_date);
		
		cmb_customer = new JComboBox();
		cmb_customer.setBounds(217, 49, 170, 22);
		panel.add(cmb_customer);
		
		btn_accept = new JButton("Accept");
		btn_accept.setBounds(392, 49, 89, 23);
		panel.add(btn_accept);
		
		btn_return = new JButton("Return");
		btn_return.setBounds(392, 7, 89, 23);
		panel.add(btn_return);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 110, 491, 196);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txa_data = new JTextPane();
        txa_data.setContentType("text/html"); // Indicar que se va a usar HTML
        scrollPane = new JScrollPane(txa_data);
        scrollPane.setBounds(0, 0, 491, 196); // Configura el tamaño del JScrollPane
        panel_1.add(scrollPane); 
		
		Logic_view_report lv = new Logic_view_report(this);
	}
}
