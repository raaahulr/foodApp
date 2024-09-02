package com.tapfoods.dao;

import java.util.ArrayList;

import com.tapfoods.model.OrderTable;

public interface OrderTableDao {
	
	int addOrder(OrderTable o);
	ArrayList<OrderTable> getAllOrders();
	OrderTable getOrder(int orderId);
	int updateOrder(OrderTable o);
	int deleteOrder(int orderId);

}