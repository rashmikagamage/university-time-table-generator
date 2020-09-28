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
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class ViewAll extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField SearchEmpTextF;
	private JCheckBox chckbxMonday,chckbxTuesday,chckbxWednesday,chckbxThursday,chckbxFriday,chckbxSaturday,chckbxSunday;
	private JRadioButton rdbtnWeekday, rdbtnWeekend;
	private JComboBox cbweekDays;
		
	
	
	String wdType,wdTime;
	String wType;
	Boolean mon,tue,wed,thu,fri,sat,sun;
	Integer wNoDays;
	
	JFrame frame = new JFrame("Swing Tester");
	JComboBox wdTypeCB;
	JTextField wdWorkTimeF;
	Integer  empId;
	private JLabel lblDays;
	private JLabel lblNoDays;

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
		scrollPane.setBounds(169, 42, 805, 100);
		contentPane.add(scrollPane);

		
		
		table = new JTable();
		table.setFont(new Font("Consolas", Font.PLAIN, 12));
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setBackground(new Color(255, 250, 250));
		scrollPane.setViewportView(table);
		
		JButton btnView = new JButton("Show");
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
		btnView.setBounds(529, 164, 89, 25);
		contentPane.add(btnView);
		
		JLabel wdhID = new JLabel("Working Day ID");
		wdhID.setForeground(new Color(25, 25, 112));
		wdhID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		wdhID.setBounds(270, 210, 116, 22);
		contentPane.add(wdhID);
		
		JTextField SearchwdhIDTextF = new JTextField();
		SearchwdhIDTextF.setText("");
		SearchwdhIDTextF.setColumns(10);
		SearchwdhIDTextF.setBounds(396, 211, 199, 25);
		contentPane.add(SearchwdhIDTextF);
		
	
		
		
		
		JLabel lblCenter = new JLabel("Type");
		lblCenter.setForeground(new Color(25, 25, 112));
		lblCenter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCenter.setBounds(270, 243, 57, 27);
		contentPane.add(lblCenter);
		
		
		
		
	
		
		JButton btnUpdateLec = new JButton("Update");
		btnUpdateLec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//String sGenerateRank;
				// name,unChangedEmpId,Faculty,Level,Building,Department,Center
				
				empId = Integer.parseInt(SearchwdhIDTextF.getText().toString());
				
				wdType = wType;
				
				wNoDays = Integer.parseInt(cbweekDays.getSelectedItem().toString());
				
				
				mon = chckbxMonday.isSelected();
				tue = chckbxTuesday.isSelected();
				wed = chckbxWednesday.isSelected();
				thu = chckbxThursday.isSelected();
				fri = chckbxFriday.isSelected();
				sat = chckbxSaturday.isSelected();
				sun = chckbxSunday.isSelected();
				
				
				 
				if(Integer.toString(empId).isEmpty()) {
						JOptionPane.showMessageDialog(frame,
							    "Please Add Relevant ID update !");
				}
				else  {
						 
						addDataViewAll viewAllConnection = new addDataViewAll();
						viewAllConnection.updateWDH(empId,wdType,wNoDays,mon,tue,wed,thu,fri,sat,sun);
						
						JOptionPane.showMessageDialog(frame,
							    "Updated !");
						
						
						
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
						    "Please Enter Id  !");
					
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
		
		Integer[] dayList = {0,1,2,3,4,5};
		
		 cbweekDays = new JComboBox(dayList);
		
		cbweekDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			        wNoDays = (Integer)cbweekDays.getSelectedItem();
			        
			      
			}
			
		});
		
		cbweekDays.setBounds(396, 284, 67, 25);
		contentPane.add(cbweekDays);
		
		chckbxMonday = new JCheckBox("Monday");
		chckbxMonday.setBounds(392, 328, 97, 23);
		contentPane.add(chckbxMonday);
		
		 chckbxTuesday = new JCheckBox("Tuesday");
		chckbxTuesday.setBounds(392, 354, 97, 23);
		contentPane.add(chckbxTuesday);
		
		 chckbxWednesday = new JCheckBox("Wednesday");
		chckbxWednesday.setBounds(392, 380, 97, 23);
		contentPane.add(chckbxWednesday);
		
		 chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.setBounds(392, 406, 97, 23);
		contentPane.add(chckbxThursday);
		
		chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.setBounds(392, 432, 97, 23);
		contentPane.add(chckbxFriday);
		
		chckbxSaturday = new JCheckBox("Saturday");
		chckbxSaturday.setBounds(508, 328, 97, 23);
		contentPane.add(chckbxSaturday);
		
		chckbxSunday = new JCheckBox("Sunday");
		chckbxSunday.setBounds(508, 354, 97, 23);
		contentPane.add(chckbxSunday);
		
		rdbtnWeekday = new JRadioButton("Weekday");
		rdbtnWeekday.setBounds(392, 243, 87, 22);
		contentPane.add(rdbtnWeekday);
		rdbtnWeekday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
		if(rdbtnWeekday.isSelected()) {
			wType = "Weekday";
		}
			}
		});
		
		rdbtnWeekend = new JRadioButton("Weekend");
		rdbtnWeekend.setBounds(508, 243, 109, 23);
		contentPane.add(rdbtnWeekend);
		
		rdbtnWeekend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
		
		if(rdbtnWeekend.isSelected()) {
			wdType = "Weekend";
		}
			}
		});
		
		ButtonGroup bgWorktype = new ButtonGroup();
		bgWorktype.add(rdbtnWeekday);
		bgWorktype.add(rdbtnWeekend);
		
		lblDays = new JLabel("Days");
		lblDays.setForeground(new Color(25, 25, 112));
		lblDays.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDays.setBounds(270, 324, 57, 27);
		contentPane.add(lblDays);
		
		lblNoDays = new JLabel("No. Days");
		lblNoDays.setForeground(new Color(25, 25, 112));
		lblNoDays.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNoDays.setBounds(270, 281, 67, 27);
		contentPane.add(lblNoDays);
		
		
		
	}
}