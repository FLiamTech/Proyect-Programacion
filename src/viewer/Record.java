package viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Record extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JList lst_register;
	public JLabel lbl_numEgree;
	public JButton btn_returnRegister;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Record frame = new Record();
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
	public Record() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dates", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 11, 434, 72);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Movimientos recientes: ");
		lblNewLabel.setBounds(10, 33, 167, 28);
		panel.add(lblNewLabel);
		
		lbl_numEgree = new JLabel("Desconocido");
		lbl_numEgree.setBounds(187, 40, 110, 14);
		panel.add(lbl_numEgree);
		
		btn_returnRegister = new JButton("Return");
		btn_returnRegister.setBounds(335, 29, 89, 23);
		panel.add(btn_returnRegister);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Table", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 80, 434, 181);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lst_register = new JList();
		lst_register.setBounds(8, 25, 414, 145);
		panel_1.add(lst_register);
		
		scrollPane = new JScrollPane(lst_register);
        scrollPane.setBounds(8, 25, 414, 145); // Ajusta los bounds según tus necesidades
        panel_1.add(scrollPane);
	}
}
