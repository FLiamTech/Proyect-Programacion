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
import javax.swing.border.BevelBorder;
import java.awt.Font;

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
    public JList<String> lst_suppliers;

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
		setTitle("Suppliers");
		setResizable(false);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 235, 224)); // Fondo beige claro
        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.LIGHT_GRAY), "Agregar Proveedor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(121, 85, 72)));
        panel.setBounds(0, 11, 358, 320);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nombre:");
        lblNewLabel.setFont(new Font("Century", Font.PLAIN, 12));
        lblNewLabel.setForeground(new Color(121, 85, 72)); // Marrón suave
        lblNewLabel.setBounds(10, 22, 101, 14);
        panel.add(lblNewLabel);

        txt_nameSupplier = new JTextField();
        txt_nameSupplier.setBackground(new Color(255, 255, 255)); // Fondo blanco
        txt_nameSupplier.setForeground(new Color(121, 85, 72)); // Marrón suave
        txt_nameSupplier.setBounds(119, 19, 229, 20);
        txt_nameSupplier.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 183, 77), new Color(255, 138, 101))); // Bisel naranja pastel
        panel.add(txt_nameSupplier);
        txt_nameSupplier.setColumns(10);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Century", Font.PLAIN, 12));
        lblEmail.setForeground(new Color(121, 85, 72)); // Marrón suave
        lblEmail.setBounds(10, 61, 101, 14);
        panel.add(lblEmail);

        txt_emailSupplier = new JTextField();
        txt_emailSupplier.setBackground(new Color(255, 255, 255)); // Fondo blanco
        txt_emailSupplier.setForeground(new Color(121, 85, 72)); // Marrón suave
        txt_emailSupplier.setBounds(119, 58, 229, 20);
        txt_emailSupplier.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 183, 77), new Color(255, 138, 101))); // Bisel naranja pastel
        panel.add(txt_emailSupplier);
        txt_emailSupplier.setColumns(10);

        JLabel lblDni = new JLabel("DNI:");
        lblDni.setFont(new Font("Century", Font.PLAIN, 12));
        lblDni.setForeground(new Color(121, 85, 72)); // Marrón suave
        lblDni.setBounds(10, 97, 101, 14);
        panel.add(lblDni);

        txt_dniSupplier = new JTextField();
        txt_dniSupplier.setBackground(new Color(255, 255, 255)); // Fondo blanco
        txt_dniSupplier.setForeground(new Color(121, 85, 72)); // Marrón suave
        txt_dniSupplier.setBounds(119, 94, 229, 20);
        txt_dniSupplier.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 183, 77), new Color(255, 138, 101))); // Bisel naranja pastel
        panel.add(txt_dniSupplier);
        txt_dniSupplier.setColumns(10);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setFont(new Font("Century", Font.PLAIN, 12));
        lblCodigo.setForeground(new Color(121, 85, 72)); // Marrón suave
        lblCodigo.setBounds(10, 133, 101, 14);
        panel.add(lblCodigo);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(new Font("Century", Font.PLAIN, 12));
        lblTelefono.setForeground(new Color(121, 85, 72)); // Marrón suave
        lblTelefono.setBounds(10, 166, 101, 14);
        panel.add(lblTelefono);

        txt_phoneSupplier = new JTextField();
        txt_phoneSupplier.setBackground(new Color(255, 255, 255)); // Fondo blanco
        txt_phoneSupplier.setForeground(new Color(121, 85, 72)); // Marrón suave
        txt_phoneSupplier.setBounds(119, 163, 229, 20);
        txt_phoneSupplier.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 183, 77), new Color(255, 138, 101))); // Bisel naranja pastel
        panel.add(txt_phoneSupplier);
        txt_phoneSupplier.setColumns(10);

        JLabel lblRazonSocial = new JLabel("Razón Social:");
        lblRazonSocial.setFont(new Font("Century", Font.PLAIN, 12));
        lblRazonSocial.setForeground(new Color(121, 85, 72)); // Marrón suave
        lblRazonSocial.setBounds(10, 203, 101, 14);
        panel.add(lblRazonSocial);

        txt_businessName = new JTextField();
        txt_businessName.setBackground(new Color(255, 255, 255)); // Fondo blanco
        txt_businessName.setForeground(new Color(121, 85, 72)); // Marrón suave
        txt_businessName.setBounds(119, 200, 229, 20);
        txt_businessName.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 183, 77), new Color(255, 138, 101))); // Bisel naranja pastel
        panel.add(txt_businessName);
        txt_businessName.setColumns(10);

        btn_addSupplier = new JButton("Agregar");
        btn_addSupplier.setFont(new Font("Century", Font.PLAIN, 11));
        btn_addSupplier.setBackground(new Color(255, 138, 101)); // Botón naranja suave
        btn_addSupplier.setForeground(Color.WHITE);
        btn_addSupplier.setBounds(49, 259, 101, 35);
        panel.add(btn_addSupplier);

        btn_returnSupplier = new JButton("Volver");
        btn_returnSupplier.setFont(new Font("Century", Font.PLAIN, 11));
        btn_returnSupplier.setBackground(new Color(255, 138, 101)); // Botón naranja suave
        btn_returnSupplier.setForeground(Color.WHITE);
        btn_returnSupplier.setBounds(207, 259, 96, 35);
        panel.add(btn_returnSupplier);

        pwf_codeSupplier = new JPasswordField();
        pwf_codeSupplier.setBackground(new Color(255, 255, 255)); // Fondo blanco
        pwf_codeSupplier.setForeground(new Color(121, 85, 72)); // Marrón suave
        pwf_codeSupplier.setBounds(119, 130, 96, 20);
        pwf_codeSupplier.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 183, 77), new Color(255, 138, 101))); // Bisel naranja pastel
        panel.add(pwf_codeSupplier);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(245, 235, 224)); // Fondo beige claro
        panel_1.setBorder(new TitledBorder(null, "Listar Proveedores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(121, 85, 72)));
        panel_1.setBounds(368, 11, 312, 320);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        lst_suppliers = new JList<>();
        lst_suppliers.setBackground(new Color(255, 255, 255)); // Fondo blanco
        lst_suppliers.setForeground(new Color(121, 85, 72)); // Marrón suave
        lst_suppliers.setBounds(10, 25, 292, 284);
        panel_1.add(lst_suppliers);
    }
}