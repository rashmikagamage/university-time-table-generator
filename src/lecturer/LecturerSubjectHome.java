package lecturer;

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

import student.AddStudent;
import student.UpdateStudent;
import student.ViewStudent;
import subject.AddSubject;
import subject.viewSubject;

import java.awt.Font;

public class LecturerSubjectHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LecturerSubjectHome frame = new LecturerSubjectHome();
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
	public LecturerSubjectHome() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/lectureSubjectHome.png"));
		image.setIcon(img);
		image.setBounds(144, 48, 394, 375);
		contentPane.add(image);
		
		JButton btnAddLecturers = new JButton("Add Lecturers");
		btnAddLecturers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				AddLecturer addLecturer = new AddLecturer();
				addLecturer.setVisible(true);
				
				
			}
		});
		btnAddLecturers.setForeground(Color.WHITE);
		btnAddLecturers.setBackground(new Color(102, 51, 255));
		btnAddLecturers.setBounds(573, 154, 152, 89);
		contentPane.add(btnAddLecturers);
		
		JButton btnVieweditupdate = new JButton("View,Edit,Delete Lecturers");
		btnVieweditupdate.setToolTipText("");
		btnVieweditupdate.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnVieweditupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewLecturer viewLecturer = new ViewLecturer();
				viewLecturer.setVisible(true);
				
			}
		});
		btnVieweditupdate.setForeground(Color.WHITE);
		btnVieweditupdate.setBackground(new Color(102, 51, 255));
		btnVieweditupdate.setBounds(756, 154, 152, 89);
		contentPane.add(btnVieweditupdate);
		
		JButton btnAddSubjects = new JButton("Add Subjects");
		btnAddSubjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddSubject addSubject = new AddSubject();
				addSubject.setVisible(true);
				
			}
		});
		btnAddSubjects.setForeground(Color.WHITE);
		btnAddSubjects.setBackground(new Color(102, 51, 255));
		btnAddSubjects.setBounds(573, 277, 152, 89);
		contentPane.add(btnAddSubjects);
		
		JButton btnVieweditdeleteSubjects = new JButton("View,Edit,Delete Subjects");
		btnVieweditdeleteSubjects.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnVieweditdeleteSubjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewSubject viewSubject = new viewSubject();
				viewSubject.setVisible(true);
				
			}
		});
		btnVieweditdeleteSubjects.setForeground(Color.WHITE);
		btnVieweditdeleteSubjects.setBackground(new Color(102, 51, 255));
		btnVieweditdeleteSubjects.setBounds(756, 277, 152, 89);
		contentPane.add(btnVieweditdeleteSubjects);
		
		JLabel image_1 = new JLabel("");
		image_1.setBounds(210, 244, 250, 205);
		contentPane.add(image_1);
		
		
	}
}
