<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.tapfoods.model.OrderItem"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Item Details</title>
<style>
  /* Add some basic styling to the page */
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f7f7f7; /* Light gray background */
  }

  /* Style the order item card */
  .order-item-card {
    max-width: 500px;
    margin: 40px auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    background-color: #fff; /* White background */
    display: flex; /* Add flexbox */
    flex-direction: column; /* Stack the order item details vertically */
    align-items: center; /* Center the order item details horizontally */
  }

  .order-item-card p {
    margin-bottom: 20px;
  }

  .order-item-card span {
    font-weight: bold;
    color: #333; /* Dark gray text */
  }

  /* Style the no order item found message */
  .no-order-item-found {
    text-align: center;
    font-size: 24px;
    color: #666; /* Dark gray text */
  }
</style>
</head>
<body>
	<%
	OrderItem ot = (OrderItem) session.getAttribute("OrderItem");
	%>
	<%
	if (ot != null) {
	%>
	<div class="order-item-card">
		<p>
			<span>Menu ID:</span>
			<%=ot.getMenuId()%></p>
		<p>
			<span>Order ID:</span>
			<%=ot.getOrderId()%></p>
		<p>
			<span>Order Item ID:</span>
			<%=ot.getOrderItemId()%></p>
		<p>
			<span>Quantity:</span>
			<%=ot.getQuantity()%></p>
	</div>
	<%
	} else {
	%>
	<p class="no-order-item-found">No order item found.</p>
	<%
	}
	%>
</body>
</html>