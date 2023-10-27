package pojo;

import java.util.ArrayList;

public class User {

	private int userid;
	private String username;
	private String useremail;
	private String usercontact;
	private String userdob;
	private String userpan;
	private String useraadhar;
	private String useraddress;
	private String userpass;
	private String userrole;
    Account acc = new Account();
//	ArrayList<User> f = new ArrayList<>();
	
	public User() {
		super();
	}
	

	public User(int userid, String username, String useremail, String usercontact, String userdob, String userpan,
		String useraadhar, String useraddress, String userpass, String userrole, Account acc) {
	super();
	this.userid = userid;
	this.username = username;
	this.useremail = useremail;
	this.usercontact = usercontact;
	this.userdob = userdob;
	this.userpan = userpan;
	this.useraadhar = useraadhar;
	this.useraddress = useraddress;
	this.userpass = userpass;
	this.userrole = userrole;
	this.acc = acc;
}


	public User(String username, String useremail, String usercontact, String userdob, String userpan,
			String useraadhar, String useraddress, String userpass) {
		super();
		this.username = username;
		this.useremail = useremail;
		this.usercontact = usercontact;
		this.userdob = userdob;
		this.userpan = userpan;
		this.useraadhar = useraadhar;
		this.useraddress = useraddress;
		this.userpass = userpass;
	}

	public User(int userid, String username, String useremail, String usercontact, String userdob, String userpan,
			String useraadhar, String useraddress, String userpass, String userrole) {
		super();
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.usercontact = usercontact;
		this.userdob = userdob;
		this.userpan = userpan;
		this.useraadhar = useraadhar;
		this.useraddress = useraddress;
		this.userpass = userpass;
		this.userrole = userrole;
	}

	
	public User(int userid, String username, String useremail, String usercontact, String userdob, String userpan,
			String useraadhar, String useraddress, String userpass) {
		super();
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.usercontact = usercontact;
		this.userdob = userdob;
		this.userpan = userpan;
		this.useraadhar = useraadhar;
		this.useraddress = useraddress;
		this.userpass = userpass;
		
	}


	public Account getAcc() {
		return acc;
	}


	public void setAcc(Account acc) {
		this.acc = acc;
	}


	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUsercontact() {
		return usercontact;
	}

	public void setUsercontact(String usercontact) {
		this.usercontact = usercontact;
	}

	public String getUserdob() {
		return userdob;
	}

	public void setUserdob(String userdob) {
		this.userdob = userdob;
	}

	public String getUserpan() {
		return userpan;
	}

	public void setUserpan(String userpan) {
		this.userpan = userpan;
	}

	public String getUseraadhar() {
		return useraadhar;
	}

	public void setUseraadhar(String useraadhar) {
		this.useraadhar = useraadhar;
	}

	public String getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", useremail=" + useremail + ", usercontact="
				+ usercontact + ", userdob=" + userdob + ", userpan=" + userpan + ", useraadhar=" + useraadhar
				+ ", useraddress=" + useraddress + ", userpass=" + userpass + ", userrole=" + userrole + "]";
	}


	public void setAccount(Account account) {
		// TODO Auto-generated method stub
		acc = account;
	}


	
	
	
	
	
	
}
