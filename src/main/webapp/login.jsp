<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style>
  /* Add some basic styling to the page */
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f7f7f7; /* Light gray background */
  }

  /* Style the login form */
  .login-form {
    max-width: 300px;
    margin: 40px auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    display: flex; /* Add flexbox */
    flex-direction: column; /* Stack the form elements vertically */
    align-items: center; /* Center the form elements horizontally */
  }

  .login-form label {
    margin-bottom: 10px;
    font-weight: bold;
    color: #666; /* Dark gray text */
  }

  .login-form input[type="email"], .login-form input[type="password"] {
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    width: 100%; /* Make the input fields full-width */
  }

  .login-form input[type="submit"] {
    background-color: #4CAF50; /* Green background */
    color: #fff; /* White text */
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }

  .login-form input[type="submit"]:hover {
    background-color: #3e8e41; /* Darker green on hover */
  }
</style>
</head>
<body>

  <center>
    <h1>Login Here</h1>
    <form class="login-form" action="login">
      <table>
        <tr>
          <td><label>Email ID:</label></td>
          <td><input type="email" name="email"></td>
        </tr>

        <tr>
          <td><label>Password:</label></td>
          <td><input type="password" name="password"></td>
        </tr>
        <tr>
          <td></td>
          <td><input type="submit" value="Login"></td>
        </tr>
      </table>
    </form>
  </center>

</body>

</html>