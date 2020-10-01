package location;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import statistics.ViewStatistics;
import student.AddStudent;
import student.UpdateStudent;
import student.ViewStudent;

public class LocationHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocationHome frame = new LocationHome();
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
	public LocationHome() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/add bulidings.png"));
		image.setIcon(img);
		image.setBounds(125, 75, 355, 375);
		contentPane.add(image);
		
		JButton button = new JButton("Add Location");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddLocation addLocation = new AddLocation();
				addLocation.setVisible(true);
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(102, 51, 255));
		button.setBounds(573, 154, 308, 66);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Location Edit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewLocation viewLocation = new ViewLocation();
				viewLocation.setVisible(true);
				
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(102, 51, 255));
		button_1.setBounds(573, 247, 308, 66);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("View Statistics");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewStatistics viewStats = new ViewStatistics();
				viewStats.setVisible(true);
				dispose();
				
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(102, 51, 255));
		button_2.setBounds(573, 337, 308, 66);
		contentPane.add(button_2);
		
	}

}
