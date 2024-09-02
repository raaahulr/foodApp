package com.tapfoods.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.daoImp.OrderHistoryDaoImp;
import com.tapfoods.model.OrderHistory;
import com.tapfoods.model.User;

/**
 * Servlet implementation class OrderHistoryServlet
 */
@WebServlet("/OrderHistoryServlet")
public class OrderHistoryServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(); 
		User user = (User)session.getAttribute("loggedInUser");
		int id= user.getUserid();
		OrderHistoryDaoImp oim = new OrderHistoryDaoImp();
		ArrayList<OrderHistory> list = oim.getHistory(id);
		session.setAttribute("HistoryList", list);
		resp.sendRedirect("OrderHistoryDisply.jsp");
		for(OrderHistory e : list )
		{
			System.out.println(e);
		}
		
	}
	
		
		
}
