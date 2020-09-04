package sprint2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import location.AddLocation;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class PreferredRoom extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreferredRoom frame = new PreferredRoom();
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
	public PreferredRoom() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("PREFERRED ROOM ASSIGN",SwingConstants.CENTER);
		label_1.setForeground(new Color(0, 51, 51));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_1.setBounds(12, 13, 970, 59);
		contentPane.add(label_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 73, 970, 2);
		contentPane.add(separator);
		
		JLabel label = new JLabel("");
		ImageIcon image = new ImageIcon(AddLocation.class.getResource("/class.png"));
		label.setIcon(image);
		label.setBounds(45, 129, 430, 301);
		contentPane.add(label);
		
		JLabel label_2 = new JLabel("Tag");
		label_2.setForeground(new Color(25, 25, 112));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(544, 129, 48, 25);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Module");
		label_3.setForeground(new Color(25, 25, 112));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(544, 194, 48, 25);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Room");
		label_4.setForeground(new Color(25, 25, 112));
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(544, 259, 48, 25);
		contentPane.add(label_4);
		
		JComboBox comboBox = new JComboBox(new Object[]{});
		comboBox.setBounds(660, 131, 197, 25);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(new Object[]{});
		comboBox_1.setBounds(660, 196, 197, 25);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox(new Object[]{});
		comboBox_2.setBounds(660, 260, 197, 25);
		contentPane.add(comboBox_2);
		
		JButton button = new JButton("Submit");
		button.setOpaque(true);
		button.setForeground(Color.BLUE);
		button.setBackground(new Color(65, 105, 225));
		button.setBounds(721, 330, 90, 40);
		contentPane.add(button);
	}

}
