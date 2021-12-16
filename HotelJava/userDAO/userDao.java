package userDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import userDTO.userDto;

public class userDao {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//�����ͺ��̽� ������ ���� �޼ҵ�
	public Connection getConnetion() {
		try { 
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","root");
			System.out.println("DB ������ �Ϸ�Ǿ����ϴ�.");
			
		} catch(Exception e) {
			e.printStackTrace();  //���� ���
		}
		return con;
	}
		
	//�����ͺ��̽� ��� ������ �����ִ� �޼ҵ�
	public void closeAll(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if(con != null) {
			try {
				con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
					
		} if(pstmt != null) {
			try {
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		} if(rs != null) {
			try {
				rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
		
	//ȸ�������� �ϱ� ���� �޼ҵ�
	public int join(userDto dto) {
		try {
			con = getConnetion();
			pstmt = con.prepareStatement("INSERT INTO user(user_id, username, usergender, userbirth, usertel, userpwd) VALUES(?,?,?,?,?,?)");
			pstmt.setString(1, dto.getUser_id());
			pstmt.setString(2, dto.getUsername());
			pstmt.setString(3, dto.getUsergender());
			pstmt.setString(4, dto.getUserbirth());
			pstmt.setString(5, dto.getUsertel());
			pstmt.setString(6, dto.getUserpwd());
			return pstmt.executeUpdate(); 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(con, pstmt, null);
		}
		return -1; //��������
	}
	
	//�ߺ�Ȯ�� �޼ҵ�
	public boolean check(String user_id) {
		try {
			con = getConnetion();
			pstmt = con.prepareStatement("SELECT user_id from user");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getString("user_id").equals(user_id)) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(con, pstmt, rs);
		}
		return false;
		}
	
	//�α��� �޼ҵ�
	public int login(String user_id, String userpwd) {
		try {
			con = getConnetion();
			pstmt = con.prepareStatement("SELECT userpwd FROM user where user_id=?");
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userpwd)) {
					return 1;
				} else
					return 0;
			} return -1; //���̵� ����
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(con, pstmt, rs);
		} return -2; //��������
	}
	
	//ȸ������ ���� �޼ҵ�
	public int edit(userDto dto) {
		int result = 0;
		try {
			con = getConnetion();
			pstmt = con.prepareStatement("UPDATE user SET user_id=?, username=?, usertel=?, userpwd=? WHERE user_id='"+dto.getUser_id()+"'");
			pstmt.setString(1, dto.getUser_id());
			pstmt.setString(2, dto.getUsername());
			pstmt.setString(3, dto.getUsertel());
			pstmt.setString(4, dto.getUserpwd());
			result = pstmt.executeUpdate(); 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//ȸ��Ż�� �޼ҵ�
	public int delete(userDto dto) {
		try {
			con = getConnetion();
			pstmt = con.prepareStatement("DELETE FROM user WHERE user_id=?");
			pstmt.setString(1, dto.getUser_id());
			return pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} return -1;
	}
	
	//���� �޼ҵ�
	public int reservation(userDto dto) {
		try {
			con = getConnetion();
			pstmt = con.prepareStatement("INSERT INTO booking(booking_no, indate, outdate, pmethod, bkpeople, roomno, bkname) VALUES(?,?,?,?,?,?,?)");
			pstmt.setString(1, dto.getBooking_no());
			pstmt.setString(2, dto.getIndate());
			pstmt.setString(3, dto.getOutdate());
			pstmt.setString(4, dto.getPmethod());
			pstmt.setString(5, dto.getBkpeople());
			pstmt.setString(6, dto.getRoomno());
			pstmt.setString(7, dto.getBkname());
			return pstmt.executeUpdate(); 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(con, pstmt, null);
		}
		return -1; //��������
	}
	
	//������� �޼ҵ�
	public int bkdelete(userDto dto) {
		try {
			con = getConnetion();
			pstmt = con.prepareStatement("DELETE FROM booking WHERE booking_no=?");
			pstmt.setString(1, dto.getBooking_no());
			return pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} return -1;
	}
	
	//���� �ۼ� �޼ҵ�
	public int qnasave(userDto dto) {
		try {
			con = getConnetion();
			pstmt = con.prepareStatement("INSERT INTO qanda(qnano, title, content) VALUES(?,?,?)");
			pstmt.setString(1, dto.getQnano());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			return pstmt.executeUpdate(); 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(con, pstmt, null);
		}
		return -1; //��������
	}
	
	//���� ���� �޼ҵ�
	public int qnadelete(userDto dto) {
		try {
			con = getConnetion();
			pstmt = con.prepareStatement("DELETE FROM qanda WHERE qnano=?");
			pstmt.setString(1, dto.getQnano());
			return pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} return -1;
	}
	
	
}
