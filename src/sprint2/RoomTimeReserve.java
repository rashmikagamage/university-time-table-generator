package sprint2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JSpinner.NumberEditor;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import location.AddLocation;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class RoomTimeReserve extends JFrame {

	private JPanel contentPane;
	private SpringLayout springLayout;
	ArrayList<String> tags = new ArrayList<String>();
	ArrayList<String> rooms = new ArrayList<String>();
	ArrayList<String> modules = new ArrayList<String>();
	JComboBox comboBox = new JComboBox();
	JComboBox comboBox_1 = new JComboBox();
	JComboBox comboBox_2 = new JComboBox();
	SpinnerModel shours = new SpinnerNumberModel(0, 0, 24, 1);
	SpinnerModel smins = new SpinnerNumberModel(0, 0, 59, 1);
	SpinnerModel ehours = new SpinnerNumberModel(0, 0, 24, 1);
	SpinnerModel emins = new SpinnerNumberModel(0, 0, 59, 1);
	JSpinner spinner = new JSpinner(shours);
	JSpinner spinner_2 = new JSpinner(ehours);
	JSpinner spinner_1 = new JSpinner(smins);
	JSpinner spinner_3 = new JSpinner(emins);
	int i,j,k = 0;
	String sRoom, sTag, sModule, sDate, sTime, eTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomTimeReserve frame = new RoomTimeReserve();
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
	public RoomTimeReserve() {
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
		
		JLabel label_1 = new JLabel("ROOM TIME RESERVATION",SwingConstants.CENTER);
		label_1.setForeground(new Color(0, 51, 51));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_1.setBounds(12, 13, 970, 59);
		contentPane.add(label_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 73, 970, 2);
		contentPane.add(separator);
		
		JLabel label = new JLabel("");
		ImageIcon image = new ImageIcon(AddLocation.class.getResource("/reservation.png"));
		label.setIcon(image);
		label.setBounds(533, 88, 338, 297);
		contentPane.add(label);
		
		JLabel label_2 = new JLabel("Tag");
		label_2.setForeground(new Color(25, 25, 112));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(53, 116, 48, 25);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Module");
		label_3.setForeground(new Color(25, 25, 112));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(53, 177, 48, 25);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Room");
		label_4.setForeground(new Color(25, 25, 112));
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(53, 238, 48, 25);
		contentPane.add(label_4);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sTag = (String)comboBox.getSelectedItem();
			}
		});
		comboBox.setBounds(155, 117, 204, 25);
		contentPane.add(comboBox);
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sModule = (String)comboBox_1.getSelectedItem();
			}
		});
		comboBox_1.setBounds(155, 178, 204, 25);
		contentPane.add(comboBox_1);
		
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sRoom = (String)comboBox_2.getSelectedItem();
			}
		});
		comboBox_2.setBounds(155, 239, 204, 25);
		contentPane.add(comboBox_2);
		
		

		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sDate = datePicker.getJFormattedTextField().getText();
				System.out.println(sDate);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(155, 299, 204, 59);
		panel.add(datePicker);
		contentPane.add(panel);
		
		spinner.setEditor(new JSpinner.NumberEditor(spinner, "00"));
		spinner.setValue(18);
		spinner.setBounds(155, 386, 53, 22);
		contentPane.add(spinner);
		
		spinner_1.setEditor(new JSpinner.NumberEditor(spinner_1, "00"));
		spinner_1.setValue(10);
		spinner_1.setBounds(231, 386, 53, 22);
		contentPane.add(spinner_1);
		
		JLabel label_6 = new JLabel("Start Time");
		label_6.setForeground(new Color(25, 25, 112));
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_6.setBounds(53, 386, 78, 25);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel(" : ");
		label_7.setForeground(new Color(25, 25, 112));
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_7.setBounds(214, 384, 15, 25);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("End Time");
		label_8.setForeground(new Color(25, 25, 112));
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_8.setBounds(53, 417, 78, 25);
		contentPane.add(label_8);
		
		spinner_2.setEditor(new JSpinner.NumberEditor(spinner_2, "00"));
		spinner_2.setValue(19);
		spinner_2.setBounds(155, 420, 53, 22);
		contentPane.add(spinner_2);
		
		spinner_3.setEditor(new JSpinner.NumberEditor(spinner_3, "00"));
		spinner_3.setValue(10);
		spinner_3.setBounds(231, 420, 53, 22);
		contentPane.add(spinner_3);
		
		JLabel label_9 = new JLabel(" : ");
		label_9.setForeground(new Color(25, 25, 112));
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_9.setBounds(214, 417, 15, 25);
		contentPane.add(label_9);
		
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
					}else if(sDate.isEmpty()) {
						JOptionPane.showMessageDialog(null, 
								"Please select a Date");
					}else {
						PreferredRoomConnection prefConnection = new PreferredRoomConnection();
						sTime = (String) (spinner.getValue() + ":" + spinner_1.getValue());
						eTime = (String) (spinner_2.getValue() + ":" + spinner_3.getValue());
						prefConnection.insertRoomRes(sTag, sModule, sRoom, sDate, sTime, eTime);
						
						JOptionPane.showMessageDialog(null,
							    "Room Reserved Successfully !");	
					}
				}
		});
		button.setOpaque(true);
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(65, 105, 225));
		button.setBounds(648, 432, 90, 40);
		contentPane.add(button);
		
		JLabel label_5 = new JLabel("Date");
		label_5.setForeground(new Color(25, 25, 112));
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(53, 299, 48, 25);
		contentPane.add(label_5);
		
		
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
		image2.setBounds(0, 455, 1037, 119);
		contentPane.add(image2);
		
		
	}
}

