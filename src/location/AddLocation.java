package location;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import home.Dashboard;
import sprint2.RoomManagementHome;
import student.addDataConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddLocation extends JFrame {

	private JPanel contentPane;
	private JTextField buildingName;
	private JTextField roomName;
	private JTextField capability;
	
	String sbuildingName, sroomName, sRoomType, scapability;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLocation frame = new AddLocation();
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
	public AddLocation() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("ADD LOCATION",SwingConstants.CENTER);
		label_1.setForeground(new Color(0, 51, 51));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_1.setBounds(12, 13, 970, 59);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Building Name");
		label_2.setForeground(new Color(25, 25, 112));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(455, 111, 100, 25);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Room Type");
		label_3.setForeground(new Color(25, 25, 112));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(455, 172, 100, 25);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Room");
		label_4.setForeground(new Color(25, 25, 112));
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(455, 233, 100, 25);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Capabilities");
		label_5.setForeground(new Color(25, 25, 112));
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(455, 295, 100, 25);
		contentPane.add(label_5);
		
		String[] RoomType = {"Lecture Hall", "Laboratory"};
		
		JComboBox roomType = new JComboBox(RoomType);
		roomType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        sRoomType = (String)roomType.getSelectedItem();
			
			}
		});
		
		roomType.setBounds(638, 173, 197, 25);
		contentPane.add(roomType);
		
		buildingName = new JTextField();
		buildingName.setText("");
		buildingName.setColumns(10);
		buildingName.setBounds(636, 113, 199, 25);
		contentPane.add(buildingName);
		
		roomName = new JTextField();
		roomName.setText("");
		roomName.setColumns(10);
		roomName.setBounds(636, 235, 199, 25);
		contentPane.add(roomName);
		
		capability = new JTextField();
		capability.setText("");
		capability.setColumns(10);
		capability.setBounds(636, 297, 199, 25);
		contentPane.add(capability);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sbuildingName = buildingName.getText().toString();
				sroomName = roomName.getText().toString();
				scapability = capability.getText().toString();
				
				if(sbuildingName.isEmpty()) {
					JOptionPane.showMessageDialog(null,
						    "Please enter a valid Building Name");
				}else if(sroomName.isEmpty()){
					JOptionPane.showMessageDialog(null,
						    "Please enter a valid Room Name");
				}else if(scapability.isEmpty()) {
					JOptionPane.showMessageDialog(null, 
							"Please enter a valid Capability.");
				}else {
					System.out.println(sroomName+ "," + scapability + "," + sbuildingName +  "," + sRoomType);
					locationConnection locationConnection = new locationConnection();
					locationConnection.insertLocation(sbuildingName, sRoomType, sroomName, scapability);
					
					JOptionPane.showMessageDialog(null,
						    "Location Added !");
					
					buildingName.setText("");
					roomName.setText("");
					capability.setText("");			
				}}
			});
		
		button.setForeground(Color.BLUE);
		button.setOpaque(true);
		button.setBackground(new Color(65, 105, 225));
		button.setBounds(560, 377, 90, 40);
		contentPane.add(button);
		
		JLabel img = new JLabel("");
		ImageIcon image = new ImageIcon(AddLocation.class.getResource("/add bulidings.png"));
		img.setIcon(image);
		img.setBounds(62, 116, 300, 301);
		contentPane.add(img);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 70, 970, 2);
		contentPane.add(separator);
		
		JButton bckBtn = new JButton("BACK");
		bckBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				LocationHome home = new LocationHome();
				home.setVisible(true);
				
				}
		});
		bckBtn.setOpaque(true);
		bckBtn.setForeground(Color.WHITE);
		bckBtn.setBackground(new Color(65, 105, 225));
		bckBtn.setBounds(890, 25, 90, 35);
		contentPane.add(bckBtn);
	}
}
