package viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPasswordField;

public class Supplier extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_nameSupplier;
	public JTextField txt_emailSupplier;
	public JTextField txt_dniSupplier;
	public JTextField txt_phoneSupplier;
	public JTextField txt_businessName;
	public JPasswordField pwf_codeSupplier;
	public JButton btn_addSupplier;
	public JButton btn_returnSupplier;
	public JList lst_suppliers;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supplier frame = new Supplier();
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
	public Supplier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Supplier", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(0, 11, 358, 320);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(10, 22, 101, 14);
		panel.add(lblNewLabel);
		
		txt_nameSupplier = new JTextField();
		txt_nameSupplier.setBounds(119, 19, 229, 20);
		panel.add(txt_nameSupplier);
		txt_nameSupplier.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 61, 101, 14);
		panel.add(lblEmail);
		
		txt_emailSupplier = new JTextField();
		txt_emailSupplier.setColumns(10);
		txt_emailSupplier.setBounds(119, 58, 229, 20);
		panel.add(txt_emailSupplier);
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setBounds(10, 97, 101, 14);
		panel.add(lblDni);
		
		txt_dniSupplier = new JTextField();
		txt_dniSupplier.setColumns(10);
		txt_dniSupplier.setBounds(119, 94, 229, 20);
		panel.add(txt_dniSupplier);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 133, 101, 14);
		panel.add(lblCodigo);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(10, 166, 101, 14);
		panel.add(lblTelefono);
		
		txt_phoneSupplier = new JTextField();
		txt_phoneSupplier.setColumns(10);
		txt_phoneSupplier.setBounds(119, 163, 229, 20);
		panel.add(txt_phoneSupplier);
		
		JLabel lblRazonSocial = new JLabel("Razon Social:");
		lblRazonSocial.setBounds(10, 203, 101, 14);
		panel.add(lblRazonSocial);
		
		txt_businessName = new JTextField();
		txt_businessName.setColumns(10);
		txt_businessName.setBounds(119, 200, 229, 20);
		panel.add(txt_businessName);
		
		btn_addSupplier = new JButton("Add");
		btn_addSupplier.setBounds(49, 259, 101, 35);
		panel.add(btn_addSupplier);
		
		btn_returnSupplier = new JButton("Return");
		btn_returnSupplier.setBounds(207, 259, 96, 35);
		panel.add(btn_returnSupplier);
		
		pwf_codeSupplier = new JPasswordField();
		pwf_codeSupplier.setBounds(119, 130, 96, 20);
		panel.add(pwf_codeSupplier);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "List Suppliers", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(368, 11, 312, 320);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lst_suppliers = new JList();
		lst_suppliers.setBounds(10, 25, 292, 284);
		panel_1.add(lst_suppliers);
	}
}
