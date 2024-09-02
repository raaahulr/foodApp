package com.tapfoods.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tapfoods.dao.UserDao;
import com.tapfoods.daoImp.UserDaoImp;
import com.tapfoods.model.User;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 String username = req.getParameter("username");
		 String email = req.getParameter("email");
		 String password = req.getParameter("password");
		 String phonenumber = req.getParameter("phonenumber");
		 String address = req.getParameter("address");
		 
		 User user = new User(username, email, password, phonenumber, address);
		 
		 UserDao userDao =  new UserDaoImp();
		 int status=userDao.addUser(user);
		 
		 if(status==0) {
			 resp.sendRedirect("failure.jsp");
		 }else {
			 resp.sendRedirect("success.jsp");
		 }

	}
}
