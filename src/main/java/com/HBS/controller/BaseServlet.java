package com.HBS.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();		
		PrintWriter writer = response.getWriter();
		writer.println(pathInfo);
		if (pathInfo == null) {
			ServletContext context= getServletContext();
			RequestDispatcher rd= context.getRequestDispatcher("/hotelsDetails");
			rd.forward(request, response);
			

		} else {
			ServletContext context= getServletContext();
			RequestDispatcher rd= context.getRequestDispatcher("/specificHotelDetails");
			rd.forward(request, response);

		}

		

	}

}
