package com.tapfoods.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.tapfoods.dao.MenuDao;
import com.tapfoods.dbutils.DBUtils;
import com.tapfoods.model.Menu;

public class MenuDaoImp implements MenuDao {
 
	Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;;
	private ResultSet resultSet;
	
	ArrayList<Menu> menuList= new ArrayList<Menu>();
	Menu menu;
	
	private static final String ADD_MENU="insert into `menu`(`restaurantId`,`menuName`,`price`,`description`,`isActive)"
			+"values(?,?,?,?,?)";
	private static final String SELECT_ALL="select * from `menu`";
	private static final String SELECT_ON_ID="select * from `menu` where restaurantId=?";
	private static final String UPDATE_ON_ID="update `menu` set `restaurantId`=?,`menuName`=?,`price`=?,`description`=?,`isActive`=? where `menuId`=?";
	private static final String DELETE_ON_ID="delete from `menu` where `menuId`=?";
	private static final String SELECT_ON_MENU_ID="select * from `menu` where menuId=?";
	
	int status=0;
	
	public MenuDaoImp() {
		try {
			 
			con=DBUtils.myConnect();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int addMenu(Menu m) {
		 try {
			 pstmt=con.prepareStatement(ADD_MENU);
			 pstmt.setInt(1,m.getRestaurantId());
			 pstmt.setString(2,m.getMenuName());
			 pstmt.setDouble(3,m.getPrice());
			 pstmt.setString(4,m.getDescription());
			 pstmt.setBoolean(5,m.isActive());
			 
			 status=pstmt.executeUpdate();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		return status;
	}
	
	@Override
	public ArrayList<Menu> getAllMenus() {
		try {
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(SELECT_ALL);
			menuList=extractMenuFromResultSet(resultSet);
		} 
		catch (Exception e) {
			 
			e.printStackTrace();
		}
		return menuList;
	}
	
	@Override
	public Menu getOnMenuId(int menuId) {

		try {
			pstmt=con.prepareStatement(SELECT_ON_MENU_ID);
			pstmt.setInt(1, menuId);
			resultSet=pstmt.executeQuery();
			menuList=extractMenuFromResultSet(resultSet);
			menu=menuList.get(0);
		}
		catch (Exception e) {

			e.printStackTrace();
		}

		return menu;
	}
	@Override
	public ArrayList<Menu> getMenu(int restaurantId) {
		
		try {
			pstmt=con.prepareStatement(SELECT_ON_ID);
			pstmt.setInt(1, restaurantId);
			resultSet=pstmt.executeQuery();
			menuList=extractMenuFromResultSet(resultSet);
//			menu=menuList.get(0);
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return menuList;
	}
	
	@Override
	public int updateMenu(Menu m) {
		 try {
			pstmt =con.prepareStatement(UPDATE_ON_ID);
			 pstmt.setInt(1,m.getRestaurantId());
			 pstmt.setString(2,m.getMenuName());
			 pstmt.setDouble(3,m.getPrice());
			 pstmt.setString(4,m.getDescription());
			 pstmt.setBoolean(5,m.isActive());
			 pstmt.setInt(6,m.getMenuId());
			 
			 status=pstmt.executeUpdate();
		 }
		 catch (Exception e) {

			 e.printStackTrace();
		 }
		 return status;
	}
	
	@Override
	public int deleteMenu(int menuId) {
		try {
			pstmt=con.prepareStatement(DELETE_ON_ID);
			pstmt.setInt(1, menuId);
			
			status=pstmt.executeUpdate();
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		return status;
		
	}
	
	//collects all the menu and returns to the getall
	ArrayList<Menu> extractMenuFromResultSet(ResultSet resultSet){
	    try {
	        while(resultSet.next()){
	            menuList.add(new Menu (resultSet.getInt("menuId"),
	            resultSet.getInt("restaurantId"),
	            resultSet.getString("menuName"),
	            resultSet.getDouble("price"),
	            resultSet.getString("description"),
	            resultSet.getBoolean("isActive")));
	        }
	    } 
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	    return menuList;
	}
}