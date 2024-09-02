package com.tapfoods.model;


public class OrderHistory {

	private int orderHistoryId;
	private int orderId;
	private int userId;
	private double totalAmount;
	private String status;
	private String orderDate;
	
	public OrderHistory() {
		super();
	}
	
	public OrderHistory(int orderHistoryId, int orderId, int userId, double totalAmount,
			String status,String orderDate) {
		super();
		this.orderHistoryId = orderHistoryId;
		this.orderId = orderId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.orderDate = orderDate;
	}
	public OrderHistory(int orderId, int userId, double totalAmount,
			String status) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	
	public OrderHistory(int orderId, int userId, double totalAmount,
			String status,String orderDate) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.orderDate = orderDate;
	}

	public int getOrderHistoryId() {
		return orderHistoryId;
	}

	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrderHistory [orderHistoryId=" + orderHistoryId + ", orderId=" + orderId + ", userId=" + userId
				 + ", totalAmount=" + totalAmount + ", status=" + status + "]"+"OrderDate="+orderDate + "]";
	}
	
	

	
	
}
