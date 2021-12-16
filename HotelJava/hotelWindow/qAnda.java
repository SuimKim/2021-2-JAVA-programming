package hotelWindow;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import userDAO.userDao;
import userDTO.userDto;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JButton;

public class qAnda extends JFrame {

	private JPanel contentPane;
	private JTextField titleField;
	private JTextField textField;

	public qAnda() {
		setTitle("Hotel.Booking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel titleLabel = new JLabel("\uBB38\uC758\uD558\uAE30");
		titleLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 25));
		titleLabel.setBounds(24, 16, 90, 34);
		contentPane.add(titleLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 225));
		panel.setLayout(null);
		panel.setBounds(21, 65, 543, 476);
		contentPane.add(panel);
		
		titleField = new JTextField();
		titleField.setForeground(Color.GRAY);
		titleField.setText("\uC81C\uBAA9");
		titleField.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		titleField.setBounds(35, 22, 470, 31);
		panel.add(titleField);
		titleField.setColumns(10);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setForeground(Color.GRAY);
		textField.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(35, 72, 470, 321);
		panel.add(textField);
		
		JButton saveButton = new JButton("\uC800\uC7A5\uD558\uAE30");
		saveButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		saveButton.setBackground(new Color(230, 230, 250));
		saveButton.setBounds(215, 416, 108, 31);
		panel.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(titleField.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "제목을 입력하세요.");
					return;
				}
				if(textField.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "내용을 입력하세요.");
					return;
				}
		
				userDto dto = new userDto();
				dto.setTitle(titleField.getText());
				dto.setContent(textField.getText());
				
				userDao dao = new userDao();
				int result = dao.qnasave(dto);
				if(result == 1) {
					JOptionPane.showMessageDialog(null, "작성이 완료되었습니다.");
					setVisible(false);
					new qnaList().setVisible(true);
				}
				if(result == -1) {
					JOptionPane.showMessageDialog(null, "오류가 발생했습니다");
				}
				
			}
		});
		
		JButton listButton = new JButton("\uC791\uC131\uD55C \uAE00");
		listButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		listButton.setBackground(new Color(230, 230, 250));
		listButton.setBounds(376, 416, 108, 31);
		panel.add(listButton);
		listButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new qnaList().setVisible(true);
			}
		});
		
		JButton backButton = new JButton("\uBA54\uC778\uC73C\uB85C");
		backButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		backButton.setBackground(new Color(230, 230, 250));
		backButton.setBounds(54, 416, 108, 31);
		panel.add(backButton);
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
