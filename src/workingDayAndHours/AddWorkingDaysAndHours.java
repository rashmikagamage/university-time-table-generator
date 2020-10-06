package workingDayAndHours;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import student.StudentHome;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JRadioButton;
import java.awt.Panel;
import java.awt.Choice;
import javax.swing.JSeparator;

public class AddWorkingDaysAndHours extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	private JCheckBox chckbxMonday, chckbxTuesday,chckbxWednesday,chckbxThursday, chckbxFriday, chckbxSaturday, chckbxSunday ;
	
	String wType , wTypeWD, wDays;
	Integer wNo;
	Boolean monday, tuesday, wednesday, thursday, friday, saturday, sunday;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddWorkingDaysAndHours frame = new AddWorkingDaysAndHours();
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
	public AddWorkingDaysAndHours() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		JPanel contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblType = new JLabel("Working Days");
		lblType.setForeground(new Color(25, 25, 112));
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblType.setBounds(450, 134, 94, 25);
		contentPane.add(lblType);
		
		Integer[] dayList = {0,1,2,3,4,5};
		
		JComboBox cbweekDays = new JComboBox(dayList);
		
		cbweekDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			        wNo = (Integer)cbweekDays.getSelectedItem();
			        
			      
			}
			
		});
		cbweekDays.setBounds(579, 136, 94, 25);
		contentPane.add(cbweekDays);
		
		JButton btnAdd = new JButton("Add");
		
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(102, 51, 255));
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				wType = wTypeWD;
			
				wNo   =   Integer.parseInt(cbweekDays.getSelectedItem().toString());
				
				monday = chckbxMonday.isSelected();
				tuesday = chckbxTuesday.isSelected();
				wednesday = chckbxWednesday.isSelected();
				thursday = chckbxThursday.isSelected();
				friday = chckbxFriday.isSelected();
				saturday = chckbxSaturday.isSelected();
				sunday = chckbxSunday.isSelected();
				
				System.out.println(""+wType+ wNo + monday + tuesday + wednesday + thursday + friday + saturday + sunday);
				
						
				
				
				if(wType.toString() == "null") {
					
					JOptionPane.showMessageDialog(null, "Please select a working day type");
				}
				
				else {
				
					addDataAddWDH addDataConnection = new addDataAddWDH();
					addDataConnection.insertWDH(wType,wNo,monday,tuesday,wednesday,thursday,friday,saturday,sunday);
					
					JOptionPane.showMessageDialog(null,
						    "Working Schedule Added !");
					
					}
				}
				catch(NullPointerException e1) {
					
					System.out.println("Null pointer exception throwwn");
					
					
					
				}
						
						
			}
					
			
		});
		
		btnAdd.setBounds(579, 347, 72, 25);
		contentPane.add(btnAdd);
		
		JLabel lblAddWorkingDays = new JLabel("Add Working Days and Hours");
		lblAddWorkingDays.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAddWorkingDays.setBounds(213, 11, 363, 52);
		contentPane.add(lblAddWorkingDays);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Navigation s = new Navigation();
				dispose();
				s.setVisible(true);
				
			}
		});
		btnBack.setBounds(34, 57, 89, 23);
		contentPane.add(btnBack);
		
		JLabel image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/class1.png"));
		image.setIcon(img);
		image.setBounds(31, 108, 251, 258);
		contentPane.add(image);
		
		JLabel lblDays = new JLabel("Days");
		lblDays.setForeground(new Color(25, 25, 112));
		lblDays.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDays.setBounds(454, 192, 90, 20);
		contentPane.add(lblDays);
		
		chckbxMonday = new JCheckBox("Monday");
		chckbxMonday.setBounds(576, 179, 97, 23);
		contentPane.add(chckbxMonday);
		
		
			
		
		 chckbxTuesday = new JCheckBox("Tuesday");
		chckbxTuesday.setBounds(576, 205, 97, 23);
		contentPane.add(chckbxTuesday);
		
		
		
			
			
		
		
		 chckbxWednesday = new JCheckBox("Wednesday");
		chckbxWednesday.setBounds(576, 231, 97, 23);
		contentPane.add(chckbxWednesday);
		
	
			
		
		
		chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.setBounds(576, 257, 97, 23);
		contentPane.add(chckbxThursday);
		
	
			
		
		 chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.setBounds(576, 283, 97, 23);
		contentPane.add(chckbxFriday);
		
		
			
			
		
		chckbxSaturday = new JCheckBox("Saturday");
		chckbxSaturday.setBounds(743, 179, 97, 23);
		contentPane.add(chckbxSaturday);
		
		
		
		
		 chckbxSunday = new JCheckBox("Sunday");
		chckbxSunday.setBounds(743, 205, 97, 23);
		contentPane.add(chckbxSunday);
		
		
		
		JRadioButton rdbtnWeekday = new JRadioButton("Weekday");
		rdbtnWeekday.setSelected(true);
		
		rdbtnWeekday.setForeground(Color.BLACK);
		rdbtnWeekday.setBounds(579, 95, 109, 23);
		contentPane.add(rdbtnWeekday);
		
		rdbtnWeekday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(rdbtnWeekday.isSelected()) {
					wTypeWD = "WeekDay";
				}
				
				
			}
		});
		
		
		
		JRadioButton rdbtnWeekend = new JRadioButton("Weekend");
		rdbtnWeekend.setForeground(Color.BLACK);
		rdbtnWeekend.setBounds(692, 95, 109, 23);
		contentPane.add(rdbtnWeekend);
		
		rdbtnWeekend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(rdbtnWeekend.isSelected()) {
					wTypeWD = "WeekEnd";
				}
				
				
			}
		});
		
		ButtonGroup bgWorktype = new ButtonGroup();
		bgWorktype.add(rdbtnWeekday);
		bgWorktype.add(rdbtnWeekend);
		
		
		
		JLabel lblWorkType = new JLabel("Work Type");
		lblWorkType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWorkType.setBounds(450, 92, 90, 24);
		contentPane.add(lblWorkType);
		
		if(rdbtnWeekend.isSelected()) {
			chckbxMonday.setEnabled(false);;
			chckbxTuesday.setEnabled(false);
			chckbxWednesday.setEnabled(false);
			chckbxThursday.setEnabled(false);
			chckbxFriday.setEnabled(false);;
		}
		else if(rdbtnWeekday.isSelected()) {
			chckbxSaturday.setSelected(false);
			chckbxSunday.setSelected(false);
		}
		
		
		
	}
}
