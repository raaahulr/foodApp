<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Food App</title>
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
  }

  .header_title {
    font-size: 36px;
    font-weight: bold;
    color: #fff; /* White text */
    text-shadow: 2px 2px 4px #666; /* Add a subtle shadow */
  }

  /* Style the buttons */
  .btn {
    background-color: #4CAF50; /* Green background */
    color: #fff; /* White text */
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }

  .btn:hover {
    background-color: #3e8e41; /* Darker green on hover */
  }

  /* Add some spacing between the buttons */
  .header_btn {
    margin-top: 20px;
  }

  .header_btn a {
    margin: 0 10px;
  }

  /* Style the welcome message */
  .welcome {
    font-size: 24px;
    font-weight: bold;
    color: #666; /* Dark gray text */
    margin-top: 50px;
    display: flex; /* Add flexbox */
    flex-direction: column; /* Stack elements vertically */
    align-items: center; /* Center elements horizontally */
  }

  /* Add some colorful highlights */
  span {
    color: #ff69b4; /* Pink highlight */
  }
</style>
</head>
<body>
<div class="header">
  <h1 class="header_title">Tap Foods</h1>

  <div class="header_btn">
    <a href="login.jsp"><button class="btn">Login</button></a>
    <a href="signUp.jsp"> <button class="btn">SignUp</button></a> 
  </div>
</div>
<div class="welcome">
  <p>Welcome To <span>Tap Foods</span>...</p>
  <p>Look at Wonderful Offers!!!</p>
  <p>Sit and Relax by Ordering your Favourite food:)</p>
</div>
</body>
</html>