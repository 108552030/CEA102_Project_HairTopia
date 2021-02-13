package com.news.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		String newsno = req.getParameter("newsno");
		String action = req.getParameter("action");
		if("getOne_For_Display".equals(action)) {
			out.println("getOne_For_Display" + action);
		}
		
//		if("")
//		out.println("123");
//		out.println(newsno);
	}

}
