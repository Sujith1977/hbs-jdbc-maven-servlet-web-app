package com.HBS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.HBS.dto.HotelDTO;
import com.HBS.entities.Hotel;
import com.HBS.utils.DBConnectionUtilFactory;
import com.HBS.utils.IDBConnectionUtil;

public class HotelDAO implements IHotelDAO {
	public HotelDTO getDetailsOfAHotel(int hotelIdAttribute) {
		// return HotelDTO object
		HotelDTO hotelDTO = new HotelDTO();
		Hotel hotel = new Hotel();
		String hotelName = null;
		IDBConnectionUtil dbConnectionUtil = DBConnectionUtilFactory.getDBConnection();
		Connection connection = dbConnectionUtil.getDBConnection();
		String query = "SELECT hotel_name FROM hotel WHERE hotel_id = " + hotelIdAttribute;
		Statement stmt;
		ResultSet rs;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				hotelName = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		hotel.setHotel_name(hotelName);
		hotelDTO.setHotel(hotel);
		return hotelDTO;

	}
}
