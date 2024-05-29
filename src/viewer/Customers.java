package viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JRadioButton;

public class Customers extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_nameClient;
	public JTextField txt_addressClient;
	public JTextField txt_contactClient;
	public JTextField txt_nameSearchClient;
	public JButton btn_addClient;
	public JButton btn_returnClient;
	public JLabel lbl_findClient;
	public JButton btn_searchClient;
	public JButton btn_changeDatesClient;
	public JList lst_customers;
	public JRadioButton rbd_addressClientChange;
	public JRadioButton rbd_contactClientChange;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customers frame = new Customers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Customers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dates Customers", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(0, 0, 450, 160);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(10, 26, 98, 14);
		panel.add(lblNewLabel);
		
		txt_nameClient = new JTextField();
		txt_nameClient.setBounds(141, 23, 164, 20);
		panel.add(txt_nameClient);
		txt_nameClient.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Direccion:");
		lblNewLabel_1.setBounds(10, 65, 98, 14);
		panel.add(lblNewLabel_1);
		
		txt_addressClient = new JTextField();
		txt_addressClient.setColumns(10);
		txt_addressClient.setBounds(141, 62, 164, 20);
		panel.add(txt_addressClient);
		
		JLabel lblNewLabel_2 = new JLabel("Contacto:");
		lblNewLabel_2.setBounds(10, 109, 98, 14);
		panel.add(lblNewLabel_2);
		
		txt_contactClient = new JTextField();
		txt_contactClient.setColumns(10);
		txt_contactClient.setBounds(141, 106, 164, 20);
		panel.add(txt_contactClient);
		
		btn_addClient = new JButton("Add");
		btn_addClient.setBounds(334, 22, 89, 57);
		panel.add(btn_addClient);
		
		btn_returnClient = new JButton("Return");
		btn_returnClient.setBounds(334, 77, 89, 57);
		panel.add(btn_returnClient);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Update", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 160, 450, 165);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		lblNewLabel_3.setBounds(10, 43, 99, 14);
		panel_1.add(lblNewLabel_3);
		
		txt_nameSearchClient = new JTextField();
		txt_nameSearchClient.setBounds(142, 40, 162, 20);
		panel_1.add(txt_nameSearchClient);
		txt_nameSearchClient.setColumns(10);
		
		btn_changeDatesClient = new JButton("Change");
		btn_changeDatesClient.setBounds(335, 53, 89, 60);
		panel_1.add(btn_changeDatesClient);
		
		btn_searchClient = new JButton("search");
		btn_searchClient.setBounds(10, 72, 89, 23);
		panel_1.add(btn_searchClient);
		
		lbl_findClient = new JLabel("Desconocido");
		lbl_findClient.setBounds(142, 76, 162, 14);
		panel_1.add(lbl_findClient);
		
		rbd_addressClientChange = new JRadioButton("Direccion");
		rbd_addressClientChange.setBounds(173, 97, 109, 23);
		panel_1.add(rbd_addressClientChange);
		
		rbd_contactClientChange = new JRadioButton("Contacto");
		rbd_contactClientChange.setBounds(173, 123, 109, 23);
		panel_1.add(rbd_contactClientChange);
		
		JLabel lblNewLabel_4 = new JLabel("Que dato desea actualizar?");
		lblNewLabel_4.setBounds(10, 116, 168, 14);
		panel_1.add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "List Customers", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(460, 0, 200, 325);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lst_customers = new JList();
		lst_customers.setBounds(10, 21, 180, 293);
		panel_2.add(lst_customers);
	}
}
