package viewer;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

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
    public JButton btn_singOut;
    public JButton btn_photo;
    public JButton btn_gitHub;

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
		setTitle("Admin");
		setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, Color.BLUE, Color.CYAN), "Add employee", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
        panel.setBounds(10, 11, 208, 280);
        panel.setBackground(new Color(218, 218, 218));
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nombre:");
        lblNewLabel.setFont(new Font("Century", Font.PLAIN, 12));
        lblNewLabel.setBounds(10, 32, 93, 14);
        panel.add(lblNewLabel);

        JLabel lblDni = new JLabel("DNI: ");
        lblDni.setFont(new Font("Century", Font.PLAIN, 12));
        lblDni.setBounds(10, 88, 93, 14);
        panel.add(lblDni);

        JLabel lblCodigo = new JLabel("Codigo:");
        lblCodigo.setFont(new Font("Century", Font.PLAIN, 12));
        lblCodigo.setBounds(10, 141, 106, 14);
        panel.add(lblCodigo);

        JLabel lblEmail = new JLabel("Fecha de ingreso:");
        lblEmail.setFont(new Font("Century", Font.PLAIN, 12));
        lblEmail.setBounds(10, 193, 162, 14);
        panel.add(lblEmail);

        txt_nameEmplod = new JTextField();
        txt_nameEmplod.setBounds(10, 57, 188, 20);
        txt_nameEmplod.setColumns(10);
        txt_nameEmplod.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.CYAN, Color.WHITE));
        panel.add(txt_nameEmplod);

        txt_dniEmplod = new JTextField();
        txt_dniEmplod.setColumns(10);
        txt_dniEmplod.setBounds(10, 109, 188, 20);
        txt_dniEmplod.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.CYAN, Color.WHITE));
        panel.add(txt_dniEmplod);

        pwf_codeEmplod = new JPasswordField();
        pwf_codeEmplod.setBounds(10, 162, 118, 20);
        pwf_codeEmplod.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLUE, Color.WHITE));
        panel.add(pwf_codeEmplod);

        btn_create = new JButton("Create");
        btn_create.setBackground(new Color(128, 128, 128));
        btn_create.setFont(new Font("Century", Font.PLAIN, 11));
        btn_create.setBounds(10, 246, 89, 23);
        panel.add(btn_create);

        txt_dateEmplod = new JTextField();
        txt_dateEmplod.setColumns(10);
        txt_dateEmplod.setBounds(10, 215, 118, 20);
        txt_dateEmplod.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLUE, Color.WHITE));
        panel.add(txt_dateEmplod);

        btn_photo = new JButton("Photo");
        btn_photo.setBackground(new Color(128, 128, 128));
        btn_photo.setBounds(138, 214, 48, 23);
        panel.add(btn_photo);

        JLabel lblFoto = new JLabel("Foto");
        lblFoto.setBounds(143, 193, 65, 14);
        panel.add(lblFoto);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, Color.ORANGE, Color.RED), "Change password", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
        panel_1.setBounds(228, 11, 261, 280);
        panel_1.setBackground(new Color(229, 229, 229));
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("DNI: ");
        lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(10, 32, 69, 14);
        panel_1.add(lblNewLabel_1);

        txt_dniEmployeeAux = new JTextField();
        txt_dniEmployeeAux.setColumns(10);
        txt_dniEmployeeAux.setBounds(10, 56, 223, 20);
        txt_dniEmployeeAux.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GREEN, Color.WHITE));
        panel_1.add(txt_dniEmployeeAux);

        btn_searchEmployee = new JButton("Search");
        btn_searchEmployee.setBackground(new Color(218, 218, 218));
        btn_searchEmployee.setFont(new Font("Century", Font.PLAIN, 11));
        btn_searchEmployee.setBounds(10, 87, 103, 34);
        panel_1.add(btn_searchEmployee);

        lbl_estate = new JLabel("Estado");
        lbl_estate.setFont(new Font("Century", Font.ITALIC, 12));
        lbl_estate.setBounds(123, 97, 92, 14);
        panel_1.add(lbl_estate);

        JLabel lblNewLabel_1_1 = new JLabel("Nueva contraseña:");
        lblNewLabel_1_1.setFont(new Font("Century", Font.PLAIN, 12));
        lblNewLabel_1_1.setBounds(10, 143, 176, 14);
        panel_1.add(lblNewLabel_1_1);

        btn_accept = new JButton("Accept");
        btn_accept.setBackground(new Color(218, 218, 218));
        btn_accept.setFont(new Font("Century", Font.PLAIN, 11));
        btn_accept.setBounds(10, 203, 103, 34);
        panel_1.add(btn_accept);

        pwd_newPassword = new JPasswordField();
        pwd_newPassword.setBounds(10, 168, 223, 20);
        pwd_newPassword.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GREEN, Color.WHITE));
        panel_1.add(pwd_newPassword);

        btn_singOut = new JButton("Sign Out");
        btn_singOut.setBackground(new Color(218, 218, 218));
        btn_singOut.setFont(new Font("Century", Font.BOLD, 12));
        btn_singOut.setBounds(135, 246, 116, 23);
        panel_1.add(btn_singOut);
        
        btn_gitHub = new JButton("gitHub");
        btn_gitHub.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btn_gitHub.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\AA-UNIVERSIDAD\\Programacion Aplicada\\Proyecto\\Proyect\\src\\view.Multimedia.Images\\github.jpg"));
        btn_gitHub.setFont(new Font("Century", Font.PLAIN, 11));
        btn_gitHub.setBackground(Color.GRAY);
        btn_gitHub.setBounds(217, 11, 37, 43);
        panel_1.add(btn_gitHub);
    }
}