package com.tapfoods.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.dao.MenuDao;
import com.tapfoods.daoImp.MenuDaoImp;
import com.tapfoods.model.Cart;
import com.tapfoods.model.CartItem;
import com.tapfoods.model.Menu;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession();
		Cart cart =(Cart)session.getAttribute("cart");
		
		if(cart == null)
		{
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		String action = req.getParameter("action");
		if("add".equals(action))
		{
			addItemToCart(req,cart);
		}
		else if("update".equals(action))
		{
			updateCartItem(req,cart);
		}
		else if("remove".equals(action))
		{
			removeItemFromCart(req,cart);
		}
		session.setAttribute("cart", cart);
		resp.sendRedirect("Cart.jsp");
		
	}
	private void removeItemFromCart(HttpServletRequest req, Cart cart) {
		int itemId = Integer.parseInt(req.getParameter("itemId"));
	    cart.removeItem(itemId);
	    
		
	}
	private void updateCartItem(HttpServletRequest req, Cart cart) {
		int itemId = Integer.parseInt(req.getParameter("itemId"));
	    int newQuantity = Integer.parseInt(req.getParameter("quantity"));
	    cart.updateItem(itemId, newQuantity);
	  
		
		
	}
	private void addItemToCart(HttpServletRequest req,Cart cart)
	{
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		
		MenuDao menuDaO = new MenuDaoImp();
		Menu menuItem = menuDaO.getOnMenuId(itemId);
		
		HttpSession session = req.getSession();
		session.setAttribute("resturantId", menuItem.getRestaurantId());
		 
		if(menuItem!=null)
		{
			CartItem item = new CartItem(
					menuItem.getMenuId(),
					menuItem.getRestaurantId(),
					menuItem.getMenuName(),
					quantity,
					menuItem.getPrice(),
					quantity*menuItem.getPrice());
			cart.addItem(item);
		}
			
			
	}
}