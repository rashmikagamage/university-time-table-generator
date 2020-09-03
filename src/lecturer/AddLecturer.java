package lecturer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddLecturer extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField empID;
	private JTextField generateRank;
	JLabel lblNewLabel ;
	
	String[] buildingList;
	String depList ;

	JComboBox faculty,center,level,department,building;
	
	String sFaculty ="Computing",sDepartment="CSSE",sCenter ="Malabe",sBuilding="New Building",sLevel ="Professor",sName,sEmpID,sGenerateRank;
	int sLevelNo=1;
	int validate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLecturer frame = new AddLecturer();
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
	public AddLecturer() {
	
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblFaculty = new JLabel("Faculty");
		lblFaculty.setForeground(new Color(25, 25, 112));
		lblFaculty.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFaculty.setBounds(453, 196, 100, 25);
		contentPane.add(lblFaculty);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(25, 25, 112));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(453, 104, 100, 14);
		contentPane.add(lblName);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setForeground(new Color(25, 25, 112));
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeId.setBounds(453, 158, 100, 14);
		contentPane.add(lblEmployeeId);
		
		JLabel lblDept = new JLabel("Department");
		lblDept.setForeground(new Color(25, 25, 112));
		lblDept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDept.setBounds(453, 243, 100, 25);
		contentPane.add(lblDept);
		
		JLabel lblCenter = new JLabel("Center");
		lblCenter.setForeground(new Color(25, 25, 112));
		lblCenter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCenter.setBounds(453, 287, 156, 25);
		contentPane.add(lblCenter);
		
		JLabel lblBuilding = new JLabel("Building");
		lblBuilding.setForeground(new Color(25, 25, 112));
		lblBuilding.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBuilding.setBounds(453, 335, 100, 25);
		contentPane.add(lblBuilding);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setForeground(new Color(25, 25, 112));
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLevel.setBounds(453, 386, 100, 25);
		contentPane.add(lblLevel);
		
		JLabel lblGenerateRank = new JLabel("Generate Rank");
		lblGenerateRank.setForeground(new Color(25, 25, 112));
		lblGenerateRank.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGenerateRank.setBounds(453, 437, 100, 25);
		contentPane.add(lblGenerateRank);
		
		name = new JTextField();
		name.setText("");
		name.setColumns(10);
		name.setBounds(595, 101, 199, 25);
		contentPane.add(name);
		
		empID = new JTextField();
		empID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				

				 String value = empID.getText();
		            int l = value.length();
//		            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
//		            	//empID.setEditable(true);
//		            	lblNewLabel.setText("");
//		            } else {
//		            	//empID.setEditable(false);
//		            	lblNewLabel.setText("* Enter only numeric digits(0-9)");
//		            }
		            System.out.println("characters"+l);
		            
		            
		            char c = ke.getKeyChar();
		            
		            if(Character.isLetter(c))
		            {
		            	lblNewLabel.setText("* Enter only numeric digits(0-9) *");
		            }
		            else {
		            	lblNewLabel.setText("");
		            }
		            
		           
				
				
			}
			
		});
		empID.setText("");
		empID.setColumns(10);
		empID.setBounds(595, 147, 199, 25);
		contentPane.add(empID);
		
		JButton btnGenerateRank = new JButton("Generate");
		btnGenerateRank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				sEmpID = empID.getText().toString();
				

				if(sEmpID.isEmpty()) {
					JOptionPane.showMessageDialog(null,
						    "Please Enter Employee ID");
				}
				else if(sLevel.equals("Professor")) {
					sGenerateRank = "1" + "." + sEmpID;
					sLevelNo = 1;
				}
				else if(sLevel.equals("Assistant Professor")) {
					sGenerateRank = "2" + "." + sEmpID;
					sLevelNo = 2;
				}
				else if(sLevel.equals("Senior Lecturer(HG)")) {
					sGenerateRank = "3" + "." + sEmpID;
					sLevelNo = 3;
				}
				else if(sLevel.equals("Senior Lecturer")) {
					sGenerateRank = "4" + "." + sEmpID;
					sLevelNo = 4;
				}
				else if(sLevel.equals("Lecturer")) {
					sGenerateRank = "5" + "." + sEmpID;
					sLevelNo = 5;
				}
				
				else if(sLevel.equals("Assistant Lecturer")) {
					sGenerateRank = "6" + "." + sEmpID;
					sLevelNo = 6;
				}
				else if(sLevel.equals("Instructor")) {
					sGenerateRank = "7" + "." + sEmpID;
					sLevelNo = 7;
				}
				
				generateRank.setText(sGenerateRank);
				
				System.out.println(sEmpID);
				System.out.println(sLevel);
				
			}
		});
		btnGenerateRank.setForeground(Color.WHITE);
		btnGenerateRank.setBackground(new Color(102, 51, 255));
		btnGenerateRank.setBounds(839, 440, 89, 23);
		contentPane.add(btnGenerateRank);
		
		JButton btnAddLecturer = new JButton("Add");
		btnAddLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sName = name.getText().toString();
				sEmpID = empID.getText().toString();
				sGenerateRank = generateRank.getText().toString();
				

				if(sName.isEmpty() || sEmpID.isEmpty() || sGenerateRank.isEmpty() ) {
					JOptionPane.showMessageDialog(null,
						    "Please Fill all fields and continue");
				
				}
				if(empID.getText().length() > 6 ) {
					JOptionPane.showMessageDialog(null,
						    "Error : Employee Id should contains 6 numbers only");
					//empID.setText("");
					System.out.println(empID.getText().length());
				}
				
				else {
					
					addLecturerDataConnection addLecturer = new addLecturerDataConnection();
					addLecturer.insertLecturer(sName, sEmpID, sFaculty, sDepartment, sCenter, sBuilding, sLevel, sLevelNo, sGenerateRank);
					
					JOptionPane.showMessageDialog(null,
						    "Lecturer Added !");
					
					name.setText("");
					empID.setText("");
					generateRank.setText("");
					faculty.setSelectedItem("Computing");
					department.setSelectedItem("CSSE");
					center.setSelectedItem("Malabe");
					building.setSelectedItem("New building");
					
				}
				
			}
		});
		btnAddLecturer.setForeground(Color.WHITE);
		btnAddLecturer.setBackground(new Color(102, 51, 255));
		btnAddLecturer.setBounds(663, 495, 72, 25);
		contentPane.add(btnAddLecturer);
		
		String[] facList = {"Computing", "Engineering", "Business"};
		 faculty = new JComboBox(facList);
		faculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sFaculty = (String)faculty.getSelectedItem();

				
				if(sFaculty.equals("Computing")) {
					department.removeAllItems();
					department.addItem("CSSE");
					department.addItem("IT");
					department.addItem("CSE");
				}
				if(sFaculty.equals("Engineering")) {
					department.removeAllItems();
					department.addItem("CIVIL ENG");
					department.addItem("MECHANICAL ENG");
					department.addItem("MATERIALS ENG");
				}
				if(sFaculty.equals("Business")) {
					department.removeAllItems();
					department.addItem("BM");
					department.addItem("BA");
					department.addItem("Accounting");
				}
				

				
			}
		});
		faculty.setBounds(595, 200, 197, 25);
		contentPane.add(faculty);
		
		
		String[] depList = {"CSSE","IT","CSE"};
		department = new JComboBox(depList);
		department.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sDepartment = (String)department.getSelectedItem();
				
				System.out.println("dept"+sDepartment);
			}
		});
		department.setBounds(595, 245, 197, 25);
		contentPane.add(department);
		
		String[] centerList = { "Malabe", "Metro", "Matara", "Kandy"};
		 center = new JComboBox(centerList);
		center.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sCenter = (String)center.getSelectedItem();
				
				System.out.println(sCenter);
				
			
				
				
			}
		});
		center.setBounds(595, 289, 197, 25);
		contentPane.add(center);
		
		String[] buildingList = {"New building", "D-block","Engineering" };
		 building = new JComboBox(buildingList);
		building.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sBuilding = (String)building.getSelectedItem();
			}
		});
		building.setBounds(595, 337, 197, 25);
		contentPane.add(building);
		
		String[] levelList = {"Professor","Assistant Professor","Senior Lecturer(HG)","Senior Lecturer","Lecturer",
			"Assistant Lecturer","Instructor"	};
		 level = new JComboBox(levelList);
		level.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sLevel = (String)level.getSelectedItem();
				
			}
		});
		level.setBounds(595, 390, 197, 25);
		contentPane.add(level);
		
		JLabel image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/class1.png"));
		image.setIcon(img);
		image.setBounds(72, 101, 300, 300);
		contentPane.add(image);
		
		generateRank = new JTextField();
		generateRank.setEditable(false);
		generateRank.setColumns(10);
		generateRank.setBounds(595, 439, 199, 25);
		contentPane.add(generateRank);
		
		JLabel lblAddLecturer = new JLabel("ADD LECTURER");
		lblAddLecturer.setForeground(new Color(0, 51, 51));
		lblAddLecturer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAddLecturer.setBounds(385, 23, 206, 59);
		contentPane.add(lblAddLecturer);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setBounds(595, 175, 199, 14);
		contentPane.add(lblNewLabel);

	}
}
