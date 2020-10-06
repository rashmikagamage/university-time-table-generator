package workingDayAndHours;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import student.StudentHome;
import student.addDataConnection;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class AddTimeSlots extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField endTime;
	private JTable table;
	private JLabel error1, error2;
	
	private JSpinner spinner, spinner_1, spinner_2 , spinner_3;
	
	
	
	String tType;
	Integer tStartHour, tEndHour, tStartMinute, tEndMinute, tWorkHours, tWorkMinutes; 
	Integer startHour, endHour , startMinute, endMinute;
	Integer workHours, workMinutes;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTimeSlots frame = new AddTimeSlots();
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
	public AddTimeSlots() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] slotTypeList = {"30 min","1 Hour"};
		
		JComboBox slotType = new JComboBox(slotTypeList);
		slotType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			        tType = (String)slotType.getSelectedItem();
			      
			}
			
		});
		
		slotType.setBounds(564, 88, 197, 25);
		contentPane.add(slotType);
		
		JLabel lblTimeSlot = new JLabel("Time Slot Type");
		lblTimeSlot.setForeground(new Color(25, 25, 112));
		lblTimeSlot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTimeSlot.setBounds(407, 91, 113, 22);
		contentPane.add(lblTimeSlot);
		
		JLabel lblStartTime = new JLabel("Work Start Time");
		lblStartTime.setForeground(new Color(25, 25, 112));
		lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStartTime.setBounds(407, 168, 121, 14);
		contentPane.add(lblStartTime);
		
		JLabel label = new JLabel("");
		label.setBounds(482, 260, 46, 14);
		contentPane.add(label);
		
		JLabel lblEndTime = new JLabel("Work End Time");
		lblEndTime.setForeground(new Color(25, 25, 112));
		lblEndTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEndTime.setBounds(407, 237, 121, 14);
		contentPane.add(lblEndTime);
		
		String[] daysList = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		
		JLabel lblAddTimeSlots = new JLabel("Add Time Slots");
		lblAddTimeSlots.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAddTimeSlots.setBounds(387, 23, 178, 39);
		contentPane.add(lblAddTimeSlots);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(102, 51, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField_1.setText(""+workHours);
				textField_2.setText(""+workMinutes);
				
				tType = slotType.getSelectedItem().toString();
				
				tStartHour = (Integer)spinner.getValue();
				tStartMinute = (Integer)spinner_1.getValue();		
				tEndHour = (Integer)spinner_2.getValue();
				tEndMinute = (Integer)spinner_3.getValue();
				tWorkHours = tEndHour - tStartHour;
				tWorkMinutes = tEndMinute - tStartMinute;
				
				
			/*	if(tType.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please select type");
				}
				
				else if(tStart.isEmpty()) {
					JOptionPane.showMessageDialog(null,
						    "Please add Start Time");
				}else if(tEnd.isEmpty()){
					JOptionPane.showMessageDialog(null,
						    "Please add End Time");
					
					
				}
				else if(tDay.isEmpty()) {
					
					JOptionPane.showMessageDialog(null,
						    "Please select Day");
					
				}
				else 
					
					if(Integer.parseInt(tStart) >=2400|| Integer.parseInt(tEnd) >=2400) {
						JOptionPane.showMessageDialog(null,
							    "Enter a value between 0hrs and 24hrs");
				}
				
				else */ {
					
					addDataAddTimeSlots addDataConnection = new addDataAddTimeSlots();
					addDataConnection.insertTimeSlots(tType,tStartHour,tStartMinute,tEndHour,tEndMinute,tWorkHours,tWorkMinutes);
					
					JOptionPane.showMessageDialog(null,
						    "Slot Added !");
					
					//slotType.setToolTipText("");
					//startTime.setText("");
					//endTime.setText("");
					//workingDays.setToolTipText("");
					
					
				}
					
			}
		});
		
		btnAdd.setBounds(531, 444, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Navigation s = new Navigation();
				s.setVisible(true);
				
			}
		});
		btnBack.setBounds(43, 23, 89, 23);
		contentPane.add(btnBack);
		
		
		
		JLabel image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/clockk.jpg"));
		image.setIcon(img);
		image.setBounds(91, 88, 263, 335);
		contentPane.add(image);
		
		error1 = new JLabel("");
		error1.setForeground(Color.RED);
		error1.setBounds(574, 201, 187, 14);
		contentPane.add(error1);
		
		 error2 = new JLabel("");
		error2.setForeground(Color.RED);
		error2.setBounds(571, 274, 190, 14);
		contentPane.add(error2);
		
		JLabel lblWorkingHours = new JLabel("Working Hours");
		lblWorkingHours.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWorkingHours.setBounds(407, 297, 113, 25);
		contentPane.add(lblWorkingHours);
		
		textField_1 = new JTextField();
		textField_1.setBounds(564, 299, 197, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(8, 8, 21, 1));
		spinner.setBounds(574, 167, 61, 20);
		contentPane.add(spinner);
		
		startHour = (Integer)spinner.getValue();
		
		 spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 30, 30));
		spinner_1.setBounds(698, 167, 63, 20);
		contentPane.add(spinner_1);
		
		startMinute = (Integer)spinner_1.getValue();
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setBounds(574, 153, 46, 14);
		contentPane.add(lblHours);
		
		
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setBounds(698, 153, 46, 14);
		contentPane.add(lblMinutes);
		
		 spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(8, 8, 21, 1));
		spinner_2.setBounds(574, 236, 61, 20);
		contentPane.add(spinner_2);
		
		endHour = (Integer)spinner_2.getValue();
		
		 spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(0, 0, 30, 30));
		spinner_3.setBounds(698, 236, 63, 20);
		contentPane.add(spinner_3);
		
		endMinute = (Integer)spinner_3.getValue();
		
		//System.out.println(endMinute);
		
	
		
		JLabel lblHours_1 = new JLabel("Hours");
		lblHours_1.setBounds(574, 222, 46, 14);
		contentPane.add(lblHours_1);
		
		JLabel lblMinutes_1 = new JLabel("Minutes");
		lblMinutes_1.setBounds(698, 222, 46, 14);
		contentPane.add(lblMinutes_1);
		
		JLabel lblWorkingMinutes = new JLabel("Working Minutes");
		lblWorkingMinutes.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWorkingMinutes.setBounds(407, 354, 140, 25);
		contentPane.add(lblWorkingMinutes);
		
		textField_2 = new JTextField();
		textField_2.setBounds(564, 354, 197, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		/*JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(807, 201, 89, 23);
		contentPane.add(btnCalculate);
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				
				textField_1.setText("" +workHours);
				
				textField_2.setText("" +workMinutes);
			}
		});*/
		
		workHours = (Integer)spinner.getValue() - (Integer)spinner_2.getValue();
		workMinutes = (Integer)spinner_1.getValue() - (Integer)spinner_3.getValue();
		
	}
}
