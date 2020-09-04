package workingDayAndHours;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import student.StudentHome;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
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
import javax.swing.DefaultComboBoxModel;

public class ViewAll extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField SearchEmpTextF;
	
	
	
	String wdType,wdTime;
	JFrame frame = new JFrame("Swing Tester");
	JComboBox wdNoDaysCB,wdTypeCB;
	JTextField wdWorkTimeF;
	Integer noDays, empId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAll frame = new ViewAll();
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
	public ViewAll() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(169, 42, 805, 176);
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
				addDataViewAll viewWDH = new addDataViewAll();
				rs = viewWDH.viewSaved();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
			}
		});
		btnView.setForeground(Color.WHITE);
		btnView.setBackground(new Color(102, 51, 255));
		btnView.setBounds(444, 229, 89, 25);
		contentPane.add(btnView);
		
		JLabel wdhID = new JLabel("Working Day ID");
		wdhID.setForeground(new Color(25, 25, 112));
		wdhID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		wdhID.setBounds(270, 264, 116, 22);
		contentPane.add(wdhID);
		
		JTextField SearchwdhIDTextF = new JTextField();
		SearchwdhIDTextF.setText("");
		SearchwdhIDTextF.setColumns(10);
		SearchwdhIDTextF.setBounds(396, 265, 199, 25);
		contentPane.add(SearchwdhIDTextF);
		
		JButton btnSearchwdhId = new JButton("Search");
		btnSearchwdhId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				empId = Integer.parseInt(SearchwdhIDTextF.getText().toString());
				
				addDataViewAll viewLecConnection = new addDataViewAll();
				ResultSet rs = viewLecConnection.getDaysById(empId);
				

				try {
					
					if(!rs.isBeforeFirst()) {
						JOptionPane.showMessageDialog(frame,
							    "No Data Found !");
						SearchwdhIDTextF.setText("");
						
						
						
					}else {
						
						while(rs.next()) {
							
							wdTypeCB.setSelectedItem(rs.getString(1));
							wdNoDaysCB.setSelectedItem(rs.getString(2));
							
							wdWorkTimeF.setText(rs.getString(3));
							
						}
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
				
				
			}
		});
		btnSearchwdhId.setForeground(Color.WHITE);
		btnSearchwdhId.setBackground(new Color(102, 51, 255));
		btnSearchwdhId.setBounds(631, 266, 89, 23);
		contentPane.add(btnSearchwdhId);
		
		JTextField wdWorkTimeF = new JTextField();
		wdWorkTimeF.setText("");
		wdWorkTimeF.setColumns(10);
		wdWorkTimeF.setBounds(396, 425, 199, 25);
		contentPane.add(wdWorkTimeF);
		
		JLabel workTime = new JLabel("Work Time");
		workTime.setForeground(new Color(25, 25, 112));
		workTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		workTime.setBounds(296, 428, 100, 14);
		contentPane.add(workTime);
		
		JLabel noOfDays = new JLabel("No. of Days");
		noOfDays.setForeground(new Color(25, 25, 112));
		noOfDays.setFont(new Font("Tahoma", Font.PLAIN, 15));
		noOfDays.setBounds(296, 370, 100, 25);
		contentPane.add(noOfDays);
		
		Integer[] dayList = {1,2,3,4,5};
		wdNoDaysCB = new JComboBox(dayList);
		wdNoDaysCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		wdNoDaysCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				noDays = (Integer)wdNoDaysCB.getSelectedItem();
			}
		});
		//faculty.setSelectedItem("Business");
		wdNoDaysCB.setBounds(396, 372, 197, 25);
		contentPane.add(wdNoDaysCB);
		
		
		
		JLabel lblCenter = new JLabel("Type");
		lblCenter.setForeground(new Color(25, 25, 112));
		lblCenter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCenter.setBounds(297, 314, 89, 25);
		contentPane.add(lblCenter);
		
		String[] centerList = { "Weekday", "Weekend"};
		JComboBox center = new JComboBox(centerList);
		center.setModel(new DefaultComboBoxModel(new String[] {"Weekday", "Weekend"}));
		center.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				wdType = (String)center.getSelectedItem();
				
			}
		});
		center.setBounds(398, 314, 197, 25);
		contentPane.add(center);
		
		String[] buildingList = {"New building", "D-block" };
		
		JButton btnUpdateLec = new JButton("Update");
		btnUpdateLec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//String sGenerateRank;
				// name,unChangedEmpId,Faculty,Level,Building,Department,Center
				
				wdType = center.getSelectedItem().toString();
				wdTime = wdWorkTimeF.getText().toString();
				noDays = Integer.parseInt(wdNoDaysCB.getSelectedItem().toString());
				empId = Integer.parseInt(SearchwdhIDTextF.getText().toString());
				 
				if(empId.equals("")) {
						JOptionPane.showMessageDialog(frame,
							    "Please Search Emp and update !");
				}
				else  {
						 
						addDataViewAll viewLecConnection = new addDataViewAll();
						viewLecConnection.updateWDH(wdType,noDays,wdTime);
						
						JOptionPane.showMessageDialog(frame,
							    "Updated !");
						
						SearchwdhIDTextF.setText("");
						
						wdWorkTimeF.setText("");
						
						wdNoDaysCB.setSelectedItem(1);
						
						center.setSelectedItem("Weekday");
						
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
				
				empId = Integer.parseInt(SearchwdhIDTextF.getText().toString());
				
				if(Integer.toString(empId).isEmpty()) {
					JOptionPane.showMessageDialog(frame,
						    "Please Id  !");
					
				}
				else {
					
					addDataViewAll viewLecConnection = new addDataViewAll();
					
					 int result = JOptionPane.showConfirmDialog(frame,"Sure? You want to Delete?", "Swing Tester",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
				            if(result == JOptionPane.YES_OPTION){
				            	viewLecConnection.deleteWDH(empId);
				            	JOptionPane.showMessageDialog(frame,
									    "Deleted !");
				            	
				            	SearchwdhIDTextF.setText("");
								
								wdWorkTimeF.setText("");
								
								wdNoDaysCB.setSelectedItem(1);
								
								center.setSelectedItem("Weekday");
								
				            	
				         }
					
				}
				
				
			}
		});
		btnDeleteLec.setForeground(Color.WHITE);
		btnDeleteLec.setBackground(new Color(102, 51, 255));
		btnDeleteLec.setBounds(536, 490, 117, 35);
		contentPane.add(btnDeleteLec);
		
		
		JLabel lblViewLecturers = new JLabel("View All");
		lblViewLecturers.setForeground(new Color(0, 51, 51));
		lblViewLecturers.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblViewLecturers.setBounds(535, 0, 100, 45);
		contentPane.add(lblViewLecturers);
		ImageIcon img = new ImageIcon(this.getClass().getResource(""));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Navigation s = new Navigation();
				s.setVisible(true);
				
			}
		});
		btnBack.setBounds(24, 54, 89, 23);
		contentPane.add(btnBack);
		
	}
}