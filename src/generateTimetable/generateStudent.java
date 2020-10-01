package generateTimetable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import workingDayAndHours.Navigation;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class generateStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					generateStudent frame = new generateStudent();
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
	public generateStudent() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setBounds(866, 493, 89, 23);
		contentPane.add(btnPrint);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(306, 32, 64, 14);
		contentPane.add(lblStudentId);
		
		textField = new JTextField();
		textField.setBounds(389, 29, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(511, 28, 89, 23);
		contentPane.add(btnGenerate);
		
		JButton btnBack = new JButton("Back");
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				generateNav s = new generateNav();
				dispose();
				s.setVisible(true);
				
			}
		});
		
		btnBack.setBounds(25, 28, 89, 23);
		contentPane.add(btnBack);

}
}
