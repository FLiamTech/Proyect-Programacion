package viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

public class Egress extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JComboBox cmb_customers;
	public JComboBox cmb_products;
	public JButton btn_returnEgress;
	public JButton btn_acceptEgress;
	public JLabel lbl_total;
	public JButton btn_calculateTotal;
	public JLabel lbl_tax;
	public JSpinner spn_stock;
	public JLabel lbl_discountType;
	public JButton btn_discount;
	public JLabel lbl_numStock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Egress frame = new Egress();
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
	public Egress() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Set up", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 11, 434, 156);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Productos:");
		lblNewLabel.setBounds(10, 30, 119, 14);
		panel.add(lblNewLabel);
		
		JLabel lblCliente = new JLabel("Clientes:");
		lblCliente.setBounds(10, 55, 119, 14);
		panel.add(lblCliente);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 117, 60, 14);
		panel.add(lblStock);
		
		cmb_products = new JComboBox();
		cmb_products.setBounds(131, 22, 154, 22);
		panel.add(cmb_products);
		
		cmb_customers = new JComboBox();
		cmb_customers.setBounds(131, 51, 154, 22);
		panel.add(cmb_customers);
		
		spn_stock = new JSpinner();
		spn_stock.setBounds(131, 114, 60, 20);
		panel.add(spn_stock);
		
		JLabel lblAplicarDescuento = new JLabel("Aplicar Descuento!");
		lblAplicarDescuento.setBounds(315, 11, 119, 14);
		panel.add(lblAplicarDescuento);
		
		btn_discount = new JButton("Press");
		btn_discount.setBounds(315, 37, 89, 51);
		panel.add(btn_discount);
		
		lbl_discountType = new JLabel("Desconocido");
		lbl_discountType.setBounds(315, 99, 119, 14);
		panel.add(lbl_discountType);
		
		JLabel lblNewLabel_2 = new JLabel("Num de productos:");
		lblNewLabel_2.setBounds(10, 92, 119, 14);
		panel.add(lblNewLabel_2);
		
		lbl_numStock = new JLabel("Desconocido");
		lbl_numStock.setBounds(131, 89, 96, 14);
		panel.add(lbl_numStock);
		
		SpinnerNumberModel priceModel = new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Calculations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 165, 434, 96);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Calcular Valor total:");
		lblNewLabel_1.setBounds(10, 23, 119, 14);
		panel_1.add(lblNewLabel_1);
		
		btn_calculateTotal = new JButton("Calculate");
		btn_calculateTotal.setBounds(135, 19, 89, 23);
		panel_1.add(btn_calculateTotal);
		
		JLabel lblNewLabel_1_1 = new JLabel("Total:");
		lblNewLabel_1_1.setBounds(10, 58, 119, 14);
		panel_1.add(lblNewLabel_1_1);
		
		lbl_total = new JLabel("Desconocido");
		lbl_total.setBounds(135, 58, 89, 14);
		panel_1.add(lbl_total);
		
		lbl_tax = new JLabel("Desconocido");
		lbl_tax.setBounds(230, 23, 89, 14);
		panel_1.add(lbl_tax);
		
		btn_acceptEgress = new JButton("Accept");
		btn_acceptEgress.setBounds(335, 11, 89, 31);
		panel_1.add(btn_acceptEgress);
		
		btn_returnEgress = new JButton("Return");
		btn_returnEgress.setBounds(335, 46, 89, 31);
		panel_1.add(btn_returnEgress);
	}
}
