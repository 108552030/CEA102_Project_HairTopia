package com.staff.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.staff.model.*;

public class StaffServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
	    res.setContentType("text/html; charset=utf-8");
	    PrintWriter out = res.getWriter();

	    res.setHeader("Cache-Control","no-store"); //HTTP 1.1
	    res.setHeader("Pragma","no-cache");        //HTTP 1.0
	    res.setDateHeader ("Expires", 0);
	    
	    out.println("<HTML>");
	    out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
	    out.println("<BODY>");
	    out.println("<BIG>Hello World , 世界你好 !</BIG>");
	    out.println("</BODY></HTML>");
	}
}
