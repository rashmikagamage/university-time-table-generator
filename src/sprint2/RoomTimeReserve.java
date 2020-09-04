package sprint2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import location.AddLocation;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RoomTimeReserve extends JFrame {

	private JPanel contentPane;
	private SpringLayout springLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomTimeReserve frame = new RoomTimeReserve();
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
	public RoomTimeReserve() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("ROOM TIME RESERVATION",SwingConstants.CENTER);
		label_1.setForeground(new Color(0, 51, 51));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_1.setBounds(12, 13, 970, 59);
		contentPane.add(label_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 73, 970, 2);
		contentPane.add(separator);
		
		JLabel label = new JLabel("");
		ImageIcon image = new ImageIcon(AddLocation.class.getResource("/reservation.png"));
		label.setIcon(image);
		label.setBounds(533, 88, 338, 297);
		contentPane.add(label);
		
		JLabel label_2 = new JLabel("Tag");
		label_2.setForeground(new Color(25, 25, 112));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(53, 116, 48, 25);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Module");
		label_3.setForeground(new Color(25, 25, 112));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(53, 177, 48, 25);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Room");
		label_4.setForeground(new Color(25, 25, 112));
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(53, 238, 48, 25);
		contentPane.add(label_4);
		
		JComboBox comboBox = new JComboBox(new Object[]{});
		comboBox.setBounds(155, 117, 204, 25);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(new Object[]{});
		comboBox_1.setBounds(155, 178, 204, 25);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox(new Object[]{});
		comboBox_2.setBounds(155, 239, 204, 25);
		contentPane.add(comboBox_2);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setOpaque(true);
		button.setForeground(Color.BLUE);
		button.setBackground(new Color(65, 105, 225));
		button.setBounds(648, 432, 90, 40);
		contentPane.add(button);
		
		JLabel label_5 = new JLabel("Tag");
		label_5.setForeground(new Color(25, 25, 112));
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(53, 299, 48, 25);
		contentPane.add(label_5);
		
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		JPanel panel = new JPanel();
		panel.setBounds(155, 299, 204, 59);
		panel.add(datePicker);
		contentPane.add(panel);
	}
}
