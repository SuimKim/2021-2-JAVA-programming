package hotelWindow;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import userDAO.userDao;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JPasswordField pwdField;
	private Object loginButton;

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 360);
		setTitle("Hotel.booking");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel idLabel = new JLabel("\uC544\uC774\uB514");
		idLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 17));
		idLabel.setBounds(88, 115, 55, 35);
		contentPane.add(idLabel);
		
		JLabel pwdLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pwdLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 17));
		pwdLabel.setBounds(88, 172, 70, 35);
		contentPane.add(pwdLabel);
		
		idField = new JTextField();
		idField.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		idField.setBounds(184, 115, 198, 26);
		contentPane.add(idField);
		idField.setColumns(10);
		
		pwdField = new JPasswordField();
		pwdField.setBounds(184, 178, 198, 26);
		contentPane.add(pwdField);
		
		JLabel titleLabel = new JLabel("Hotel.booking");
		titleLabel.setFont(new Font("1HoonRoman Regular", Font.BOLD, 30));
		titleLabel.setBounds(136, 35, 198, 52);
		contentPane.add(titleLabel);
		
		JButton joinButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		joinButton.setBackground(new Color(255, 228, 225));
		joinButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		joinButton.setBounds(88, 254, 115, 26);
		contentPane.add(joinButton);
		joinButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Join().setVisible(true);
				
			}
		});
			
		
		JButton loginButton = new JButton("\uB85C\uADF8\uC778");
		loginButton.setBackground(new Color(255, 228, 225));
		loginButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		loginButton.setBounds(267, 254, 115, 26);
		contentPane.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					if(idField.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "아이디를 입력하세요.");
						return;
					}
					if(pwdField.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.");
						return;
					}
					userDao dao = new userDao();
					int result = dao.login(idField.getText(), pwdField.getText());
					if(result == 1) {
						setVisible(false);
						new Main().setVisible(true);
					} else if(result == -1) {
						JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.");
						return;
					} else if(result == 0) {
						JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다.");
						return;
					} else {
						JOptionPane.showMessageDialog(null, "서버오류가 발생했습니다.");
						return;
					}
				}
		});
			
		
		setVisible(true);
		
	}
	
	/*public static void main(String[] args) {
		Login login = new Login();
	}	*/
	
}
