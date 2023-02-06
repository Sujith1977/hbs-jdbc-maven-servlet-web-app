package com.HBS.dao;

import com.HBS.dto.HotelDTO;

public interface IHotelDAO {

	HotelDTO getDetailsOfAHotel(int hotelIdAttribute);

}