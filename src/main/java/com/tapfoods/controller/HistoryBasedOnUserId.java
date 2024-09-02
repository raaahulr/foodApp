package com.tapfoods.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.daoImp.OrderItemDaoImp;
import com.tapfoods.model.OrderItem;

/**
 * Servlet implementation class HistoryBasedOnUserId
 */
@WebServlet("/HistorybsedOnOrderId")
public class HistoryBasedOnUserId extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int id =Integer.parseInt(req.getParameter("OrderId"));
		System.out.println(id);
		OrderItemDaoImp oii = new OrderItemDaoImp();
		OrderItem oi = oii.getOrderItem(id);
		session.setAttribute("OrderItem", oi);
		resp.sendRedirect("ItemHistory.jsp");
		System.out.println(oi);
	}

}
