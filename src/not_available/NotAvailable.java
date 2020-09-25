package not_available;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import student.StudentHome;

public class NotAvailable extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotAvailable frame = new NotAvailable();
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
	public NotAvailable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudent = new JLabel("Not Available Times");
		lblStudent.setBounds(368, 25, 280, 74);
		lblStudent.setForeground(new Color(0, 51, 51));
		lblStudent.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblStudent);
		
		JButton button = new JButton("Lecturers");
		button.setBounds(122, 158, 211, 53);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentHome studentHome = new StudentHome();
				studentHome.setVisible(true);
				dispose();	
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 191, 255));
		contentPane.add(button);
		
		JButton button1 = new JButton("Session");
		button1.setBounds(122, 313, 211, 53);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentHome studentHome = new StudentHome();
				studentHome.setVisible(true);
				dispose();
				
			}
		});
		button1.setForeground(Color.WHITE);
		button1.setBackground(new Color(0, 191, 255));
		contentPane.add(button1);
		
		JButton button2 = new JButton("Groups");
		button2.setBounds(122, 234, 211, 53);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentHome studentHome = new StudentHome();
				studentHome.setVisible(true);
				dispose();
				
			}
		});
		button2.setForeground(Color.WHITE);
		button2.setBackground(new Color(0, 191, 255));
		contentPane.add(button2);
		

		JButton button3 = new JButton("Sub Groups");
		button3.setBounds(122, 398, 211, 53);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentHome studentHome = new StudentHome();
				studentHome.setVisible(true);
				dispose();
				
			}
		});
		button3.setForeground(Color.WHITE);
		button3.setBackground(new Color(0, 191, 255));
		contentPane.add(button3);
	}

}
