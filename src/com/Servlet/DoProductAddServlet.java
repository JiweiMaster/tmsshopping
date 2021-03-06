package com.Servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.EASYBUY_PRODUCT;
import com.dao.EASYBUY_PRODUCTDao;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class DoProductAddServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		SmartUpload su = new SmartUpload();
		
		su.initialize(this.getServletConfig(), req, resp);
		
		try {
			su.upload();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		
		Files fs = su.getFiles();
		File f = fs.getFile(0);
		String fname = f.getFileName();
		try {
			su.save("images/product");
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		Request req1 = su.getRequest();
		String pname = req1.getParameter("productName");
		String id = req1.getParameter("parentId");
		String price = req1.getParameter("productPrice");
		String desc = req1.getParameter("productDesc");
		String stock = req1.getParameter("productStock");
		EASYBUY_PRODUCT p = null;
		if(price!=null && stock!=null && id!=null){
			p = new EASYBUY_PRODUCT(0, pname, desc, 
													Integer.parseInt(price), 
													Integer.parseInt(stock), 
													Integer.parseInt(id.split("-")[0]), 
													Integer.parseInt(id.split("-")[1]), 
													fname);
		}
		int count = 0;
		if(p!=null){
			count = EASYBUY_PRODUCTDao.insert(p);
		}
		
		req.getRequestDispatcher("productSelect").forward(req, resp);
		
	}
}
