package com.tapfoods.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.DriverManager;
import com.tapfoods.dao.OrderItemDao;
import com.tapfoods.dbutils.DBUtils;
import com.tapfoods.model.OrderItem;

public class OrderItemDaoImp implements OrderItemDao {
 
	Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;;
	private ResultSet resultSet;
	
	ArrayList<OrderItem> orderItemList= new ArrayList<OrderItem>();
	OrderItem orderItem;
	
	private static final String ADD_ORDER_ITEM="insert into `orderitem`(`orderId`,`menuId`,`quantity`,`itemTotal`)"
			+"values(?,?,?,?)";
	private static final String SELECT_ALL="select * from `orderitem`";
	private static final String SELECT_ON_ID="select * from `orderitem` where `orderItemId`=?";
	private static final String UPDATE_ON_ID="update `orderitem` set `orderId`=?,`menuId`=?,`quantity`=?,`itemTotal`=? where `orderItemId`=?";
	private static final String DELETE_ON_ID="delete from `orderitem` where `orderItemId`=?";
	
	int status=0;
	
	public OrderItemDaoImp() {
		try {
			 
			con=DBUtils.myConnect();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int addOrderItem(OrderItem oi) {
		 try {
			 pstmt=con.prepareStatement(ADD_ORDER_ITEM);
			 pstmt.setInt(1,oi.getOrderId());
			 pstmt.setInt(2,oi.getMenuId());
			 pstmt.setInt(3,oi.getQuantity());
			 pstmt.setDouble(4,oi.getItemTotal());
			 
			 status=pstmt.executeUpdate();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		return status;
	}
	
	@Override
	public ArrayList<OrderItem> getAllOrderItems() {
		try {
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(SELECT_ALL);
			orderItemList=extractOrderItemFromResultSet(resultSet);
		} 
		catch (SQLException e) {
			 
			e.printStackTrace();
		}
		return orderItemList;
	}
	
	@Override
	public OrderItem getOrderItem(int orderItemId) {

		try {
			pstmt=con.prepareStatement(SELECT_ON_ID);
			pstmt.setInt(1, orderItemId);
			resultSet=pstmt.executeQuery();
			orderItemList=extractOrderItemFromResultSet(resultSet);
			orderItem=orderItemList.get(0);
		}
		catch (Exception e) {

			e.printStackTrace();
		}

		return orderItem;
	}
	
	@Override
	public int updateOrderItem(OrderItem oi) {
		 try {
			pstmt =con.prepareStatement(UPDATE_ON_ID);
			 pstmt.setInt(1,oi.getOrderId());
			 pstmt.setInt(2,oi.getMenuId());
			 pstmt.setInt(3,oi.getQuantity());
			 pstmt.setDouble(4,oi.getItemTotal());
			 pstmt.setInt(5,oi.getOrderItemId());
			 
			 status=pstmt.executeUpdate();
		 }
		 catch (Exception e) {

			 e.printStackTrace();
		 }
		 return status;
	}
	
	@Override
	public int deleteOrderItem(int orderItemId) {
		try {
			pstmt=con.prepareStatement(DELETE_ON_ID);
			pstmt.setInt(1, orderItemId);
			
			status=pstmt.executeUpdate();
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		return status;
		
	}
	
	//collects all the orderitem and returns to the getall
	ArrayList<OrderItem> extractOrderItemFromResultSet(ResultSet resultSet){
		try {
			
			while(resultSet.next()){
				
				orderItemList.add(new OrderItem (resultSet.getInt("orderItemId"),
				resultSet.getInt("orderId"),
				resultSet.getInt("menuId"),
				resultSet.getInt("quantity"),
				resultSet.getDouble("itemTotal")));
			}
		} 
		catch (SQLException e) {
			 
			e.printStackTrace();
		}
		return orderItemList;
	}
}