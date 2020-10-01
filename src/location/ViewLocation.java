package location;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;
import sprint2.RoomManagementHome;
import student.ViewDataConnection;
import student.updateDataConnection;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.SwingConstants;

public class ViewLocation extends JFrame {
	
	

	private JPanel contentPane;
	private JTextField buildingName;
	private JTextField roomName;
	private JTextField capability;
	private JTable table;
	private JTextField idField;
	JFrame frame = new JFrame("Swing Tester");
	
	String idlocation, id, building, room, cap, roomType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLocation frame = new ViewLocation();
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
	public ViewLocation() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				ResultSet rs = null;
				ViewLocationConnection viewLocationCon = new ViewLocationConnection();
				rs = viewLocationCon.viewLocation();
				table.setModel(DbUtils.resultSetToTableModel(rs));
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
		
		JLabel label_1 = new JLabel("LOCATIONS");
		label_1.setForeground(new Color(0, 51, 51));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_1.setBounds(399, 13, 138, 59);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Building Name");
		label_2.setForeground(new Color(25, 25, 112));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(481, 330, 100, 25);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Room Type");
		label_3.setForeground(new Color(25, 25, 112));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(481, 367, 100, 25);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Room");
		label_4.setForeground(new Color(25, 25, 112));
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(481, 405, 100, 25);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Capabilities");
		label_5.setForeground(new Color(25, 25, 112));
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(481, 443, 100, 25);
		contentPane.add(label_5);
		
		idField = new JTextField();
		idField.setBounds(735, 125, 116, 22);
		contentPane.add(idField);
		idField.setColumns(10);
		
		String[] RoomType = {"Lecture Hall", "Laboratory"};
		
		JComboBox comboBox = new JComboBox(RoomType);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				roomType = (String)comboBox.getSelectedItem();
			}
		});
		comboBox.setBounds(654, 368, 197, 25);
		contentPane.add(comboBox);
		
		buildingName = new JTextField();
		buildingName.setText("");
		buildingName.setColumns(10);
		buildingName.setBounds(652, 330, 199, 25);
		contentPane.add(buildingName);
		
		roomName = new JTextField();
		roomName.setText("");
		roomName.setColumns(10);
		roomName.setBounds(654, 406, 199, 25);
		contentPane.add(roomName);
		
		capability = new JTextField();
		capability.setText("");
		capability.setColumns(10);
		capability.setBounds(654, 444, 199, 25);
		contentPane.add(capability);
		
		JLabel image = new JLabel("");
		image.setBounds(89, 337, 307, 176);
		ImageIcon img = new ImageIcon(AddLocation.class.getResource("/viewlocation.png"));
		image.setIcon(img);
		contentPane.add(image);
		
		JButton button = new JButton("UPDATE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				id = idField.getText();
				building = buildingName.getText();
				room = roomName.getText();
				cap = capability.getText();
				
				ViewLocationConnection updateLocCon = new ViewLocationConnection();
				updateLocCon.updateLocation(building, roomType, room, cap, id);
				JOptionPane.showMessageDialog(frame, "Location Updated !");
				
				idField.setText("");
				buildingName.setText("");
				roomName.setText("");
				capability.setText("");
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(102, 51, 255));
		button.setBounds(534, 488, 100, 25);
		contentPane.add(button);
		
		JButton delbtn = new JButton("DELETE");
		delbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				id = idField.getText();
				
				ViewLocationConnection deleteLocCon = new ViewLocationConnection();
				deleteLocCon.deleteLocation(id);
				JOptionPane.showMessageDialog(frame, "Location Deleted !");
				
				idField.setText("");
				buildingName.setText("");
				roomName.setText("");
				capability.setText("");
			}
		});
		delbtn.setForeground(Color.WHITE);
		delbtn.setBackground(new Color(255, 0, 0));
		delbtn.setBounds(664, 488, 100, 25);
		contentPane.add(delbtn);
			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(89, 97, 567, 206);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		table.setBackground(Color.LIGHT_GRAY);
		table.setBorder(null);
		table.setBounds(743, 278, -566, -195);
		
		
		JButton button_1 = new JButton("Search");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				idlocation = idField.getText().toString();
				//idField.setText("");
				
				
				ViewLocationConnection updateLocationCon = new ViewLocationConnection();
				ResultSet rs = updateLocationCon.getLocation(idlocation);
				try {
					
					if(!rs.isBeforeFirst()) {
						JOptionPane.showMessageDialog(frame,
							    "No Data Found !");
						buildingName.setText("");
						roomName.setText("");
						capability.setText("");
						
					}else {
						while(rs.next()) {
							buildingName.setText(rs.getString(2));
							String roomType = (rs.getString(3)).toString();
							comboBox.setSelectedItem(roomType);
							roomName.setText(rs.getString(4));
							capability.setText(rs.getString(5));
						}
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				try {
					while(rs.next()) {
						System.out.println(rs.getString(1));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(102, 51, 255));
		button_1.setBounds(880, 124, 89, 25);
		contentPane.add(button_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 70, 970, 2);
		contentPane.add(separator);
		
		JLabel lblId = new JLabel("ID");
		label_2.setForeground(new Color(25, 25, 112));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(703, 128, 20, 16);
		contentPane.add(lblId);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(680, 111, 10, 192);
		contentPane.add(separator_1);
		
		JButton btnViewAll = new JButton("View All");
		btnViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = null;
				ViewLocationConnection viewLocationCon = new ViewLocationConnection();
				rs = viewLocationCon.viewLocation();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		});
		btnViewAll.setBounds(741, 190, 97, 25);
		contentPane.add(btnViewAll);
		
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
