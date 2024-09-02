<%@page import="com.tapfoods.model.User"%>
<%@page import="com.tapfoods.model.Restaurant"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tap Foods</title>
<style>
  /* Add some basic styling to the page */
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f7f7f7; /* Light gray background */
  }

  /* Style the header section */
  .header {
    background-color: #ff9900; /* Orange background */
    padding: 20px;
    text-align: center;
    border-bottom: 1px solid #ccc;
    display: flex; /* Add flexbox */
    justify-content: space-between; /* Space out the nav and welcome message */
    align-items: center; /* Center the elements vertically */
  }

  .header_link {
    margin: 0 10px;
    text-decoration: none;
    color: #fff; /* White text */
  }

  .header_link:hover {
    color: #ccc; /* Light gray text on hover */
  }

  .header_menu {
    display: flex; /* Add flexbox */
    justify-content: space-between; /* Space out the menu items */
  }

  /* Style the welcome message */
  .welcome {
    font-size: 24px;
    font-weight: bold;
    color: #666; /* Dark gray text */
  }

  /* Style the restaurant list */
  .restaurant-list {
    display: flex; /* Add flexbox */
    flex-wrap: wrap; /* Wrap the restaurants to the next line */
    justify-content: center; /* Center the restaurants horizontally */
  }

  .restaurant {
    margin: 20px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 250px; /* Set a fixed width for the restaurant cards */
  }

  .restaurant h3 {
    font-size: 18px;
    margin-top: 0;
  }

  .restaurant p {
    font-size: 14px;
    color: #666; /* Dark gray text */
  }

  .restaurant a {
    text-decoration: none;
    color: #4CAF50; /* Green text */
  }

  .restaurant a:hover {
    color: #3e8e41; /* Darker green text on hover */
  }
</style>
</head>
<body>

  <header class="header">
    <nav><a class="header_link" href="home">Home</a></nav>
    <%
    User user = (User) session.getAttribute("loggedInUser");
    %>
    <%
    if (user != null) {
    %>
    <h3 class="welcome">Welcome back <%
    out.println(user.getUsername());
    }
    %></h3>
    <nav class="header_menu">
      <a class="header_link" href="cart">View Cart</a> 
      <a class="header_link" href="OrdeHistorybasedOnUserId?userId=<%=user.getUserid()%>">View Order History</a> 
      <a class="header_link" href="logout">Logout</a>
    </nav>

    <%
    if (user == null) {
    %>
    <nav class="header_menu">
      <a class="header_link" href="login.jsp">Login</a>
      <a class="header_link" href="signUp.jsp">Register</a></nav>
    <%
    }
    %>
  </header>

  <h2>Featured Restaurants</h2>

  <section class="restaurant-list">
    <%
    ArrayList<Restaurant> restaurantList = (ArrayList<Restaurant>) session.getAttribute("restaurantList");
    if(restaurantList != null){
      for(Restaurant restaurant : restaurantList){
    %>
      <div class="restaurant">
        <h3><%=restaurant.getRestaurantName()%></h3>
        <p><%=restaurant.getCuisinType()%>
          <%=restaurant.getDeliveryTime()%>
          mins
        </p>
        <a href="viewMenu?restId=<%=restaurant.getRestaurantId()%>">View Menu</a>
      </div>
      <%
      }
    } else {
    %>
      <p>No Restaurant Available at the mmoment</p>
	<% 
	}%>
</section>