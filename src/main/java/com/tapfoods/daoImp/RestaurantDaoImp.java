package com.tapfoods.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.DriverManager;
import com.tapfoods.dao.RestaurantDao;
import com.tapfoods.dbutils.DBUtils;
import com.tapfoods.model.Restaurant;

public class RestaurantDaoImp implements RestaurantDao {
 
	Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;;
	private ResultSet resultSet;
	
	ArrayList<Restaurant> restaurantList= new ArrayList<Restaurant>();
	Restaurant restaurant;
	
	private static final String ADD_RESTAURANT="insert into `restaurant`(`restaurantName`,`deliveryTime`,`cuisinType`,`address`,`rating`,`isActive`,`adminId`)"
			+"values(?,?,?,?,?,?,?)";
	private static final String SELECT_ALL="select * from `restaurant`";
	private static final String SELECT_ON_ID="select * from `restaurant` where `restaurantId`=?";
	private static final String UPDATE_ON_ID="update `restaurant` set `restaurantName`=?,`deliveryTime`=?,`cuisinType`=?,`address`=?,`rating`=?,`isActive`=?,`adminId`=? where `restaurantId`=?";
	private static final String DELETE_ON_ID="delete from `restaurant` where `restaurantId`=?";
	
	int status=0;
	
	public RestaurantDaoImp() {
		try {
			 
			con=DBUtils.myConnect();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int addRestaurant(Restaurant r) {
		 try {
			 pstmt=con.prepareStatement(ADD_RESTAURANT);
			 pstmt.setString(1,r.getRestaurantName());
			 pstmt.setInt(2,r.getDeliveryTime());
			 pstmt.setString(3,r.getCuisinType());
			 pstmt.setString(4,r.getAddress());
			 pstmt.setDouble(5,r.getRating());
			 pstmt.setBoolean(6,r.isActive());
			 pstmt.setInt(7,r.getAdminId());
			 
			 status=pstmt.executeUpdate();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		return status;
	}
	
	@Override
	public ArrayList<Restaurant> getAllRestaurants() {
		try {
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(SELECT_ALL);
			restaurantList=extractRestaurantFromResultSet(resultSet);
		} 
		catch (SQLException e) {
			 
			e.printStackTrace();
		}
		return restaurantList;
	}
	
	@Override
	public Restaurant getRestaurant(int restaurantId) {

		try {
			pstmt=con.prepareStatement(SELECT_ON_ID);
			pstmt.setInt(1, restaurantId);
			resultSet=pstmt.executeQuery();
			restaurantList=extractRestaurantFromResultSet(resultSet);
			restaurant=restaurantList.get(0);
		}
		catch (Exception e) {

			e.printStackTrace();
		}

		return restaurant;
	}
	
	@Override
	public int updateRestaurant(Restaurant r) {
		 try {
			pstmt =con.prepareStatement(UPDATE_ON_ID);
			 pstmt.setString(1,r.getRestaurantName());
			 pstmt.setInt(2,r.getDeliveryTime());
			 pstmt.setString(3,r.getCuisinType());
			 pstmt.setString(4,r.getAddress());
			 pstmt.setDouble(5,r.getRating());
			 pstmt.setBoolean(6,r.isActive());
			 pstmt.setInt(7,r.getAdminId());
			 pstmt.setInt(8,r.getRestaurantId());
			 
			 status=pstmt.executeUpdate();
		 }
		 catch (Exception e) {

			 e.printStackTrace();
		 }
		 return status;
	}
	
	@Override
	public int deleteRestaurant(int restaurantId) {
		try {
			pstmt=con.prepareStatement(DELETE_ON_ID);
			pstmt.setInt(1, restaurantId);
			
			status=pstmt.executeUpdate();
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		return status;
		
	}
	
	//collects all the restaurant and returns to the getall
	ArrayList<Restaurant> extractRestaurantFromResultSet(ResultSet resultSet){
		try {
			
			while(resultSet.next()){
				
				restaurantList.add(new Restaurant (resultSet.getInt("restaurantId"),
				resultSet.getString("restaurantName"),
				resultSet.getInt("deliveryTime"),
				resultSet.getString("cuisinType"),
				resultSet.getString("address"),
				resultSet.getDouble("rating"),
				resultSet.getBoolean("isActive"),
				resultSet.getInt("adminId")));
			}
		} 
		catch (SQLException e) {
			 
			e.printStackTrace();
		}
		return restaurantList;
	}
}