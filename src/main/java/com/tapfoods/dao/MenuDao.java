package com.tapfoods.dao;

import java.util.ArrayList;

import com.tapfoods.model.Menu;

public interface MenuDao {

	int addMenu(Menu m);
	ArrayList<Menu> getAllMenus();
	ArrayList<Menu>  getMenu(int restaurantId);
	int updateMenu(Menu m);
	int deleteMenu(int menuId);
	Menu getOnMenuId(int menuId);

}