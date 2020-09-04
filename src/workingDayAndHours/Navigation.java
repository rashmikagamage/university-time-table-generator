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
		
		JButton button = new JButton("Add Working Days and Hours");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddWorkingDaysAndHours addWDH = new AddWorkingDaysAndHours();
				addWDH.setVisible(true);
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(102, 51, 255));
		button.setBounds(655, 165, 152, 89);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Add Time Slots");
		
		button_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e1) {
				
				AddTimeSlots addTS = new AddTimeSlots();
				addTS.setVisible(true);
				
			}
			
		});
		
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(102, 51, 255));
		button_1.setBounds(547, 293, 152, 89);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("View and Edit");
		
		button_2.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e2) {
			
			ViewAll viewAll = new ViewAll();
			viewAll.setVisible(true);
			
		}
		
	});
		
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(102, 51, 255));
		button_2.setBounds(767, 293, 152, 89);
		contentPane.add(button_2);

}
}
