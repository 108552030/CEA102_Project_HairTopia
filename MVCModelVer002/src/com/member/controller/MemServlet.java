package com.member.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.member.model.*;

public class MemServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		String action = req.getParameter("action");
		
	    // 【取得使用者 帳號(account) 密碼(password)】
	    String account = req.getParameter("account");
	    String password = req.getParameter("password");
		
	    if (!allowUser(account, password)) {          //【帳號 , 密碼無效時】
	        out.println("<HTML><HEAD><TITLE>Access Denied</TITLE></HEAD>");
	        out.println("<BODY>你的帳號 , 密碼無效!<BR>");
	        out.println("請按此重新登入 <A HREF="+req.getContextPath()+"/mem/login.jsp>重新登入</A>");
	        out.println("</BODY></HTML>");
	      }else {    
	    	  
	    	  HttpSession session = req.getSession();
	          session.setAttribute("account", account);
	    	  
	    	  	String url = "/mem/login_success.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);	
	      }
	}
	
	   //【檢查使用者輸入的帳號(account) 密碼(password)是否有效】
	   //【實際上應至資料庫搜尋比對】
	  protected boolean allowUser(String memEmail, String memPswd) {
		  MemService memSvc = new MemService();

	    if (memSvc.validate(memEmail, memPswd))
	      return true;
	    else
	      return false;
	  }
}