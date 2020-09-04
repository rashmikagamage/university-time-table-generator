package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.Icon;

public class UpdateStudent extends JFrame {

	private JPanel contentPane;
	private JTextField semesterTextF;
	private JTextField yearTextF;
	private JTextField programmeTextF;
	private JTextField subGroupNoTextF;
	private JTextField groupNoTextF;
	private JTextField subGroupIdTextF;
	private JTextField groupIdTextF;
	JFrame frame = new JFrame("Swing Tester");
	static UpdateStudent frame1 ;
	String groupId,subGroupId,programme,sem,year,subGroupNo,groupNo,unChangedGroupId,unChangedSubId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame1 = new UpdateStudent();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateStudent() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setForeground(new Color(25, 25, 112));
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYear.setBounds(434, 208, 100, 25);
		contentPane.add(lblYear);
		
		JLabel lblGroupId = new JLabel("Group Id");
		lblGroupId.setForeground(new Color(25, 25, 112));
		lblGroupId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGroupId.setBounds(434, 107, 75, 14);
		contentPane.add(lblGroupId);
		
		JLabel lblSubGroupId = new JLabel("Sub Group Id");
		lblSubGroupId.setForeground(new Color(25, 25, 112));
		lblSubGroupId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSubGroupId.setBounds(434, 146, 100, 25);
		contentPane.add(lblSubGroupId);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setForeground(new Color(25, 25, 112));
		lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSemester.setBounds(434, 256, 100, 23);
		contentPane.add(lblSemester);
		
		JLabel lblProgramme = new JLabel("Programme");
		lblProgramme.setForeground(new Color(25, 25, 112));
		lblProgramme.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProgramme.setBounds(434, 301, 100, 25);
		contentPane.add(lblProgramme);
		
		JLabel lblGroupNo = new JLabel("Group No");
		lblGroupNo.setForeground(new Color(25, 25, 112));
		lblGroupNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGroupNo.setBounds(434, 347, 100, 25);
		contentPane.add(lblGroupNo);
		
		JLabel lblSubGroupNo = new JLabel("Sub Group No");
		lblSubGroupNo.setForeground(new Color(25, 25, 112));
		lblSubGroupNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSubGroupNo.setBounds(427, 393, 117, 25);
		contentPane.add(lblSubGroupNo);
		
		JLabel lblUpdateStudent = new JLabel("UPDATE STUDENT");
		lblUpdateStudent.setForeground(new Color(0, 51, 51));
		lblUpdateStudent.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUpdateStudent.setBounds(398, 11, 333, 57);
		contentPane.add(lblUpdateStudent);
		
		JLabel image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/class1.png"));
		image.setIcon(img);
		image.setBounds(24, 132, 300, 300);
		contentPane.add(image);
		
		semesterTextF = new JTextField();
		semesterTextF.setColumns(10);
		semesterTextF.setBounds(576, 258, 199, 25);
		contentPane.add(semesterTextF);
		
		yearTextF = new JTextField();
		yearTextF.setText("");
		yearTextF.setColumns(10);
		yearTextF.setBounds(576, 211, 199, 25);
		contentPane.add(yearTextF);
		
		programmeTextF = new JTextField();
		programmeTextF.setColumns(10);
		programmeTextF.setBounds(576, 304, 199, 25);
		contentPane.add(programmeTextF);
		
		subGroupNoTextF = new JTextField();
		subGroupNoTextF.setColumns(10);
		subGroupNoTextF.setBounds(576, 395, 199, 25);
		contentPane.add(subGroupNoTextF);
		
		groupNoTextF = new JTextField();
		groupNoTextF.setColumns(10);
		groupNoTextF.setBounds(576, 352, 199, 25);
		contentPane.add(groupNoTextF);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				year = yearTextF.getText();
				sem = semesterTextF.getText();
				groupNo = groupNoTextF.getText();
				subGroupNo = subGroupNoTextF.getText();
				programme = programmeTextF.getText();
				
				if(!subGroupNo.isEmpty()) {
					subGroupId = year + "." + sem + "."+ programme + "."+ groupNo + "." + subGroupNo;
				}else {
					subGroupId = "";
				}
				groupId = year + "." + sem + "."+ programme + "."+ groupNo;
				
				updateDataConnection updateDataConnection = new updateDataConnection();
				updateDataConnection.updateStudent(year, sem, programme, groupNo, subGroupNo, groupId, subGroupId,unChangedGroupId,unChangedSubId);
				
				if(!subGroupNo.isEmpty()) {
					JOptionPane.showMessageDialog(frame,
						    "Updated! New ID is " + subGroupId);
				}else {
					JOptionPane.showMessageDialog(frame,
						    "Updated! New ID is " + groupId);
				}
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(new Color(102, 51, 255));
		btnUpdate.setBounds(524, 471, 117, 35);
		contentPane.add(btnUpdate);
		
		subGroupIdTextF = new JTextField();
		subGroupIdTextF.setText("");
		subGroupIdTextF.setColumns(10);
		subGroupIdTextF.setBounds(576, 146, 199, 25);
		contentPane.add(subGroupIdTextF);
		
		groupIdTextF = new JTextField();
		groupIdTextF.setText("");
		groupIdTextF.setColumns(10);
		groupIdTextF.setBounds(576, 107, 199, 25);
		contentPane.add(groupIdTextF);
		
		JButton btnSearchGroup = new JButton("Search");
		btnSearchGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				groupNo = groupIdTextF.getText().toString();
				
				updateDataConnection updateDataConnection = new updateDataConnection();
				ResultSet rs = updateDataConnection.getStudentsByGroupId(groupNo);
				
				try {
					
					if(!rs.isBeforeFirst()) {
						JOptionPane.showMessageDialog(frame,
							    "No Data Found !");
						yearTextF.setText("");
						semesterTextF.setText("");
						programmeTextF.setText("");
						groupNoTextF.setText("");
						subGroupNoTextF.setText("");
						
					}else {
						
						while(rs.next()) {
							yearTextF.setText(rs.getString(2));
							semesterTextF.setText(rs.getString(3));
							programmeTextF.setText(rs.getString(4));
							groupNoTextF.setText(rs.getString(5));
							subGroupNoTextF.setText(rs.getString(6));	
							unChangedGroupId = rs.getString(7);
							unChangedSubId = rs.getString(8);
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
		btnSearchGroup.setForeground(Color.WHITE);
		btnSearchGroup.setBackground(new Color(102, 51, 255));
		btnSearchGroup.setBounds(794, 106, 89, 23);
		contentPane.add(btnSearchGroup);
		
		JButton btnSearchSubGroup = new JButton("Search");
		btnSearchSubGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				subGroupId = subGroupIdTextF.getText().toString();
				
				updateDataConnection updateDataConnection = new updateDataConnection();
				ResultSet rs = updateDataConnection.getStudentsBySubGroupId(subGroupId);
				
				
				try {
					if(!rs.isBeforeFirst()) {
						JOptionPane.showMessageDialog(frame,
							    "No Data Found !");
						yearTextF.setText("");
						semesterTextF.setText("");
						programmeTextF.setText("");
						groupNoTextF.setText("");
						subGroupNoTextF.setText("");	
					}else {
						
						while(rs.next()) {
							System.out.println(rs.getString(3));
							yearTextF.setText(rs.getString(2));
							semesterTextF.setText(rs.getString(3));
							programmeTextF.setText(rs.getString(4));
							groupNoTextF.setText(rs.getString(5));
							subGroupNoTextF.setText(rs.getString(6));	
							unChangedGroupId = rs.getString(7);
							unChangedSubId = rs.getString(8);
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
		btnSearchSubGroup.setForeground(Color.WHITE);
		btnSearchSubGroup.setBackground(new Color(102, 51, 255));
		btnSearchSubGroup.setBounds(794, 145, 89, 23);
		contentPane.add(btnSearchSubGroup);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				groupId = groupIdTextF.getText();
				subGroupId = subGroupIdTextF.getText();
				System.out.println(groupId);
				
				if(groupId.isEmpty() && subGroupId.isEmpty()) {
					JOptionPane.showMessageDialog(frame,
						    "Please Enter Group Id  !");
					groupId = "";
					subGroupId = "";
				}else if(!groupId.isEmpty() && !subGroupId.isEmpty()) {
					JOptionPane.showMessageDialog(frame,
						    "Please Enter either Group ID or Sub Group Id  !");
					groupId = "";
					subGroupId = "";
				}else {
			
				updateDataConnection updateDataConnection = new updateDataConnection();
				
				 int result = JOptionPane.showConfirmDialog(frame,"Sure? You want to Delete?", "Swing Tester",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
			            if(result == JOptionPane.YES_OPTION){
			            	updateDataConnection.deleteStudent(groupId, subGroupId);
			            	JOptionPane.showMessageDialog(frame,
								    "Deleted !");
			            }
				}
					
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(102, 51, 255));
		btnDelete.setBounds(706, 471, 117, 35);
		contentPane.add(btnDelete);
		
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/home.png"));
	}
}
