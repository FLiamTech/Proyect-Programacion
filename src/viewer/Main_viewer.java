package viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controller.Logic_view_register;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Main_viewer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btn_inventory;
	public JButton btn_manager;
	public JButton btn_customers;
	public JButton btn_shell;
	public JLabel lbl_photo;
	public JLabel lblDni;
	public JLabel lbl_dniEmployee;
	public JLabel lblCodigo;
	public JLabel lbl_codeEmployee;
	public JButton btn_signOut;
	public JLabel lbl_nameEmployee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_viewer frame = new Main_viewer();
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
	public Main_viewer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 396);
		setTitle("Electro Tech");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Menu Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 371, 348);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btn_inventory = new JButton("Gestion de Inventario");
		btn_inventory.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\AA-UNIVERSIDAD\\Programacion Aplicada\\Proyecto\\resources\\software-de-gestion-de-inventarios-ES-Capterra-Header.png"));
		btn_inventory.setBounds(10, 24, 169, 96);
		panel.add(btn_inventory);
		
		btn_shell = new JButton("Punto de venta");
		btn_shell.setBounds(189, 24, 170, 140);
		panel.add(btn_shell);
		
		btn_manager = new JButton("Gestion de Proveedor");
		btn_manager.setBounds(9, 175, 170, 140);
		panel.add(btn_manager);
		
		btn_customers = new JButton("Gestion de clientes");
		btn_customers.setBounds(189, 175, 170, 140);
		panel.add(btn_customers);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Profile", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(386, 11, 147, 348);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lbl_photo = new JLabel("New label");
		lbl_photo.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\AA-UNIVERSIDAD\\Programacion Aplicada\\Proyecto\\Proyect\\src\\view.Multimedia.Images\\iconProfile.png"));
		lbl_photo.setBounds(10, 24, 120, 120);
		panel_1.add(lbl_photo);
		
		JLabel lblNewLabel = new JLabel("Nombre del empleado");
		lblNewLabel.setBounds(10, 166, 127, 14);
		panel_1.add(lblNewLabel);
		
		lbl_nameEmployee = new JLabel("desconocido");
		lbl_nameEmployee.setBounds(10, 191, 127, 14);
		panel_1.add(lbl_nameEmployee);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(10, 216, 127, 14);
		panel_1.add(lblDni);
		
		lbl_dniEmployee = new JLabel("desconocido");
		lbl_dniEmployee.setBounds(10, 241, 127, 14);
		panel_1.add(lbl_dniEmployee);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 266, 127, 14);
		panel_1.add(lblCodigo);
		
		lbl_codeEmployee = new JLabel("desconocido");
		lbl_codeEmployee.setBounds(10, 291, 127, 14);
		panel_1.add(lbl_codeEmployee);
		
		btn_signOut = new JButton("Sign Out");
		btn_signOut.setBounds(29, 316, 89, 23);
		panel_1.add(btn_signOut);
	}
}
