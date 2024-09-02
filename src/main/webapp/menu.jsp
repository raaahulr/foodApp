<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.tapfoods.model.Menu"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu List</title>
<style>
  /* Add some basic styling to the page */
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f7f7f7; /* Light gray background */
  }

  /* Style the menu items */
  .menu-item {
    margin: 20px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    display: flex; /* Add flexbox */
    flex-direction: column; /* Stack the menu item elements vertically */
    align-items: center; /* Center the menu item elements horizontally */
  }

  .menu-item h4 {
    font-weight: bold;
    color: #333; /* Dark gray text */
  }

  .menu-item p {
    margin-bottom: 20px;
  }

  .menu-item .price {
    font-weight: bold;
    color: #666; /* Dark gray text */
  }

  .menu-item .status {
    font-weight: bold;
    color: #666; /* Dark gray text */
  }

  .menu-item form {
    margin-top: 20px;
  }

  .menu-item input[type="number"] {
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    width: 50px; /* Make the input field narrower */
  }

  .menu-item input[type="submit"] {
    background-color: #4CAF50; /* Green background */
    color: #fff; /* White text */
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }

  .menu-item input[type="submit"]:hover {
    background-color: #3e8e41; /* Darker green on hover */
  }
</style>
</head>
<body>
	 
	<%
            ArrayList<Menu> menuList =(ArrayList<Menu>)session.getAttribute("menuList");
            if(menuList!=null) {
                for(Menu menu : menuList ) {
        %>
            <div class="menu-item">
                 
                <h4><%=menu.getMenuName() %></h4>
                <p><%=menu.getDescription() %></p>
                <div class="price">Price: $<%=menu.getPrice() %></div>
                <div class="status">Item Status:<%=menu.isActive()%></div>
                <form action ="cart">
                    <input type="hidden" name="itemId" value="<%=menu.getMenuId()%>">
                    Quantity: <input type="number" name="quantity" value="1" min="1">
                    <input type="submit" value="Add to cart">
                    <input type="hidden" name="action" value="add">
                </form>
                 
            </div>
        <%
                }
            }
        %>
    </div>
 	 
</body>
</html>