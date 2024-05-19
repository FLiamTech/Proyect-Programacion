package viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Inventory extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_nameProduct;
	public JComboBox cmb_supplier;
	public JSpinner spn_stock;
	public JSpinner spn_price;
	public JTextPane txtp_description;
	public JButton btn_addProduct;
	public JLabel lbl_products;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventory frame = new Inventory();
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
	public Inventory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "add product", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 319, 312);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(10, 21, 99, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion:");
		lblNewLabel_1.setBounds(10, 46, 99, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Precio:");
		lblNewLabel_1_1.setBounds(10, 143, 99, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Stock:");
		lblNewLabel_1_1_1.setBounds(10, 168, 99, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Proveedor:");
		lblNewLabel_1_1_1_1.setBounds(10, 204, 99, 14);
		panel.add(lblNewLabel_1_1_1_1);
		
		txt_nameProduct = new JTextField();
		txt_nameProduct.setBounds(133, 18, 176, 20);
		panel.add(txt_nameProduct);
		txt_nameProduct.setColumns(10);
		
		txtp_description = new JTextPane();
		txtp_description.setBounds(133, 40, 176, 83);
		panel.add(txtp_description);
		
		SpinnerNumberModel priceModel = new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01); // Valores: 0.0 a 1000.0, incremento de 0.01
        spn_price = new JSpinner(priceModel);
        spn_price.setBounds(133, 140, 80, 20); // Ajusta el tamaño según sea necesario
        panel.add(spn_price);
		
		spn_stock = new JSpinner();
		spn_stock.setBounds(133, 165, 50, 20);
		panel.add(spn_stock);
		
		cmb_supplier = new JComboBox();
		cmb_supplier.setBounds(133, 200, 176, 22);
		panel.add(cmb_supplier);
		
		btn_addProduct = new JButton("Add");
		btn_addProduct.setBounds(10, 278, 89, 23);
		panel.add(btn_addProduct);
		
		lbl_products = new JLabel("Desconocido");
		lbl_products.setBounds(133, 282, 176, 14);
		panel.add(lbl_products);
	}
}
