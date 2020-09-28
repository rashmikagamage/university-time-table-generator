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
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class EditAndDeleteTimeslots extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField SearchEmpTextF;
	private JRadioButton rdbtnWeekday, rdbtnWeekend;
		
	
	
	String wdType;
	String wType;
	Boolean mon,tue,wed,thu,fri,sat,sun;
	Integer wNoDays;
	Integer startHour,startMinute,endHour,endMinute,workHours,workMinutes;
	
	JFrame frame = new JFrame("Swing Tester");
	JComboBox wdTypeCB;
	JTextField wdWorkTimeF;
	Integer  empId;
	private JLabel lblNoDays;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JLabel label;
	private JSpinner spinner_2;
	private JSpinner spinner_3;
	private JLabel lblHours;
	private JLabel lblMinutes;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblWorkHours;
	private JLabel lblWorkMinutes;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnCalculat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditAndDeleteTimeslots frame = new EditAndDeleteTimeslots();
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
	public EditAndDeleteTimeslots() {

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
				addDataEditAndDeleteTimeSlots viewWDH = new addDataEditAndDeleteTimeSlots();
				rs = viewWDH.viewSaved();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
			}
		});
		btnView.setForeground(Color.WHITE);
		btnView.setBackground(new Color(102, 51, 255));
		btnView.setBounds(529, 164, 89, 25);
		contentPane.add(btnView);
		
		JLabel wdhID = new JLabel("Slot ID");
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
				
				startHour = (Integer)spinner.getValue();
				startMinute= (Integer)spinner_1.getValue();
				endHour= (Integer)spinner_2.getValue();
				endMinute=(Integer)spinner_3.getValue();
				workHours= endHour - startHour;
				workMinutes= endMinute - startMinute;
				
				
				
				 
				if(Integer.toString(empId).isEmpty()) {
						JOptionPane.showMessageDialog(frame,
							    "Please Add Relevant ID update !");
				}
				else  {
						 
						addDataEditAndDeleteTimeSlots viewAllConnection = new addDataEditAndDeleteTimeSlots();
						
						viewAllConnection.updateTimeslot(wdType,startHour,startMinute,endHour,endMinute,workHours,workMinutes,empId);
						
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
					
					addDataEditAndDeleteTimeSlots viewLecConnection = new addDataEditAndDeleteTimeSlots();
					
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
		
		rdbtnWeekday = new JRadioButton("Weekday");
		rdbtnWeekday.setBounds(406, 243, 87, 22);
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
		
		lblNoDays = new JLabel("Work End Time");
		lblNoDays.setForeground(new Color(25, 25, 112));
		lblNoDays.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNoDays.setBounds(270, 343, 116, 27);
		contentPane.add(lblNoDays);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 24, 1));
		spinner.setBounds(410, 286, 46, 22);
		contentPane.add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 59, 15));
		spinner_1.setBounds(508, 286, 46, 22);
		contentPane.add(spinner_1);
		
		label = new JLabel("Work Start Time");
		label.setForeground(new Color(25, 25, 112));
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(270, 281, 116, 27);
		contentPane.add(label);
		
		spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 24, 1));
		spinner_2.setBounds(410, 343, 46, 25);
		contentPane.add(spinner_2);
		
		spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(0, 0, 59, 15));
		spinner_3.setBounds(508, 343, 46, 25);
		contentPane.add(spinner_3);
		
		lblHours = new JLabel("Hours");
		lblHours.setBounds(410, 272, 46, 14);
		contentPane.add(lblHours);
		
		lblMinutes = new JLabel("Minutes");
		lblMinutes.setBounds(508, 273, 46, 14);
		contentPane.add(lblMinutes);
		
		label_1 = new JLabel("Hours");
		label_1.setBounds(410, 331, 46, 14);
		contentPane.add(label_1);
		
		label_2 = new JLabel("Minutes");
		label_2.setBounds(508, 331, 46, 14);
		contentPane.add(label_2);
		
		lblWorkHours = new JLabel("Work Hours");
		lblWorkHours.setForeground(new Color(25, 25, 112));
		lblWorkHours.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWorkHours.setBounds(270, 392, 116, 27);
		contentPane.add(lblWorkHours);
		
		lblWorkMinutes = new JLabel("Work Minutes");
		lblWorkMinutes.setForeground(new Color(25, 25, 112));
		lblWorkMinutes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWorkMinutes.setBounds(270, 433, 116, 27);
		contentPane.add(lblWorkMinutes);
		
		textField = new JTextField();
		textField.setBounds(396, 392, 199, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(396, 435, 199, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnCalculat = new JButton("Calculate");
		btnCalculat.setBounds(651, 303, 89, 23);
		contentPane.add(btnCalculat);
		
		
		
	}
}