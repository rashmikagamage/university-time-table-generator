package statistics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import location.AddLocation;
import location.ViewLocationConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;

public class ViewStatistics extends JFrame {

	private JPanel contentPane;
	JLabel lblSubject = new JLabel("Loading...");
	JLabel lblLecturer = new JLabel("Loading...");
	JLabel lblStudent = new JLabel("Loading...");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStatistics frame = new ViewStatistics();
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
	public ViewStatistics() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				ResultSet rs = null;//result set for subjects
				ResultSet rs2 = null;//result set for lecturers
				ResultSet rs3 = null;//result set for students
				
				StatConnection viewStatCon = new StatConnection();
				rs = viewStatCon.subjectNo();
				rs2 = viewStatCon.lecturerNo();
				rs3 = viewStatCon.studentNo();
				try {
					rs.next();
					rs2.next();
					rs3.next();
					lblSubject.setText(rs.getString(1));
					lblLecturer.setText(rs2.getString(1));
					lblStudent.setText(rs3.getString(1));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel label_1 = new JLabel("STATISTICS");
		label_1.setForeground(new Color(0, 51, 51));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_1.setBounds(12, 13, 147, 59);
		contentPane.add(label_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 70, 970, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("LECTURERS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(384, 85, 227, 59);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("STUDENTS");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setBackground(Color.LIGHT_GRAY);
		label.setOpaque(true);
		label.setBounds(48, 85, 227, 59);
		contentPane.add(label);
		
		JLabel label_2 = new JLabel("SUBJECTS");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBackground(Color.LIGHT_GRAY);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_2.setOpaque(true);
		label_2.setBounds(722, 85, 227, 59);
		contentPane.add(label_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(330, 100, 2, 427);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(664, 100, 2, 427);
		contentPane.add(separator_2);
		lblStudent.setForeground(new Color(30, 144, 255));
		lblStudent.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		lblStudent.setBounds(141, 453, 134, 40);
		contentPane.add(lblStudent);
		
		JLabel lblNewLabel_2 = new JLabel("");
		ImageIcon studentImg = new ImageIcon(AddLocation.class.getResource("/student.png"));
		ImageIcon lecturerImg = new ImageIcon(AddLocation.class.getResource("/lecturer.png"));
		ImageIcon subjectImg = new ImageIcon(AddLocation.class.getResource("/subjects.png"));
		lblNewLabel_2.setIcon(studentImg);
		lblNewLabel_2.setBounds(91, 453, 38, 40);
		contentPane.add(lblNewLabel_2);
		lblLecturer.setForeground(new Color(30, 144, 255));
		lblLecturer.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		lblLecturer.setBounds(479, 453, 134, 40);
		contentPane.add(lblLecturer);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(427, 453, 40, 40);
		label_4.setIcon(lecturerImg);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(745, 453, 38, 40);
		label_5.setIcon(subjectImg);
		contentPane.add(label_5);
		lblSubject.setForeground(new Color(30, 144, 255));
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		lblSubject.setBounds(795, 453, 134, 40);
		contentPane.add(lblSubject);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(127, 453, 2, 40);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(465, 453, 2, 40);
		contentPane.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(781, 453, 2, 40);
		contentPane.add(separator_5);
		
		JButton btnTest = new JButton("VIEW CHART");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentGraph graph1 = new StudentGraph("Comparison", "Students in each Programme");
	            graph1.pack();
	            graph1.setVisible(true);
			}
		});
		btnTest.setBounds(91, 256, 125, 40);
		contentPane.add(btnTest);
		
		JButton button = new JButton("VIEW CHART");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LectureGraph demo = new LectureGraph("Comparison", "Lecturer Levels");
	            demo.pack();
	            demo.setVisible(true);
			}
		});
		button.setBounds(427, 256, 125, 40);
		contentPane.add(button);
		
		JButton button_1 = new JButton("VIEW CHART");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubjectGraph graph2 = new SubjectGraph("Comparison", "Number of Subjects in each Year");
	            graph2.pack();
	            graph2.setVisible(true);
			}
		});
		button_1.setBounds(769, 256, 125, 40);
		contentPane.add(button_1);
		
		JLabel label_3 = new JLabel("Number of Students");
		label_3.setForeground(Color.DARK_GRAY);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_3.setBounds(48, 389, 227, 40);
		contentPane.add(label_3);
		
		JLabel label_6 = new JLabel("Number of Lecturers");
		label_6.setForeground(Color.DARK_GRAY);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_6.setBounds(384, 389, 227, 40);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Number of Subjects");
		label_7.setForeground(Color.DARK_GRAY);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_7.setBounds(722, 389, 227, 40);
		contentPane.add(label_7);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(48, 438, 227, 2);
		contentPane.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(384, 438, 227, 2);
		contentPane.add(separator_7);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(709, 438, 227, 2);
		contentPane.add(separator_8);
		
        
	}
}
