package hotelWindow;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import userDAO.userDao;
import userDTO.userDto;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Join extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JTextField nameField;
	private JTextField birthField;
	private JTextField telField;
	private JPasswordField pwdField;
	private int cnt = 0;

	public Join() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 640);
		setTitle("Hotel.booking");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel titleLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		titleLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 30));
		titleLabel.setBounds(171, 10, 109, 42);
		contentPane.add(titleLabel);
		
		JPanel contentsPanel = new JPanel();
		contentsPanel.setBackground(new Color(230, 230, 250));
		contentsPanel.setBounds(27, 62, 409, 513);
		contentPane.add(contentsPanel);
		contentsPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		contentsPanel.add(lblNewLabel_1);
		
		JLabel idLabel = new JLabel("\uC544\uC774\uB514");
		idLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		idLabel.setBounds(36, 41, 50, 26);
		contentsPanel.add(idLabel);
		
		idField = new JTextField();
		idField.setForeground(SystemColor.windowBorder);
		idField.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		idField.setBounds(36, 71, 333, 26);
		contentsPanel.add(idField);
		idField.setColumns(10);
		
		JLabel pwdLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pwdLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		pwdLabel.setBounds(36, 107, 61, 26);
		contentsPanel.add(pwdLabel);
		
		JLabel birthLabel = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		birthLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		birthLabel.setBounds(36, 232, 61, 26);
		contentsPanel.add(birthLabel);
		
		JLabel genderLabel = new JLabel("\uC131\uBCC4");
		genderLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		genderLabel.setBounds(36, 360, 50, 26);
		contentsPanel.add(genderLabel);
		
		JLabel telLabel = new JLabel("\uC804\uD654\uBC88\uD638");
		telLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		telLabel.setBounds(36, 297, 61, 26);
		contentsPanel.add(telLabel);
		
		JLabel nameLabel = new JLabel("\uC774\uB984");
		nameLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		nameLabel.setBounds(36, 171, 50, 26);
		contentsPanel.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		nameField.setColumns(10);
		nameField.setBounds(36, 196, 333, 26);
		contentsPanel.add(nameField);
		
		birthField = new JTextField();
		birthField.setForeground(SystemColor.windowBorder);
		birthField.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		birthField.setColumns(10);
		birthField.setBounds(36, 261, 333, 26);
		contentsPanel.add(birthField);
		
		telField = new JTextField();
		telField.setForeground(SystemColor.windowBorder);
		telField.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		telField.setColumns(10);
		telField.setBounds(36, 324, 333, 26);
		contentsPanel.add(telField);
		
		pwdField = new JPasswordField();
		pwdField.setBounds(36, 135, 333, 26);
		contentsPanel.add(pwdField);
		
		JButton checkButton = new JButton("\uC911\uBCF5\uD655\uC778");
		checkButton.setBackground(new Color(255, 228, 225));
		checkButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		checkButton.setBounds(71, 445, 93, 37);
		contentsPanel.add(checkButton);
		checkButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					userDao dao = new userDao();
					try {
						if(dao.check(idField.getText())) {
							JOptionPane.showMessageDialog(null, "ÀÌ¹Ì Á¸ÀçÇÏ´Â ¾ÆÀÌµðÀÔ´Ï´Ù.");
							idField.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "»ç¿ë°¡´ÉÇÑ ¾ÆÀÌµðÀÔ´Ï´Ù");
							cnt += 1;
						}
					} catch(Exception e1) {
						
					}
				}
		});
		
		JLabel idifoLabel = new JLabel("\uC601\uBB38, \uC22B\uC790 10\uC790 \uC774\uB0B4");
		idifoLabel.setForeground(Color.RED);
		idifoLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		idifoLabel.setBounds(263, 47, 106, 15);
		contentsPanel.add(idifoLabel);
		
		JLabel birthinfoLabel = new JLabel("YYYY-MM-DD \uD615\uC2DD");
		birthinfoLabel.setForeground(Color.RED);
		birthinfoLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		birthinfoLabel.setBounds(263, 238, 106, 15);
		contentsPanel.add(birthinfoLabel);
		
		JLabel telinfoLabel = new JLabel("010-0000-0000 \uD615\uC2DD");
		telinfoLabel.setForeground(Color.RED);
		telinfoLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		telinfoLabel.setBounds(252, 303, 117, 15);
		contentsPanel.add(telinfoLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC5EC\uC790", "\uB0A8\uC790"}));
		comboBox.setBounds(36, 393, 333, 26);
		contentsPanel.add(comboBox);
		
		
		JButton joinButton = new JButton("\uAC00\uC785\uD558\uAE30");
		joinButton.setBackground(new Color(255, 228, 225));
		joinButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		joinButton.setBounds(232, 445, 93, 37);
		contentsPanel.add(joinButton);
		joinButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String gender = comboBox.getSelectedItem().toString();
				if(idField.getText().length() == 0||pwdField.getText().length() == 0||nameField.getText().length() == 0||
				   birthField.getText().length() == 0||telField.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "¸ðµç Á¤º¸¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.");
					return;
				}
					
				if(cnt == 0) {
					JOptionPane.showMessageDialog(null, "¾ÆÀÌµð Áßº¹Ã¼Å©¸¦ ÇØÁÖ¼¼¿ä.");
					return;
				}
				
				
				userDto dto = new userDto();
				dto.setUser_id(idField.getText());
				dto.setUserpwd(pwdField.getText());
				dto.setUsername(nameField.getText());
				dto.setUserbirth(birthField.getText());
				dto.setUsertel(telField.getText());
				dto.setUsergender(gender);
				
				
				userDao dao = new userDao();
				int result = dao.join(dto);
				if(result == 1) {
					JOptionPane.showMessageDialog(null, "È¸¿ø°¡ÀÔÀÌ ¿Ï·áµÇ¾ú½À´Ï´Ù");
					setVisible(false);
					new Login().setVisible(true);
				}
				if(result == -1) {
					JOptionPane.showMessageDialog(null, "¿À·ù°¡ ¹ß»ýÇß½À´Ï´Ù");
				}
			}
		});
		
		setVisible(true);
	}
}
