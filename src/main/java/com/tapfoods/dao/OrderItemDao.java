package com.tapfoods.dao;

import java.util.ArrayList;

import com.tapfoods.model.OrderItem;

public interface OrderItemDao {
	
	int addOrderItem(OrderItem oi);
	ArrayList<OrderItem> getAllOrderItems();
	OrderItem getOrderItem(int orderItemId);
	int updateOrderItem(OrderItem oi);
	int deleteOrderItem(int orderItemId);

}