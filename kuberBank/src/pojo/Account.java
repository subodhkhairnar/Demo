package pojo;

public class Account {

	private int accno;
	private String acctype;
	private int userid;
	private double balance;
	private String status;
	
	public int getAccno() {
		return accno;
	}
	public String getAcctype() {
		return acctype;
	}
	public int getUserid() {
		return userid;
	}
	public double getBalance() {
		return balance;
	}
	public String getStatus() {
		return status;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Account() {
		
	}
	public Account(int accno, String acctype, double balance, String status) {
		super();
		this.accno = accno;
		this.acctype = acctype;
		this.balance = balance;
		this.status = status;
	}
	public Account(String acctype, int userid, double balance, String status) {
		super();
		this.acctype = acctype;
		this.userid = userid;
		this.balance = balance;
		this.status = status;
	}
	public Account(int accno, String acctype, int userid, double balance, String status) {
		super();
		this.accno = accno;
		this.acctype = acctype;
		this.userid = userid;
		this.balance = balance;
		this.status = status;
	}
}
