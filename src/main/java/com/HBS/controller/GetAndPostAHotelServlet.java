package com.HBS.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HBS.dao.HotelDAO;
import com.HBS.dao.IHotelDAO;
import com.HBS.dto.HotelDTO;
import com.HBS.utils.HotelDAOFactory;

public class GetAndPostAHotelServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.println("inside GetAHotelServlet");
		String hotelAttribute = (String) request.getAttribute("hotel");
		int hotelIdAttribute = Integer.parseInt((String) request.getAttribute("hotelId"));

		IHotelDAO hotelDAO = (HotelDAO) HotelDAOFactory.getHotelDAO();
		HotelDTO hotelDTO = hotelDAO.getDetailsOfAHotel(hotelIdAttribute);
		writer.println("hotel is named - " + hotelDTO.getHotel().getHotel_name());

	}

}
