package com.tapfoods.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.DriverManager;
import com.tapfoods.dao.UserDao;
import com.tapfoods.dbutils.DBUtils;
import com.tapfoods.model.User;

public class UserDaoImp implements UserDao {
 
	Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;;
	private ResultSet resultSet;
	
	ArrayList<User> userList= new ArrayList<User>();
	User user;
	
	private static final String ADD_USER="insert into `user`(`username`,`email`,`password`,`phonenumber`,`address`)"
			+"values(?,?,?,?,?)";
	private static final String SELECT_ALL="select * from `user`";
	private static final String SELECT_ON_EMAIL="select * from `user` where `email`=?";
	private static final String UPDATE_ON_EMAIL="update `user` set `username`=?,`password`=?,`phonenumber`=?,`address`=? where `email`=?";
	private static final String DELETE_ON_EMAIL="delete from `user` where `email`=?";
	
	int status=0;
	
	public UserDaoImp() {
		try {
			 
			con=DBUtils.myConnect();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int addUser(User u) {
		 try {
			 pstmt=con.prepareStatement(ADD_USER);
			 pstmt.setString(1,u.getUsername());
			 pstmt.setString(2,u.getEmail());
			 pstmt.setString(3,u.getPassword());
			 pstmt.setString(4,u.getPhonenumber());
			 pstmt.setString(5,u.getAddress());
			 
			 status=pstmt.executeUpdate();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		return status;
	}
	
	@Override
	public ArrayList<User> getAllUser() {
		try {
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(SELECT_ALL);
			userList=exractUserFromresultSet(resultSet);
		} 
		catch (SQLException e) {
			 
			e.printStackTrace();
		}
		return userList;
	}
	
	@Override
	public User getUser(String email) {

		try {
			pstmt=con.prepareStatement(SELECT_ON_EMAIL);
			pstmt.setString(1, email);
			resultSet=pstmt.executeQuery();
			userList=exractUserFromresultSet(resultSet);
			user=userList.get(0);
		}
		catch (Exception e) {

			e.printStackTrace();
		}

		return user;
	}
	
	@Override
	public int updateUser(User u) {
		 try {
			pstmt =con.prepareStatement(UPDATE_ON_EMAIL);
			 pstmt.setString(1,u.getUsername());
			 pstmt.setString(2,u.getPassword());
			 pstmt.setString(3,u.getPhonenumber());
			 pstmt.setString(4,u.getAddress());
			 pstmt.setString(5,u.getEmail());
			 
			 status=pstmt.executeUpdate();
		 }
		 catch (Exception e) {

			 e.printStackTrace();
		 }
		 return status;
	}
	
	@Override
	public int deleteUser(String email) {
		try {
			pstmt=con.prepareStatement(UPDATE_ON_EMAIL);
			pstmt.setString(1, email);
			
			status=pstmt.executeUpdate();
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		return status;
		
	}
	
	//collects all the user and returns to the getall
	ArrayList<User> exractUserFromresultSet(ResultSet resultSet){
		try {
			
			while(resultSet.next()){
				
				userList.add(new User (resultSet.getInt("userId"),
				resultSet.getString("username"),
				resultSet.getString("email"),
				resultSet.getString("password"),
				resultSet.getString("phonenumber"),
				resultSet.getString("address")));
			}
		} 
		catch (SQLException e) {
			 
			e.printStackTrace();
		}
		return userList;
	}
}
