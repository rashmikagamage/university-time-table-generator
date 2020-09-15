package session;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db_connection.DB_Connection;
import lecturer.viewLecturerConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JList;

public class AddSession extends JFrame {

	private JPanel contentPane;
	private JTextField lecturers;
	String sLec="Computing";
	JComboBox lecturerList , subList;
	String[] gav;
	Connection connection = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSession frame = new AddSession();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
// https://www.youtube.com/watch?v=qD01v_-1p-8&t=749s
	/**
	 * Create the frame.
	 */
	private void lecDropDown() {
		
		try {
			
			String lec = "SELECT * FROM lects";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(lec);
			
			while(set.next())
			{
				lecturerList.addItem(set.getString("lecName"));
			}
		}
		catch(Exception e)
		{
			
		}
	}
	
  private void subDropDown() {
		
		try {
			
			String sub = "SELECT * FROM subjects";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sub);
			
			while(set.next())
			{
				subList.addItem(set.getString("subName"));
			}
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	public AddSession() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		//setContentPane(contentPane);
		
		 try {
             Class.forName("com.mysql.jdbc.Driver");
         } catch (ClassNotFoundException ex) {
            // Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             connection=DriverManager.getConnection("jdbc:mysql://timetable.ct3ibccer38y.us-east-1.rds.amazonaws.com:3306/timetable","admin","rashmika123");
         } catch (SQLException ex) {
             //Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
         }

		
		
		addComponentListener(new ComponentAdapter() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				
				ResultSet rs = null;
				addSessionDataConnection addSession = new addSessionDataConnection();
				rs = addSession.loadLecturer();
				// table.setModel(DbUtils.resultSetToTableModel(rs));
				//lecturerList.add(DbUtils.resultSetToNestedList(rs));
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
		
		JLabel lblAddLecturer = new JLabel("ADD LECTURER");
		lblAddLecturer.setForeground(new Color(0, 51, 51));
		lblAddLecturer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAddLecturer.setBounds(286, 35, 206, 59);
		contentPane.add(lblAddLecturer);
		
		JLabel image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/class1.png"));
		image.setIcon(img);
		image.setBounds(37, 108, 300, 300);
		contentPane.add(image);
		
		JLabel lblLecturers = new JLabel("Lecturer");
		lblLecturers.setForeground(new Color(25, 25, 112));
		lblLecturers.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLecturers.setBounds(429, 146, 100, 14);
		contentPane.add(lblLecturers);
		
		//String[] facList = {"Computing", "Engineering", "Business"};
		
		ArrayList<String> le = new ArrayList<String>();
	    
	    
	    
		lecturerList = new JComboBox();
		lecturerList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sLec = (String)lecturerList.getSelectedItem();

			}
		});
		lecturerList.setBounds(528, 143, 197, 25);
		contentPane.add(lecturerList);
		
		
		
		JButton btnAddLec = new JButton("Add");
		btnAddLec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//System.out.println(sLec);
				le.add(sLec);
				
				System.out.println(le);
				
				String listString="";
				
				for (String s : le)
				{
				    listString += s + "\t";
				}

				System.out.println(listString);
				
				lecturers.setText(listString);
				
				
				
				
			}
		});
		btnAddLec.setForeground(Color.WHITE);
		btnAddLec.setBackground(new Color(102, 51, 255));
		btnAddLec.setBounds(753, 144, 89, 23);
		contentPane.add(btnAddLec);
		
		lecturers = new JTextField();
		lecturers.setEditable(false);
		lecturers.setText("");
		

		lecturers.setColumns(10);
		lecturers.setBounds(526, 195, 316, 59);
		contentPane.add(lecturers);
		
		
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(382, 315, 6, 20);
		contentPane.add(textPane);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setForeground(new Color(25, 25, 112));
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSubject.setBounds(429, 294, 100, 14);
		contentPane.add(lblSubject);
		
		subList = new JComboBox();
		subList.setBounds(528, 281, 197, 25);
		contentPane.add(subList);
		
		lecDropDown();
		subDropDown();
		
	}
}
