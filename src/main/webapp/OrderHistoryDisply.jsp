<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.tapfoods.model.User"%>
<%@page import="com.tapfoods.model.OrderHistory"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order History</title>
<style>
  /* Add some basic styling to the page */
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f7f7f7; /* Light gray background */
  }

  /* Style the username */
  .username {
    text-align: right;
    padding: 10px;
    background-color: #333; /* Dark gray background */
    color: #fff; /* White text */
  }

  /* Style the order list */
  .order-list {
    display: flex; /* Add flexbox */
    flex-wrap: wrap; /* Wrap the order items */
    justify-content: center; /* Center the order items horizontally */
  }

  /* Style the order item */
  .order-item {
    background-color: #fff; /* White background */
    padding: 10px;
    margin: 10px;
    border: 1px solid #ccc; /* Light gray border */
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 250px; /* Set a fixed width for the order item */
  }

  /* Style the order item details */
  .order-id, .order-status, .order-amount {
    display: block;
    margin-bottom: 10px;
  }

  .order-id {
    font-weight: bold;
  }

  .order-status {
    color: #666; /* Dark gray text */
  }

  .order-amount {
    font-size: 18px;
    font-weight: bold;
    color: #333; /* Dark gray text */
  }

  /* Style the view link */
  .order-item a {
    text-decoration: none;
    color: #337ab7; /* Blue text */
  }

  .order-item a:hover {
    color: #23527c; /* Darker blue hover effect */
  }

  /* Style the total amount */
  .total-amount {
    text-align: right;
    padding: 10px;
    font-size: 18px;
    font-weight: bold;
    color: #333; /* Dark gray text */
  }
</style>
</head>
<body>

  <div class="username">
    <% User user = (User)session.getAttribute("loggedInUser"); %>
    Welcome, <%= user.getUsername()%>!
  </div>

  <h3>Your Order Items</h3>
  <% float sum = 0; %>

  <div class="order-list">
    <% ArrayList<OrderHistory> list = (ArrayList<OrderHistory>)session.getAttribute("HistoryList"); 
    for(OrderHistory e : list) { %>
    <div class="order-item">
      <span class="order-id">Order ID: <%= e.getOrderId() %></span> 
      <span class="order-status"><%= e.getStatus() %></span> 
      <span class="order-amount">$<%= e.getTotalAmount() %></span>
      <a href="orderItemHistory?orderId=<%=e.getOrderId()%>">View</a>
      <% sum += e.getTotalAmount(); %>
    </div>
    <% } %>
  </div>

  <div class="total-amount">
    Total Amount: $<%= sum %>
  </div>
</body>
</html>