package viewer;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;

public class Inventory extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_nameProduct;
	public JComboBox<String> cmb_supplier;
	public JSpinner spn_stock;
	public JSpinner spn_price;
	public JTextPane txtp_description;
	public JButton btn_addProduct;
	public JLabel lbl_products;
	public JButton btn_return;

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
		setTitle("Inventory");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(210, 180, 140));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.LIGHT_GRAY), "Agregar Producto", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		panel.setBounds(0, 11, 329, 323);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBounds(10, 21, 99, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descripción:");
		lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(10, 46, 99, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Precio:");
		lblNewLabel_1_1.setFont(new Font("Century", Font.PLAIN, 12));
		lblNewLabel_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1.setBounds(10, 143, 99, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Stock:");
		lblNewLabel_1_1_1.setFont(new Font("Century", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1_1.setBounds(10, 168, 99, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Proveedor:");
		lblNewLabel_1_1_1_1.setFont(new Font("Century", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1_1_1.setBounds(10, 204, 99, 14);
		panel.add(lblNewLabel_1_1_1_1);
		
		// Borde biselado
		BevelBorder bevelBorder = new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.GRAY);
		
		txt_nameProduct = new JTextField();
		txt_nameProduct.setBackground(new Color(245, 222, 179));
		txt_nameProduct.setForeground(Color.DARK_GRAY);
		txt_nameProduct.setBounds(133, 18, 176, 20);
		txt_nameProduct.setBorder(new LineBorder(new Color(0, 255, 0), 2)); // Borde de línea verde
		panel.add(txt_nameProduct);
		txt_nameProduct.setColumns(10);
		
		txtp_description = new JTextPane();
		txtp_description.setBackground(new Color(245, 222, 179));
		txtp_description.setForeground(Color.DARK_GRAY);
		txtp_description.setBounds(133, 40, 176, 83);
		txtp_description.setBorder(bevelBorder); // Borde biselado
		panel.add(txtp_description);
		
		SpinnerNumberModel priceModel = new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01);
        spn_price = new JSpinner(priceModel);
        spn_price.setBounds(133, 140, 80, 20);
        spn_price.setBackground(new Color(245, 222, 179));
		spn_price.setForeground(Color.DARK_GRAY);
		spn_price.setBorder(bevelBorder); // Borde biselado
        panel.add(spn_price);
		
        SpinnerNumberModel stockModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spn_stock = new JSpinner(stockModel);
		spn_stock.setBounds(133, 165, 50, 20);
		spn_stock.setBackground(new Color(245, 222, 179));
		spn_stock.setForeground(Color.DARK_GRAY);
		spn_stock.setBorder(bevelBorder); // Borde biselado
		panel.add(spn_stock);
		
		cmb_supplier = new JComboBox<>();
		cmb_supplier.setBounds(133, 200, 176, 22);
		cmb_supplier.setBackground(new Color(245, 222, 179));
		cmb_supplier.setForeground(Color.DARK_GRAY);
		cmb_supplier.setBorder(bevelBorder); // Borde biselado
		panel.add(cmb_supplier);
		
		btn_addProduct = new JButton("Agregar");
		btn_addProduct.setFont(new Font("Century", Font.PLAIN, 11));
		btn_addProduct.setBackground(new Color(139, 69, 19));
		btn_addProduct.setForeground(Color.WHITE);
		btn_addProduct.setBounds(10, 252, 89, 23);
		panel.add(btn_addProduct);
		
		lbl_products = new JLabel("Productos:");
		lbl_products.setFont(new Font("Century", Font.ITALIC, 12));
		lbl_products.setForeground(Color.DARK_GRAY);
		lbl_products.setBounds(133, 282, 176, 14);
		panel.add(lbl_products);
		
		btn_return = new JButton("Volver");
		btn_return.setFont(new Font("Century", Font.PLAIN, 12));
		btn_return.setBackground(new Color(139, 69, 19));
		btn_return.setForeground(Color.WHITE);
		btn_return.setBounds(10, 278, 89, 23);
		panel.add(btn_return);
	}
}