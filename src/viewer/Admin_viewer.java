package viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTable;

public class Admin_viewer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_nameEmplod;
	public JTextField txt_dniEmplod;
	public JPasswordField pwf_codeEmplod;
	public JTextField txt_dniEmployeeAux;
	public JTextField txt_dateEmplod;
	public JButton btn_create;
	public JButton btn_accept;
	public JButton btn_searchEmployee;
	public JLabel lbl_estate;
	public JPasswordField pwd_newPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_viewer frame = new Admin_viewer();
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
	public Admin_viewer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Add employee", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 208, 280);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(10, 32, 93, 14);
		panel.add(lblNewLabel);
		
		JLabel lblDni = new JLabel("DNI: ");
		lblDni.setBounds(10, 88, 93, 14);
		panel.add(lblDni);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 141, 106, 14);
		panel.add(lblCodigo);
		
		JLabel lblEmail = new JLabel("Fecha de ingreso:");
		lblEmail.setBounds(10, 193, 162, 14);
		panel.add(lblEmail);
		
		txt_nameEmplod = new JTextField();
		txt_nameEmplod.setBounds(10, 57, 188, 20);
		panel.add(txt_nameEmplod);
		txt_nameEmplod.setColumns(10);
		
		txt_dniEmplod = new JTextField();
		txt_dniEmplod.setColumns(10);
		txt_dniEmplod.setBounds(10, 109, 188, 20);
		panel.add(txt_dniEmplod);
		
		pwf_codeEmplod = new JPasswordField();
		pwf_codeEmplod.setBounds(10, 162, 118, 20);
		panel.add(pwf_codeEmplod);
		
		btn_create = new JButton("Create");
		btn_create.setBounds(10, 246, 89, 23);
		panel.add(btn_create);
		
		txt_dateEmplod = new JTextField();
		txt_dateEmplod.setColumns(10);
		txt_dateEmplod.setBounds(10, 215, 118, 20);
		panel.add(txt_dateEmplod);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Forget pasword", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(228, 11, 261, 280);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("DNI: ");
		lblNewLabel_1.setBounds(10, 32, 34, 14);
		panel_1.add(lblNewLabel_1);
		
		txt_dniEmployeeAux = new JTextField();
		txt_dniEmployeeAux.setColumns(10);
		txt_dniEmployeeAux.setBounds(10, 56, 223, 20);
		panel_1.add(txt_dniEmployeeAux);
		
		btn_searchEmployee = new JButton("Search");
		btn_searchEmployee.setBounds(10, 87, 103, 34);
		panel_1.add(btn_searchEmployee);
		
		lbl_estate = new JLabel("Estado");
		lbl_estate.setBounds(123, 97, 92, 14);
		panel_1.add(lbl_estate);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nueva contraseña:");
		lblNewLabel_1_1.setBounds(10, 143, 176, 14);
		panel_1.add(lblNewLabel_1_1);
		
		btn_accept = new JButton("Accept");
		btn_accept.setBounds(10, 203, 103, 34);
		panel_1.add(btn_accept);
		
		pwd_newPassword = new JPasswordField();
		pwd_newPassword.setBounds(10, 168, 223, 20);
		panel_1.add(pwd_newPassword);
	}
}
