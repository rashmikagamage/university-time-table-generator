package lecturer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ViewLecturer extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField SearchEmpTextF;
	private JTextField nameTextF;
	private JTextField empIdTextF;
	
	
	String empId,name,unChangedEmpId,Faculty,Level,Building,Department,Center,sGenerateRank;
	JFrame frame = new JFrame("Swing Tester");
	JComboBox faculty,level,building,department,center;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLecturer frame = new ViewLecturer();
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
	public ViewLecturer() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(98, 11, 805, 176);
		contentPane.add(scrollPane);

		
		
		table = new JTable();
		table.setFont(new Font("Consolas", Font.PLAIN, 12));
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setBackground(new Color(255, 250, 250));
		scrollPane.setViewportView(table);
		
		JButton btnView = new JButton("View All");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ResultSet rs = null;
				viewLecturerConnection viewLecConnection = new viewLecturerConnection();
				rs = viewLecConnection.viewLecturer();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
			}
		});
		btnView.setForeground(Color.WHITE);
		btnView.setBackground(new Color(102, 51, 255));
		btnView.setBounds(441, 198, 89, 25);
		contentPane.add(btnView);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setForeground(new Color(25, 25, 112));
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeId.setBounds(269, 253, 100, 14);
		contentPane.add(lblEmployeeId);
		
		SearchEmpTextF = new JTextField();
		SearchEmpTextF.setText("");
		SearchEmpTextF.setColumns(10);
		SearchEmpTextF.setBounds(394, 250, 199, 25);
		contentPane.add(SearchEmpTextF);
		
		JButton btnSearchEmpId = new JButton("Search");
		btnSearchEmpId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				empId = SearchEmpTextF.getText().toString();
				
				viewLecturerConnection viewLecConnection = new viewLecturerConnection();
				ResultSet rs = viewLecConnection.getLecturersByEmpId(empId);
				

				try {
					
					if(!rs.isBeforeFirst()) {
						JOptionPane.showMessageDialog(frame,
							    "No Data Found !");
						empIdTextF.setText("");
						nameTextF.setText("");
						
						
					}else {
						
						while(rs.next()) {
							nameTextF.setText(rs.getString(1));
							empIdTextF.setText(rs.getString(2));
							faculty.setSelectedItem(rs.getString(3));
							department.setSelectedItem(rs.getString(4));
							center.setSelectedItem(rs.getString(5));
							building.setSelectedItem(rs.getString(6));
							level.setSelectedItem(rs.getString(7));
							
							
						}
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
				
				
			}
		});
		btnSearchEmpId.setForeground(Color.WHITE);
		btnSearchEmpId.setBackground(new Color(102, 51, 255));
		btnSearchEmpId.setBounds(638, 251, 89, 23);
		contentPane.add(btnSearchEmpId);
		
		nameTextF = new JTextField();
		nameTextF.setText("");
		nameTextF.setColumns(10);
		nameTextF.setBounds(98, 312, 199, 25);
		contentPane.add(nameTextF);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(25, 25, 112));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(24, 315, 100, 14);
		contentPane.add(lblName);
		
		empIdTextF = new JTextField();
		empIdTextF.setText("");
		empIdTextF.setColumns(10);
		empIdTextF.setBounds(476, 312, 199, 25);
		contentPane.add(empIdTextF);
		
		JLabel lblEmployeeId_1 = new JLabel("Employee ID");
		lblEmployeeId_1.setForeground(new Color(25, 25, 112));
		lblEmployeeId_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeId_1.setBounds(349, 315, 100, 14);
		contentPane.add(lblEmployeeId_1);
		
		JLabel lblFaculty = new JLabel("Faculty");
		lblFaculty.setForeground(new Color(25, 25, 112));
		lblFaculty.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFaculty.setBounds(700, 310, 100, 25);
		contentPane.add(lblFaculty);
		
		String[] facList = {"Computing", "Engineering", "Business", "Humanities & Sciences"};
		faculty = new JComboBox(facList);
		faculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Faculty = (String)faculty.getSelectedItem();
			}
		});
		//faculty.setSelectedItem("Business");
		faculty.setBounds(777, 312, 197, 25);
		contentPane.add(faculty);
		
		JLabel lblDept = new JLabel("Department");
		lblDept.setForeground(new Color(25, 25, 112));
		lblDept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDept.setBounds(10, 370, 100, 25);
		contentPane.add(lblDept);
		
		String[] depList = {"CSSE","SE"};
		department = new JComboBox(depList);
		department.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Department = (String)department.getSelectedItem();
				
			}
		});
		department.setBounds(100, 370, 197, 25);
		contentPane.add(department);
		
		JLabel lblCenter = new JLabel("Center");
		lblCenter.setForeground(new Color(25, 25, 112));
		lblCenter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCenter.setBounds(349, 370, 156, 25);
		contentPane.add(lblCenter);
		
		String[] centerList = { "Malabe", "Metro", "Matara", "Kandy", "Kurunagala","Jaffna"};
		center = new JComboBox(centerList);
		center.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Center = (String)center.getSelectedItem();
				
			}
		});
		center.setBounds(476, 372, 197, 25);
		contentPane.add(center);
		
		JLabel lblBuilding = new JLabel("Building");
		lblBuilding.setForeground(new Color(25, 25, 112));
		lblBuilding.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBuilding.setBounds(700, 370, 100, 25);
		contentPane.add(lblBuilding);
		
		String[] buildingList = {"New building", "D-block" };
		building = new JComboBox(buildingList);
		building.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Building = (String)building.getSelectedItem();
				
			}
		});
		building.setBounds(777, 372, 197, 25);
		contentPane.add(building);
		
		JButton btnUpdateLec = new JButton("Update");
		btnUpdateLec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//String sGenerateRank;
				// name,unChangedEmpId,Faculty,Level,Building,Department,Center
				
				name = nameTextF.getText().toString();
				unChangedEmpId = empIdTextF.getText().toString();
				empId = SearchEmpTextF.getText().toString();
				 
				if(empId.equals("")) {
						JOptionPane.showMessageDialog(frame,
							    "Please Search Emp and update !");
				}
				else {
					if(Level.equals("Professor")) {
						sGenerateRank = "1" + "." + unChangedEmpId;
					}
					else if(Level.equals("Assistant Professor")) {
						sGenerateRank = "2" + "." + unChangedEmpId;
					}
					else if(Level.equals("Senior Lecturer(HG)")) {
						sGenerateRank = "3" + "." + unChangedEmpId;
					}
					else if(Level.equals("Senior Lecturer")) {
						sGenerateRank = "4" + "." + unChangedEmpId;
					}
					else if(Level.equals("Lecturer")) {
						sGenerateRank = "5" + "." + unChangedEmpId;
					}
					else if(Level.equals("Assistant Lecturer")) {
						sGenerateRank = "6" + "." + unChangedEmpId;
					}
					else if(Level.equals("Instructor")) {
						sGenerateRank = "7" + "." + unChangedEmpId;
					}
					
					System.out.println(name+unChangedEmpId+sGenerateRank+Level);
					
					if(empId.equals("")) {
						JOptionPane.showMessageDialog(frame,
							    "Please Fill empid !");
					}
					else {
						 
						viewLecturerConnection viewLecConnection = new viewLecturerConnection();
						viewLecConnection.updateLecturer(name, unChangedEmpId, Faculty, Department, Center, Building, Level, sGenerateRank,empId);
						
						JOptionPane.showMessageDialog(frame,
							    "Updated !");
						
						SearchEmpTextF.setText("");
						nameTextF.setText("");
						empIdTextF.setText("");
						
						faculty.setSelectedItem("Computing");
						department.setSelectedItem("CSSE");
						center.setSelectedItem("Malabe");
						building.setSelectedItem("New building");
						level.setSelectedItem("Professor");
					}
					
				}
			
				
			}
		});
		btnUpdateLec.setForeground(Color.WHITE);
		btnUpdateLec.setBackground(new Color(102, 51, 255));
		btnUpdateLec.setBounds(362, 490, 117, 35);
		contentPane.add(btnUpdateLec);
		
		JButton btnDeleteLec = new JButton("Delete");
		btnDeleteLec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				empId = SearchEmpTextF.getText().toString();
				
				if(empId.isEmpty() ) {
					JOptionPane.showMessageDialog(frame,
						    "Please Enter Emp Id  !");
					
				}
				else {
					
					viewLecturerConnection viewLecConnection = new viewLecturerConnection();
					
					 int result = JOptionPane.showConfirmDialog(frame,"Sure? You want to Delete?", "Swing Tester",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
				            if(result == JOptionPane.YES_OPTION){
				            	viewLecConnection.deleteLecturer(empId);
				            	JOptionPane.showMessageDialog(frame,
									    "Deleted !");
				            	
				            	SearchEmpTextF.setText("");
								nameTextF.setText("");
								empIdTextF.setText("");
								
								faculty.setSelectedItem("Computing");
								department.setSelectedItem("CSSE");
								center.setSelectedItem("Malabe");
								building.setSelectedItem("New building");
								level.setSelectedItem("Professor");
				            	
				         }
					
				}
				
				
			}
		});
		btnDeleteLec.setForeground(Color.WHITE);
		btnDeleteLec.setBackground(new Color(102, 51, 255));
		btnDeleteLec.setBounds(536, 490, 117, 35);
		contentPane.add(btnDeleteLec);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setForeground(new Color(25, 25, 112));
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLevel.setBounds(349, 430, 156, 25);
		contentPane.add(lblLevel);
		
		String[] levelList = {"Professor","Assistant Professor","Senior Lecturer(HG)","Senior Lecturer","Lecturer",
				"Assistant Lecturer","Instructor"	};
		level = new JComboBox(levelList);
		level.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Level = (String)level.getSelectedItem();
				
			}
		});
		level.setBounds(478, 432, 197, 25);
		contentPane.add(level);
	}
}
