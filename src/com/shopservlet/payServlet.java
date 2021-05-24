package com.shopservlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.EASYBUY_ORDER_DETAIL;
import com.bean.EASYBUY_USER;
import com.dao.ESDao;
import com.util.EncodeUtil;


public class payServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
		throws ServletException, IOException {
	arg1.setContentType("text/html;charset=utf-8");
	PrintWriter out=arg1.getWriter();
	EncodeUtil.encode(arg0);
	HttpSession session=arg0.getSession();

		out.print("<script>");
		out.print("location.href='confirm.jsp';");
		out.print("</script>");
		out.close();
}
}
