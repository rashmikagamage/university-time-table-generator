package session;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SessionsHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SessionsHome frame = new SessionsHome();
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
	public SessionsHome() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddLecturers = new JButton("Add Sessions");
		btnAddLecturers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddSession addSession = new AddSession();
				addSession.setVisible(true);
			}
		});
		btnAddLecturers.setForeground(Color.WHITE);
		btnAddLecturers.setBackground(new Color(102, 51, 255));
		btnAddLecturers.setBounds(434, 182, 152, 89);
		contentPane.add(btnAddLecturers);
		
		JButton btnAddLecturers_1 = new JButton("View Sessions");
		btnAddLecturers_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewSession viewSession = new ViewSession();
				viewSession.setVisible(true);
			}
		});
		btnAddLecturers_1.setForeground(Color.WHITE);
		btnAddLecturers_1.setBackground(new Color(102, 51, 255));
		btnAddLecturers_1.setBounds(647, 182, 152, 89);
		contentPane.add(btnAddLecturers_1);
		
		JButton btnAddLecturers_2 = new JButton("Filter Sessions");
		btnAddLecturers_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewSession viewSession = new ViewSession();
				viewSession.setVisible(true);
			}
		});
		btnAddLecturers_2.setForeground(Color.WHITE);
		btnAddLecturers_2.setBackground(new Color(102, 51, 255));
		btnAddLecturers_2.setBounds(434, 320, 152, 89);
		contentPane.add(btnAddLecturers_2);
		
		JButton btnAddLecturers_3 = new JButton("Add Sessions");
		btnAddLecturers_3.setForeground(Color.WHITE);
		btnAddLecturers_3.setBackground(new Color(102, 51, 255));
		btnAddLecturers_3.setBounds(647, 320, 152, 89);
		contentPane.add(btnAddLecturers_3);
		
		JLabel image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/lectureSubjectHome.png"));
		image.setIcon(img);
		image.setBounds(71, 85, 394, 375);
		contentPane.add(image);
		
		
	}

}
