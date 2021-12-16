package hotelWindow;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import userDAO.userDao;
import userDTO.userDto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

public class bkDelete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public bkDelete() {
		setTitle("\uD68C\uC6D0\uD0C8\uD1F4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel infLabel = new JLabel("\uC608\uC57D\uC744 \uCDE8\uC18C \uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C?");
		infLabel.setFont(new Font("�����ٸ�����", Font.PLAIN, 20));
		infLabel.setBounds(91, 32, 221, 36);
		contentPane.add(infLabel);
		
		JLabel infLabel2 = new JLabel("\uC774 \uC791\uC5C5\uC740 \uCDE8\uC18C\uD560 \uC218 \uC5C6\uC2B5\uB2C8\uB2E4.");
		infLabel2.setFont(new Font("�����ٸ�����", Font.PLAIN, 13));
		infLabel2.setBounds(119, 78, 164, 15);
		contentPane.add(infLabel2);
		
		JButton okayButton = new JButton("\uCDE8\uC18C\uD558\uAE30");
		okayButton.setFont(new Font("�����ٸ�����", Font.PLAIN, 12));
		okayButton.setBackground(new Color(255, 228, 225));
		okayButton.setBounds(93, 194, 91, 29);
		contentPane.add(okayButton);
		okayButton.addActionListener(null);
		okayButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				userDto dto = new userDto();
				dto.setBooking_no(textField.getText());
				
				userDao dao = new userDao();
				int result = dao.bkdelete(dto);
				if(result == 1) {
					JOptionPane.showMessageDialog(null, "������Ұ� �Ϸ�Ǿ����ϴ�.");
					setVisible(false);
					new bkCheck().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "������ �߻��߽��ϴ�.");
					return;
				}
			}
		});
		
		JButton noButton = new JButton("\uB3CC\uC544\uAC00\uAE30");
		noButton.setFont(new Font("�����ٸ�����", Font.PLAIN, 12));
		noButton.setBackground(new Color(255, 228, 225));
		noButton.setBounds(207, 194, 91, 29);
		contentPane.add(noButton);
		noButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new bkCheck().setVisible(true);
				
			}
		});
		
		JLabel infLabel2_1 = new JLabel("\uCDE8\uC18C\uB97C \uC6D0\uD560 \uC2DC \uC608\uC57D\uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		infLabel2_1.setFont(new Font("�����ٸ�����", Font.PLAIN, 13));
		infLabel2_1.setBounds(83, 96, 221, 15);
		contentPane.add(infLabel2_1);
		
		textField = new JTextField();
		textField.setBounds(93, 134, 205, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		setVisible(true);
	}
	

}
