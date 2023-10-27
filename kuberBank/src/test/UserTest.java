package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.UserDaoImpl;
import pojo.User;



public class UserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int userid;
		 String username;
		 String useremail;
		 String usercontact;
		 String userdob;
		 String userpan;
		 String useraadhar;
		 String useraddress;
		 String userpass;
		 String userrole;
		 User user;
		 UserDaoImpl userdao=new UserDaoImpl();
		 boolean result;
		 int choice;
		 char ch;
		 Scanner sc=new Scanner(System.in);
		 
		 System.out.println("Enter Email id :");
		 String email = sc.next();
		 System.out.println("Enter Passward:");
		 String check = "";
		 String pass = sc.next();
		 try {
		 check = userdao.checkUserEmailPass(email,pass);
		 }catch (SQLException e ) {
			 e.printStackTrace();
		 }
		 if (check.equals("Admin")) {
		 
		 do {
		 System.out.println("-----welcome to kuberbank-----");
		 System.out.println("1.add user");
		 System.out.println("2.update user");
		 System.out.println("3.delete user");
		 System.out.println("4.show user list");
		 System.out.println("5.show user list with Account details");
		 System.out.println("6.search user by id");
		 System.out.println("7.search user by email");
		 System.out.println("8.search user by account");
		 System.out.println("9.search user by aadhar");
		 System.out.println("10.Activate User");
		 System.out.println("---------------------------------");
		 
		 System.out.println("Enter your choice:");
		 choice=sc.nextInt();
		 
		 
			 switch(choice) {
			 case 1:
				 System.out.println("Enter user name:");
				 username=sc.next();
				 System.out.println("Enter user email:");
				 useremail=sc.next();
				 System.out.println("Enter user contact:");
				 usercontact=sc.next();
				 System.out.println("Enter user dob:");
				 userdob=sc.next();
				 System.out.println("Enter user pan:");
				 userpan=sc.next();
				 System.out.println("Enter user aadhar:");
				 useraadhar=sc.next();
				 System.out.println("Enter user address:");
				 useraddress=sc.next();
				 System.out.println("Enter user password:");
				 userpass=sc.next();
				 user=new User(username, useremail, usercontact, userdob, userpan, useraadhar, useraddress, userpass);
				 try {
					result=userdao.addUser(user);
					if(result)
						System.out.println("user added successfully");
					else
						System.out.println("user not added");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 break;
			 case 2:
				 System.out.println("Enter user id");
				 userid = sc.nextInt();
				 System.out.println("Enter user name:");
				 username=sc.next();
				 System.out.println("Enter user email:");
				 useremail=sc.next();
				 System.out.println("Enter user contact:");
				 usercontact=sc.next();
				 System.out.println("Enter user dob:");
				 userdob=sc.next();
				 System.out.println("Enter user pan:");
				 userpan=sc.next();
				 System.out.println("Enter user aadhar:");
				 useraadhar=sc.next();
				 System.out.println("Enter user address:");
				 useraddress=sc.next();
				 System.out.println("Enter user password:");
				 userpass=sc.next();
				 user=new User(userid,username, useremail, usercontact, userdob, userpan, useraadhar, useraddress, userpass);
				 try {
					result=userdao.updateUser(user);
					if(result)
						System.out.println("user updated successfully");
					else
						System.out.println("user not added");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 break;
			 case 3:
				 System.out.println("Enter userid:");
				 userid = sc.nextInt();
				 try {
						result=userdao.deleteUser(userid);
						System.out.println(result);
						if(!result)
							System.out.println("user deleted successfully");
						else
							System.out.println("user not deleted");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 break;
			 case 4:
				 try {
					    List<User> l = new ArrayList<>();
						l=userdao.showUserList();
						System.out.println(l);
						if(l != null)
							System.out.println("user showed successfully");
						else
							System.out.println("error");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 break;
				 
			 case 5:
				 System.out.println("Account detail:");
				
				 try {
					    
						userdao.showUserWithAccount();
			
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 break;
			
			 case 6:
				
				 System.out.println("Enter userid:");
				 userid = sc.nextInt();
				 try {
					user = userdao.searchUserByUserid(userid);
					System.out.println(user);
				 }catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 break;
			 case 7:
				 System.out.println("Enter Email:");
				 useremail = sc.next();
				 try {
						user = userdao.searchUserByEmail(useremail);
						System.out.println(user);
					 }catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 break;
			 case 8:
				 System.out.println("Enter Account Number:");
				 int accno = sc.nextInt();
				 try {
						user = userdao.searchUserByAccountno(accno);
						System.out.println(user);
					 }catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 break;
			 case 9:
					
				 System.out.println("Enter adhar Number:");
				 useraadhar = sc.next();
				 try {
					user = userdao.searchUserByAadhar(useraadhar);
					System.out.println(user);
				 }catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 break;
			 case 10:
				 System.out.println("Enter Account Number");
				 accno = sc.nextInt();
				 
				 try {
					userdao.ActivateUser(accno);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				 
				 break;
			 }
			 
			 	 
			 System.out.println("do you want to continue if yes enter y:");
			 ch=sc.next().charAt(0);
		 }while(ch=='y'|| ch=='Y');
		 }
		 else if (check.equals("user")) {
			char ch1 = 0;
			
			 do {
				 
				 System.out.println("1. Deposit");
				 System.out.println("2. Credit");
				 System.out.println("3. Transfer");
				 System.out.println("4. Payee");
				 
				 System.out.println("Enter your choice");
				 int choice1 = sc.nextInt();
				 
				 switch(choice1) {
				 case 1:
					 System.out.println("---Deposit Money---");
					 System.out.println("Entery Money you want to deposit:");
					 double dmoney = sc.nextInt();
					 try {
						 userdao.DepositMoney(email,dmoney);
					 }catch(SQLException e) {
						 e.printStackTrace();
					 }
					 break;
				 case 2:
					 System.out.println("---Withdraw Money---");
					 System.out.println("Entery Money you want to Credit:");
					 double cmoney = sc.nextInt();
					 try {
						 userdao.WithdrawMoney(email,cmoney);
					 }catch(SQLException e) {
						 e.printStackTrace();
					 }
					 break;
				 case 3:
					 System.out.println("---Transfer Money---");
					 System.out.println("Entery Account Number you want to Transfer:");
					 int taccnumber = sc.nextInt();
					 System.out.println("Enter money you want to transfer:");
					 int tmoney = sc.nextInt();
					 try {
						 userdao.Transaction(email,taccnumber,tmoney);
					 }catch(SQLException e) {
						 e.printStackTrace();
					 }
					 break;
				 case 4:
					 HashMap<Integer, String> payees = new HashMap<Integer, String>();
					 int accno = 0;
					 String name ="";
					 do {
					 int num;
					 System.out.println("1.Add user in payee");
					 System.out.println("2.Remove user from payee");
					 System.out.println("3.Transaction");
					 num = sc.nextInt();
					 switch(num) {
					 case 1: 
						 System.out.println("Enter Account number to add user:");
						 accno = sc.nextInt();
						 try {
							name =userdao.findusername(accno,email);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					//	 System.out.println(name);
						 payees.put(accno, name);
						 break;
					 case 2:
						 System.out.println("Enter Account number you want to remove");
						 email = sc.next();
						 payees.remove(accno);
						 break;
					 case 3:
						 for ( Map.Entry<Integer, String> m : payees.entrySet()) {
							 System.out.println(m.getKey()+" "+m.getValue());
						 }
						 System.out.println("Enter Account Number:");
						 int n = sc.nextInt();
						 System.out.println("Enter Money:");
						 int m = sc.nextInt();
						 try {
							 userdao.Transaction(email,accno,m);
						 }catch(SQLException e) {
							 e.printStackTrace();
						 }
						 break;
					 }
					 System.out.println("do you want to continue if yes enter y:");
					 ch1 = sc.next().charAt(0);
					 }while(ch1=='y'|| ch1=='Y');
				 }
				 
				 System.out.println("do you want to continue if yes enter y:");
				 ch1 = sc.next().charAt(0);
			 }while(ch1=='y'|| ch1=='Y');
		 }
		 else {
			 System.out.println("Enter valid id And Pass Or Account Inactive");
		 }
	}

}