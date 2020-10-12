package parallelSession;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConsecutiveSession.CSData;
import ConsecutiveSession.NotOverLapData;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

public class ParallelSes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	JList list_1;
	JList<String> list;
	List<String> arr;
	ArrayList<String> data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParallelSes frame = new ParallelSes();
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
	public ParallelSes() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelName = new JLabel("Category Name");
		labelName.setBounds(86, 127, 123, 23);
		labelName.setForeground(new Color(25, 25, 112));
		labelName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(labelName);

		JLabel lblStudent = new JLabel("Parallel Sessions");
		lblStudent.setBounds(67, 17, 280, 59);
		lblStudent.setForeground(new Color(0, 0, 128));
		lblStudent.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblStudent);

		JLabel image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/foot.png"));
		image.setIcon(img);
		image.setBounds(0, 439, 1037, 119);
		contentPane.add(image);

		JLabel lblNewLabel_3 = new JLabel("New label");
		ImageIcon head = new ImageIcon(this.getClass().getResource("/headl.png"));
		lblNewLabel_3.setIcon(head);
		lblNewLabel_3.setBounds(302, 17, 67, 59);
		contentPane.add(lblNewLabel_3);

		textField = new JTextField();
		textField.setBounds(213, 130, 134, 23);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblSelectSessionNumbers = new JLabel("Select Session (with CTRL)");
		lblSelectSessionNumbers.setForeground(new Color(25, 25, 112));
		lblSelectSessionNumbers.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		lblSelectSessionNumbers.setBounds(159, 160, 134, 23);
		contentPane.add(lblSelectSessionNumbers);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 arr = list.getSelectedValuesList();
				String cat = "";
				cat = textField.getText();
				String ids = "";
				if (arr.size() < 2) {
					JOptionPane.showMessageDialog(null, "Select at least two sessions");
				} else if (cat.equals("")) {
					JOptionPane.showMessageDialog(null, "Give a Category Name");
				}

				else {

					for (int i = 0; i < arr.size(); i++) {
						String a[] = arr.get(i).split("-");

						if (i == 0) {
							ids = ids + a[0];
						} else {

							ids = ids + "-" + a[0];
						}
					}
					CSData c = new CSData();
					c.addData(cat, ids);
					JOptionPane.showMessageDialog(null, "Success");
					list.clearSelection();
				}

			}
		});

		btnNewButton.setBounds(126, 410, 203, 35);

		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(102, 51, 255));
		contentPane.add(btnNewButton);

		JLabel lblNooverlapSessions = new JLabel("No-Overlap Sessions");
		lblNooverlapSessions.setForeground(new Color(0, 0, 128));
		lblNooverlapSessions.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNooverlapSessions.setBounds(597, 17, 250, 59);
		contentPane.add(lblNooverlapSessions);

		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(837, 17, 67, 59);
		ImageIcon head2 = new ImageIcon(this.getClass().getResource("/headl.png"));
		label_1.setIcon(head2);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Category Name");
		label_2.setForeground(new Color(25, 25, 112));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(624, 121, 123, 23);
		contentPane.add(label_2);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(750, 123, 134, 23);
		contentPane.add(textField_1);

	

		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> arr = list_1.getSelectedValuesList();
				String cat = "";
				cat = textField_1.getText();
				String ids = "";
				if (arr.size() < 2) {
					JOptionPane.showMessageDialog(null, "Select at least two sessions");
				} else if (cat.equals("")) {
					JOptionPane.showMessageDialog(null, "Give a Category Name");
				}

				else {

					for (int i = 0; i < arr.size(); i++) {
						String a[] = arr.get(i).split("-");

						if (i == 0) {
							ids = ids + a[0];
						} else {

							ids = ids + "-" + a[0];
						}
					}
					NotOverLapData c = new NotOverLapData();
					c.addData(cat, ids);
					JOptionPane.showMessageDialog(null, "Success");
					list_1.clearSelection();
				
					
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(102, 51, 255));
		button.setBounds(655, 410, 203, 35);
		contentPane.add(button);

		JLabel label = new JLabel("Select Session (with CTRL)");
		label.setForeground(new Color(25, 25, 112));
		label.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		label.setBounds(682, 160, 134, 23);
		contentPane.add(label);

		loadData();
	}

	public void loadData() {
		CSData l = new CSData();
		data = l.getData();
		String arr[][] = new String[data.size()][6];
		String id[] = new String[data.size()];
		String code[] = new String[data.size()];
		for (int i = 0; i < data.size(); i++) {
			arr[i] = data.get(i).split(",");
		}

		for (int i = 0; i < arr.length; i++) {

			id[i] = arr[i][0];
			code[i] = arr[i][2];
		}

		String tog[] = new String[code.length];

		for (int i = 0; i < tog.length; i++) {
			tog[i] = id[i] + "-" + code[i];
		}

		list_1 = new JList(tog);
		list_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		list_1.setBounds(666, 194, 176, 189);
		contentPane.add(list_1);
		
		list = new JList(tog);
		list.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		list.setBounds(138, 194, 176, 189);
		contentPane.add(list);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(495, 0, 6, 525);
		contentPane.add(lblNewLabel);
		lblNewLabel.setOpaque(true);
		Color c = new Color(100, 100, 100);
		lblNewLabel.setBackground(new Color(128, 0, 128));
		
		JLabel label = new JLabel("");
		label.setOpaque(true);
		label.setBackground(new Color(128, 0, 128));
		label.setBounds(978, 0, 6, 525);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setOpaque(true);
		label_1.setBackground(new Color(128, 0, 128));
		label_1.setBounds(0, 0, 6, 525);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setOpaque(true);
		label_2.setBackground(new Color(128, 0, 128));
		label_2.setBounds(0, 0, 984, 6);
		contentPane.add(label_2);

	}
}
