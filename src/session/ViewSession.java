package session;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lecturer.viewLecturerConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ViewSession extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String sType="Subject",selectTyp="";
	PreparedStatement ps=null;
	Connection connection = null;
	JComboBox selectType,type; 
	private JTextField sessionCount;
	private JLabel lblViewsearchSessions;
	private JLabel lblNoOfSessions;
	private JLabel image;
	private JButton btnSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSession frame = new ViewSession();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

private void LoadAllSessions() {
	ResultSet rs = null;
	viewSessionDataConnection viewSession = new viewSessionDataConnection();
	rs = viewSession.viewSessions();
	table.setModel(DbUtils.resultSetToTableModel(rs));
	}

private void countNoOfSessions() {
	
	try {
		
		String lec = "SELECT count(id) as count FROM sessions";
		Statement statement = connection.createStatement();
		ResultSet set = statement.executeQuery(lec);
		
		while(set.next())
		{
			sessionCount.setText(set.getString("count"));
		}
	}
	catch(Exception e)
	{
		
	}
}
	
private void lecDropDown() {
		
		try {
			
			String lec = "SELECT * FROM lects";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(lec);
			
			while(set.next())
			{
				selectType.addItem(set.getString("lecName"));
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
			selectType.addItem(set.getString("subName"));
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
					selectType.addItem(set.getString("groupId"));
				}
				

			}
			catch(Exception e)
			{
				
			}
		}
 
 
 public ResultSet getSessionsBySubject(String sub){
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM sessions where subject='"+sub+"'";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
 
 public ResultSet getSessionsByGroupId(String groupId){
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM sessions where groupId='"+groupId+"'";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
 
 public ResultSet getSessionsByLecturer(String lecturer){
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM sessions where lects like '%"+lecturer+"%'   ";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	/**
	 * Create the frame.
	 */
	public ViewSession() {
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
				LoadAllSessions();
				countNoOfSessions();
				subDropDown();
				
				
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(112, 296, 805, 239);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Consolas", Font.PLAIN, 12));
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setBackground(new Color(255, 250, 250));
		scrollPane.setViewportView(table);
		
		String[] typeList = {"Subject", "Lecturer", "GroupId"};
		type = new JComboBox(typeList);
		type.setFont(new Font("Tahoma", Font.PLAIN, 14));
		type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sType = (String)type.getSelectedItem();
				
				if(sType.equals("GroupId"))
				{
					selectType.removeAllItems();
					groupDropDown();
				}
				else if(sType.equals("Lecturer"))
				{
					selectType.removeAllItems();
					lecDropDown();
				}
				else {
					selectType.removeAllItems();
					subDropDown();
				}
				
			}
		});
		type.setBounds(735, 125, 182, 23);
		contentPane.add(type);
		
		selectType = new JComboBox();
		selectType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selectTyp = (String)selectType.getSelectedItem();
			}
		});
		selectType.setBounds(524, 127, 182, 23);
		contentPane.add(selectType);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(65, 105, 225));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println(selectTyp);
				
				if(sType.equals("Subject")) {
				ResultSet rs = null;
				rs = getSessionsBySubject(selectTyp);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				else if(sType.equals("GroupId")) {
					ResultSet rs = null;
					rs = getSessionsByGroupId(selectTyp);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				else if(sType.equals("Lecturer")) {
					ResultSet rs = null;
					rs = getSessionsByLecturer(selectTyp);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				
			}
		});
		btnSearch.setBounds(616, 196, 98, 27);
		contentPane.add(btnSearch);
		
		sessionCount = new JTextField();
		sessionCount.setForeground(Color.RED);
		sessionCount.setHorizontalAlignment(SwingConstants.CENTER);
		sessionCount.setFont(new Font("Tahoma", Font.BOLD, 18));
		sessionCount.setEditable(false);
		sessionCount.setBounds(193, 60, 58, 32);
		contentPane.add(sessionCount);
		sessionCount.setColumns(10);
		
		JButton viewAll = new JButton("view All");
		viewAll.setBackground(new Color(65, 105, 225));
		viewAll.setForeground(Color.WHITE);
		viewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoadAllSessions();
			}
		});
		viewAll.setBounds(735, 196, 98, 27);
		contentPane.add(viewAll);
		
		lblViewsearchSessions = new JLabel("VIEW/SEARCH SESSIONS");
		lblViewsearchSessions.setForeground(new Color(0, 51, 51));
		lblViewsearchSessions.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblViewsearchSessions.setBounds(353, 11, 390, 45);
		contentPane.add(lblViewsearchSessions);
		
		lblNoOfSessions = new JLabel("No Of Sessions :");
		lblNoOfSessions.setForeground(new Color(25, 25, 112));
		lblNoOfSessions.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNoOfSessions.setBounds(38, 65, 163, 23);
		contentPane.add(lblNoOfSessions);
		
		image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/session3.png"));
		image.setIcon(img);
		image.setBounds(258, 67, 256, 203);
		contentPane.add(image);
		
		
	}
}
