package com.tapfoods.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.dao.MenuDao;
import com.tapfoods.daoImp.MenuDaoImp;
import com.tapfoods.model.Menu;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/viewMenu")
public class MenuServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int restId = Integer.parseInt(req.getParameter("restId"));
//        System.out.println(restId);
	    MenuDao menuDao = new MenuDaoImp();
	    ArrayList<Menu> menuList = menuDao.getMenu(restId);
//	    for(Menu e : menuList) {
//	    	System.out.println(e);
//	    }
        
	    HttpSession session = req.getSession();
	    session.setAttribute("menuList", menuList); 
	    resp.sendRedirect("menu.jsp");
	}
}
