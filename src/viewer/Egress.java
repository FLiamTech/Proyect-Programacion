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
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;

public class Egress extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JComboBox<String> cmb_customers;
    public JComboBox<String> cmb_products;
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
		setTitle("Egree");
		setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(166, 210, 255));
        panel.setBorder(new TitledBorder(null, "Set up", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180))); // Borde azul claro
        panel.setBounds(0, 11, 434, 156);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Productos:");
        lblNewLabel.setFont(new Font("Century", Font.PLAIN, 12));
        lblNewLabel.setBounds(10, 30, 119, 14);
        panel.add(lblNewLabel);

        JLabel lblCliente = new JLabel("Clientes:");
        lblCliente.setFont(new Font("Century", Font.PLAIN, 12));
        lblCliente.setBounds(10, 55, 119, 14);
        panel.add(lblCliente);

        JLabel lblStock = new JLabel("Stock:");
        lblStock.setFont(new Font("Century", Font.PLAIN, 12));
        lblStock.setBounds(10, 117, 60, 14);
        panel.add(lblStock);

        cmb_products = new JComboBox<String>();
        cmb_products.setBounds(131, 22, 154, 22);
        cmb_products.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.GRAY)); // Borde biselado
        panel.add(cmb_products);

        cmb_customers = new JComboBox<String>();
        cmb_customers.setBounds(131, 51, 154, 22);
        cmb_customers.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.GRAY)); // Borde biselado
        panel.add(cmb_customers);

        SpinnerNumberModel stockModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        spn_stock = new JSpinner(stockModel);
        spn_stock.setBounds(131, 114, 60, 20);
        spn_stock.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.GRAY)); // Borde biselado
        panel.add(spn_stock);

        JLabel lblAplicarDescuento = new JLabel("Aplicar Descuento!");
        lblAplicarDescuento.setFont(new Font("Century", Font.PLAIN, 12));
        lblAplicarDescuento.setBounds(315, 11, 119, 14);
        panel.add(lblAplicarDescuento);

        btn_discount = new JButton("Press");
        btn_discount.setFont(new Font("Century", Font.PLAIN, 11));
        btn_discount.setBackground(new Color(0, 128, 255));
        btn_discount.setBounds(315, 37, 89, 51);
        btn_discount.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.GRAY)); // Borde biselado
        panel.add(btn_discount);

        lbl_discountType = new JLabel("Desconocido");
        lbl_discountType.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 12));
        lbl_discountType.setBounds(315, 99, 119, 14);
        panel.add(lbl_discountType);

        JLabel lblNewLabel_2 = new JLabel("Num de productos:");
        lblNewLabel_2.setFont(new Font("Century", Font.PLAIN, 12));
        lblNewLabel_2.setBounds(10, 92, 119, 14);
        panel.add(lblNewLabel_2);

        lbl_numStock = new JLabel("Desconocido");
        lbl_numStock.setFont(new Font("Century", Font.BOLD, 12));
        lbl_numStock.setBounds(131, 89, 96, 14);
        panel.add(lbl_numStock);

        SpinnerNumberModel priceModel = new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01);
        // aqui
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(187, 255, 255));
        panel_1.setBorder(new TitledBorder(null, "Calculations", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180))); // Borde azul claro
        panel_1.setBounds(0, 165, 434, 96);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Calcular Valor total:");
        lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 11));
        lblNewLabel_1.setBounds(10, 23, 119, 14);
        panel_1.add(lblNewLabel_1);

        btn_calculateTotal = new JButton("Calculate");
        btn_calculateTotal.setFont(new Font("Century", Font.PLAIN, 11));
        btn_calculateTotal.setBackground(new Color(128, 255, 255));
        btn_calculateTotal.setBounds(135, 19, 89, 23);
        panel_1.add(btn_calculateTotal);

        JLabel lblNewLabel_1_1 = new JLabel("Total:");
        lblNewLabel_1_1.setFont(new Font("Century", Font.PLAIN, 11));
        lblNewLabel_1_1.setBounds(10, 58, 119, 14);
        panel_1.add(lblNewLabel_1_1);

        lbl_total = new JLabel("Desconocido");
        lbl_total.setFont(new Font("Century", Font.BOLD, 12));
        lbl_total.setBounds(135, 58, 89, 14);
        panel_1.add(lbl_total);

        lbl_tax = new JLabel("Desconocido");
        lbl_tax.setFont(new Font("Century", Font.BOLD, 12));
        lbl_tax.setBounds(230, 23, 89, 14);
        panel_1.add(lbl_tax);

        btn_acceptEgress = new JButton("Accept");
        btn_acceptEgress.setFont(new Font("Century", Font.PLAIN, 11));
        btn_acceptEgress.setBackground(new Color(0, 255, 255));
        btn_acceptEgress.setBounds(335, 11, 89, 31);
        panel_1.add(btn_acceptEgress);

        btn_returnEgress = new JButton("Return");
        btn_returnEgress.setFont(new Font("Century", Font.PLAIN, 11));
        btn_returnEgress.setBackground(new Color(0, 255, 255));
        btn_returnEgress.setBounds(335, 46, 89, 31);
        panel_1.add(btn_returnEgress);
    }
}