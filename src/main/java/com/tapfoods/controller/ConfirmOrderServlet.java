package com.tapfoods.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.daoImp.OrderHistoryDaoImp;
import com.tapfoods.daoImp.OrderItemDaoImp;
import com.tapfoods.daoImp.OrderTableDaoImp;
import com.tapfoods.model.Cart;
import com.tapfoods.model.CartItem;
import com.tapfoods.model.Menu;
import com.tapfoods.model.OrderHistory;
import com.tapfoods.model.OrderItem;
import com.tapfoods.model.OrderTable;
import com.tapfoods.model.User;

/**
 * Servlet implementation class ConfirmOrderServlet
 */
@WebServlet("/ConfirmOrderServlet")
public class ConfirmOrderServlet extends HttpServlet {
	 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		
		OrderTableDaoImp ot = new OrderTableDaoImp();
		OrderItemDaoImp oi = new OrderItemDaoImp();
		OrderHistoryDaoImp oh = new OrderHistoryDaoImp();
		String paymentMode = req.getParameter("paymentMode");
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("loggedInUser");
		int userid= user.getUserid();
		System.out.println(userid);
		int restaurantId=0;
		ArrayList<Menu> menuList =(ArrayList<Menu>)session.getAttribute("menuList");
		for(Menu m : menuList)
		{
			restaurantId= m.getRestaurantId();
			System.out.println(m);
		}
		System.out.println(restaurantId);
		float totalAmount=0.0f;
		Cart cart =(Cart)session.getAttribute("cart");
		if (cart != null) 
		{
            Map<Integer, CartItem> cartitems = cart.getItems();
            if (cartitems != null && !cartitems.isEmpty()) 
            {
                for (Map.Entry<Integer, CartItem> entry : cartitems.entrySet())
                {
                    CartItem cartitem = entry.getValue();
                    totalAmount+= cartitem.getSubTotal();
                }
            
                OrderTable Ot = new OrderTable(restaurantId, userid, totalAmount,"Pending",paymentMode);
               int orderId = ot.addOrder(Ot);
               System.out.println(orderId);
               int a=0;
              for (Map.Entry<Integer, CartItem> entry : cartitems.entrySet()) {
              	CartItem cartitem = entry.getValue();
              	
               	OrderItem item = new OrderItem(orderId, cartitem.getItemId(), cartitem.getQuantity(), cartitem.getPrice()*cartitem.getQuantity());
               	 a = oi.addOrderItem(item);
               	System.out.println(a);
               }
               OrderHistory ohs = new OrderHistory(orderId,userid,totalAmount,"completed");
               int b = oh.addOrderHistory(ohs);
               if(orderId>0 && a>0&&b>0)
               {
            	   resp.sendRedirect("orderconfirm.jsp");
               }
               
               
               
            } 
		}
    
	}

}
