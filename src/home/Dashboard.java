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
import session.SessionsHome;
import sprint2.RoomManagementHome;
import statistics.ViewStatistics;
import student.StudentHome;
import workingDayAndHours.Navigation;
import generateTimetable.generateNav;

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
		btnStudentsManagement.setBounds(88, 157, 211, 53);
		contentPane.add(btnStudentsManagement);
		

		JLabel image = new JLabel("");
		image.setBackground(new Color(25, 25, 112));
		ImageIcon img = new ImageIcon(this.getClass().getResource("/dash.png"));
		image.setIcon(img);
		image.setBounds(351, 79, 320, 349);
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
		btnTagsManagement.setBounds(88, 221, 211, 53);
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
		btnLecturerManagement.setBounds(88, 285, 211, 53);
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
		btnStatisticsManagement.setBounds(703, 157, 211, 53);
		contentPane.add(btnStatisticsManagement);
		
		JButton button_4 = new JButton("Consecutive Sessions");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsecutiveSession   c = new ConsecutiveSession();
				c.setVisible(true);
				
			}
		});
		button_4.setForeground(Color.WHITE);
		button_4.setBackground(new Color(25, 25, 112));
		button_4.setBounds(703, 221, 211, 53);
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
		btnSessionManagement_1.setBounds(703, 349, 211, 53);
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
		button_5.setBounds(703, 285, 211, 53);
		contentPane.add(button_5);
		
		JLabel image2 = new JLabel("");
		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/foot.png"));
		image2.setIcon(img2);
		image2.setBounds(0, 449, 1037, 119);
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
		btnSessionManagement.setBounds(88, 349, 211, 53);
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
		roomManagement.setBounds(703, 93, 211, 53);
		contentPane.add(roomManagement);
		
		JButton btnWorkingDaysAnd = new JButton("Working Days and TimeSlots");
		btnWorkingDaysAnd.setForeground(Color.WHITE);
		btnWorkingDaysAnd.setBackground(new Color(25, 25, 112));
		btnWorkingDaysAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Navigation p = new Navigation();
				p.setVisible(true);
				
			}
		});
		btnWorkingDaysAnd.setBounds(88, 93, 211, 53);
		contentPane.add(btnWorkingDaysAnd);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setForeground(Color.WHITE);
		btnGenerate.setBackground(new Color(25, 25, 112));
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateNav p = new generateNav();
				p.setVisible(true);
				
			}
		});
		btnGenerate.setBounds(397, 400, 224, 61);
		contentPane.add(btnGenerate);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(199, 21, 133));
		lblNewLabel.setBounds(0, 0, 5, 536);
		lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setOpaque(true);
		label_1.setBackground(new Color(199, 21, 133));
		label_1.setBounds(979, 0, 5, 536);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setOpaque(true);
		label_2.setBackground(new Color(199, 21, 133));
		label_2.setBounds(0, 0, 984, 5);
		contentPane.add(label_2);
		
	}
}
