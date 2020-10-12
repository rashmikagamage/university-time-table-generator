package ConsecutiveSession;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConsecutiveSession.*;
import javafx.scene.control.ComboBox;

import javax.swing.JList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ConsecutiveSession extends JFrame {

	private JPanel contentPane;
	String lecturer = "lec";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsecutiveSession frame = new ConsecutiveSession();
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
	public ConsecutiveSession() {
		
		CSData l = new CSData();
		ArrayList<String> data = l.getData();
		String arr[][] = new String[data.size()][6];
		String id[] = new String[data.size()];
		String count[] = new String[data.size()];
		String tag[] = new String[data.size()];
		String subject[] = new String[data.size()];
		String duration[] = new String[data.size()];
		String code[] = new String[data.size()];
		for (int i = 0; i < data.size(); i++) {
			arr[i] = data.get(i).split(",");
		}

		for (int i = 0; i < arr.length; i++) {

			id[i] = arr[i][0];
			subject[i] = arr[i][1];
			code[i] = arr[i][2];
			tag[i] = arr[i][3];
			count[i] = arr[i][4];
			duration[i] = arr[i][5];

		}

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelName = new JLabel("Select Session 1");
		labelName.setBounds(86, 127, 123, 23);
		labelName.setForeground(new Color(25, 25, 112));
		labelName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(labelName);

		JLabel labelName1 = new JLabel("Select Session 2");
		labelName1.setBounds(543, 127, 123, 23);
		labelName1.setForeground(new Color(25, 25, 112));
		labelName1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(labelName1);

		JLabel lblStudent = new JLabel("Consecutive Sessions");
		lblStudent.setBounds(335, 11, 280, 59);
		lblStudent.setForeground(new Color(0, 0, 128));
		lblStudent.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblStudent);

		

		JLabel ssds = new JLabel("New label");
		ssds.setFont(new Font("Tahoma", Font.BOLD, 12));
		ssds.setBounds(102, 184, 86, 23);
		contentPane.add(ssds);
		ssds.setText("Subject");

		JLabel Code = new JLabel("Code");
		Code.setFont(new Font("Tahoma", Font.BOLD, 12));
		Code.setBounds(102, 218, 86, 23);
		contentPane.add(Code);

		JLabel lblNewLabel = new JLabel("Tag");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(102, 261, 86, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Student Count");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(102, 297, 107, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Duration");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(102, 332, 86, 14);
		contentPane.add(lblNewLabel_2);

		JLabel label = new JLabel("Subject");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(556, 184, 87, 23);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Code");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(556, 218, 87, 23);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Tag");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(556, 261, 87, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Student Count");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(556, 297, 110, 14);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("Duration");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(556, 332, 87, 14);
		contentPane.add(label_4);

		JLabel s1tag = new JLabel("Lecture");
		s1tag.setFont(new Font("Tahoma", Font.PLAIN, 12));
		s1tag.setBounds(242, 261, 144, 18);
		contentPane.add(s1tag);

		JLabel s1code = new JLabel("SE001");
		s1code.setFont(new Font("Tahoma", Font.PLAIN, 12));
		s1code.setBounds(242, 223, 144, 18);
		contentPane.add(s1code);

		JLabel s1subject = new JLabel("Mathematics");
		s1subject.setFont(new Font("Tahoma", Font.PLAIN, 12));
		s1subject.setBounds(242, 189, 144, 18);
		contentPane.add(s1subject);

		JLabel s1count = new JLabel("100");
		s1count.setFont(new Font("Tahoma", Font.PLAIN, 12));
		s1count.setBounds(242, 298, 144, 18);
		contentPane.add(s1count);

		JLabel s2subject = new JLabel("Mathematics");
		s2subject.setFont(new Font("Tahoma", Font.PLAIN, 12));
		s2subject.setBounds(689, 189, 144, 18);
		contentPane.add(s2subject);

		JLabel s2code = new JLabel("SE001");
		s2code.setFont(new Font("Tahoma", Font.PLAIN, 12));
		s2code.setBounds(689, 223, 144, 18);
		contentPane.add(s2code);

		JLabel s2Tag = new JLabel("Lecture");
		s2Tag.setFont(new Font("Tahoma", Font.PLAIN, 12));
		s2Tag.setBounds(689, 262, 144, 18);
		contentPane.add(s2Tag);

		JLabel s2count = new JLabel("10");
		s2count.setFont(new Font("Tahoma", Font.PLAIN, 12));
		s2count.setBounds(689, 298, 144, 18);
		contentPane.add(s2count);

		JLabel s2dur = new JLabel("2");
		s2dur.setFont(new Font("Tahoma", Font.PLAIN, 12));
		s2dur.setBounds(689, 328, 144, 18);
		contentPane.add(s2dur);

		JLabel s1dur = new JLabel("2");
		s1dur.setFont(new Font("Tahoma", Font.PLAIN, 12));
		s1dur.setBounds(242, 328, 144, 18);
		contentPane.add(s1dur);
		
		JComboBox comboBox = new JComboBox(id);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int i = comboBox.getSelectedIndex();
				s1code.setText(code[i]);
				s1count.setText(count[i]);
				s1dur.setText(duration[i]);
				s1subject.setText(subject[i]);
				s1tag.setText(tag[i]);
			}
		});
		comboBox.setBounds(242, 130, 132, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(id);
		comboBox_1.setBounds(689, 130, 132, 20);
		contentPane.add(comboBox_1);
		
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int i = comboBox_1.getSelectedIndex();
				s2code.setText(code[i]);
				s2count.setText(count[i]);
				s2dur.setText(duration[i]);
				s2subject.setText(subject[i]);
				s2Tag.setText(tag[i]);
			}
		});
		comboBox.setBounds(242, 130, 132, 20);
		contentPane.add(comboBox);
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 =  comboBox.getSelectedItem().toString();
				String s2 = comboBox_1.getSelectedItem().toString();
				
				if(s1.equals(s2)) {
					JOptionPane.showMessageDialog(null,
						    "Select Two Different Sesssions");
				}else {
					
					CSData c = new CSData();
					c.addData(s1, s2);
					JOptionPane.showMessageDialog(null,
						    "Success");
					
				}
				
				
			}
		});
		btnNewButton.setBounds(358, 411, 203, 35);

		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(102, 51, 255));
		contentPane.add(btnNewButton);
		
		
		JLabel image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/foot.png"));
		image.setIcon(img);
		image.setBounds(0, 439, 1037, 119);
		contentPane.add(image);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		ImageIcon head = new ImageIcon(this.getClass().getResource("/headl.png"));
		lblNewLabel_3.setIcon(head);
		lblNewLabel_3.setBounds(602, 17, 67, 59);
		contentPane.add(lblNewLabel_3);
		
		
	}
}
