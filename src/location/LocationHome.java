package location;

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
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import statistics.ViewStatistics;
import student.AddStudent;
import student.UpdateStudent;
import student.ViewStudent;

public class LocationHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocationHome frame = new LocationHome();
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
	public LocationHome() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/add bulidings.png"));
		image.setIcon(img);
		image.setBounds(125, 75, 355, 375);
		contentPane.add(image);
		
		JLabel label_1 = new JLabel("LOCATION MANAGEMENT HOME",SwingConstants.CENTER);
		label_1.setForeground(new Color(0, 51, 51));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_1.setBounds(12, 13, 970, 59);
		contentPane.add(label_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 73, 970, 2);
		contentPane.add(separator);
		
		JButton button = new JButton("Add Location");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				AddLocation addLocation = new AddLocation();
				addLocation.setVisible(true);
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(25, 25, 112));
		button.setBounds(573, 139, 308, 66);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Location Edit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				ViewLocation viewLocation = new ViewLocation();
				viewLocation.setVisible(true);
				
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(25, 25, 112));
		button_1.setBounds(573, 307, 308, 66);
		contentPane.add(button_1);
		
		JLabel image2 = new JLabel("");
		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/foot.png"));
		image2.setIcon(img2);
		image2.setBounds(-11, 455, 1037, 90);
		contentPane.add(image2);
	}

}
