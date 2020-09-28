package sprint2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import location.AddLocation;
import student.AddStudent;

public class RoomManagementHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomManagementHome frame = new RoomManagementHome();
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
	public RoomManagementHome() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("ROOM MANAGEMENT HOME",SwingConstants.CENTER);
		label_1.setForeground(new Color(0, 51, 51));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_1.setBounds(12, 13, 970, 59);
		contentPane.add(label_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 73, 970, 2);
		contentPane.add(separator);
		
		JLabel label = new JLabel("");
		ImageIcon image = new ImageIcon(AddLocation.class.getResource("/class.png"));
		label.setIcon(image);
		label.setBounds(291, 138, 431, 301);
		contentPane.add(label);
		
		
		JButton preferRmBtn = new JButton("Preferred Room");
		preferRmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				PreferredRoom preferRm = new PreferredRoom();
				preferRm.setVisible(true);
				
			}
		});
		preferRmBtn.setOpaque(true);
		preferRmBtn.setForeground(Color.WHITE);
		preferRmBtn.setBackground(new Color(25, 25, 112));
		preferRmBtn.setBounds(774, 220, 191, 40);
		contentPane.add(preferRmBtn);
		
		JButton tagRmBtn = new JButton("Tag Room");
		tagRmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				RoomForTag rmTag = new RoomForTag();
				rmTag.setVisible(true);
				
			}
		});
		tagRmBtn.setOpaque(true);
		tagRmBtn.setForeground(Color.WHITE);
		tagRmBtn.setBackground(new Color(25, 25, 112));
		tagRmBtn.setBounds(774, 318, 191, 40);
		contentPane.add(tagRmBtn);
		
		JButton lectRmBtn = new JButton("Lecturer Room");
		lectRmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				SuitableLecRoom lecRm = new SuitableLecRoom();
				lecRm.setVisible(true);
				
			}
		});
		lectRmBtn.setOpaque(true);
		lectRmBtn.setForeground(Color.WHITE);
		lectRmBtn.setBackground(new Color(25, 25, 112));
		lectRmBtn.setBounds(774, 411, 191, 40);
		contentPane.add(lectRmBtn);
		
		JButton rmTimeResBtn = new JButton("Reserve Room");
		rmTimeResBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				RoomTimeReserve resRm = new RoomTimeReserve();
				resRm.setVisible(true);
				
			}
		});
		rmTimeResBtn.setOpaque(true);
		rmTimeResBtn.setForeground(Color.WHITE);
		rmTimeResBtn.setBackground(new Color(25, 25, 112));
		rmTimeResBtn.setBounds(774, 126, 191, 40);
		contentPane.add(rmTimeResBtn);
		
		JButton grpRmBtn = new JButton("Group Room");
		grpRmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				SuitableGrpRoom grpRoom = new SuitableGrpRoom();
				grpRoom.setVisible(true);
				
			}
		});
		grpRmBtn.setOpaque(true);
		grpRmBtn.setForeground(Color.WHITE);
		grpRmBtn.setBackground(new Color(25, 25, 112));
		grpRmBtn.setBounds(47, 126, 206, 40);
		contentPane.add(grpRmBtn);
		
		JButton conSessionsBtn = new JButton("Consecutive Sessions Room");
		conSessionsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				ConsecutiveSessions conSessions = new ConsecutiveSessions();
				conSessions.setVisible(true);
				
			}
		});
		conSessionsBtn.setOpaque(true);
		conSessionsBtn.setForeground(Color.WHITE);
		conSessionsBtn.setBackground(new Color(25, 25, 112));
		conSessionsBtn.setBounds(47, 266, 206, 40);
		contentPane.add(conSessionsBtn);
		
		
		JButton sessRmBtn = new JButton("Session Room");
		sessRmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				SuitableSessionRoom sessRm = new SuitableSessionRoom();
				sessRm.setVisible(true);
				
			}
		});
		sessRmBtn.setOpaque(true);
		sessRmBtn.setForeground(Color.WHITE);
		sessRmBtn.setBackground(new Color(25, 25, 112));
		sessRmBtn.setBounds(47, 411, 206, 40);
		contentPane.add(sessRmBtn);
		
		JLabel image2 = new JLabel("");
		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/foot.png"));
		image2.setIcon(img2);
		image2.setBounds(0, 473, 1037, 90);
		contentPane.add(image2);
	}

}
