package com.HBS.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		RequestDispatcher dispatcher = null;
		PrintWriter writer = response.getWriter();
		if (pathInfo == null) {
			writer.println("inside hotel servlet");
//			dispatcher = request.getRequestDispatcher("/HotelsServlet.java");
//			writer.println(dispatcher);

		} else {
			writer.println("inside specific hotel servlet");
//			dispatcher = request.getRequestDispatcher("/SpecificHotelServlet.java");
//			writer.println(dispatcher);

		}

		dispatcher.forward(request, response);

	}

}
