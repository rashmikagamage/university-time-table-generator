package generateTimetable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import workingDayAndHours.Navigation;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import db_connection.DB_Connection;
import Model.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class generateHall extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	public String[][] data=new String[][] {{"",""}};
	private JLabel Monday8;
	private JLabel Tuesday8;
	private JLabel Wednesday8;
	private JLabel Thursday8;
	private JLabel Friday8;
	private JLabel Friday9;
	private JLabel Thursday9;
	private JLabel Wednesday9;
	private JLabel Tuesday9;
	private JLabel Monday9;
	private JLabel Monday10;
	private JLabel Tuesday10;
	private JLabel Wednesday10;
	private JLabel Thursday10;
	private JLabel Friday10;
	private JLabel Friday11;
	private JLabel Thursday11;
	private JLabel Wednesday11;
	private JLabel Tuesday11;
	private JLabel Monday11;
	private JLabel Monday12;
	private JLabel Tuesday12;
	private JLabel Wednesday12;
	private JLabel Thursday12;
	private JLabel Friday12;
	private JLabel Friday13;
	private JLabel Thursday13;
	private JLabel Wednesday13;
	private JLabel Tuesday13;
	private JLabel Monday13;
	private JLabel Monday14;
	private JLabel Tuesday14;
	private JLabel Wednesday14;
	private JLabel Thursday14;
	private JLabel Friday14;
	private JLabel Friday15;
	private JLabel Thursday15;
	private JLabel Wednesday15;
	private JLabel Tuesday15;
	private JLabel Monday15;
	private JLabel Monday16;
	private JLabel Tuesday16;
	private JLabel Wednesday16;
	private JLabel Thursday16;
	private JLabel Friday16;
	private Connection connection;
	DB_Connection dbConn= new DB_Connection();
	ArrayList<sessionsModel> sessionsList= new ArrayList<>();
	ArrayList<SessionRoomModel> SessionRoom= new ArrayList<>();
	ArrayList<timeSlots> timeSlotList= new ArrayList<>();
	ArrayList<workDaysModel> workDaysList= new ArrayList<>();
	HashMap<String, JLabel> LabelName=null;
	ArrayList<String> LableNameList= new ArrayList<>();
	private JPanel TimeTablePanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					generateHall frame = new generateHall();
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
	public generateHall() {
		connection= dbConn.get_connection();
		
		try {
            if(connection==null) {
                JOptionPane.showMessageDialog(null, "DATABASE NOT CONNECTED");
            }
	} catch (Exception exp) {
            JOptionPane.showMessageDialog(null, exp);
	}
		
		getAllDataFromDatabase();
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Print(TimeTablePanel);
			}
		});
		btnPrint.setBounds(866, 493, 89, 23);
		contentPane.add(btnPrint);
		
		JLabel lblStudentId = new JLabel("Room #");
		lblStudentId.setBounds(306, 32, 64, 14);
		contentPane.add(lblStudentId);
		
		textField = new JTextField();
		textField.setBounds(389, 29, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setStuentTimeTable(textField.getText());
			}
		});
		btnGenerate.setBounds(511, 28, 89, 23);
		contentPane.add(btnGenerate);
		
		JButton btnBack = new JButton("Back");
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				generateNav s = new generateNav();
				dispose();
				s.setVisible(true);
				
			}
		});
		
		btnBack.setBounds(25, 28, 89, 23);
		contentPane.add(btnBack);
		
		TimeTablePanel = new JPanel();
		TimeTablePanel.setBounds(26, 74, 931, 399);
		contentPane.add(TimeTablePanel);
		TimeTablePanel.setLayout(null);
		
		Monday8 = new JLabel("");
		Monday8.setBounds(156, 40, 153, 40);
		TimeTablePanel.add(Monday8);
		Monday8.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Monday9 = new JLabel("");
		Monday9.setBounds(156, 79, 153, 40);
		TimeTablePanel.add(Monday9);
		Monday9.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Monday11 = new JLabel("");
		Monday11.setBounds(156, 160, 153, 40);
		TimeTablePanel.add(Monday11);
		Monday11.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Monday10 = new JLabel("");
		Monday10.setBounds(156, 120, 153, 40);
		TimeTablePanel.add(Monday10);
		Monday10.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Monday12 = new JLabel("");
		Monday12.setBounds(156, 200, 153, 40);
		TimeTablePanel.add(Monday12);
		Monday12.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Monday13 = new JLabel("");
		Monday13.setBounds(156, 239, 153, 40);
		TimeTablePanel.add(Monday13);
		Monday13.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Monday14 = new JLabel("");
		Monday14.setBounds(156, 280, 153, 40);
		TimeTablePanel.add(Monday14);
		Monday14.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Monday15 = new JLabel("");
		Monday15.setBounds(156, 320, 153, 40);
		TimeTablePanel.add(Monday15);
		Monday15.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Monday16 = new JLabel("");
		Monday16.setBounds(156, 359, 153, 40);
		TimeTablePanel.add(Monday16);
		Monday16.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Tuesday8 = new JLabel("");
		Tuesday8.setBounds(311, 40, 153, 40);
		TimeTablePanel.add(Tuesday8);
		Tuesday8.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Tuesday9 = new JLabel("");
		Tuesday9.setBounds(311, 79, 153, 40);
		TimeTablePanel.add(Tuesday9);
		Tuesday9.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Tuesday10 = new JLabel("");
		Tuesday10.setBounds(311, 120, 153, 40);
		TimeTablePanel.add(Tuesday10);
		Tuesday10.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Tuesday11 = new JLabel("");
		Tuesday11.setBounds(311, 160, 153, 40);
		TimeTablePanel.add(Tuesday11);
		Tuesday11.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Tuesday12 = new JLabel("");
		Tuesday12.setBounds(311, 200, 153, 40);
		TimeTablePanel.add(Tuesday12);
		Tuesday12.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Tuesday13 = new JLabel("");
		Tuesday13.setBounds(311, 239, 153, 40);
		TimeTablePanel.add(Tuesday13);
		Tuesday13.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Tuesday14 = new JLabel("");
		Tuesday14.setBounds(311, 280, 153, 40);
		TimeTablePanel.add(Tuesday14);
		Tuesday14.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Tuesday15 = new JLabel("");
		Tuesday15.setBounds(311, 320, 153, 40);
		TimeTablePanel.add(Tuesday15);
		Tuesday15.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Tuesday16 = new JLabel("");
		Tuesday16.setBounds(311, 359, 153, 40);
		TimeTablePanel.add(Tuesday16);
		Tuesday16.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Wednesday8 = new JLabel("");
		Wednesday8.setBounds(467, 40, 153, 40);
		TimeTablePanel.add(Wednesday8);
		Wednesday8.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Thursday8 = new JLabel("");
		Thursday8.setBounds(622, 40, 153, 40);
		TimeTablePanel.add(Thursday8);
		Thursday8.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Thursday9 = new JLabel("");
		Thursday9.setBounds(622, 79, 153, 40);
		TimeTablePanel.add(Thursday9);
		Thursday9.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Wednesday9 = new JLabel("");
		Wednesday9.setBounds(467, 79, 153, 40);
		TimeTablePanel.add(Wednesday9);
		Wednesday9.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Wednesday10 = new JLabel("");
		Wednesday10.setBounds(467, 120, 153, 40);
		TimeTablePanel.add(Wednesday10);
		Wednesday10.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Thursday10 = new JLabel("");
		Thursday10.setBounds(622, 120, 153, 40);
		TimeTablePanel.add(Thursday10);
		Thursday10.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Thursday11 = new JLabel("");
		Thursday11.setBounds(622, 160, 153, 40);
		TimeTablePanel.add(Thursday11);
		Thursday11.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Wednesday11 = new JLabel("");
		Wednesday11.setBounds(467, 160, 153, 40);
		TimeTablePanel.add(Wednesday11);
		Wednesday11.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Wednesday12 = new JLabel("");
		Wednesday12.setBounds(467, 200, 153, 40);
		TimeTablePanel.add(Wednesday12);
		Wednesday12.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Thursday12 = new JLabel("");
		Thursday12.setBounds(622, 200, 153, 40);
		TimeTablePanel.add(Thursday12);
		Thursday12.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Thursday13 = new JLabel("");
		Thursday13.setBounds(622, 239, 153, 40);
		TimeTablePanel.add(Thursday13);
		Thursday13.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Wednesday13 = new JLabel("");
		Wednesday13.setBounds(467, 239, 153, 40);
		TimeTablePanel.add(Wednesday13);
		Wednesday13.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Wednesday14 = new JLabel("");
		Wednesday14.setBounds(467, 280, 153, 40);
		TimeTablePanel.add(Wednesday14);
		Wednesday14.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Thursday14 = new JLabel("");
		Thursday14.setBounds(622, 280, 153, 40);
		TimeTablePanel.add(Thursday14);
		Thursday14.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Thursday16 = new JLabel("");
		Thursday16.setBounds(622, 359, 153, 40);
		TimeTablePanel.add(Thursday16);
		Thursday16.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Thursday15 = new JLabel("");
		Thursday15.setBounds(622, 320, 153, 40);
		TimeTablePanel.add(Thursday15);
		Thursday15.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Wednesday15 = new JLabel("");
		Wednesday15.setBounds(467, 320, 153, 40);
		TimeTablePanel.add(Wednesday15);
		Wednesday15.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Wednesday16 = new JLabel("");
		Wednesday16.setBounds(467, 359, 153, 40);
		TimeTablePanel.add(Wednesday16);
		Wednesday16.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Friday8 = new JLabel("");
		Friday8.setBounds(776, 40, 153, 40);
		TimeTablePanel.add(Friday8);
		Friday8.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Friday9 = new JLabel("");
		Friday9.setBounds(776, 79, 153, 40);
		TimeTablePanel.add(Friday9);
		Friday9.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Friday10 = new JLabel("");
		Friday10.setBounds(776, 120, 153, 40);
		TimeTablePanel.add(Friday10);
		Friday10.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Friday11 = new JLabel("");
		Friday11.setBounds(776, 160, 153, 40);
		TimeTablePanel.add(Friday11);
		Friday11.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Friday12 = new JLabel("");
		Friday12.setBounds(776, 200, 153, 40);
		TimeTablePanel.add(Friday12);
		Friday12.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Friday13 = new JLabel("");
		Friday13.setBounds(776, 239, 153, 40);
		TimeTablePanel.add(Friday13);
		Friday13.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Friday14 = new JLabel("");
		Friday14.setBounds(776, 280, 153, 40);
		TimeTablePanel.add(Friday14);
		Friday14.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Friday15 = new JLabel("");
		Friday15.setBounds(776, 320, 153, 40);
		TimeTablePanel.add(Friday15);
		Friday15.setFont(new Font("Arial", Font.PLAIN, 9));
		
		Friday16 = new JLabel("");
		Friday16.setBounds(776, 359, 153, 40);
		TimeTablePanel.add(Friday16);
		Friday16.setFont(new Font("Arial", Font.PLAIN, 9));
		
		table = new JTable();
		table.setEnabled(false);
		table.setBounds(0, 0, 931, 399);
		TimeTablePanel.add(table);
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"},
				{"08:30", data[0][0], null, null, null, null},
				{"09:30", null, null, null, null, null},
				{"10:30", null, null, null, null, null},
				{"11:30", null, null, null, null, null},
				{"12:30", null, null, null, null, null},
				{"13:30", null, null, null, null, null},
				{"14:30", null, null, null, null, null},
				{"15:30", null, null, null, null, null},
				{"16:30", null, null, null, null, null},
			},
			new String[] {
				"New column", "Monday", "New column", "New column", "New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(0).setMinWidth(150);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.setRowHeight(40);
		

}

	public HashMap<String, JLabel> getLabelHaspMap() {
		// TODO Auto-generated method stub
		LabelName= new HashMap<String,JLabel>();
		LabelName.put("Monday8", Monday8);LabelName.put("Tuesday8", Tuesday8);LabelName.put("Wednesday8", Wednesday8);LabelName.put("Thursday8", Thursday8);LabelName.put("Friday8", Friday8);
		LabelName.put("Monday9", Monday9);LabelName.put("Tuesday9", Tuesday9);LabelName.put("Wednesday9", Wednesday9);LabelName.put("Thursday9", Thursday9);LabelName.put("Friday9", Friday9);
		LabelName.put("Monday10", Monday10);LabelName.put("Tuesday10", Tuesday10);LabelName.put("Wednesday10", Wednesday10);LabelName.put("Thursday10", Thursday10);LabelName.put("Friday10", Friday10);
		LabelName.put("Monday11", Monday11);LabelName.put("Tuesday11", Tuesday11);LabelName.put("Wednesday11", Wednesday11);LabelName.put("Thursday11", Thursday11);LabelName.put("Friday11", Friday11);
		LabelName.put("Monday12", Monday12);LabelName.put("Tuesday12", Tuesday12);LabelName.put("Wednesday12", Wednesday12);LabelName.put("Thursday12", Thursday12);LabelName.put("Friday12", Friday12);
		LabelName.put("Monday13", Monday13);LabelName.put("Tuesday13", Tuesday13);LabelName.put("Wednesday13", Wednesday13);LabelName.put("Thursday13", Thursday13);LabelName.put("Friday13", Friday13);
		LabelName.put("Monday14", Monday14);LabelName.put("Tuesday14", Tuesday14);LabelName.put("Wednesday14", Wednesday14);LabelName.put("Thursday14", Thursday14);LabelName.put("Friday14", Friday14);
		LabelName.put("Monday15", Monday15);LabelName.put("Tuesday15", Tuesday15);LabelName.put("Wednesday15", Wednesday15);LabelName.put("Thursday15", Thursday15);LabelName.put("Friday15", Friday15);
		LabelName.put("Monday16", Monday16);LabelName.put("Tuesday16", Tuesday16);LabelName.put("Wednesday16", Wednesday16);LabelName.put("Thursday16", Thursday16);LabelName.put("Friday16", Friday16);
		
		return LabelName;
		
	}

	protected void setStuentTimeTable(String text) {
		// TODO Auto-generated method stub
		emptyLabelData();
		for(SessionRoomModel roomData:SessionRoom) {
			if(roomData.getRoom().equals(text)) {
				for(sessionsModel sessData:sessionsList) {
					if(sessData.getId().equals(roomData.getId())) {
						for(timeSlots timeData:timeSlotList) {
							if(sessData.getId().equals(timeData.getIdTs())) {
								for(workDaysModel workData:workDaysList) {
									if(timeData.getIdTs().equals(workData.getwID())) {
										if(workData.getwMonday().equals("1")) {
											if(getLabelNameList("Monday",Integer.parseInt(timeData.getStartHour()),Integer.parseInt(timeData.getEndHour()))!=null) {
												for(String lableName:getLabelNameList("Monday",Integer.parseInt(timeData.getStartHour()),Integer.parseInt(timeData.getEndHour()))) {
													getLabelHaspMap().get(lableName).setText(sessData.getGroupId()+"\n"+sessData.getCode()+"-"+sessData.getSubject()+"("+sessData.getTag()+")");
												}
											}else {
												JOptionPane.showMessageDialog(null, "TIME SHOULD BE IN RANGE OF 8:00 TO 16:00");
											}
											
										}
										if(workData.getwTuesday().equals("1")) {
											if(getLabelNameList("Tuesday",Integer.parseInt(timeData.getStartHour()),Integer.parseInt(timeData.getEndHour()))!=null) {
												for(String lableName:getLabelNameList("Tuesday",Integer.parseInt(timeData.getStartHour()),Integer.parseInt(timeData.getEndHour()))) {
													getLabelHaspMap().get(lableName).setText(sessData.getGroupId()+"\n"+sessData.getCode()+"-"+sessData.getSubject()+"("+sessData.getTag()+")");
												}
											}else {
												JOptionPane.showMessageDialog(null, "TIME SHOULD BE IN RANGE OF 8:00 TO 16:00");
											}
											
										}
										if(workData.getwWednesday().equals("1")) {
											if(getLabelNameList("Wednesday",Integer.parseInt(timeData.getStartHour()),Integer.parseInt(timeData.getEndHour()))!=null) {
												for(String lableName:getLabelNameList("Wednesday",Integer.parseInt(timeData.getStartHour()),Integer.parseInt(timeData.getEndHour()))) {
													getLabelHaspMap().get(lableName).setText(sessData.getGroupId()+"\n"+sessData.getCode()+"-"+sessData.getSubject()+"("+sessData.getTag()+")");
												}
											}else {
												JOptionPane.showMessageDialog(null, "TIME SHOULD BE IN RANGE OF 8:00 TO 16:00");
											}
											
										}
										if(workData.getwThursday().equals("1")) {
											if(getLabelNameList("Thursday",Integer.parseInt(timeData.getStartHour()),Integer.parseInt(timeData.getEndHour()))!=null) {
												for(String lableName:getLabelNameList("Thursday",Integer.parseInt(timeData.getStartHour()),Integer.parseInt(timeData.getEndHour()))) {
													getLabelHaspMap().get(lableName).setText(sessData.getGroupId()+"\n"+sessData.getCode()+"-"+sessData.getSubject()+"("+sessData.getTag()+")");
												}
											}else {
												JOptionPane.showMessageDialog(null, "TIME SHOULD BE IN RANGE OF 8:00 TO 16:00");
											}
											
										}
										if(workData.getwFriday().equals("1")) {
											if(getLabelNameList("Friday",Integer.parseInt(timeData.getStartHour()),Integer.parseInt(timeData.getEndHour()))!=null) {
												for(String lableName:getLabelNameList("Friday",Integer.parseInt(timeData.getStartHour()),Integer.parseInt(timeData.getEndHour()))) {
													getLabelHaspMap().get(lableName).setText(sessData.getGroupId()+"\n"+sessData.getCode()+"-"+sessData.getSubject()+"("+sessData.getTag()+")");
												}
											}else {
												JOptionPane.showMessageDialog(null, "TIME SHOULD BE IN RANGE OF 8:00 TO 16:00");
											}
											
										}
									}
								}
							}
						}
					}
					}
			}
		}
		
		}
		
	

	private ArrayList<String> getLabelNameList(String day,int start,int end) {
		// TODO Auto-generated method stub
		ArrayList<String> list= new ArrayList<>();
		if(start>=8 && end<=16) {
			for(int i=start;i<=end;i++) {
				list.add(day+i);
			}
			return list;
		}
		return null;
		
	}

	private void getAllDataFromDatabase() {
		// TODO Auto-generated method stub
		setSessionData();
		setTimeSlotData();
		setWorkDaysData();
		setSessionRoomData();

		
		
	}
	private void setSessionData() {
		String totalsql = "select id, lects, subject,code,tag,groupid,count,duration from timetable.sessions;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(totalsql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()) {
                	sessionsList.add(new sessionsModel(
                			resultSet.getString("id"), 
                			resultSet.getString("lects"), 
                			resultSet.getString("subject"), 
                			resultSet.getString("code"), 
                			resultSet.getString("tag"), 
                			resultSet.getString("groupid"), 
                			resultSet.getString("count"), 
                			resultSet.getString("duration")));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
	}

	
	private void setSessionRoomData() {
		String totalsql = "SELECT idSessionRoom,session,room FROM timetable.SessionRoom;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(totalsql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()) {
                	SessionRoom.add(new SessionRoomModel(
                			resultSet.getString("idSessionRoom"), 
                			resultSet.getString("session"), 
                			resultSet.getString("room")));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
	}
	
	private void setTimeSlotData() {
		String totalsql = "select idTs,slotType,startHour,startMinute,endHour,endMinute,workHours,workMinutes from timetable.timeSlots;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(totalsql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()) {
                	timeSlotList.add(new timeSlots(
                			resultSet.getString("idTs"), 
                			resultSet.getString("slotType"), 
                			resultSet.getString("startHour"), 
                			resultSet.getString("startMinute"), 
                			resultSet.getString("endHour"), 
                			resultSet.getString("endMinute"), 
                			resultSet.getString("workHours"), 
                			resultSet.getString("workMinutes")));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
	}
	
	
	private void setWorkDaysData() {
		String totalsql = "select w.wID,w.wdhType,w.wdhNoDays,w.wMonday,w.wTuesday,w.wWednesday,w.wThursday,w.wFriday from timetable.workingDaysHours w;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(totalsql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()) {
                	workDaysList.add(new workDaysModel(
                			resultSet.getString("wID"), 
                			resultSet.getString("wdhType"), 
                			resultSet.getString("wdhNoDays"), 
                			resultSet.getString("wMonday"), 
                			resultSet.getString("wTuesday"), 
                			resultSet.getString("wWednesday"), 
                			resultSet.getString("wThursday"), 
                			resultSet.getString("wFriday")));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
	}
	private void emptyLabelData() {
		for(String lableName:getLabelNameList("Monday",8,16)) {
			getLabelHaspMap().get(lableName).setText("");
		}
		for(String lableName:getLabelNameList("Tuesday",8,16)) {
			getLabelHaspMap().get(lableName).setText("");
		}
		for(String lableName:getLabelNameList("Wednesday",8,16)) {
			getLabelHaspMap().get(lableName).setText("");
		}
		for(String lableName:getLabelNameList("Thursday",8,16)) {
			getLabelHaspMap().get(lableName).setText("");
		}
		for(String lableName:getLabelNameList("Friday",8,16)) {
			getLabelHaspMap().get(lableName).setText("");
		}
		
	}
	
	
	public void Print(JPanel component){
	    PrinterJob pj = PrinterJob.getPrinterJob();
	    pj.setJobName(" Print Component ");

	    pj.setPrintable (new Printable() {    
	        public int print(Graphics pg, PageFormat pf, int pageNum){
	        if (pageNum > 0){
	            return Printable.NO_SUCH_PAGE;
	        }    
	            Graphics2D g2 = (Graphics2D) pg;
	            g2.translate(pf.getImageableX() + pf.getImageableWidth() / 2 - component.getWidth() / 2, pf.getImageableY() + pf.getImageableHeight() / 2 - component.getHeight() / 2);
	            component.paint(g2);
	            return Printable.PAGE_EXISTS;
	    }     
	  });

	            PageFormat pf = pj.defaultPage();
	            pf = pj.defaultPage();
	            Paper paper = pf.getPaper();
	            paper.setSize(8.5 * 72, 14 * 72);
	            paper.setImageableArea(0.5 * 72, 0.0 * 72, 8 * 72, 14 * 72);
	            pf.setPaper(paper);
	            pf.setOrientation(PageFormat.LANDSCAPE);
	            Book book = new Book();//java.awt.print.Book
	            book.append((new Printable() {    
	            public int print(Graphics pg, PageFormat pf, int pageNum){
	            if (pageNum > 0){
	            return Printable.NO_SUCH_PAGE;
	            }    
	            Graphics2D g2 = (Graphics2D) pg;
	            g2.translate(pf.getImageableX() + pf.getImageableWidth() / 2 - component.getWidth() / 2, pf.getImageableY() + pf.getImageableHeight() / 2 - component.getHeight() / 2);
	            component.paint(g2);
	            return Printable.PAGE_EXISTS;
	    }     
	  }), pf);
	            pj.setPageable(book); 
	            if (pj.printDialog() == false)
	            return;

	  try {
	        pj.print();
	  } catch (PrinterException ex) {
	        // handle exception
	  }
	}
}
