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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddWorkingDaysAndHours extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel error3;
	
	String wType , wTime;
	Integer wNo;

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
		
		Integer[] dayList = {1,2,3,4,5};
		
		JComboBox wNum = new JComboBox(dayList);
		wNum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			        wNo = (Integer)wNum.getSelectedItem();
			      
			}
			
		});
		wNum.setBounds(538, 136, 197, 25);
		contentPane.add(wNum);
		
		JLabel lblNoOfDays = new JLabel("No. of Days");
		lblNoOfDays.setForeground(new Color(25, 25, 112));
		lblNoOfDays.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNoOfDays.setBounds(402, 141, 90, 20);
		contentPane.add(lblNoOfDays);
		
		JLabel lblType = new JLabel("Type");
		lblType.setForeground(new Color(25, 25, 112));
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblType.setBounds(402, 74, 46, 25);
		contentPane.add(lblType);
		
		String[] typeList = {"Weekday","Weekend"};
		
		JComboBox type = new JComboBox(typeList);
		type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			        wType = (String)type.getSelectedItem();
			      
			}
			
		});
		type.setBounds(538, 73, 197, 25);
		contentPane.add(type);
		
		
		
		JLabel lblWorkingTime = new JLabel("Working Time");
		lblWorkingTime.setForeground(new Color(25, 25, 112));
		lblWorkingTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWorkingTime.setBounds(398, 207, 94, 22);
		contentPane.add(lblWorkingTime);
		
		
		
		JTextField workingTime = new JTextField();
		workingTime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				
				char c = ke.getKeyChar();
	            
	            if(Character.isLetter(c))
	            {
	            	error3.setText("* Enter only numeric digits");
	            }
	            else {
	            	error3.setText("");
	            }
			}
		});
		workingTime.setBounds(538, 208, 200, 25);
		contentPane.add(workingTime);
		workingTime.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(102, 51, 255));
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				wType = type.getSelectedItem().toString();
				wNo   =   Integer.parseInt(wNum.getSelectedItem().toString());
				wTime = workingTime.getText().toString();
				
				
				if(wTime.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please add a working time");
				}
				
				
				else {
					
					addDataAddWDH addDataConnection = new addDataAddWDH();
					addDataConnection.insertWDH(wType,wNo,wTime);
					
					JOptionPane.showMessageDialog(null,
						    "Working Schedule Added !");
					
					type.setToolTipText("");
					
					workingTime.setText("");
					
					wNum.setToolTipText("");
					;
					
				}
					
			}
		});
		
		btnAdd.setBounds(507, 359, 72, 25);
		contentPane.add(btnAdd);
		
		JLabel lblAddWorkingDays = new JLabel("Add Working Days and Hours");
		lblAddWorkingDays.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAddWorkingDays.setBounds(213, 11, 363, 52);
		contentPane.add(lblAddWorkingDays);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Navigation s = new Navigation();
				s.setVisible(true);
				
			}
		});
		btnBack.setBounds(34, 57, 89, 23);
		contentPane.add(btnBack);
		
		JLabel image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/class1.png"));
		image.setIcon(img);
		image.setBounds(48, 105, 300, 300);
		contentPane.add(image);
		
		error3 = new JLabel("");
		error3.setForeground(Color.RED);
		error3.setBounds(538, 244, 197, 14);
		contentPane.add(error3);
	}
}
