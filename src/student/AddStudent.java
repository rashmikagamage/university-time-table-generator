package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudent extends JFrame {

	private JPanel contentPane;
	private JTextField groupNo;
	private JTextField programme;
	private JTextField generatedGroupId;
	private JTextField generatedSubGroupId;
	private JTextField subGroup;
	static AddStudent frame;
	//JFrame frame = new JFrame("Swing Tester");
	
	String sYear ="Y1",sSem="S2",sProgramme,sGroup,sSubGroup,sGroupId,sSubGroupId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AddStudent();
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
	/**
	 * 
	 */
	public AddStudent() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYear = new JLabel("Programme");
		lblYear.setForeground(new Color(25, 25, 112));
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYear.setBounds(453, 196, 100, 25);
		contentPane.add(lblYear);
		
		JLabel label = new JLabel("Year");
		label.setForeground(new Color(25, 25, 112));
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(453, 119, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Semester");
		label_1.setForeground(new Color(25, 25, 112));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(453, 158, 100, 14);
		contentPane.add(label_1);
		
		JLabel lblGroupId = new JLabel("Generate Group ID");
		lblGroupId.setForeground(new Color(25, 25, 112));
		lblGroupId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGroupId.setBounds(453, 287, 156, 25);
		contentPane.add(lblGroupId);
		
		JLabel lblGroupNo = new JLabel("Group No");
		lblGroupNo.setForeground(new Color(25, 25, 112));
		lblGroupNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGroupNo.setBounds(453, 243, 100, 25);
		contentPane.add(lblGroupNo);
		
		JLabel lblSubGroupId = new JLabel("Sub Group No");
		lblSubGroupId.setForeground(new Color(25, 25, 112));
		lblSubGroupId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSubGroupId.setBounds(453, 335, 100, 25);
		contentPane.add(lblSubGroupId);
		
		JLabel lblGenerateSubGroup = new JLabel("Generate Sub Group ID");
		lblGenerateSubGroup.setForeground(new Color(25, 25, 112));
		lblGenerateSubGroup.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGenerateSubGroup.setBounds(453, 382, 156, 25);
		contentPane.add(lblGenerateSubGroup);
		
		JLabel lblStudent = new JLabel("ADD STUDENT");
		lblStudent.setForeground(new Color(0, 51, 51));
		lblStudent.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblStudent.setBounds(403, 11, 206, 59);
		contentPane.add(lblStudent);
		
		JLabel image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/class1.png"));
		image.setIcon(img);
		image.setBounds(103, 119, 300, 300);
		contentPane.add(image);
		
		groupNo = new JTextField();
		groupNo.setBounds(651, 245, 199, 25);
		contentPane.add(groupNo);
		groupNo.setColumns(10);
		
		programme = new JTextField();
		programme.setText("");
		programme.setColumns(10);
		programme.setBounds(651, 198, 199, 25);
		contentPane.add(programme);
		
		String[] yearList = {"Y1","Y2","Y3","Y4"};
		
		JComboBox year = new JComboBox(yearList);
		year.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			        sYear = (String)year.getSelectedItem();
			      
			}
			
		});
		year.setBounds(651, 111, 197, 25);
		contentPane.add(year);
		
		String[] semList = {"S1","S2"};
		JComboBox semester = new JComboBox(semList);
		semester.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 sSem = (String)semester.getSelectedItem();
			}
			
			
		});
		semester.setBounds(651, 155, 197, 25);
		contentPane.add(semester);
		
		generatedGroupId = new JTextField();
		generatedGroupId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		generatedGroupId.setEditable(false);
		generatedGroupId.setColumns(10);
		generatedGroupId.setBounds(651, 291, 199, 25);
		contentPane.add(generatedGroupId);
		
		generatedSubGroupId = new JTextField();
		generatedSubGroupId.setEditable(false);
		generatedSubGroupId.setColumns(10);
		generatedSubGroupId.setBounds(651, 382, 199, 25);
		contentPane.add(generatedSubGroupId);
		
		subGroup = new JTextField();
		subGroup.setColumns(10);
		subGroup.setBounds(651, 339, 199, 25);
		contentPane.add(subGroup);
		
		JButton btnGenerateGroupId = new JButton("Generate");
		btnGenerateGroupId.setForeground(new Color(255, 255, 255));
		btnGenerateGroupId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				sGroup = groupNo.getText().toString();
				sSubGroup = subGroup.getText().toString();
				sProgramme = programme.getText().toString();
				
				if(sGroup.isEmpty()) {
					JOptionPane.showMessageDialog(null,
						    "Please Enter Group");
				}else if(sProgramme.isEmpty()){
					JOptionPane.showMessageDialog(null,
						    "Please Enter Programme");
				}else {
				
				sGroupId = sYear + "." + sSem + "."+ sProgramme + "."+ sGroup;
				generatedGroupId.setText(sGroupId);
				
				}
			}
		});
		btnGenerateGroupId.setBackground(new Color(102, 51, 255));
		btnGenerateGroupId.setBounds(869, 292, 89, 23);
		contentPane.add(btnGenerateGroupId);
		
		JButton btnGenerateSubGroupId = new JButton("Generate");
		btnGenerateSubGroupId.setForeground(new Color(255, 255, 255));
		btnGenerateSubGroupId.setBackground(new Color(102, 51, 255));
		btnGenerateSubGroupId.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				sGroup = groupNo.getText().toString();
				sSubGroup = subGroup.getText().toString();
				sProgramme = programme.getText().toString();
				
				if(sGroup.isEmpty()) {
					JOptionPane.showMessageDialog(null,
						    "Please Enter Group");
				}else if(sSubGroup.isEmpty()) {
					JOptionPane.showMessageDialog(null,
						    "Please Enter Sub Group");
				}else if(sProgramme.isEmpty()){
					JOptionPane.showMessageDialog(null,
						    "Please Enter Programme");
				}else {
					sSubGroupId = sYear + "." + sSem + "."+ sProgramme + "."+ sGroup + "." + sSubGroup;
					generatedSubGroupId.setText(sSubGroupId);
				}
				
				
				
			}
		});
		btnGenerateSubGroupId.setBounds(869, 385, 89, 23);
		contentPane.add(btnGenerateSubGroupId);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(102, 51, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sGroup = groupNo.getText().toString();
				sSubGroup = subGroup.getText().toString();
				sProgramme = programme.getText().toString();
				
				if(sGroup.isEmpty()) {
					JOptionPane.showMessageDialog(null,
						    "Please Enter Group");
				}else if(sProgramme.isEmpty()){
					JOptionPane.showMessageDialog(null,
						    "Please Enter Programme");
				}else {
					
					addDataConnection addDataConnection = new addDataConnection();
					addDataConnection.insertStudent(sYear, sSem, sGroup, sSubGroup, sProgramme,sGroupId,sSubGroupId);
					
					JOptionPane.showMessageDialog(null,
						    "Group Added !");
					
					groupNo.setText("");
					programme.setText("");
					subGroup.setText("");
					generatedSubGroupId.setText("");
					groupNo.setText("");
					generatedGroupId.setText("");
					
				}
					
			}
		});
		btnAdd.setBounds(723, 436, 72, 25);
		contentPane.add(btnAdd);
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/home.png"));
		
	}
}
