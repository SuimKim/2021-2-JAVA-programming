package userDTO;

public class userDto {
	//----------------------회원테이블----------------------
	private String user_id;
	private String username;
	private String usergender;
	private String userbirth;
	private String usertel;
	private String userpwd;
	//----------------------예약테이블----------------------
	private String booking_no;
	private String indate;
	private String outdate;
	private String pmethod;
	private String bkpeople;
	private String roomno;
	private String bkname;
	//----------------------문의테이블----------------------
	private String qnano;
	private String title;
	private String content;
	private String answer;
	//---------------------------------------------------
	//----------------------회원테이블----------------------
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsergender() {
		return usergender;
	}
	public void setUsergender(String usergender) {
		this.usergender = usergender;
	}
	public String getUserbirth() {
		return userbirth;
	}
	public void setUserbirth(String userbirth) {
		this.userbirth = userbirth;
	}
	public String getUsertel() {
		return usertel;
	}
	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	//----------------------예약테이블----------------------
	public String getBooking_no() {
		return booking_no;
	}
	public void setBooking_no(String booking_no) {
		this.booking_no = booking_no;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public String getOutdate() {
		return outdate;
	}
	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}
	public String getPmethod() {
		return pmethod;
	}
	public void setPmethod(String pmethod) {
		this.pmethod = pmethod;
	}
	public String getBkpeople() {
		return bkpeople;
	}
	public void setBkpeople(String bkpeople) {
		this.bkpeople = bkpeople;
	}
	//---------------------------------------------------
	public String getRoomno() {
		return roomno;
	}
	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}
	public String getBkname() {
		return bkname;
	}
	public void setBkname(String bkname) {
		this.bkname = bkname;
	}
	//---------------------------------------------------
	public String getQnano() {
		return qnano;
	}
	public void setQnano(String qnano) {
		this.qnano = qnano;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
