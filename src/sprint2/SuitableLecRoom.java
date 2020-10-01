package sprint2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import location.AddLocation;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SuitableLecRoom extends JFrame {

	private JPanel contentPane;
	private String sLecturer, sRoom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuitableLecRoom frame = new SuitableLecRoom();
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
	public SuitableLecRoom() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("SUITABLE ROOM ASSIGN - Lecturer",SwingConstants.LEFT);
		label_1.setForeground(new Color(0, 51, 51));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_1.setBounds(12, 13, 970, 59);
		contentPane.add(label_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 73, 970, 2);
		contentPane.add(separator);
		
		JLabel label = new JLabel("");
		ImageIcon image = new ImageIcon(AddLocation.class.getResource("/class1.png"));
		label.setIcon(image);
		label.setBounds(144, 109, 300, 301);
		contentPane.add(label);
		
		JLabel label_2 = new JLabel("Lecturer");
		label_2.setForeground(new Color(25, 25, 112));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(539, 181, 53, 25);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Room");
		label_3.setForeground(new Color(25, 25, 112));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(539, 238, 48, 25);
		contentPane.add(label_3);
		
		JComboBox comboBox = new JComboBox(new Object[]{});
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sLecturer = (String) comboBox.getSelectedItem();
			}
		});
		comboBox.setBounds(638, 182, 197, 25);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(new Object[]{});
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sRoom = (String) comboBox_1.getSelectedItem();
			}
		});
		comboBox_1.setBounds(638, 239, 197, 25);
		contentPane.add(comboBox_1);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(sLecturer.isEmpty()) {
					JOptionPane.showMessageDialog(null,
						    "Please select a valid Lecturer");
				}else if(sRoom.isEmpty()){
					JOptionPane.showMessageDialog(null,
						    "Please select a valid Room Name");
				}else {
					System.out.println(sLecturer+ "," + sRoom );
					SuitableRoomConnection roomConnection = new SuitableRoomConnection();
					roomConnection.suitableLecRoom(sLecturer, sRoom);
					
					JOptionPane.showMessageDialog(null,
						    "Suitable Room for Lecturer Added!");	
				}}
		});
		button.setOpaque(true);
		button.setForeground(Color.BLUE);
		button.setBackground(new Color(65, 105, 225));
		button.setBounds(693, 293, 90, 40);
		contentPane.add(button);
	}

}
