package viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Main_viewer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setBounds(100, 100, 559, 398);
		setTitle("Electro Tech");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Menu Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 369, 344);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_inventory = new JButton("Gestion de Inventario");
		btn_inventory.setBounds(10, 29, 176, 140);
		panel.add(btn_inventory);
		
		JButton btn_shell = new JButton("Punto de venta");
		btn_shell.setBounds(196, 29, 163, 140);
		panel.add(btn_shell);
		
		JButton btn_manager = new JButton("Gestion de Proveedor");
		btn_manager.setBounds(10, 180, 176, 153);
		panel.add(btn_manager);
		
		JButton btn_customers = new JButton("Gestion de clientes");
		btn_customers.setBounds(196, 180, 163, 153);
		panel.add(btn_customers);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Profile", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(386, 11, 147, 344);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl_photo = new JLabel("New label");
		lbl_photo.setBounds(10, 11, 127, 124);
		panel_1.add(lbl_photo);
	}
}
