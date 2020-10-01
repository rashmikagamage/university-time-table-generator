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

import ConsecutiveSession.ConsecutiveSession;
import Tags.Tags;
import lecturer.LecturerSubjectHome;
import location.LocationHome;
import parallelSession.ParallelSes;
<<<<<<< HEAD
import session.SessionsHome;
=======
import sprint2.RoomManagementHome;
import statistics.ViewStatistics;
>>>>>>> refs/remotes/origin/pramodhSprint2
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
		
		JButton btnStudentsManagement = new JButton("Students Management");
		btnStudentsManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentHome studentHome = new StudentHome();
				studentHome.setVisible(true);
				
				
			}
		});
		btnStudentsManagement.setForeground(Color.WHITE);
		btnStudentsManagement.setBackground(new Color(25, 25, 112));
		btnStudentsManagement.setBounds(85, 101, 211, 53);
		contentPane.add(btnStudentsManagement);
		

		JLabel image = new JLabel("");
		image.setBackground(new Color(25, 25, 112));
		ImageIcon img = new ImageIcon(this.getClass().getResource("/dashboard.png"));
		image.setIcon(img);
		image.setBounds(362, 101, 384, 358);
		contentPane.add(image);
		
		JButton btnTagsManagement = new JButton("Tags Management");
		btnTagsManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tags t = new Tags();
				t.setVisible(true);
			}
		});
		btnTagsManagement.setForeground(Color.WHITE);
		btnTagsManagement.setBackground(new Color(25, 25, 112));
		btnTagsManagement.setBounds(85, 205, 211, 53);
		contentPane.add(btnTagsManagement);
		
		JButton btnLecturerManagement = new JButton("Lecturer Management");
		btnLecturerManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LecturerSubjectHome a = new LecturerSubjectHome();
				a.setVisible(true);
			}
		});
		btnLecturerManagement.setForeground(Color.WHITE);
		btnLecturerManagement.setBackground(new Color(25, 25, 112));
		btnLecturerManagement.setBounds(85, 301, 211, 53);
		contentPane.add(btnLecturerManagement);
		
		JButton btnStatisticsManagement = new JButton("View Statistics ");
		btnStatisticsManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStatistics viewStats = new ViewStatistics();
				viewStats.setVisible(true);
				
			}
		});
		btnStatisticsManagement.setForeground(Color.WHITE);
		btnStatisticsManagement.setBackground(new Color(25, 25, 112));
		btnStatisticsManagement.setBounds(703, 101, 211, 53);
		contentPane.add(btnStatisticsManagement);
		
		JButton button_4 = new JButton("Consecutive Session Management");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsecutiveSession   c = new ConsecutiveSession();
				c.setVisible(true);
				
			}
		});
		button_4.setForeground(Color.WHITE);
		button_4.setBackground(new Color(25, 25, 112));
		button_4.setBounds(703, 206, 211, 53);
		contentPane.add(button_4);

		JButton btnSessionManagement_1 = new JButton("Session Management");
		btnSessionManagement_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SessionsHome s = new SessionsHome();
				s.setVisible(true);
			}
		});
		btnSessionManagement_1.setForeground(Color.WHITE);
		btnSessionManagement_1.setBackground(new Color(25, 25, 112));
		btnSessionManagement_1.setBounds(703, 301, 211, 53);
		contentPane.add(btnSessionManagement_1);
		JButton button_5 = new JButton("Location Management");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocationHome locHome = new LocationHome();
				locHome.setVisible(true);
				
			}
		});
		button_5.setForeground(Color.WHITE);
		button_5.setBackground(new Color(25, 25, 112));
		button_5.setBounds(703, 301, 211, 53);
		contentPane.add(button_5);
		
		JLabel image2 = new JLabel("");
		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/foot.png"));
		image2.setIcon(img2);
		image2.setBounds(0, 439, 1037, 119);
		contentPane.add(image2);
		
		JButton btnSessionManagement = new JButton("Parallel Session Management");
		btnSessionManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParallelSes p = new ParallelSes();
				p.setVisible(true);
				
			}
		});
		btnSessionManagement.setForeground(Color.WHITE);
		btnSessionManagement.setBackground(new Color(25, 25, 112));
		btnSessionManagement.setBounds(85, 395, 211, 53);
		contentPane.add(btnSessionManagement);
		
		JButton roomManagement = new JButton("Room Management");
		roomManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RoomManagementHome rmHome = new RoomManagementHome();
				rmHome.setVisible(true);
				
			}
		});
		roomManagement.setForeground(Color.WHITE);
		roomManagement.setBackground(new Color(25, 25, 112));
		roomManagement.setBounds(703, 395, 211, 53);
		contentPane.add(roomManagement);
		
	}
}
