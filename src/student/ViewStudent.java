package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ViewStudent extends JFrame {

	private JPanel contentPane;
	private JTable table;
	String sem = "S1",year = "Y1";
	static ViewStudent frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new ViewStudent();
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
	public ViewStudent() {
		

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudent = new JLabel("VIEW STUDENT");
		lblStudent.setForeground(new Color(47, 79, 79));
		lblStudent.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblStudent.setBounds(385, 11, 333, 57);
		contentPane.add(lblStudent);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(98, 256, 805, 206);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Consolas", Font.PLAIN, 12));
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setBackground(new Color(255, 250, 250));
		
		JLabel label = new JLabel("Year");
		label.setForeground(new Color(25, 25, 112));
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(336, 99, 46, 50);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Semester");
		label_1.setForeground(new Color(25, 25, 112));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(331, 162, 100, 11);
		contentPane.add(label_1);
		
		String[] yearList = {"Y1","Y2","Y3","Y4"};
		JComboBox yearCombo = new JComboBox(yearList);
		yearCombo.setForeground(new Color(0, 0, 102));
		yearCombo.setBackground(new Color(255, 255, 255));
		
		
		String[] semList = {"S1","S2"};
		JComboBox semCombo = new JComboBox(semList);
		semCombo.setBackground(new Color(255, 255, 255));
		semCombo.setForeground(new Color(0, 0, 102));
		semCombo.setBounds(459, 157, 197, 25);
		contentPane.add(semCombo);
		
		yearCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				year = (String)yearCombo.getSelectedItem();
				System.out.println(sem + " " + year);
			}
		});
		
		semCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sem = (String)semCombo.getSelectedItem();
				System.out.println(sem + " " + year);
			}
		});
		yearCombo.setBounds(459, 113, 197, 25);
		contentPane.add(yearCombo);
		
		
		
		JLabel image = new JLabel("");
		image.setBounds(113, 69, 165, 165);
		contentPane.add(image);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/bell.png"));
		image.setIcon(img);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ResultSet rs = null;
				ViewDataConnection viewDataConnection = new ViewDataConnection();
				rs = viewDataConnection.filterStudent(sem,year);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(102, 51, 255));
		button.setBounds(694, 136, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("View All");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = null;
				ViewDataConnection viewDataConnection = new ViewDataConnection();
				rs = viewDataConnection.viewStudent();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(102, 51, 255));
		button_1.setBounds(523, 207, 89, 25);
		contentPane.add(button_1);
		
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/home.png"));
		
		JLabel image2 = new JLabel("");
		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/foot.png"));
		image2.setIcon(img2);
		image2.setBounds(0, 439, 1037, 119);
		contentPane.add(image2);
	}
	
}
