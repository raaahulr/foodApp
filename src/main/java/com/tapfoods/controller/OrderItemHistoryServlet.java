package com.tapfoods.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.daoImp.MenuDaoImp;
import com.tapfoods.daoImp.OrderItemDaoImp;
import com.tapfoods.model.Menu;
import com.tapfoods.model.OrderItem;

/**
 * Servlet implementation class OrderItemHistory
 */
@WebServlet("/orderItemHistory")
public class OrderItemHistoryServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int id =Integer.parseInt(req.getParameter("orderId"));
		System.out.println(id);
		OrderItemDaoImp ol = new OrderItemDaoImp();
		OrderItem  o = ol.getOrderItem(id);
		int id1= o.getMenuId();
		MenuDaoImp md = new MenuDaoImp();
		Menu m= md.getOnMenuId(id1);
		session.setAttribute("Menu", m);
		session.setAttribute("OrderItem", o);
		resp.sendRedirect("OrderItemHistory.jsp");

		System.out.println(m);
		System.out.println(o);

	}

}
