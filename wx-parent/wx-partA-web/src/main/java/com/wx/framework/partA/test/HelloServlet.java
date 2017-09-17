package com.wx.framework.partA.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = -2699916013551305854L;

	protected void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
		req.setAttribute("aaa", "me");
		req.getRequestDispatcher("/hello.jsp").forward(req, res);
	}
}
