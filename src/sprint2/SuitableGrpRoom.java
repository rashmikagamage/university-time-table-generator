package sprint2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import location.AddLocation;
import location.locationConnection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SuitableGrpRoom extends JFrame {
	
	private String sGrp, sRoom;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuitableGrpRoom frame = new SuitableGrpRoom();
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
	public SuitableGrpRoom() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("SUITABLE ROOM ASSIGN - Group/Sub-Group",SwingConstants.LEFT);
		label_1.setForeground(new Color(0, 51, 51));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_1.setBounds(12, 13, 970, 59);
		contentPane.add(label_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 73, 970, 2);
		contentPane.add(separator);
		
		JLabel label = new JLabel("");
		ImageIcon image = new ImageIcon(AddLocation.class.getResource("/grpassign.png"));
		label.setIcon(image);
		label.setBounds(96, 129, 300, 301);
		contentPane.add(label);
		
		JLabel label_2 = new JLabel("Group/Sub-Group");
		label_2.setForeground(new Color(25, 25, 112));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(472, 166, 120, 25);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Room");
		label_3.setForeground(new Color(25, 25, 112));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(542, 228, 48, 25);
		contentPane.add(label_3);
		
		JComboBox comboBox = new JComboBox(new Object[]{});
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sGrp = (String) comboBox.getSelectedItem();
			}
		});
		comboBox.setBounds(638, 167, 197, 25);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(new Object[]{});
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sRoom = (String) comboBox_1.getSelectedItem();
			}
		});
		comboBox_1.setBounds(638, 229, 197, 25);
		contentPane.add(comboBox_1);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(sGrp.isEmpty()) {
					JOptionPane.showMessageDialog(null,
						    "Please select a valid Group/Sub-group");
				}else if(sRoom.isEmpty()){
					JOptionPane.showMessageDialog(null,
						    "Please select a valid Room Name");
				}else {
					System.out.println(sGrp+ "," + sRoom );
					SuitableRoomConnection roomConnection = new SuitableRoomConnection();
					roomConnection.suitableGrpRoom(sGrp, sRoom);
					
					JOptionPane.showMessageDialog(null,
						    "Suitable Room for Group Added!");	
				}}
		});
		button.setOpaque(true);
		button.setForeground(Color.BLUE);
		button.setBackground(new Color(65, 105, 225));
		button.setBounds(696, 280, 90, 40);
		contentPane.add(button);
	}

}
