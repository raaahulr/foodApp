<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.tapfoods.model.OrderHistory"%>
<%@ page import="java.util.List"%>

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

  /* Style the order card */
  .order-card {
    background-color: #fff; /* White background */
    padding: 20px;
    margin: 20px;
    border: 1px solid #ccc; /* Light gray border */
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    display: flex; /* Add flexbox */
    justify-content: space-between; /* Space out the order info and action */
  }

  /* Style the order info */
  .order-info {
    flex: 1; /* Take up the available space */
  }

  /* Style the order info paragraphs */
  .order-info p {
    margin-bottom: 10px;
  }

  /* Style the order info spans */
  .order-info span {
    font-weight: bold;
    margin-right: 10px;
  }

  /* Style the order action */
  .order-action {
    margin-left: 20px;
  }

  /* Style the view link */
  .order-action a {
    text-decoration: none;
    color: #337ab7; /* Blue text */
  }

  .order-action a:hover {
    color: #23527c; /* Darker blue hover effect */
  }

  /* Style the no orders found message */
  p {
    text-align: center;
    color: #666; /* Dark gray text */
  }
</style>
</head>
<body>
<% List<OrderHistory> list = (List<OrderHistory>) session.getAttribute("list"); %>
        <% if (list != null && !list.isEmpty()) { %>
            <% for(OrderHistory e : list) { %>
                <div class="order-card">
                    <div class="order-info">
                        <p><span>Order History ID:</span> <%= e.getOrderHistoryId() %></p>
                        <p><span>Order ID:</span> <%= e.getOrderId() %></p>
                        <p><span>Status:</span> <%= e.getStatus() %></p>
                        <p><span>Total Amount:</span> <%= e.getTotalAmount() %></p>
                        <p><span>Order Date:</span> <%= e.getOrderDate() %></p>
                    </div>
                    <div class="order-action">
                        <a href="HistorybsedOnOrderId?OrderId=<%= e.getOrderId() %>">View</a>
                    </div>
                </div>
            <% } %>
        <% } else { %>
            <p>No orders found.</p>
        <% } %>

</body>
</html>