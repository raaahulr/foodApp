<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.tapfoods.model.Cart"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.tapfoods.model.CartItem"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<style>
/* Add some basic styling to the page */
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f7f7f7; /* Light gray background */
}

/* Style the cart container */
.cart-container {
	max-width: 800px;
	margin: 40px auto;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	background-color: #fff; /* White background */
}

/* Style the cart item */
.cart-item {
	margin-bottom: 20px;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	display: flex; /* Add flexbox */
	flex-direction: row;
	/* Stack the item info and subtotal horizontally */
	align-items: center; /* Center the item info and subtotal vertically */
}

.cart-item .item-info {
	flex: 1; /* Take up the remaining space */
}

.cart-item .item-info h3 {
	margin-bottom: 10px;
	color: #333; /* Dark gray text */
}

.cart-item .item-subtotal {
	margin-left: 20px;
}

.cart-item .item-subtotal h3 {
	font-weight: bold;
	color: #666; /* Dark gray text */
}

/* Style the quantity form */
.cart-item form {
	display: inline;
}

.cart-item input[type="number"] {
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	width: 50px; /* Make the input field narrower */
}

.cart-item input[type="submit"] {
	background-color: #4CAF50; /* Green background */
	color: #fff; /* White text */
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.cart-item input[type="submit"]:hover {
	background-color: #3e8e41; /* Darker green on hover */
}

/* Style the proceed to checkout button */
.proceed-to-check-btn {
	background-color: #4CAF50; /* Green background */
	color: #fff; /* White text */
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.proceed-to-check-btn:hover {
	background-color: #3e8e41; /* Darker green on hover */
}

/* Style the cart empty message */
.cart-empty {
	font-size: 24px;
	font-weight: bold;
	color: #666; /* Dark gray text */
	text-align: center;
}
</style>
</head>
<body>
	<div class="cart-container">
		<% 
            Cart cart = (Cart) session.getAttribute("cart"); 
            if (cart != null) {
                Map<Integer, CartItem> cartItems = cart.getItems();
                if (cartItems != null && !cartItems.isEmpty()) {
                    for (Map.Entry<Integer, CartItem> entry : cartItems.entrySet()) {
                        CartItem cartItem = entry.getValue();
        %>
		<div class="cart-item">
			<div class="item-info">
				<h3>
					Item Id:
					<%= cartItem.getItemId() %></h3>
				<h3>
					Item Name:
					<%= cartItem.getName() %></h3>
				<h3>
					Item Price: $<%= cartItem.getPrice() %>
					<h3>
						Quantity:
						<form action="cart" style="display: inline;">
							<input type="hidden" name="itemId"
								value="<%= cartItem.getItemId() %>"> <input
								type="number" name="quantity"
								value="<%= cartItem.getQuantity() %>" min="1"> <input
								type="submit" name="action" value="update"> <input
								type="submit" name="action" value="remove">
						</form>
			</div>
			<div class="item-subtotal">
				<h3>
					Subtotal: $<%=cartItem.getQuantity()*cartItem.getPrice()  %></h3>
			</div>
			<% 
                    }%>
		</div>
		<%   } else { 
        %>
		<p class="cart-empty">Your cart is empty.</p>
		<% 
                } 
            } else { 
        %>
		<p class="cart-empty">Your cart is empty.</p>

		<% 
            } 
        %>
		<div>
			<%
        	if(session.getAttribute("cart")!=null)
        	{
        %>
			<form action="checkOut.jsp">
				<input type="submit" value="Proceed to checkOut"
					class="btn proceed-to-check-btn">
			</form>
			<%} %>
		</div>
</body>
</html>