package Tags;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import student.StudentHome;

import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class Tags extends JFrame {

	private JPanel contentPane;
	private JTextField tagTextField;
	JFrame alert = new JFrame("Swing Tester");
	ArrayList<String> tags = new ArrayList<String>();
	String selectedTag ="" ;
	private JTextField editText;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tags frame = new Tags();
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
	public Tags() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel image = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/tags.png"));
		image.setIcon(img);
		image.setBounds(10, 117, 442, 338);
		contentPane.add(image);
		
		JLabel lblStudent = new JLabel("Tags");
		lblStudent.setForeground(new Color(47, 79, 79));
		lblStudent.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblStudent.setBounds(439, 11, 135, 53);
		contentPane.add(lblStudent);
		
		JLabel lblTags = new JLabel("Tag");
		lblTags.setForeground(new Color(25, 25, 112));
		lblTags.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTags.setBounds(555, 93, 57, 31);
		contentPane.add(lblTags);
		
		tagTextField = new JTextField();
		tagTextField.setText("");
		tagTextField.setColumns(10);
		tagTextField.setBounds(632, 98, 199, 25);
		contentPane.add(tagTextField);
		
		editText = new JTextField();
		editText.setBounds(632, 416, 199, 25);
		contentPane.add(editText);
		editText.setColumns(10);
		
		JButton Add = new JButton("Add");
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String tag = tagTextField.getText();
				
				if(tag.isEmpty()) {
					JOptionPane.showMessageDialog(alert,
						    "Enter a Tag !");
				}else {
				
				TagsDataConnection tagsDataConnection = new TagsDataConnection();
				tagsDataConnection.insertTag(tag);
				JOptionPane.showMessageDialog(alert,
					    "Tag Added !");
				tagTextField.setText("");
				}
			}
		});
		Add.setForeground(Color.WHITE);
		Add.setBackground(new Color(102, 51, 255));
		Add.setBounds(841, 97, 89, 23);
		contentPane.add(Add);
		
		
		JList<String> list = new JList(tags.toArray());
		list.setBorder(new LineBorder(new Color(51, 51, 51), 1, true));
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedTag = list.getSelectedValue();
				editText.setText(selectedTag);
			}
		});
		list.setForeground(new Color(0, 0, 102));
		list.setFont(new Font("Arial", Font.PLAIN, 18));
		list.setBounds(632, 201, 199, 187);
		contentPane.add(list);
		
		JButton btnViewTags = new JButton("View Tags");
		btnViewTags.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TagsDataConnection tagsDataConnection = new TagsDataConnection();
				tags = tagsDataConnection.getTags();
				
				if(tags.isEmpty()) {
					JOptionPane.showMessageDialog(alert,
						    "No Data Found!");
				}
				
				DefaultListModel<String> tagsDM  = new DefaultListModel<String>();
				for(int i = 0 ; i < tags.size(); i++) {
					tagsDM.addElement(tags.get(i));
					
				}
				list.setModel(tagsDM);
				
			}
		});
		btnViewTags.setForeground(Color.WHITE);
		btnViewTags.setBackground(new Color(102, 51, 255));
		btnViewTags.setBounds(683, 154, 115, 23);
		contentPane.add(btnViewTags);
		
		
		JLabel lblEditHere = new JLabel("Edit Here");
		lblEditHere.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEditHere.setForeground(new Color(0, 0, 102));
		lblEditHere.setBounds(555, 416, 82, 20);
		contentPane.add(lblEditHere);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(selectedTag == "") {
					JOptionPane.showMessageDialog(alert,
						    "Please select a Tag !");
				}else {
				TagsDataConnection t = new TagsDataConnection();
				t.deleteTag(selectedTag);
				JOptionPane.showMessageDialog(alert,
					    "Deleted!");
				editText.setText("");
				}
			}
		});
		delete.setForeground(Color.WHITE);
		delete.setBackground(new Color(102, 51, 255));
		delete.setBounds(855, 365, 89, 23);
		contentPane.add(delete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(selectedTag == "") {
					JOptionPane.showMessageDialog(alert,
						    "Please select a Tag !");
				}else {
					TagsDataConnection t = new TagsDataConnection();
					t.updateTag(editText.getText(), selectedTag);
					JOptionPane.showMessageDialog(alert,
						    "Updated Succesfully!");
					editText.setText("");
				}
				
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(new Color(102, 51, 255));
		btnUpdate.setBounds(855, 417, 89, 23);
		contentPane.add(btnUpdate);
		
		JLabel image2 = new JLabel("");
		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/foot.png"));
		image2.setIcon(img2);
		image2.setBounds(0, 439, 1037, 119);
		contentPane.add(image2);
		
		
	}
}
