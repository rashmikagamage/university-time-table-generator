package workingDayAndHours;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;


import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Navigation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Navigation frame = new Navigation();
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
	public Navigation() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/class.png"));
		image.setIcon(img);
		image.setBounds(75, 65, 394, 375);
		contentPane.add(image);
		
		JButton btnAddWorkingDays = new JButton("Add Working Days ");
		btnAddWorkingDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddWorkingDaysAndHours addWDH = new AddWorkingDaysAndHours();
				addWDH.setVisible(true);
			}
		});
		btnAddWorkingDays.setForeground(Color.WHITE);
		btnAddWorkingDays.setBackground(new Color(102, 51, 255));
		btnAddWorkingDays.setBounds(767, 162, 169, 89);
		contentPane.add(btnAddWorkingDays);
		
		JButton button_1 = new JButton("Add Time Slots");
		
		button_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e1) {
				
				AddTimeSlots addTS = new AddTimeSlots();
				addTS.setVisible(true);
				
			}
			
		});
		
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(102, 51, 255));
		button_1.setBounds(562, 162, 169, 89);
		contentPane.add(button_1);
		
		JButton btnViewAndEdit_1 = new JButton("View and Edit Working Days");
		
		btnViewAndEdit_1.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e2) {
			
			ViewAll viewAll = new ViewAll();
			viewAll.setVisible(true);
			
		}
		
	});
		
		btnViewAndEdit_1.setForeground(Color.WHITE);
		btnViewAndEdit_1.setBackground(new Color(102, 51, 255));
		btnViewAndEdit_1.setBounds(767, 293, 169, 89);
		contentPane.add(btnViewAndEdit_1);
		
		JButton btnViewAndEdit = new JButton("View and Edit Timeslots");
		
		btnViewAndEdit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e2) {
				
				EditAndDeleteTimeslots viewAll = new EditAndDeleteTimeslots();
				viewAll.setVisible(true);
				
			}
			
		});
		
		
		btnViewAndEdit.setForeground(Color.WHITE);
		btnViewAndEdit.setBackground(new Color(102, 51, 255));
		btnViewAndEdit.setBounds(562, 293, 169, 89);
		contentPane.add(btnViewAndEdit);

}
}
