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

import com.tapfoods.dao.OrderTableDao;
import com.tapfoods.dbutils.DBUtils;
import com.tapfoods.model.OrderTable;


public class OrderTableDaoImp implements OrderTableDao {
 
	Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;;
	private ResultSet resultSet;
	
	ArrayList<OrderTable> orderList= new ArrayList<OrderTable>();
	OrderTable order;
	
	
	
	private static final String ADD_ORDER="insert into `ordertable`(`restaurantId`,`userId`,`totalAmount`,`status`,`paymentmode`)"
			+"values(?,?,?,?,?)";
	private static final String SELECT_ALL="select * from `ordertable`";
	private static final String SELECT_ON_ID="select * from `ordertable` where `orderId`=?";
	private static final String UPDATE_ON_ID="update `ordertable` set `restaurantId`=?,`userId`=?,`orderDate`=?,`totalAmount`=?,`status`=?,`paymentmode`=? where `orderId`=?";
	private static final String DELETE_ON_ID="delete from `ordertable` where `orderId`=?";
	
	int status=0;
	
	public OrderTableDaoImp() {
		try {
			 
			con=DBUtils.myConnect();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int addOrder(OrderTable o) {
		int orderId=0;
		 try {
			 pstmt=con.prepareStatement(ADD_ORDER,Statement.RETURN_GENERATED_KEYS);
			 pstmt.setInt(1,o.getRestaurantId());
			 pstmt.setInt(2,o.getUserId());
//			 pstmt.setDate(3, new java.sql.Date(o.getOrderDate().getTime()));
			 pstmt.setDouble(3,o.getTotalAmount());
			 pstmt.setString(4,o.getStatus());
			 pstmt.setString(5,o.getPaymentMode());
			 
			 status=pstmt.executeUpdate();
			 if(status>0) {
				 resultSet=pstmt.getGeneratedKeys();
				 if(resultSet.next()) {
					 orderId=resultSet.getInt(1);
				 }
			 }
			 
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		return orderId;
	}
	
	@Override
	public ArrayList<OrderTable> getAllOrders() {
		try {
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(SELECT_ALL);
			orderList=extractOrderFromResultSet(resultSet);
		} 
		catch (SQLException e) {
			 
			e.printStackTrace();
		}
		return orderList;
	}
	
	@Override
	public OrderTable getOrder(int orderId) {

		try {
			pstmt=con.prepareStatement(SELECT_ON_ID);
			pstmt.setInt(1, orderId);
			resultSet=pstmt.executeQuery();
			orderList=extractOrderFromResultSet(resultSet);
			order=orderList.get(0);
		}
		catch (Exception e) {

			e.printStackTrace();
		}

		return order;
	}
	
	@Override
	public int updateOrder(OrderTable o) {
		 try {
			pstmt =con.prepareStatement(UPDATE_ON_ID);
			 pstmt.setInt(1,o.getRestaurantId());
			 pstmt.setInt(2,o.getUserId());
//			 pstmt.setDate(3, new java.sql.Date(o.getOrderDate().getTime()));
			 pstmt.setDouble(3,o.getTotalAmount());
			 pstmt.setString(4,o.getStatus());
			 pstmt.setString(5,o.getPaymentMode());
			 pstmt.setInt(6,o.getOrderId());
			 
			 status=pstmt.executeUpdate();
		 }
		 catch (Exception e) {

			 e.printStackTrace();
		 }
		 return status;
	}
	
	@Override
	public int deleteOrder(int orderId) {
		try {
			pstmt=con.prepareStatement(DELETE_ON_ID);
			pstmt.setInt(1, orderId);
			
			status=pstmt.executeUpdate();
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		return status;
		
	}
	
	//collects all the order and returns to the getall
	ArrayList<OrderTable> extractOrderFromResultSet(ResultSet resultSet) {
		try {
			while(resultSet.next()){
				orderList.add(new OrderTable (resultSet.getInt("orderId"),
				resultSet.getInt("restaurantId"),
				resultSet.getInt("userId"),
				resultSet.getDouble("totalAmount"),
				resultSet.getString("status"),
				resultSet.getString("paymentmode")));
			}
		} 
		catch (SQLException  e) {
			 
			e.printStackTrace();
		}
		return orderList;
	}
}