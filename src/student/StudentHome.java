package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentHome extends JFrame {

	private JPanel contentPane;
	static StudentHome frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new StudentHome();
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
	public StudentHome() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/class.png"));
		image.setIcon(img);
		image.setBounds(75, 65, 394, 375);
		contentPane.add(image);
		
		JButton button = new JButton("Add Students");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddStudent addStudent = new AddStudent();
				addStudent.setVisible(true);
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(102, 51, 255));
		button.setBounds(573, 154, 152, 89);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Delete Students");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UpdateStudent updateStudent = new UpdateStudent();
				updateStudent.setVisible(true);
				
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(102, 51, 255));
		button_1.setBounds(756, 154, 152, 89);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Update Students");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateStudent updateStudent = new UpdateStudent();
				updateStudent.setVisible(true);
				
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(102, 51, 255));
		button_2.setBounds(573, 277, 152, 89);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("View Students");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewStudent viewStudent = new ViewStudent();
				viewStudent.setVisible(true);
				
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setBackground(new Color(102, 51, 255));
		button_3.setBounds(756, 277, 152, 89);
		contentPane.add(button_3);
		
	}

}
