package com.tapfoods.dao;

import java.util.ArrayList;

import com.tapfoods.model.OrderHistory;

public interface OrderHistoryDao {
	
	int addOrderHistory(OrderHistory oh);
	ArrayList<OrderHistory> getAllOrderHistories();
	ArrayList<OrderHistory> getHistory(int fk_orderId);
	OrderHistory getOrderHistory(int orderHistoryId);
	int updateOrderHistory(OrderHistory oh);
	int deleteOrderHistory(int orderHistoryId);
	

}