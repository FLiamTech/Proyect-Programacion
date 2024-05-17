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
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		setBounds(100, 100, 450, 341);
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
		
		textField = new JTextField();
		textField.setBounds(10, 57, 188, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 109, 188, 20);
		panel.add(textField_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 162, 118, 20);
		panel.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("Create");
		btnNewButton_1.setBounds(10, 246, 89, 23);
		panel.add(btnNewButton_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 215, 118, 20);
		panel.add(textField_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Forget pasword", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(228, 11, 196, 280);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("DNI: ");
		lblNewLabel_1.setBounds(10, 32, 34, 14);
		panel_1.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 56, 176, 20);
		panel_1.add(textField_2);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(10, 87, 103, 34);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Estado");
		lblNewLabel_2.setBounds(140, 97, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 172, 176, 20);
		panel_1.add(textField_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nueva contraseña:");
		lblNewLabel_1_1.setBounds(10, 143, 176, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setBounds(10, 203, 103, 34);
		panel_1.add(btnAccept);
	}
}
