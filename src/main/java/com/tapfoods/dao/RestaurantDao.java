package com.tapfoods.dao;

import java.util.ArrayList;

import com.tapfoods.model.Restaurant;

public interface RestaurantDao {

	int addRestaurant(Restaurant r);
	ArrayList<Restaurant> getAllRestaurants();
	Restaurant getRestaurant(int restaurantId);
	int updateRestaurant(Restaurant r);
	int deleteRestaurant(int restaurantId);
}
