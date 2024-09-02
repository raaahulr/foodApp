<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Placed</title>
<style>
  /* Add some basic styling to the page */
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f7f7f7; /* Light gray background */
  }

  /* Style the header */
  h1 {
    text-align: center;
    color: #333; /* Dark gray text */
    margin-bottom: 20px;
  }

  /* Style the form */
  form {
    display: flex; /* Add flexbox */
    justify-content: center; /* Center the form horizontally */
  }

  /* Style the submit button */
  input[type="submit"] {
    background-color: #4CAF50; /* Green background */
    color: #fff; /* White text */
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }

  input[type="submit"]:hover {
    background-color: #3e8e41; /* Darker green hover effect */
  }
</style>
</head>
<body>
     <h1>Your Order is Placed</h1>
    
    <form action="OrderHistoryServlet">
        <input type="submit" value="Show History Details">
    </form>
   
</body>
</html>