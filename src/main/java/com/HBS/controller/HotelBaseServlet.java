package com.HBS.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HotelBaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String servletPath = request.getRequestURI().substring(request.getContextPath().length());
		PrintWriter writer = response.getWriter();
		String seperator = "/";
		int seperatorIndex = servletPath.indexOf(seperator) + 1;
		String servletPathSubString = servletPath.substring(seperatorIndex);
		String[] servletPathInfo = servletPathSubString.split("/");
		String hotel = servletPathInfo[0];
		String hotelId = servletPathInfo[1];
		request.setAttribute("hotel", hotel);
		request.setAttribute("hotelId", hotelId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/getAHotel");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
