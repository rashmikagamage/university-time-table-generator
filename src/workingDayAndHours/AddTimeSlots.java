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

public class AddTimeSlots extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField endTime;
	private JTable table;
	private JLabel error1, error2;
	
	
	
	String tType , tStart , tEnd , tDay;

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
		
		JLabel lblTimeSlot = new JLabel("Time Slot");
		lblTimeSlot.setForeground(new Color(25, 25, 112));
		lblTimeSlot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTimeSlot.setBounds(434, 91, 94, 14);
		contentPane.add(lblTimeSlot);
		
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setForeground(new Color(25, 25, 112));
		lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStartTime.setBounds(434, 168, 94, 14);
		contentPane.add(lblStartTime);
		
		JTextField startTime = new JTextField();
		startTime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				
				
				char c = ke.getKeyChar();
	            
	            if(Character.isLetter(c))
	            {
	            	error1.setText("* Enter only numeric digits");
	            }
	            else {
	            	error1.setText("");
	            }
			}
		});
		startTime.setBounds(564, 165, 197, 25);
		contentPane.add(startTime);
		startTime.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(482, 260, 46, 14);
		contentPane.add(label);
		
		JLabel lblEndTime = new JLabel("End Time");
		lblEndTime.setForeground(new Color(25, 25, 112));
		lblEndTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEndTime.setBounds(434, 237, 94, 14);
		contentPane.add(lblEndTime);
		
		JTextField endTime = new JTextField();
		endTime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				
				char c = ke.getKeyChar();
	            
	            if(Character.isLetter(c))
	            {
	            	error2.setText("* Enter only numeric digits");
	            }
	            else {
	            	error2.setText("");
	            }
				
				
			}
		});
		endTime.setBounds(561, 234, 200, 25);
		contentPane.add(endTime);
		endTime.setColumns(10);
		
		JLabel lblDays = new JLabel("Day");
		lblDays.setForeground(new Color(25, 25, 112));
		lblDays.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDays.setBounds(434, 309, 94, 25);
		contentPane.add(lblDays);
		
		String[] daysList = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		
		JComboBox workingDays = new JComboBox(daysList);
		workingDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				
			        tDay = (String)workingDays.getSelectedItem();
			      
			}
			
		});

		workingDays.setBounds(564, 313, 197, 25);
		contentPane.add(workingDays);
		
		JLabel lblAddTimeSlots = new JLabel("Add Time Slots");
		lblAddTimeSlots.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAddTimeSlots.setBounds(387, 23, 178, 39);
		contentPane.add(lblAddTimeSlots);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(102, 51, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tType = slotType.getSelectedItem().toString();
				tStart =startTime.getText().toString();
				tEnd = 	endTime.getText().toString();
				tDay = 	workingDays.getSelectedItem().toString();
				
				if(tType.isEmpty()) {
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
				
				else {
					
					addDataAddTimeSlots addDataConnection = new addDataAddTimeSlots();
					addDataConnection.insertTimeSlots(tType,tStart,tEnd,tDay);
					
					JOptionPane.showMessageDialog(null,
						    "Slot Added !");
					
					slotType.setToolTipText("");
					startTime.setText("");
					endTime.setText("");
					workingDays.setToolTipText("");
					;
					
				}
					
			}
		});
		
		btnAdd.setBounds(509, 415, 89, 23);
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
		
		
	}
}
