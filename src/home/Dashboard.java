package home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Tags.Tags;
import student.StudentHome;

public class Dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblStudent = new JLabel("Welcome!");
		lblStudent.setForeground(new Color(0, 51, 51));
		lblStudent.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblStudent.setBounds(464, 0, 125, 61);
		contentPane.add(lblStudent);
		
		JLabel label = new JLabel("Time Table Generator");
		label.setForeground(new Color(0, 51, 51));
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(444, 45, 164, 27);
		contentPane.add(label);
		
		JButton button = new JButton("Students");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentHome studentHome = new StudentHome();
				studentHome.setVisible(true);
				dispose();
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 191, 255));
		button.setBounds(85, 152, 211, 53);
		contentPane.add(button);
		

		JLabel image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/dashboard.png"));
		image.setIcon(img);
		image.setBounds(360, 122, 384, 358);
		contentPane.add(image);
		
		JButton button_1 = new JButton("Tags");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tags t = new Tags();
				t.setVisible(true);
				dispose();
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(0, 191, 255));
		button_1.setBounds(85, 267, 211, 53);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("fill");
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(0, 191, 255));
		button_2.setBounds(85, 392, 211, 53);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("fill");
		button_3.setForeground(Color.WHITE);
		button_3.setBackground(new Color(0, 191, 255));
		button_3.setBounds(703, 152, 211, 53);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("fill");
		button_4.setForeground(Color.WHITE);
		button_4.setBackground(new Color(0, 191, 255));
		button_4.setBounds(703, 267, 211, 53);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("fill");
		button_5.setForeground(Color.WHITE);
		button_5.setBackground(new Color(0, 191, 255));
		button_5.setBounds(703, 392, 211, 53);
		contentPane.add(button_5);
		
	}

}
