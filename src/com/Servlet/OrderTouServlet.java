package com.Servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.EASYBUY_DD;
import com.bean.EASYBUY_ORDER;
import com.dao.EASYBUY_DDDao;
import com.dao.EASYBUY_ORDERDao;

public class OrderTouServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		String id=req.getParameter("id");
		EASYBUY_ORDER order=EASYBUY_ORDERDao.selectById(Integer.parseInt(id));
		ArrayList<EASYBUY_DD> dlist=EASYBUY_DDDao.selectById(Integer.parseInt(id));
		req.setAttribute("dlist", dlist);
		req.setAttribute("order", order);
		req.getRequestDispatcher("order-modify.jsp").forward(req, resp);
}
}
