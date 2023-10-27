package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import pojo.Account;
import pojo.User;
import utility.DBConnection;



public class UserDaoImpl implements UserDao{
    
	Connection conn=DBConnection.getConnect();
	PreparedStatement ps;
	ResultSet rs;
	int result;
	String sql;
	User user;
	ArrayList<User> f = new ArrayList<>();
	Account account;
	@Override
	public boolean addUser(User user) throws SQLException {
		sql="insert into userinfo(username,useremail,usercontact,userdob,userpan,useraadhar,useraddress,userpass)values(?,?,?,?,?,?,?,?)";
		ps=conn.prepareStatement(sql);
		ps.setString(1,user.getUsername() );
		ps.setString(2, user.getUseremail());
		ps.setString(3, user.getUsercontact());
		ps.setString(4, user.getUserdob());
		ps.setString(5, user.getUserpan());
		ps.setString(6, user.getUseraadhar());
		ps.setString(7, user.getUseraddress());
		ps.setString(8, user.getUserpass());
		
		System.out.println("Query:"+ps);
		result=ps.executeUpdate();
		if(result>0)
			return true;
		return false;
	}

	@Override
	public boolean updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		sql="update userinfo set username=?,useremail=?,usercontact=?,userdob=?,userpan=?,useraadhar=?,useraddress=?,userpass=? where userid=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(9, user.getUserid());
		ps.setString(1,user.getUsername() );
		ps.setString(2, user.getUseremail());
		ps.setString(3, user.getUsercontact());
		ps.setString(4, user.getUserdob());
		ps.setString(5, user.getUserpan());
		ps.setString(6, user.getUseraadhar());
		ps.setString(7, user.getUseraddress());
		ps.setString(8, user.getUserpass());
		
		System.out.println("Query:"+ps);
		result=ps.executeUpdate();
		if(result>0)
			return true;
		
		
		return false;
	}

	@Override
	public boolean deleteUser(int userid) throws SQLException {
		// TODO Auto-generated method stub
		
		sql = "delete from userinfo where userid = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, userid);
	    boolean rss =ps.execute();
		
		return rss;
	}

	@Override
	public List<User> showUserList() throws SQLException {
		// TODO Auto-generated method stub
		
		sql = "Select * from userinfo";
		ps = conn.prepareStatement(sql);
	    rs =ps.executeQuery();
		
		
		while ( rs.next() ) {
			user = new User();
			user.setUserid(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setUseremail(rs.getString(3));
			user.setUsercontact(rs.getString(4));
			user.setUserdob(rs.getString(5));
			user.setUserpan(rs.getString(6));
			user.setUseraadhar(rs.getString(7));
			user.setUseraddress(rs.getString(8));
			user.setUserpass(rs.getString(9));
			user.setUserrole(rs.getString(10));
			
			f.add(user);
		}
		
		
		return f;
	}

	@Override
	public List<User> showUserWithAccount() throws SQLException {
		sql = "Select a.*,u.* from account a join userinfo u";
		ps = conn.prepareStatement(sql);
	    rs =ps.executeQuery();
		
		
		while ( rs.next() ) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)
			  +" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getString(5));	
			f.add(user);
		}
		return f;		
	}

	@Override
	public User searchUserByUserid(int userid) throws SQLException {
		// TODO Auto-generated method stub
		sql = "Select * from userinfo where userid = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, userid);
		rs =ps.executeQuery();
		while(rs.next()) {
			user=new User();
			user.setUserid(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setUseremail(rs.getString(3));
			user.setUsercontact(rs.getString(4));
			user.setUserdob(rs.getString(5));
			user.setUserpan(rs.getString(6));
			user.setUseraadhar(rs.getString(7));
			user.setUseraddress(rs.getString(8));
			user.setUserpass(rs.getString(9));
			user.setUserrole(rs.getString(10));
			
		     f.add(user);
		}
		return user;
		
	}

	@Override
	public User searchUserByEmail(String useremail) throws SQLException {
		sql = "Select * from userinfo where useremail = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, useremail);
		rs =ps.executeQuery();
		while(rs.next()) {
			user=new User();
			user.setUserid(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setUseremail(rs.getString(3));
			user.setUsercontact(rs.getString(4));
			user.setUserdob(rs.getString(5));
			user.setUserpan(rs.getString(6));
			user.setUseraadhar(rs.getString(7));
			user.setUseraddress(rs.getString(8));
			user.setUserpass(rs.getString(9));
			user.setUserrole(rs.getString(10));
			
		     f.add(user);
		}
		return user;
	}

	@Override
	public User searchUserByAadhar(String useraadhar) throws SQLException {
		sql = "Select * from userinfo where useraadhar = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(7, useraadhar);
		rs =ps.executeQuery();
		while(rs.next()) {
			user=new User();
			user.setUserid(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setUseremail(rs.getString(3));
			user.setUsercontact(rs.getString(4));
			user.setUserdob(rs.getString(5));
			user.setUserpan(rs.getString(6));
			user.setUseraadhar(rs.getString(7));
			user.setUseraddress(rs.getString(8));
			user.setUserpass(rs.getString(9));
			user.setUserrole(rs.getString(10));
			
		     f.add(user);
		}
		return user;
	}

	public String checkUserEmailPass(String useremail, String userpass ) throws SQLException {
		// TODO Auto-generated method stub
		
		String role ="";
		sql = "select userrole from userinfo "
				+ "where useremail = ? and userpass = ? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, useremail);
		ps.setString(2, userpass);
	
		rs = ps.executeQuery();	
		if (rs.next()) { // Move the cursor to the first row
	        role = rs.getString("userrole"); // Retrieve the value of userrole
	        System.out.println(role);
		}
		
		if (role.equals("user")) {
			String status = "";
			String sql1 = "select a.status from account a join userinfo u on a.userid = u.userid where u.useremail = ?";
		    ps = conn.prepareStatement(sql1);
		    ps.setString(1, useremail);
		    rs = ps.executeQuery();
		    if ( rs.next()) {
		    	status = rs.getString(1);
		    }
		    System.out.println(status);
		    if (status.equals("inactive")) {
		    	return "nulluser";
		    }
		    
		}
		return role;
	}

	public void DepositMoney(String useremail, double balance) throws SQLException {
		// TODO Auto-generated method stub
		double balanced = 0;
		String sql1 ="select a.balance from userinfo u join account a  "
				+ "WHERE u.userid = a.userid  AND u.useremail = ?";
		ps = conn.prepareStatement(sql1);
		ps.setString(1,useremail);
		rs = ps.executeQuery();	
		if (rs.next()) { // Move the cursor to the first row
			balanced  = rs.getInt(1); // Retrieve the value of userrole
	       // System.out.println(balanced);
		}
		balance = balanced+balance;
        
		sql = "UPDATE userinfo u, account a SET a.balance = ?"
				+ "WHERE u.userid = a.userid  AND u.useremail = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(2, useremail);
		ps.setDouble(1, balance);
		int upm = ps.executeUpdate();
	}

	public void WithdrawMoney(String  useremail, double balance) throws SQLException {
		// TODO Auto-generated method stub
		double balanced = 0;
		String sql1 ="select a.balance from userinfo u join account a  "
				+ "WHERE u.userid = a.userid  AND u.useremail = ?";
		ps = conn.prepareStatement(sql1);
		ps.setString(1,useremail);
		rs = ps.executeQuery();	
		if (rs.next()) { // Move the cursor to the first row
			balanced  = rs.getInt(1); // Retrieve the value of userrole
	       // System.out.println(balanced);
		}
		balance = balanced-balance;
        
		sql = "UPDATE userinfo u, account a SET a.balance = ?"
				+ "WHERE u.userid = a.userid  AND u.useremail = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(2, useremail);
		ps.setDouble(1, balance);
		int upm = ps.executeUpdate();
	}

	@Override
	public User searchUserByAccountno(int accno) throws SQLException {
		
		sql="select u.userid,username,useremail,usercontact,userdob,userpan,useraadhar,useraddress,userpass,userrole,accno,acctype,balance,status"
				+ " from userinfo u join account a on u.userid=a.userid where accno=?";
		ps=conn.prepareStatement(sql);	
		ps.setInt(1, accno);
		System.out.println("query:"+ps);
		rs=ps.executeQuery();

		while(rs.next()) {
			user=new User();
			user.setUserid(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setUseremail(rs.getString(3));
			user.setUsercontact(rs.getString(4));
			user.setUserdob(rs.getString(5));
			user.setUserpan(rs.getString(6));
			user.setUseraadhar(rs.getString(7));
			user.setUseraddress(rs.getString(8));
			user.setUserpass(rs.getString(9));
			user.setUserrole(rs.getString(10));
			//account=new Account(rs.getInt(11),rs.getString(12),rs.getDouble(13),rs.getString(14));
			//account=new Account();
			//account.setAccount_no(rs.getInt(11));
			account  = new Account(rs.getInt(11),rs.getString(12),rs.getDouble(13),rs.getString(14));
			user.setAccount(account);
		}
		return user;
	}
	public boolean Transaction(String email,int racc, int amt) throws SQLException {
		int uacc = 0 ;
		double ubal = 0;
		String sql = " select a.accno,a.balance"
				+ " from userinfo u join account a"
				+ " on u.userid = a.userid "
				+ " where u.useremail = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		rs = ps.executeQuery();
		while (rs.next()) {
			uacc = rs.getInt(1);
			ubal = rs.getDouble(2);
		}
		
		System.out.println(ubal +" "+uacc);
		
		if ( (ubal - amt) > 1000 ) {
			String sql1 = "update account set balance = ? where accno = ?";
			ps = conn.prepareStatement(sql1);
			ps.setDouble(1, ubal-amt);
			ps.setInt(2, uacc);
			ps.executeUpdate();
			
			String sql2 = "update account set balance = balance+ ? where accno = ?";
			ps = conn.prepareStatement(sql2);
			ps.setDouble(1,amt);
			ps.setInt(2, racc);
			ps.executeUpdate();

			
			Calendar currenttime = Calendar.getInstance();
			Date sqldateDate = new Date(currenttime.getTime().getTime());

			System.out.println(sqldateDate);

			String sql3 = "INSERT INTO transaction (accnofrom, accnoto, ttype, tamt, tdate) VALUES (?, ?, ?, ?, ?)";
			
			    PreparedStatement ps = conn.prepareStatement(sql3);
			    ps.setInt(1, uacc);
			    ps.setInt(2, racc);
			    ps.setString(3, "Credit Amount");
			    ps.setDouble(4, amt);
			    ps.setDate(5, sqldateDate);
			    ps.executeUpdate();
			    System.out.println("Insertion Successful");		

		}
	
		return false;
		
	}
	public void ActivateUser(int accno) throws SQLException {
		String sql = "update account set status = ? where accno = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, "Active");
		ps.setInt(2, accno);
		ps.executeUpdate();
		
		System.out.println("Account Activated");
	}
	

	public String findusername(int accno, String email) throws SQLException {
	    String name1 = "";
	    sql = "select u.username from userinfo u join account a on u.userid = a.userid where a.accno = ?";
	    ps = conn.prepareStatement(sql);
	    ps.setInt(1, accno);  // Set the parameter value
	    rs = ps.executeQuery();
	    if (rs.next()) {
	        name1 = rs.getString(1);
	    }
	 //   System.out.println(name1);
	    return name1;
	}

}

