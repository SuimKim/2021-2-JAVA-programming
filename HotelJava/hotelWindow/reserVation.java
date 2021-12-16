package hotelWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class reserVation extends JFrame {
	private JPanel contentPane;
	private JTextField codeField;
	private JTextField outField;
	private JTextField peopleField;
	private JTextField inField;
	private JTextField bknameField;

	//UI
	public reserVation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 730);
		setTitle("Hotel.booking");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel titleLabel = new JLabel("\uC608\uC57D\uD558\uAE30");
		titleLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 30));
		titleLabel.setBounds(168, 10, 109, 42);
		contentPane.add(titleLabel);
		
		JPanel contentsPanel = new JPanel();
		contentsPanel.setBackground(new Color(230, 230, 250));
		contentsPanel.setBounds(27, 62, 409, 605);
		contentPane.add(contentsPanel);
		contentsPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		contentsPanel.add(lblNewLabel_1);
		
		JLabel Label1 = new JLabel("\uC608\uC57D\uD558\uB824\uB294 \uAC1D\uC2E4\uD638\uC218");
		Label1.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		Label1.setBounds(36, 41, 128, 26);
		contentsPanel.add(Label1);
		
		codeField = new JTextField();
		codeField.setForeground(SystemColor.windowBorder);
		codeField.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		codeField.setBounds(36, 71, 333, 26);
		contentsPanel.add(codeField);
		codeField.setColumns(10);
		
		JLabel indateLabel = new JLabel("\uCCB4\uD06C\uC778 \uB0A0\uC9DC");
		indateLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		indateLabel.setBounds(36, 128, 67, 26);
		contentsPanel.add(indateLabel);
		
		JLabel pmLabel = new JLabel("\uACB0\uC81C\uBC29\uBC95");
		pmLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		pmLabel.setBounds(36, 280, 61, 26);
		contentsPanel.add(pmLabel);
		
		JLabel peopleLabel = new JLabel("\uD22C\uC219\uC778\uC6D0");
		peopleLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		peopleLabel.setBounds(36, 356, 61, 26);
		contentsPanel.add(peopleLabel);
		
		JLabel outLabel = new JLabel("\uCCB4\uD06C\uC544\uC6C3 \uB0A0\uC9DC");
		outLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		outLabel.setBounds(36, 208, 93, 26);
		contentsPanel.add(outLabel);
		
		outField = new JTextField();
		outField.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		outField.setColumns(10);
		outField.setBounds(36, 233, 333, 26);
		contentsPanel.add(outField);
		
		peopleField = new JTextField();
		peopleField.setForeground(SystemColor.windowBorder);
		peopleField.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		peopleField.setColumns(10);
		peopleField.setBounds(36, 383, 333, 26);
		contentsPanel.add(peopleField);
		
		JButton backButton = new JButton("\uB3CC\uC544\uAC00\uAE30");
		backButton.setBackground(new Color(255, 228, 225));
		backButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		backButton.setBounds(75, 528, 93, 37);
		contentsPanel.add(backButton);
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new bkRoom().setVisible(true);
				
			}
		});
		
		JLabel idifoLabel = new JLabel("\uC22B\uC790\uB9CC \uC785\uB825");
		idifoLabel.setForeground(Color.RED);
		idifoLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		idifoLabel.setBounds(308, 47, 61, 15);
		contentsPanel.add(idifoLabel);
		
		JLabel birthinfoLabel = new JLabel("YYYY-MM-DD \uD615\uC2DD");
		birthinfoLabel.setForeground(Color.RED);
		birthinfoLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		birthinfoLabel.setBounds(263, 214, 106, 15);
		contentsPanel.add(birthinfoLabel);
		
		JLabel telinfoLabel = new JLabel("\uC22B\uC790\uB9CC \uC785\uB825");
		telinfoLabel.setForeground(Color.RED);
		telinfoLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		telinfoLabel.setBounds(308, 362, 61, 15);
		contentsPanel.add(telinfoLabel);
		
		inField = new JTextField();
		inField.setForeground(SystemColor.windowBorder);
		inField.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		inField.setColumns(10);
		inField.setBounds(36, 156, 333, 26);
		contentsPanel.add(inField);
		
		JLabel birthinfoLabel_1 = new JLabel("YYYY-MM-DD \uD615\uC2DD");
		birthinfoLabel_1.setForeground(Color.RED);
		birthinfoLabel_1.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		birthinfoLabel_1.setBounds(263, 134, 106, 15);
		contentsPanel.add(birthinfoLabel_1);
		
		bknameField = new JTextField();
		bknameField.setForeground(SystemColor.windowBorder);
		bknameField.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		bknameField.setColumns(10);
		bknameField.setBounds(36, 461, 333, 26);
		contentsPanel.add(bknameField);
		
		JLabel idField = new JLabel("\uC608\uC57D\uC790 \uC774\uB984");
		idField.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		idField.setBounds(36, 434, 82, 26);
		contentsPanel.add(idField);
	
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uCE74\uB4DC", "\uD604\uAE08", "\uACC4\uC88C\uC774\uCCB4"}));
		comboBox.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 12));
		comboBox.setBounds(36, 307, 333, 26);
		contentsPanel.add(comboBox);
		
		JButton okayButton = new JButton("\uC608\uC57D\uD558\uAE30");
		okayButton.setBackground(new Color(255, 228, 225));
		okayButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		okayButton.setBounds(236, 528, 93, 37);
		contentsPanel.add(okayButton);
		okayButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pay = comboBox.getSelectedItem().toString();
				if(codeField.getText().length() == 0||inField.getText().length() == 0||outField.getText().length() == 0||
				   outField.getText().length() == 0||peopleField.getText().length() == 0||bknameField.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "¸ðµç Á¤º¸¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.");
					return;
				}
					
				userDto dto = new userDto();
				dto.setIndate(inField.getText());
				dto.setOutdate(outField.getText());
				dto.setPmethod(pay);
				dto.setBkpeople(peopleField.getText());
				dto.setRoomno(codeField.getText());
				dto.setBkname(bknameField.getText());
				
				userDao dao = new userDao();
				int result = dao.reservation(dto);
				if(result == 1) {
					JOptionPane.showMessageDialog(null, "¿¹¾àÀÌ ¿Ï·áµÇ¾ú½À´Ï´Ù");
					setVisible(false);
					new bkCheck().setVisible(true);
				}
				if(result == -1) {
					JOptionPane.showMessageDialog(null, "¿À·ù°¡ ¹ß»ýÇß½À´Ï´Ù");
				}
			}
		});
		
		setVisible(true);
	}
	

}
