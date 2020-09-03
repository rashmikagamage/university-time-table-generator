package subject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddSubject extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField code;
	private JTextField lec;
	private JTextField tute;
	private JTextField lab;
	private JTextField evl;
	private JLabel lblName_2;
	private JLabel lblName_3;
	private JLabel lblName_4;
	private JLabel lblName_5;
	private JLabel lblName_6;
	private JLabel lblName_7;
	private JLabel lblName_1;
	private JLabel lblAddSubject;
	
	String sName,sCode,sYear="Y1",sSem="S1",sLec,sTute,sLab,sEvl;
	private JLabel v1;
	private JLabel v2;
	private JLabel v3;
	private JLabel v4;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSubject frame = new AddSubject();
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
	public AddSubject() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(25, 25, 112));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(461, 89, 100, 14);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setText("");
		name.setColumns(10);
		name.setBounds(637, 86, 199, 25);
		contentPane.add(name);
		

		JLabel image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/subject.png"));
		image.setIcon(img);
		image.setBounds(103, 119, 300, 300);
		contentPane.add(image);
		
		code = new JTextField();
		code.setText("");
		code.setColumns(10);
		code.setBounds(637, 140, 199, 25);
		contentPane.add(code);
		
		lec = new JTextField();
		lec.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				
				  char c = key.getKeyChar();
		            
		            if(Character.isLetter(c))
		            {
		            	v1.setText("* Enter only numeric digits(0-9) *");
		            }
		            else {
		            	v1.setText("");
		            }
			}
		});
		lec.setText("");
		lec.setColumns(10);
		lec.setBounds(637, 306, 199, 25);
		contentPane.add(lec);
		
		tute = new JTextField();
		tute.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				

				  char c = key.getKeyChar();
		            
		            if(Character.isLetter(c))
		            {
		            	v2.setText("* Enter only numeric digits(0-9) *");
		            }
		            else {
		            	v2.setText("");
		            }

			}
		});
		tute.setText("");
		tute.setColumns(10);
		tute.setBounds(637, 362, 199, 25);
		contentPane.add(tute);
		
		lab = new JTextField();
		lab.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {

				  char c = key.getKeyChar();
		            
		            if(Character.isLetter(c))
		            {
		            	v3.setText("* Enter only numeric digits(0-9) *");
		            }
		            else {
		            	v3.setText("");
		            }

				
			}
		});
		lab.setText("");
		lab.setColumns(10);
		lab.setBounds(637, 410, 199, 25);
		contentPane.add(lab);
		
		evl = new JTextField();
		evl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				

				  char c = key.getKeyChar();
		            
		            if(Character.isLetter(c))
		            {
		            	v4.setText("* Enter only numeric digits(0-9) *");
		            }
		            else {
		            	v4.setText("");
		            }

			}
		});
		evl.setText("");
		evl.setColumns(10);
		evl.setBounds(637, 461, 199, 25);
		contentPane.add(evl);
		
		lblName_2 = new JLabel("Subject Code");
		lblName_2.setForeground(new Color(25, 25, 112));
		lblName_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName_2.setBounds(461, 143, 100, 14);
		contentPane.add(lblName_2);
		
		lblName_3 = new JLabel("Offered Year");
		lblName_3.setForeground(new Color(25, 25, 112));
		lblName_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName_3.setBounds(461, 195, 100, 14);
		contentPane.add(lblName_3);
		
		lblName_4 = new JLabel("Offered Semester");
		lblName_4.setForeground(new Color(25, 25, 112));
		lblName_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName_4.setBounds(461, 249, 134, 14);
		contentPane.add(lblName_4);
		
		lblName_5 = new JLabel("No. Lec. Hours");
		lblName_5.setForeground(new Color(25, 25, 112));
		lblName_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName_5.setBounds(461, 309, 100, 14);
		contentPane.add(lblName_5);
		
		lblName_6 = new JLabel("No. Tute Hours");
		lblName_6.setForeground(new Color(25, 25, 112));
		lblName_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName_6.setBounds(461, 365, 114, 14);
		contentPane.add(lblName_6);
		
		lblName_7 = new JLabel("No. Lab Hours");
		lblName_7.setForeground(new Color(25, 25, 112));
		lblName_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName_7.setBounds(461, 413, 100, 14);
		contentPane.add(lblName_7);
		
		JButton btnAddSubject = new JButton("Add");
		btnAddSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				sName = name.getText().toString();
				sCode = code.getText().toString();
				
				
				sLec = lec.getText().toString();
				sTute = tute.getText().toString();
				sLab = lab.getText().toString();
				sEvl = evl.getText().toString();
				
				int lecs,tutes,labs,evls;
				
				
				
				
				if(sName.isEmpty() || sCode.isEmpty() || sCode.isEmpty() || sLec.isEmpty() || 
						sTute.isEmpty() || sLab.isEmpty() ||  sEvl.isEmpty()
						) {
					JOptionPane.showMessageDialog(null,
						    "Fields can't be empty ");
				}
				else {
					
					lecs = Integer.parseInt(sLec);
					tutes = Integer.parseInt(sTute);
					labs = Integer.parseInt(sLab);
					evls = Integer.parseInt(sEvl);

					addSubjectDataConnection addSubject = new addSubjectDataConnection();
					addSubject.insertSubject(sName, sCode, sYear, sSem, lecs, tutes, labs, evls);
					
					System.out.println("SEM"+sSem);
					
					JOptionPane.showMessageDialog(null,
						    "Subject Added !");
					
					
					name.setText("");
					code.setText("");
					lec.setText("");
					tute.setText("");
					lab.setText("");
					evl.setText("");
					
				}
				
				
				
				
			}
		});
		btnAddSubject.setForeground(Color.WHITE);
		btnAddSubject.setBackground(new Color(102, 51, 255));
		btnAddSubject.setBounds(697, 510, 72, 25);
		contentPane.add(btnAddSubject);
		
		lblName_1 = new JLabel("No. Evl. Hours");
		lblName_1.setForeground(new Color(25, 25, 112));
		lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName_1.setBounds(461, 466, 100, 14);
		contentPane.add(lblName_1);
		
		lblAddSubject = new JLabel("ADD SUBJECT");
		lblAddSubject.setForeground(new Color(0, 51, 51));
		lblAddSubject.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAddSubject.setBounds(369, 11, 206, 59);
		contentPane.add(lblAddSubject);
		
		String[] yearList = {"Y1", "Y2", "Y3", "Y4"};
		JComboBox year = new JComboBox(yearList);
		year.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				sYear = (String)year.getSelectedItem();
			}
		});
		year.setBounds(637, 192, 197, 25);
		contentPane.add(year);
		
		String[] semList = {"S1", "S2"};
		JComboBox sem = new JComboBox(semList);
		sem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sSem = (String)sem.getSelectedItem();
			}
		});
		sem.setBounds(637, 246, 197, 25);
		contentPane.add(sem);
		
		v1 = new JLabel("");
		v1.setForeground(Color.RED);
		v1.setBounds(637, 342, 199, 14);
		contentPane.add(v1);
		
		v2 = new JLabel("");
		v2.setForeground(Color.RED);
		v2.setBounds(637, 385, 199, 14);
		contentPane.add(v2);
		
		v3 = new JLabel("");
		v3.setForeground(Color.RED);
		v3.setBounds(637, 435, 199, 14);
		contentPane.add(v3);
		
		v4 = new JLabel("");
		v4.setForeground(Color.RED);
		v4.setBounds(637, 485, 199, 14);
		contentPane.add(v4);
	}
}
