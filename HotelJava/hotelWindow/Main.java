package hotelWindow;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import userDTO.userDto;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JButton;

public class Main extends JFrame {

	private JPanel contentPane;

	public Main() {
		setTitle("Hotel.Booking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 640);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Hotel.");
		lblNewLabel.setFont(new Font("1HoonRoman Regular", Font.BOLD, 30));
		lblNewLabel.setBounds(26, 34, 126, 57);
		contentPane.add(lblNewLabel);
		
		JLabel lblBooking = new JLabel("Booking");
		lblBooking.setFont(new Font("1HoonRoman Regular", Font.BOLD, 30));
		lblBooking.setBounds(26, 79, 126, 57);
		contentPane.add(lblBooking);
		
		JPanel userPanel = new JPanel();
		userPanel.setBackground(new Color(230, 230, 250));
		userPanel.setBounds(191, 24, 263, 112);
		userPanel.setLayout(null);
		contentPane.add(userPanel);
		JLabel hiLabel = new JLabel();
		hiLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
		hiLabel.setText("\uD68C\uC6D0\uB2D8 \uD658\uC601\uD569\uB2C8\uB2E4");
		hiLabel.setBounds(63, 10, 138, 24);
		userPanel.add(hiLabel);
		
		JButton editButton = new JButton("\uD68C\uC6D0\uC815\uBCF4\uC218\uC815");
		editButton.setBackground(new Color(176, 196, 222));
		editButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		editButton.setBounds(39, 44, 183, 23);
		userPanel.add(editButton);
		editButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new userEdit().setVisible(true);
			}
		});
		
		JButton outButton = new JButton("\uB85C\uADF8\uC544\uC6C3");
		outButton.setBackground(new Color(176, 196, 222));
		outButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 13));
		outButton.setBounds(39, 77, 183, 23);
		userPanel.add(outButton);
		outButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					setVisible(false);
					new Login().setVisible(true);
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 240, 245));
		panel_1.setBounds(12, 159, 442, 434);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton checkButton = new JButton("\uC608\uC57D\uD655\uC778");
		checkButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 20));
		checkButton.setBackground(new Color(255, 228, 225));
		checkButton.setBounds(65, 42, 309, 66);
		panel_1.add(checkButton);
		checkButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new bkCheck().setVisible(true);
			}
		});
		
		JButton bookingButton = new JButton("\uAC1D\uC2E4\uBAA9\uB85D");
		bookingButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 20));
		bookingButton.setBackground(new Color(230, 230, 250));
		bookingButton.setBounds(65, 183, 309, 66);
		panel_1.add(bookingButton);
		bookingButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new bkRoom().setVisible(true);
			}
		});
		
		JButton qnaButton = new JButton("\uBB38\uC758\uD558\uAE30");
		qnaButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 20));
		qnaButton.setBackground(new Color(255, 239, 213));
		qnaButton.setBounds(65, 329, 309, 66);
		panel_1.add(qnaButton);
		qnaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new qAnda().setVisible(true);
			}
		});
		
		setVisible(true);
	}
	
	
}
