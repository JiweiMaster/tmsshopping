package com.Servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.EASYBUY_PRODUCT;
import com.bean.EASYBUY_PRODUCT_CATEGORY;
import com.dao.EASYBUY_PRODUCTDao;
import com.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.util.EncodeUtil;

public class SelectProductListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		EncodeUtil.encode(req);
		ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = EASYBUY_PRODUCT_CATEGORYDao.selectFather();
		req.setAttribute("flist", flist);
		ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = EASYBUY_PRODUCT_CATEGORYDao.selectChild();
		req.setAttribute("clist", clist);
		HttpSession session = req.getSession();
		ArrayList<Integer> ids = (ArrayList<Integer>)session.getAttribute("ids");
		if(ids!=null){
			ArrayList<EASYBUY_PRODUCT> lastlylist = EASYBUY_PRODUCTDao.selectById(ids);
			req.setAttribute("lastlylist", lastlylist);
		}
		
		int cpage = 1;
		int count = 8;
		String cp = req.getParameter("cp");
		if(cp!=null){
			cpage = Integer.parseInt(cp);
		}
		int tpage = 0;
		String fid = req.getParameter("fid");
		String cid = req.getParameter("cid");
		String name = req.getParameter("name");
		ArrayList<EASYBUY_PRODUCT> list = null;
		if(fid==null&&cid==null){
			list = EASYBUY_PRODUCTDao.selectAll(cpage, count);
			req.setAttribute("title", "All Goods");
			tpage = EASYBUY_PRODUCTDao.totalPage(count);
		}
		if(fid!=null){
			int id = Integer.parseInt(fid);
			list = EASYBUY_PRODUCTDao.selectAllByFid(cpage, count, id);
			tpage = EASYBUY_PRODUCTDao.totalPageByFid(count, id);
			req.setAttribute("title", EASYBUY_PRODUCT_CATEGORYDao.selectById(id).getEPC_NAME());
		}
		if(cid!=null){
			int id = Integer.parseInt(cid);
			list = EASYBUY_PRODUCTDao.selectAllByCid(cpage, count, id);
			tpage = EASYBUY_PRODUCTDao.totalPageByCid(count, id);
			req.setAttribute("title", EASYBUY_PRODUCT_CATEGORYDao.selectById(id).getEPC_NAME());
		}
		if(name!=null){
			list = EASYBUY_PRODUCTDao.selectAllByName(name);
			tpage = EASYBUY_PRODUCTDao.totalPageByName(count, name);
		} 
		req.setAttribute("list", list);
		req.setAttribute("cpage", cpage);
		req.setAttribute("tpage", tpage);
		req.setAttribute("search_words", name);
		req.setAttribute("selected_fid", fid);
		req.getRequestDispatcher("product-list.jsp").forward(req, resp);
	}
}
