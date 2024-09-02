<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.tapfoods.model.CartItem" %> 
<%@ page import="com.tapfoods.model.Cart" %>
<%@ page import="java.util.Map" %>  
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Summary</title>
<style>
  /* Add some basic styling to the page */
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f7f7f7; /* Light gray background */
  }

  /* Style the cart item */
  .cart-item {
    margin-bottom: 20px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    display: flex; /* Add flexbox */
    flex-direction: row; /* Stack the item info and subtotal horizontally */
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

  /* Style the order form */
  .order-form {
    max-width: 500px;
    margin: 40px auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    background-color: #fff; /* White background */
  }

  .order-form h3 {
    margin-bottom: 20px;
    color: #333; /* Dark gray text */
  }

  .order-form input[type="text"] {
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    width: 100%; /* Make the input field full width */
  }

  .order-form select {
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    width: 100%; /* Make the select field full width */
  }

  .order-form input[type="submit"] {
    background-color: #4CAF50; /* Green background */
    color: #fff; /* White text */
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }

  .order-form input[type="submit"]:hover {
    background-color: #3e8e41; /* Darker green on hover */
  }
</style>
</head>
<body>
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
                            <h3>Item Name: <%= cartItem.getName() %></h3>
                            <h3>Item Price: $<%= cartItem.getPrice() %></h3>
                            <h3>Quantity: <%= cartItem.getQuantity() %></h3>
                        </div>
                        <div class="item-subtotal">
                            <h3>Subtotal: $<%= cartItem.getQuantity() * cartItem.getPrice() %></h3>
                        </div>
                    </div>
    <% 
                }
            }
        }
    %>
    
      <!-- Form for address input and order confirmation -->
    <div class="order-form">
        <h3>Enter Your Shipping Address and Payment Mode</h3>
        <form action="ConfirmOrderServlet" method="post">
            <input type="text" name="address" placeholder="Enter your address" required>
            <select name="paymentMode" required>
                <option value="">Select Payment Mode</option>
                <option value="Credit Card">CreditCard</option>
                <option value="Debit Card">DebitCard</option>
                <option value="PayPal">PayPal</option>
                <option value="Cash on Delivery">Cash on Delivery</option>
            </select>
            <input type="submit" value="Confirm Order">
        </form>
    </div>
			 
</body>
</html>