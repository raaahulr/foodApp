<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp Page</title>
<style>
  /* Add some basic styling to the page */
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f7f7f7; /* Light gray background */
  }

  /* Style the sign up form */
  .sign-up-form {
    max-width: 400px;
    margin: 40px auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    display: flex; /* Add flexbox */
    flex-direction: column; /* Stack the form elements vertically */
    align-items: center; /* Center the form elements horizontally */
  }

  .sign-up-form label {
    margin-bottom: 10px;
    font-weight: bold;
    color: #666; /* Dark gray text */
  }

  .sign-up-form input[type="text"], .sign-up-form input[type="email"], .sign-up-form input[type="password"], .sign-up-form input[type="tel"] {
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    width: 100%; /* Make the input fields full-width */
  }

  .sign-up-form input[type="submit"] {
    background-color: #4CAF50; /* Green background */
    color: #fff; /* White text */
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }

  .sign-up-form input[type="submit"]:hover {
    background-color: #3e8e41; /* Darker green on hover */
  }
</style>
</head>
<body>

  <center>
    <h1>SignUp Here</h1>
    <form class="sign-up-form" action="signUp" method="post">
      <table>
        <tr>
          <td><label>UserName:</label></td>
          <td><input type="text" name="username"></td>
        </tr>

        <tr>
          <td><label>Email ID:</label></td>
          <td><input type="email" name="email"></td>
        </tr>

        <tr>
          <td><label>Password:</label></td>
          <td><input type="password" name="password"></td>
        </tr>
        <tr>
          <td><label>PhoneNumber:</label></td>
          <td><input type="tel" name="phonenumber"></td>
        </tr>
        
        <tr>
          <td><label>Address:</label></td>
          <td><input type="text" name="address"></td>
        </tr>
        <tr>
          <td><input type="submit" value="SUBMIT"></td>
        </tr>
      </table>
    </form>
  </center>

</body>

</html>