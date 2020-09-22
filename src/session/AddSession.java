package session;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db_connection.DB_Connection;
import lecturer.addLecturerDataConnection;
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
import javax.swing.JOptionPane;

public class AddSession extends JFrame {

	private JPanel contentPane;
	private JTextField lecturers;
	String sLec="Computing",sTag="",sGroup,sSubID,sLects;
	int sCount,sDuration;
	String sSub = "";
	JComboBox lecturerList , subList;
	JComboBox tagList,grpList;
	String[] gav;
	Connection connection = null;
	
	ArrayList<String> subCodes = new ArrayList<String>();
	private JTextField subId;
	private JTextField count;
	private JTextField duration;

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
	
private void tagDropDown() {
		
		try {
			
			String sub = "SELECT * FROM Tags";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sub);
			
			while(set.next())
			{
				tagList.addItem(set.getString("Tag"));
				
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
				subCodes.add(set.getString("subCode"));
			}
		}
		catch(Exception e)
		{
			
		}
	}
  
  private void groupDropDown() {
		
		try {
			
			String lec = "SELECT * FROM students";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(lec);
			
			while(set.next())
			{
				grpList.addItem(set.getString("groupId"));
				
			}
		}
		catch(Exception e)
		{
			
		}
	}
  
  private void subGroupDropDown() {
		
		try {
			
			String lec = "SELECT * FROM students";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(lec);
			
			while(set.next())
			{
				grpList.addItem(set.getString("subGroupId"));
				
			}
		}
		catch(Exception e)
		{
			
		}
	}
  
  public void subjectName(String name) {
	  
	  System.out.println(name);
	  
	  try {
			
			String lec = "SELECT * FROM subjects where subName='"+name+"'";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(lec);
			
			while(set.next())
			{
			
				System.out.println(set.getString("subCode"));
				subId.setText(set.getString("subCode"));
			}
		}
		catch(Exception e)
		{
			
		}
	  
  }
  
 // select subCode
 // from subjects
 // where subName = "English"
	
	
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

		
		
//		addComponentListener(new ComponentAdapter() {
//			
//			@Override
//			public void componentShown(ComponentEvent e) {
//				
//				ResultSet rs = null;
//				addSessionDataConnection addSession = new addSessionDataConnection();
//				rs = addSession.loadLecturer();
//				// table.setModel(DbUtils.resultSetToTableModel(rs));
//				//lecturerList.add(DbUtils.resultSetToNestedList(rs));
//			}
//		});
		

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddLecturer = new JLabel("ADD SESSION");
		lblAddLecturer.setForeground(new Color(0, 51, 51));
		lblAddLecturer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAddLecturer.setBounds(286, 11, 206, 59);
		contentPane.add(lblAddLecturer);
		
		JLabel image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/class1.png"));
		image.setIcon(img);
		image.setBounds(49, 130, 300, 300);
		contentPane.add(image);
		
		JLabel lblLecturers = new JLabel("Lecturer");
		lblLecturers.setForeground(new Color(25, 25, 112));
		lblLecturers.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLecturers.setBounds(418, 97, 100, 14);
		contentPane.add(lblLecturers);
		
		
		
		ArrayList<String> le = new ArrayList<String>();
	    
	    
	    
		lecturerList = new JComboBox();
		lecturerList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sLec = (String)lecturerList.getSelectedItem();

			}
		});
		lecturerList.setBounds(526, 94, 197, 25);
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
		btnAddLec.setBounds(746, 95, 89, 23);
		contentPane.add(btnAddLec);
		
		lecturers = new JTextField();
		lecturers.setEditable(false);
		lecturers.setText("");
		

		lecturers.setColumns(10);
		lecturers.setBounds(526, 130, 316, 59);
		contentPane.add(lecturers);
		
		
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(382, 315, 6, 20);
		contentPane.add(textPane);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setForeground(new Color(25, 25, 112));
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSubject.setBounds(418, 315, 100, 14);
		contentPane.add(lblSubject);
		
		subList = new JComboBox();
		subList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				sSub =  (String)subList.getSelectedItem();
				
				subjectName(sSub);
				
			}
		});
		subList.setBounds(526, 310, 197, 25);
		contentPane.add(subList);
		
		tagList = new JComboBox();
		tagList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				sTag = (String)tagList.getSelectedItem();
				
				if(sTag.equals("Lecture")) {
					grpList.removeAllItems();
					groupDropDown();
				}
				else if(sTag.equals("Tute")) {
					grpList.removeAllItems();
					groupDropDown();
				}
				else {
					grpList.removeAllItems();
					subGroupDropDown();
				}
			}
		});
		tagList.setBounds(526, 213, 197, 25);
		contentPane.add(tagList);
		
		JLabel lblTag = new JLabel("Tag");
		lblTag.setForeground(new Color(25, 25, 112));
		lblTag.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTag.setBounds(418, 211, 100, 25);
		contentPane.add(lblTag);
		
		grpList = new JComboBox();
		grpList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sGroup = (String)grpList.getSelectedItem();
				
				System.out.println(sGroup);
			}
		});
		grpList.setBounds(526, 260, 197, 25);
		contentPane.add(grpList);
		
		JLabel lblGroup = new JLabel("Group");
		lblGroup.setForeground(new Color(25, 25, 112));
		lblGroup.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGroup.setBounds(418, 258, 100, 25);
		contentPane.add(lblGroup);
		
		subId = new JTextField();
		subId.setEditable(false);
		subId.setBounds(526, 361, 197, 25);
		contentPane.add(subId);
		subId.setColumns(10);
		
		JLabel lblSubjectId = new JLabel("Subject ID");
		lblSubjectId.setForeground(new Color(25, 25, 112));
		lblSubjectId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSubjectId.setBounds(418, 364, 100, 14);
		contentPane.add(lblSubjectId);
		
		count = new JTextField();
		count.setColumns(10);
		count.setBounds(526, 408, 197, 25);
		contentPane.add(count);
		
		duration = new JTextField();
		duration.setColumns(10);
		duration.setBounds(526, 459, 197, 25);
		contentPane.add(duration);
		
		JButton btnAddSession = new JButton("Add");
		btnAddSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sCount = Integer.parseInt(count.getText().toString());
				sDuration =  Integer.parseInt(duration.getText().toString());

				sSubID = subId.getText().toString();
				sLects = lecturers.getText().toString();
				
				
				// sGroup, sTag,sSub
				
				if(sCount <= 0 || sDuration <=0)
				{
					
				}
				else {
					
					
					addSessionDataConnection addSession = new addSessionDataConnection();
					addSession.insertSession(sLects, sSub, sSubID, sTag, sGroup, sCount, sDuration);
					
					JOptionPane.showMessageDialog(null,
						    "Session Added !");
					
					count.setText("");
					duration.setText("");
					subId.setText("");
					lecturers.setText("");
					le.clear();

				}
				
				
			}
		});
		btnAddSession.setForeground(Color.WHITE);
		btnAddSession.setBackground(new Color(102, 51, 255));
		btnAddSession.setBounds(580, 512, 89, 23);
		contentPane.add(btnAddSession);
		
		JLabel lblStudentCount = new JLabel("Student Count");
		lblStudentCount.setForeground(new Color(25, 25, 112));
		lblStudentCount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStudentCount.setBounds(418, 413, 100, 14);
		contentPane.add(lblStudentCount);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setForeground(new Color(25, 25, 112));
		lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDuration.setBounds(418, 464, 100, 14);
		contentPane.add(lblDuration);
		
		lecDropDown();
		subDropDown();
		tagDropDown();
		
	}
}
