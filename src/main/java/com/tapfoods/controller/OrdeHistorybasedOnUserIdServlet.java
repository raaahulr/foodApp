package com.tapfoods.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.daoImp.OrderHistoryDaoImp;
import com.tapfoods.model.OrderHistory;

/**
 * Servlet implementation class OrdeHistorybasedOnUserIdServlet
 */
@WebServlet("/OrdeHistorybasedOnUserId")
public class OrdeHistorybasedOnUserIdServlet extends HttpServlet {
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		int id =Integer.parseInt(req.getParameter("userId"));
		System.out.print(id);
		OrderHistoryDaoImp ohi = new OrderHistoryDaoImp();
		
		List<OrderHistory> list = ohi.getHistory(id);
		session.setAttribute("list", list);
		resp.sendRedirect("UserOrderHistory.jsp");
	}

}
