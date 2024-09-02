package com.tapfoods.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.dao.UserDao;
import com.tapfoods.daoImp.UserDaoImp;
import com.tapfoods.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email=req.getParameter("email");
		String password=req.getParameter("password");

		UserDao userDao = new UserDaoImp();
		User user=userDao.getUser(email);
		
		if(password.equals(user.getPassword())) {
			HttpSession session = req.getSession();
			session.setAttribute("loggedInUser", user);
			resp.sendRedirect("home");	
		}else {
			resp.sendRedirect("failure.jsp");
		}
	}

}
