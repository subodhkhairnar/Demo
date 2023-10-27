package dao;

import java.sql.SQLException;
import java.util.List;

import pojo.User;



	public interface UserDao {

		boolean addUser(User user)throws SQLException;
		boolean updateUser(User user)throws SQLException;
		boolean deleteUser(int userid)throws SQLException;
		List<User> showUserList()throws SQLException;
		List<User> showUserWithAccount()throws SQLException;
		User searchUserByUserid(int userid)throws SQLException;
		User searchUserByEmail(String email)throws SQLException;
	//	User searchUserByAccountno(int accno)throws SQLException;
		User searchUserByAadhar(String aadhar)throws SQLException;
		User searchUserByAccountno(int accno) throws SQLException;
	    
		
	}

