package com.Servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.EASYBUY_PRODUCT;
import com.bean.EASYBUY_USER;
import com.bean.eb_shop;
import com.dao.EASYBUY_PRODUCTDao;
import com.dao.ESDao;

public class ShopAddServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		EASYBUY_PRODUCT p = null;
		String pid = req.getParameter("id");
		String count = req.getParameter("count");
		if(pid!=null){
			p = EASYBUY_PRODUCTDao.selectById(Integer.parseInt(pid));
		}
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		EASYBUY_USER user=(EASYBUY_USER)session.getAttribute("name");
		
		if(user!=null){
			EASYBUY_USER eu=(EASYBUY_USER)session.getAttribute("name");
			String id=(String)eu.getEU_USER_ID();
			ArrayList<eb_shop> list=ESDao.getShop(id);
			req.setAttribute("shoplist",list);
		}else{
			out.print("<script>");
			out.print("alert('please login first');");
			out.print("location.href='login.jsp';");
			out.print("</script>");
			out.close();
			return;
		}
		String uid = user.getEU_USER_ID();
		int valid = 1;
		eb_shop sp = new eb_shop(0, p.getEP_FILE_NAME(), p.getEP_NAME(), p.getEP_PRICE(), Integer.parseInt(count), p.getEP_STOCK(), p.getEP_ID(), uid, valid);
		ESDao.insert(sp);
		resp.sendRedirect("ShopSelect");
	}
}
