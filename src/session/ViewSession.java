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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ViewSession extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String sType="Subject",selectTyp="";
	PreparedStatement ps=null;
	Connection connection = null;
	JComboBox selectType,type; 

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
 
 
 public ResultSet getLecturersByEmpId(){
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM `lects` ";
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
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(132, 262, 805, 255);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Consolas", Font.PLAIN, 12));
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setBackground(new Color(255, 250, 250));
		scrollPane.setViewportView(table);
		
		String[] typeList = {"Subject", "Lecturer", "GroupId"};
		type = new JComboBox(typeList);
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
		type.setBounds(490, 102, 149, 20);
		contentPane.add(type);
		
		selectType = new JComboBox();
		selectType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selectTyp = (String)selectType.getSelectedItem();
			}
		});
		selectType.setBounds(233, 102, 149, 20);
		contentPane.add(selectType);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println(selectTyp);
				
				ResultSet rs = null;
				rs = getLecturersByEmpId();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		});
		btnSearch.setBounds(739, 101, 89, 23);
		contentPane.add(btnSearch);
	}
}
