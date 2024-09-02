<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.tapfoods.model.Menu"%>
<%@page import="com.tapfoods.model.OrderItem"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Details</title>
<style>
  /* Add some basic styling to the page */
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f7f7f7; /* Light gray background */
  }

  /* Style the container */
  .container {
    max-width: 500px; /* Set a maximum width for the container */
    margin: 40px auto; /* Center the container horizontally */
    padding: 20px;
    background-color: #fff; /* White background */
    border: 1px solid #ccc; /* Light gray border */
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }

  /* Style the menu item */
  .menu-item {
    display: flex; /* Add flexbox */
    align-items: center; /* Vertically center the label and value */
    margin-bottom: 10px;
  }

  /* Style the label */
  .label {
    font-weight: bold;
    margin-right: 10px;
  }

  /* Style the order item */
  .order-item {
    display: flex; /* Add flexbox */
    align-items: center; /* Vertically center the label and value */
    margin-bottom: 10px;
  }
</style>
</head>
<body>
<div class="container">
        <% Menu menu = (Menu) session.getAttribute("Menu"); %>
        <% OrderItem item = (OrderItem) session.getAttribute("OrderItem"); %>

        <div class="menu-item">
            <span class="label">Menu Name:</span>
            <span><%= menu.getMenuName() %></span>
        </div>
        <div class="menu-item">
            <span class="label">Restaurant ID:</span>
            <span><%= menu.getRestaurantId() %></span>
        </div>
        <div class="menu-item">
            <span class="label">Price:</span>
            <span><%= menu.getPrice() %></span>
        </div>

        <div class="order-item">
            <span class="label">Quantity:</span>
            <span><%= item.getQuantity() %></span>
        </div>
</div>
</body>
</html>