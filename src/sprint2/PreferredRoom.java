package sprint2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PreferredRoom extends JFrame {

	private JPanel contentPane;
	ArrayList<String> tags = new ArrayList<String>();
	ArrayList<String> rooms = new ArrayList<String>();
	ArrayList<String> modules = new ArrayList<String>();
	JComboBox comboBox = new JComboBox();
	JComboBox comboBox_1 = new JComboBox();
	JComboBox comboBox_2 = new JComboBox();
	int i,j,k = 0;
	String sRoom, sTag, sModule;

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
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				ResultSet rs= null;
				ResultSet rsRooms = null;
				ResultSet rsModules = null;
				
				PreferredRoomConnection prefConnection = new PreferredRoomConnection();
				rs = prefConnection.tagsRetrieve();
				rsRooms = prefConnection.roomRetreieve();
				rsModules = prefConnection.moduleRetreieve();
				
				

				try {
					while( rs.next( ) ) { 
					     tags.add(rs.getString( "Tag"));
					     comboBox.addItem(tags.get(i));
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
				try {
					while( rsModules.next( ) ) { 
					     modules.add(rsModules.getString( "subName"));
					     comboBox_2.addItem(modules.get(k));
					     k++;
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
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sTag = (String)comboBox.getSelectedItem();
			}
		});
		comboBox.setBounds(660, 131, 197, 25);
		contentPane.add(comboBox);
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sModule = (String)comboBox_1.getSelectedItem();
			}
		});
		comboBox_1.setBounds(660, 196, 197, 25);
		contentPane.add(comboBox_1);
		
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sRoom = (String)comboBox_2.getSelectedItem();
			}
		});
		comboBox_2.setBounds(660, 260, 197, 25);
		contentPane.add(comboBox_2);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(sTag.isEmpty()) {
					JOptionPane.showMessageDialog(null,
						    "Please select a Tag");
				}else if(sRoom.isEmpty()){
					JOptionPane.showMessageDialog(null,
						    "Please select a Room");
				}else if(sModule.isEmpty()) {
					JOptionPane.showMessageDialog(null, 
							"Please select a Module");
				}else {
					PreferredRoomConnection prefConnection = new PreferredRoomConnection();
					prefConnection.insertPrefRoom(sTag, sModule, sRoom);
					
					JOptionPane.showMessageDialog(null,
						    "Preferred Room Added Successfully !");	
				}
			}
		});
		button.setOpaque(true);
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(65, 105, 225));
		button.setBounds(721, 330, 90, 40);
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
		image2.setBounds(0, 460, 1037, 119);
		contentPane.add(image2);
	}

}


