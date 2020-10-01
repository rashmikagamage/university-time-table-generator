package generateTimetable;

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

public class generateNav extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					generateNav frame = new generateNav();
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
	public generateNav() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/img/class.png"));
		image.setIcon(img);
		image.setBounds(75, 65, 394, 375);
		contentPane.add(image);
		
		JButton btnAddWorkingDays = new JButton("Generate Lecturer Timetable");
		btnAddWorkingDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				generateLecturer addWDH = new generateLecturer();
				dispose();
				addWDH.setVisible(true);
			}
		});
		btnAddWorkingDays.setForeground(Color.WHITE);
		btnAddWorkingDays.setBackground(new Color(102, 51, 255));
		btnAddWorkingDays.setBounds(767, 162, 169, 89);
		contentPane.add(btnAddWorkingDays);
		
		JButton btnGenerateStudentTimetable = new JButton("Generate Student Timetable");
		
		btnGenerateStudentTimetable.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e1) {
				
				generateStudent addTS = new generateStudent();
				dispose();
				addTS.setVisible(true);
				
			}
			
		});
		
		btnGenerateStudentTimetable.setForeground(Color.WHITE);
		btnGenerateStudentTimetable.setBackground(new Color(102, 51, 255));
		btnGenerateStudentTimetable.setBounds(562, 162, 169, 89);
		contentPane.add(btnGenerateStudentTimetable);
		
		JButton btnViewAndEdit = new JButton("Generate Hall Timetable");
		btnViewAndEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				generateHall addTS = new generateHall();
				dispose();
				addTS.setVisible(true);
				
			}
		});
		btnViewAndEdit.setForeground(Color.WHITE);
		btnViewAndEdit.setBackground(new Color(102, 51, 255));
		btnViewAndEdit.setBounds(672, 295, 169, 89);
		contentPane.add(btnViewAndEdit);

}
}
