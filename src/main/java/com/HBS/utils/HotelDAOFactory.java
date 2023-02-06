package com.HBS.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import com.HBS.dao.IHotelDAO;

public class HotelDAOFactory {
	public static IHotelDAO getHotelDAO() {
		Class<?> hotelDAOClass = null;
		IHotelDAO hotelDAO = null;
		try {
			hotelDAOClass = Class.forName(getHotelDAOClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			hotelDAO = (IHotelDAO) hotelDAOClass.getDeclaredConstructor().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return hotelDAO;

	}

	private static String getHotelDAOClassName() {
		String hotelDAOClassName = null;

		Properties properties = new Properties();

		ClassLoader hotelDAOClassLoader = HotelDAOFactory.class.getClassLoader();

		InputStream inputStream = hotelDAOClassLoader.getResourceAsStream("dao.config");

		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		hotelDAOClassName = properties.getProperty("hotelDAO");

		return hotelDAOClassName;
	}
}
