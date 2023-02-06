package com.HBS.dto;

import com.HBS.entities.Hotel;

public class HotelDTO {
	Hotel hotel;

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "HotelDTO [hotel=" + hotel + "]";
	}
	
	
}
