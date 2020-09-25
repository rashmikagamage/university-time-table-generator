package not_available;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import sprint2.DateLabelFormatter;

public class SubGroups extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubGroups frame = new SubGroups();
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
	public SubGroups() {
		SubGroupDataConnection l = new SubGroupDataConnection();
		ArrayList<String> id = l.getData();
		String arr[] = new String[id.size()];
		
		try {
			for (int i =0; i < id.size(); i++) {
				arr[i] = id.get(i);
			}
		} catch (Exception e) {
			System.out.println("Exception");
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("HH");
		label.setForeground(new Color(25, 25, 112));
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(471, 180, 107, 23);
		contentPane.add(label);
		
		JLabel labelName = new JLabel("Select Group");
		labelName.setForeground(new Color(25, 25, 112));
		labelName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelName.setBounds(463, 184, 132, 14);
		contentPane.add(labelName);
		
		JLabel labelsd = new JLabel("Select Date");
		labelsd.setForeground(new Color(25, 25, 112));
		labelsd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelsd.setBounds(463, 235, 109, 23);
		contentPane.add(labelsd);
		
		JLabel labess = new JLabel("Time");
		labess.setForeground(new Color(25, 25, 112));
		labess.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labess.setBounds(463, 298, 109, 22);
		contentPane.add(labess);
		
		JLabel labelss = new JLabel("Duration");
		labelss.setForeground(new Color(25, 25, 112));
		labelss.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelss.setBounds(464, 352,121, 22);
		contentPane.add(labelss);
		
		
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.getJFormattedTextField().setText("Select Data");
		JPanel panel = new JPanel();
		panel.setBounds(597, 235, 212, 33);
		panel.add(datePicker);
		contentPane.add(panel);
		
		JComboBox lecsCb = new JComboBox(arr);
		lecsCb.setBounds(597, 181, 212, 25);
		contentPane.add(lecsCb);
		
		String hours[] = {"00","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
		JComboBox hrs = new JComboBox(hours);
		hrs.setBounds(597, 296, 48, 25);
		contentPane.add(hrs);
		
		String min[] = {"00","05","10","15","20","25","30","35","40","45","50","55"};
		JComboBox mins = new JComboBox(min);
		mins.setBounds(672, 296, 48, 25);
		contentPane.add(mins);

		JLabel lblStudent = new JLabel("Sub Groups");
		lblStudent.setForeground(new Color(0, 51, 51));
		lblStudent.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblStudent.setBounds(403, 11, 206, 59);
		contentPane.add(lblStudent);
		
		
		JLabel labelmm = new JLabel("HH");
		label.setForeground(new Color(25, 25, 112));
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(647, 299, 31, 22);
		contentPane.add(label);
		
		JLabel label2 = new JLabel("MM");
		label2.setForeground(new Color(25, 25, 112));
		label2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label2.setBounds(721, 302, 46, 14);
		contentPane.add(label2);
		
		JComboBox durahrs = new JComboBox(hours);
		durahrs.setBounds(597, 353, 48, 25);
		contentPane.add(durahrs);
		
		JLabel label_1 = new JLabel("HH");
		label_1.setForeground(new Color(25, 25, 112));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(647, 356, 31, 22);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("MM");
		label_2.setForeground(new Color(25, 25, 112));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(721, 359, 46, 14);
		contentPane.add(label_2);
		
		JComboBox duramins = new JComboBox(min);
		duramins.setBounds(672, 353, 48, 25);
		contentPane.add(duramins);
		
		JButton btnNewButton = new JButton("Allocate");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				String group = String.valueOf(lecsCb.getSelectedItem());
				Date selectedDate = (Date) datePicker.getModel().getValue();
				if (!hrs.getSelectedItem().equals("00") && !mins.getSelectedItem().equals("00")) {
					selectedDate.setHours(Integer.parseInt(hrs.getSelectedItem().toString()));
					selectedDate.setMinutes(Integer.parseInt(mins.getSelectedItem().toString()));
					selectedDate.setSeconds(00);
				}else {
					
						JOptionPane.showMessageDialog(null,
							    "Current Date and Time will be set as default");
					
				}
				
				int Duration  = (Integer.parseInt(durahrs.getSelectedItem().toString())*60)+Integer.parseInt(duramins.getSelectedItem().toString());
				
				if(Duration==0) {
					JOptionPane.showMessageDialog(null,
						    "Please Select Duration !");
				}else {
					
					SubGroupDataConnection g = new SubGroupDataConnection();
					g.addData(group, selectedDate.toString(), Duration);
					JOptionPane.showMessageDialog(null,
						    "Allocated !");
					
				}
				
				
				
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(102, 51, 255));
		btnNewButton.setBounds(597, 411, 123, 33);
		contentPane.add(btnNewButton);
	}

}
