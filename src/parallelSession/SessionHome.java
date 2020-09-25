package parallelSession;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SessionHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SessionHome frame = new SessionHome();
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
	public SessionHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		
		
		JLabel image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/foot.png"));
		contentPane.setLayout(null);
		image.setIcon(img);
		image.setBounds(5, 477, 974, 54);
		contentPane.add(image);
		
		JButton button = new JButton("fill");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 191, 255));
		button.setBounds(554, 285, 211, 53);
		contentPane.add(button);
		
		JButton button_1 = new JButton("fill");
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(0, 191, 255));
		button_1.setBounds(554, 194, 211, 53);
		contentPane.add(button_1);
	}
}
