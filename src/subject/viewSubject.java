package subject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class viewSubject extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblViewSubjects;
	private JLabel lblSubjectCode;
	private JTextField search;
	private JButton btnSearchEmpId;
	private JButton btnUpdateSub;
	private JButton btnDeleteSub;
	private JLabel lblName;
	private JTextField name;
	private JLabel lblName_1;
	private JLabel lblName_2;
	private JLabel lblName_3;
	private JComboBox sem;
	private JComboBox subYear;
	private JLabel lblName_4;
	private JTextField code;
	private JTextField lec;
	private JLabel lblName_5;
	private JLabel lblName_6;
	private JLabel lblName_7;
	private JTextField tute;
	private JTextField lab;
	private JTextField evl;
	
	String nameSub,searchCode,chainedCode,year="Y1",semester="S1",lecs,tutes,labs,evls;
	JFrame frame = new JFrame("Swing Tester");
	private JLabel image;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewSubject frame = new viewSubject();
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
	public viewSubject() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(170, 50, 805, 176);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Consolas", Font.PLAIN, 12));
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setBackground(new Color(255, 250, 250));
		scrollPane.setViewportView(table);
		
		JButton btnShow = new JButton("View All");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ResultSet rs = null;
				viewSubjectDataConnection viewSubjects = new viewSubjectDataConnection();
				rs = viewSubjects.viewSubjects();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
			}
		});
		btnShow.setForeground(Color.WHITE);
		btnShow.setBackground(new Color(102, 51, 255));
		btnShow.setBounds(453, 237, 89, 25);
		contentPane.add(btnShow);
		
		lblViewSubjects = new JLabel("VIEW/EDIT/DELETE SUBJECTS");
		lblViewSubjects.setForeground(new Color(0, 51, 51));
		lblViewSubjects.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblViewSubjects.setBounds(390, 0, 374, 45);
		contentPane.add(lblViewSubjects);
		
		lblSubjectCode = new JLabel("Subject Code");
		lblSubjectCode.setForeground(new Color(25, 25, 112));
		lblSubjectCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSubjectCode.setBounds(170, 296, 100, 14);
		contentPane.add(lblSubjectCode);
		
		search = new JTextField();
		search.setText("");
		search.setColumns(10);
		search.setBounds(309, 293, 199, 25);
		contentPane.add(search);
		
		btnSearchEmpId = new JButton("Search");
		btnSearchEmpId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				searchCode = search.getText().toString();
				
				viewSubjectDataConnection viewSubjects = new viewSubjectDataConnection();
				ResultSet rs = viewSubjects.getSubjectsByCode(searchCode);
				

				try {
					
					if(!rs.isBeforeFirst()) {
						JOptionPane.showMessageDialog(frame,
							    "No Data Found !");
						
						
						
					}else {
						
						while(rs.next()) {
							name.setText(rs.getString(1));
							code.setText(rs.getString(2));
							subYear.setSelectedItem(rs.getString(3));
							sem.setSelectedItem(rs.getString(4));
							lec.setText(rs.getString(5));
							tute.setText(rs.getString(6));
							lab.setText(rs.getString(7));
							evl.setText(rs.getString(8));
							
							
						}
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
				
				
				
			}
		});
		btnSearchEmpId.setForeground(Color.WHITE);
		btnSearchEmpId.setBackground(new Color(102, 51, 255));
		btnSearchEmpId.setBounds(554, 294, 89, 23);
		contentPane.add(btnSearchEmpId);
		
		btnUpdateSub = new JButton("Update");
		btnUpdateSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// nameSub,searchCode,unchainedCode,year="Y1",semester="S1",lecs,tutes,labs,evls;
				
				nameSub = name.getText().toString();
				chainedCode = code.getText().toString();
				lecs = lec.getText().toString();
				tutes = tute.getText().toString();
				labs = lab.getText().toString();
				evls = evl.getText().toString();
				
				int l,t,la,ev;
				
				l = Integer.parseInt(lecs);
				t = Integer.parseInt(tutes);
				la = Integer.parseInt(labs);
				ev = Integer.parseInt(evls);
				
				
				//where
				searchCode = search.getText().toString();
				
				
				if(searchCode.equals("")) {
					JOptionPane.showMessageDialog(frame,
						    "Please Search subject and update !");
			    }
				else {
					
					
					if(code.equals("")) {
						JOptionPane.showMessageDialog(frame,
							    "Please Fill code !");
					}
					else {
						viewSubjectDataConnection viewSubjects = new viewSubjectDataConnection();
						viewSubjects.updateSubject(nameSub, chainedCode, year, semester, l, t, la, ev, searchCode);
						
						JOptionPane.showMessageDialog(frame,
							    "Updated !");
						
						name.setText("");
						code.setText("");
						search.setText("");
						lec.setText("");
						tute.setText("");
						lab.setText("");
						evl.setText("");
						sem.setSelectedItem("S1");
						subYear.setSelectedItem("Y1");
						
						
					}
				}
				
				
			}
		});
		btnUpdateSub.setForeground(Color.WHITE);
		btnUpdateSub.setBackground(new Color(102, 51, 255));
		btnUpdateSub.setBounds(351, 490, 117, 35);
		contentPane.add(btnUpdateSub);
		
		btnDeleteSub = new JButton("Delete");
		btnDeleteSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				searchCode = search.getText().toString();
				

				if(searchCode.equals("")) {
					JOptionPane.showMessageDialog(frame,
						    "Please Search subject and Delete!");
			    }
				else {
					
					viewSubjectDataConnection viewSubject = new viewSubjectDataConnection();
					
					int result = JOptionPane.showConfirmDialog(frame,"Sure? You want to Delete?", "Swing Tester",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
				            if(result == JOptionPane.YES_OPTION){
				            	viewSubject.deleteSubject(searchCode);
				            	JOptionPane.showMessageDialog(frame,
									    "Deleted !");
				            	
				            	name.setText("");
								code.setText("");
								search.setText("");
								lec.setText("");
								tute.setText("");
								lab.setText("");
								evl.setText("");
								sem.setSelectedItem("S1");
								subYear.setSelectedItem("Y1");
				            	
				         }
					
					
					
					
				}
				
			}
		});
		btnDeleteSub.setForeground(Color.WHITE);
		btnDeleteSub.setBackground(new Color(102, 51, 255));
		btnDeleteSub.setBounds(478, 490, 117, 35);
		contentPane.add(btnDeleteSub);
		
		lblName = new JLabel("Name");
		lblName.setForeground(new Color(25, 25, 112));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(36, 346, 100, 14);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setText("");
		name.setColumns(10);
		name.setBounds(125, 343, 199, 25);
		contentPane.add(name);
		
		lblName_1 = new JLabel("Subject Code");
		lblName_1.setForeground(new Color(25, 25, 112));
		lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName_1.setBounds(361, 348, 100, 14);
		contentPane.add(lblName_1);
		
		lblName_2 = new JLabel("Offered Year");
		lblName_2.setForeground(new Color(25, 25, 112));
		lblName_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName_2.setBounds(664, 346, 100, 14);
		contentPane.add(lblName_2);
		
		lblName_3 = new JLabel("Semester");
		lblName_3.setForeground(new Color(25, 25, 112));
		lblName_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName_3.setBounds(36, 399, 134, 14);
		contentPane.add(lblName_3);
		
		String[] semList = {"S1", "S2"};
		sem = new JComboBox(semList);
		sem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				semester = (String)sem.getSelectedItem();
				
			}
		});
		sem.setBounds(125, 396, 197, 25);
		contentPane.add(sem);
		
		String[] yearList = {"Y1", "Y2", "Y3", "Y4"};
		subYear = new JComboBox(yearList);
		subYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				year = (String)subYear.getSelectedItem();
			}
		});
		subYear.setBounds(774, 343, 197, 25);
		contentPane.add(subYear);
		
		lblName_4 = new JLabel("No. Lec. Hours");
		lblName_4.setForeground(new Color(25, 25, 112));
		lblName_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName_4.setBounds(351, 399, 100, 14);
		contentPane.add(lblName_4);
		
		code = new JTextField();
		code.setText("");
		code.setColumns(10);
		code.setBounds(458, 345, 199, 25);
		contentPane.add(code);
		
		lec = new JTextField();
		lec.setText("");
		lec.setColumns(10);
		lec.setBounds(458, 398, 199, 25);
		contentPane.add(lec);
		
		lblName_5 = new JLabel("No. Tute Hours");
		lblName_5.setForeground(new Color(25, 25, 112));
		lblName_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName_5.setBounds(664, 401, 114, 14);
		contentPane.add(lblName_5);
		
		lblName_6 = new JLabel("No. Lab Hours");
		lblName_6.setForeground(new Color(25, 25, 112));
		lblName_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName_6.setBounds(170, 451, 100, 14);
		contentPane.add(lblName_6);
		
		lblName_7 = new JLabel("No. Evl. Hours");
		lblName_7.setForeground(new Color(25, 25, 112));
		lblName_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName_7.setBounds(495, 451, 100, 14);
		contentPane.add(lblName_7);
		
		tute = new JTextField();
		tute.setText("");
		tute.setColumns(10);
		tute.setBounds(772, 398, 199, 25);
		contentPane.add(tute);
		
		lab = new JTextField();
		lab.setText("");
		lab.setColumns(10);
		lab.setBounds(280, 448, 199, 25);
		contentPane.add(lab);
		
		evl = new JTextField();
		evl.setText("");
		evl.setColumns(10);
		evl.setBounds(605, 450, 199, 25);
		contentPane.add(evl);
		
		image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/viewLecturer.png"));
		image.setIcon(img);
		image.setBounds(10, 50, 149, 209);
		contentPane.add(image);
	}

}
