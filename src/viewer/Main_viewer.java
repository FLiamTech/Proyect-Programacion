package viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;

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
		setBounds(100, 100, 537, 394);
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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 29, 128, 90);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(231, 29, 128, 90);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.setBounds(10, 243, 128, 90);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("New button");
		btnNewButton_1_1_1.setBounds(231, 243, 128, 90);
		panel.add(btnNewButton_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Profile", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(386, 11, 125, 344);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
	}
}
