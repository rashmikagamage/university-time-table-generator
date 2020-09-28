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
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ConsecutiveSessions extends JFrame {

	private JPanel contentPane;
	private String cSession, room;
	ArrayList<String> csessions = new ArrayList<String>();
	ArrayList<String> rooms = new ArrayList<String>();
	JComboBox comboBox = new JComboBox();
	JComboBox comboBox_1 = new JComboBox();
	int i,j = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsecutiveSessions frame = new ConsecutiveSessions();
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
	public ConsecutiveSessions() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				ResultSet rsConSess= null;
				ResultSet rsRooms = null;
				
				ConSessionConnection cSessConnection = new ConSessionConnection();
				rsConSess = cSessConnection.consecSessionRetrieve();
				rsRooms = cSessConnection.roomRetreieve();
				
				

				try {
					while( rsConSess.next( ) ) { 
					     csessions.add(rsConSess.getString( "conSession"));
					     comboBox.addItem(csessions.get(i));
					     i++;
					  }
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					while( rsRooms.next( ) ) { 
					     rooms.add(rsRooms.getString( "room"));
					     comboBox_1.addItem(rooms.get(j));
					     j++;
					  }
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("CONSECUTIVE SESSIONS ASSIGN",SwingConstants.CENTER);
		label_1.setForeground(new Color(0, 51, 51));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_1.setBounds(12, 13, 970, 59);
		contentPane.add(label_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 73, 970, 2);
		contentPane.add(separator);
		
		JLabel label = new JLabel("");
		ImageIcon image = new ImageIcon(AddLocation.class.getResource("/consession.png"));
		label.setIcon(image);
		label.setBounds(112, 130, 300, 301);
		contentPane.add(label);
		
		JLabel label_2 = new JLabel("Consecutive Session");
		label_2.setForeground(new Color(25, 25, 112));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(462, 165, 131, 25);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Room");
		label_3.setForeground(new Color(25, 25, 112));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(545, 228, 48, 25);
		contentPane.add(label_3);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cSession = (String)comboBox.getSelectedItem();
			}
		});
		comboBox.setBounds(638, 166, 197, 25);
		contentPane.add(comboBox);
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				room = (String)comboBox_1.getSelectedItem();
			}
		});
		comboBox_1.setBounds(638, 229, 197, 25);
		contentPane.add(comboBox_1);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cSession.isEmpty()) {
					JOptionPane.showMessageDialog(null,
						    "Please select a valid Consecutive Session");
				}else if(room.isEmpty()){
					JOptionPane.showMessageDialog(null,
						    "Please select a valid Room Name");
				}else {
					ConSessionConnection conSesConnection = new ConSessionConnection();
					conSesConnection.insertConSession(cSession, room);
					
					JOptionPane.showMessageDialog(null,
						    "Suitable Room for Consecutive Session Added!");	
				}}
		});
		button.setOpaque(true);
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(65, 105, 225));
		button.setBounds(709, 284, 90, 40);
		contentPane.add(button);
		
		JButton bckBtn = new JButton("BACK");
		bckBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				RoomManagementHome home = new RoomManagementHome();
				home.setVisible(true);
				
				}
		});
		bckBtn.setOpaque(true);
		bckBtn.setForeground(Color.WHITE);
		bckBtn.setBackground(new Color(65, 105, 225));
		bckBtn.setBounds(890, 25, 90, 35);
		contentPane.add(bckBtn);
		
		JLabel image2 = new JLabel("");
		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/foot.png"));
		image2.setIcon(img2);
		image2.setBounds(0, 471, 1037, 90);
		contentPane.add(image2);
	}

}
