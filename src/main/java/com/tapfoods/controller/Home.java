package com.tapfoods.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.dao.RestaurantDao;
import com.tapfoods.daoImp.RestaurantDaoImp;
import com.tapfoods.model.Restaurant;
 

/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 RestaurantDao restaurantDao = new RestaurantDaoImp();
		 ArrayList<Restaurant> restaurantList = restaurantDao.getAllRestaurants();
		 
		 HttpSession session = req.getSession();
		 
		 session.setAttribute("restaurantList", restaurantList);
		 
		 resp.sendRedirect("home.jsp");
	}
	
}
