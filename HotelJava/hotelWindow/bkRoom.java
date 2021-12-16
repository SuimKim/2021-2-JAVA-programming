package hotelWindow;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import userDTO.userDto;

import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.Font;

public class bkRoom extends JFrame {
    private JTable table;    
    private JScrollPane scrollPane;

    private String driver = "com.mysql.jdbc.Driver";        
    private String colNames[] = {"객실호수","객실명","침대타입","뷰타입","가격","최대투숙인원"};  // 테이블 컬럼 값들
    private DefaultTableModel model = new DefaultTableModel(colNames, 0); 
            
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;   // 리턴받아 사용할 객체 생성 ( select에서 보여줄 때 필요 )
    private JButton bkButton;

   
    public bkRoom() {
    	getContentPane().setBackground(new Color(255, 255, 255));
    	setTitle("Hotel.Booking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
        getContentPane().setLayout(null);            // 레이아웃 배치관리자 삭제
        table = new JTable(model);  // 테이블에 모델객체 삽입
        table.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
        scrollPane = new JScrollPane(table);            // 테이블에 스크롤 생기게 하기
        scrollPane.setLocation(12, 10);
        scrollPane.setSize(762, 260);
        getContentPane().add(scrollPane);        
        
        JButton backButton = new JButton("\uB3CC\uC544\uAC00\uAE30");
        backButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
        backButton.setBackground(new Color(255, 228, 225));
        backButton.setBounds(203, 298, 119, 35);
        getContentPane().add(backButton);
        backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Main().setVisible(true);
				
			}
		});
        
        bkButton = new JButton("\uC608\uC57D\uD558\uAE30");
        bkButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
        bkButton.setBackground(new Color(255, 228, 225));
        bkButton.setBounds(465, 298, 119, 35);
        getContentPane().add(bkButton);
        bkButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new reserVation().setVisible(true);
				
			}
		});
        
        select();
        setVisible(true);

    }
            
    private void select(){        // 테이블에 보이기 위해 검색
        String query = "select roomno, roomname, bedtype, viewtype, roomprice, maxpeople from room";     
        try{
            Class.forName(driver);
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","root");
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery(); // 리턴받아와서 데이터를 사용할 객체생성
            
            while(rs.next()){            // 각각 값을 가져와서 테이블값들을 추가
                model.addRow(new Object[]{rs.getString("roomno"),rs.getString("roomname"),rs.getString("bedtype"),
                                                        rs.getString("viewtype"),rs.getString("roomprice"),rs.getString("maxpeople")});
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                rs.close(); 
                pstmt.close(); 
                con.close();  
            } catch (Exception e2) {
            	}
            }
        }
}


