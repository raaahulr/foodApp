package com.tapfoods.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.DriverManager;
import com.tapfoods.dao.OrderHistoryDao;
import com.tapfoods.dbutils.DBUtils;
import com.tapfoods.model.OrderHistory;

public class OrderHistoryDaoImp implements OrderHistoryDao {
 
	Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;;
	private ResultSet resultSet;
	
	ArrayList<OrderHistory> orderHistoryList= new ArrayList<OrderHistory>();
	OrderHistory orderHistory;
	
	private static final String ADD_ORDER_HISTORY="insert into `orderhistory`(`fk_orderId`,`fk_userId`,`totalAmount`,`status`)"
			+"values(?,?,?,?)";
	private static final String SELECT_ALL="select * from `orderhistory`";
	private static final String SELECT_ON_USERID="select * from `orderhistory` where `fk_userId`=?";
	private static final String SELECT_ON_ID="select * from `orderhistory` where `orderHistoryId`=?";
	private static final String UPDATE_ON_ID="update `orderhistory` set `fk_orderId`=?,`fk_userId`=?,`totalAmount`=?,`status`=? where `orderHistoryId`=?";
	private static final String DELETE_ON_ID="delete from `orderhistory` where `orderHistoryId`=?";
	
	int status=0;
	
	public OrderHistoryDaoImp() {
		try {
			 
			con=DBUtils.myConnect();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int addOrderHistory(OrderHistory oh) {
		 try {
			 pstmt=con.prepareStatement(ADD_ORDER_HISTORY);
			 pstmt.setInt(1,oh.getOrderId());
			 pstmt.setInt(2,oh.getUserId());
//			 pstmt.setDate(3, new java.sql.Date(oh.getOrderDate().getTime()));
			 pstmt.setDouble(3,oh.getTotalAmount());
			 pstmt.setString(4,oh.getStatus());
			 
			 status=pstmt.executeUpdate();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		return status;
	}
	@Override
	public ArrayList<OrderHistory> getAllOrderHistories() {
		try {
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(SELECT_ALL);
			orderHistoryList=extractOrderHistoryFromResultSet(resultSet);
		} 
		catch (SQLException e) {
			 
			e.printStackTrace();
		}
		return orderHistoryList;
	}
	
	@Override
	public OrderHistory getOrderHistory(int orderHistoryId) {

		try {
			pstmt=con.prepareStatement(SELECT_ON_ID);
			pstmt.setInt(1, orderHistoryId);
			resultSet=pstmt.executeQuery();
			orderHistoryList=extractOrderHistoryFromResultSet(resultSet);
			orderHistory=orderHistoryList.get(0);
		}
		catch (Exception e) {

			e.printStackTrace();
		}

		return orderHistory;
	}
	
	@Override
	public int updateOrderHistory(OrderHistory oh) {
		 try {
			pstmt =con.prepareStatement(UPDATE_ON_ID);
			 pstmt.setInt(1,oh.getOrderId());
			 pstmt.setInt(2,oh.getUserId());
//			 pstmt.setDate(3, new java.sql.Date(oh.getOrderDate().getTime()));
			 pstmt.setDouble(4,oh.getTotalAmount());
			 pstmt.setString(5,oh.getStatus());
			 pstmt.setInt(7,oh.getOrderHistoryId());
			 
			 status=pstmt.executeUpdate();
		 }
		 catch (Exception e) {

			 e.printStackTrace();
		 }
		 return status;
	}
	
	@Override
	public int deleteOrderHistory(int orderHistoryId) {
		try {
			pstmt=con.prepareStatement(DELETE_ON_ID);
			pstmt.setInt(1, orderHistoryId);
			
			status=pstmt.executeUpdate();
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		return status;
		
	}
	
	//collects all the orderhistory and returns to the getall
	ArrayList<OrderHistory> extractOrderHistoryFromResultSet(ResultSet resultSet){
		try {
			while(resultSet.next()){
				orderHistoryList.add(new OrderHistory (resultSet.getInt("orderHistoryId"),
				resultSet.getInt("fk_orderId"),
				resultSet.getInt("fk_userId"),
				resultSet.getDouble("totalAmount"),
				resultSet.getString("status"),
				resultSet.getString("orderDate")));
			}
		} 
		catch (Exception  e) {
			 
			e.printStackTrace();
		}
		return orderHistoryList;
	}

	@Override
	public ArrayList<OrderHistory> getHistory(int fk_userId) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(SELECT_ON_USERID);
			pstmt.setInt(1, fk_userId);
			resultSet=pstmt.executeQuery();
			orderHistoryList=extractOrderHistoryFromResultSet(resultSet);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return orderHistoryList;
	}
}