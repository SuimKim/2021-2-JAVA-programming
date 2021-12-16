package hotelWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import userDAO.userDao;
import userDTO.userDto;

public class userEdit extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField telField;
	private JPasswordField pwdField;
	private JTextField idField;

	public userEdit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 480);
		setTitle("Hotel.booking");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel titleLabel = new JLabel("\uD68C\uC6D0\uC815\uBCF4\uC218\uC815");
		titleLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 30));
		titleLabel.setBounds(155, 10, 163, 42);
		contentPane.add(titleLabel);
		
		JPanel contentsPanel = new JPanel();
		contentsPanel.setBackground(new Color(230, 230, 250));
		contentsPanel.setBounds(27, 62, 409, 356);
		contentPane.add(contentsPanel);
		contentsPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		contentsPanel.add(lblNewLabel_1);
		
		JLabel pwdLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pwdLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		pwdLabel.setBounds(36, 86, 61, 26);
		contentsPanel.add(pwdLabel);
		
		JLabel telLabel = new JLabel("\uC804\uD654\uBC88\uD638");
		telLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		telLabel.setBounds(36, 211, 61, 26);
		contentsPanel.add(telLabel);
		
		JLabel nameLabel = new JLabel("\uC774\uB984");
		nameLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		nameLabel.setBounds(36, 150, 50, 26);
		contentsPanel.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		nameField.setColumns(10);
		nameField.setBounds(36, 175, 333, 26);
		contentsPanel.add(nameField);
		
		telField = new JTextField();
		telField.setForeground(SystemColor.windowBorder);
		telField.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		telField.setColumns(10);
		telField.setBounds(36, 238, 333, 26);
		contentsPanel.add(telField);
		
		pwdField = new JPasswordField();
		pwdField.setBounds(36, 114, 333, 26);
		contentsPanel.add(pwdField);
		
		JButton joinButton = new JButton("\uC218\uC815\uD558\uAE30");
		joinButton.setBackground(new Color(255, 228, 225));
		joinButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		joinButton.setBounds(47, 289, 93, 37);
		contentsPanel.add(joinButton);
		joinButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(idField.getText().length() == 0||pwdField.getText().length() == 0||nameField.getText().length() == 0||telField.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "¸ðµç Á¤º¸¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.");
					return;
				}
					
				userDto dto = new userDto();
				dto.setUser_id(idField.getText());
				dto.setUserpwd(pwdField.getText());
				dto.setUsername(nameField.getText());
				dto.setUsertel(telField.getText());
				
				userDao dao = new userDao();
				int result = dao.edit(dto);
				if(result == 1) {
					JOptionPane.showMessageDialog(null, "Á¤º¸ ¼öÁ¤ÀÌ ¿Ï·áµÇ¾ú½À´Ï´Ù.");
					setVisible(false);
					new Main().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "¿À·ù°¡ ¹ß»ýÇß½À´Ï´Ù.");
					return;
				}
			}
		});
		
		JLabel telinfoLabel = new JLabel("010-0000-0000 \uD615\uC2DD");
		telinfoLabel.setForeground(Color.RED);
		telinfoLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		telinfoLabel.setBounds(252, 217, 117, 15);
		contentsPanel.add(telinfoLabel);
		
		JButton outButton = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
		outButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		outButton.setBackground(new Color(255, 228, 225));
		outButton.setBounds(156, 289, 93, 37);
		contentsPanel.add(outButton);
		outButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new userDelete().setVisible(true);
			}
		});
		
		JButton backButton = new JButton("\uB3CC\uC544\uAC00\uAE30");
		backButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		backButton.setBackground(new Color(255, 228, 225));
		backButton.setBounds(266, 288, 93, 37);
		contentsPanel.add(backButton);
		
		idField = new JTextField();
		idField.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		idField.setColumns(10);
		idField.setBounds(36, 50, 333, 26);
		contentsPanel.add(idField);
		
		JLabel idLabel = new JLabel("\uC544\uC774\uB514");
		idLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		idLabel.setBounds(35, 18, 61, 26);
		contentsPanel.add(idLabel);
		
		JLabel telinfoLabel_1 = new JLabel("\uBC18\uB4DC\uC2DC \uBCF8\uC778\uC758 \uC544\uC774\uB514\uB97C \uC785\uB825\uD558\uC138\uC694.");
		telinfoLabel_1.setForeground(Color.RED);
		telinfoLabel_1.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		telinfoLabel_1.setBounds(190, 25, 179, 15);
		contentsPanel.add(telinfoLabel_1);
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Main().setVisible(true);
			}
		});
		
		
		
		setVisible(true);
	}
}


