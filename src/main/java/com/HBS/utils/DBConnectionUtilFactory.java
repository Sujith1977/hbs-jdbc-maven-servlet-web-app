package com.HBS.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class DBConnectionUtilFactory {

	public static IDBConnectionUtil getDBConnection() {
		IDBConnectionUtil dbConnectionUtil = null;
		Class<?> DBConnectionUtilClass = null;
		try {
			DBConnectionUtilClass = Class.forName(getDBConnectionClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			dbConnectionUtil = (IDBConnectionUtil) DBConnectionUtilClass.getDeclaredConstructor().newInstance();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return dbConnectionUtil;
	}

	private static String getDBConnectionClassName() {
		String DBConnectionClassName = null;

		Properties properties = new Properties();

		ClassLoader DBConnectionUtilClass = DBConnectionUtilFactory.class.getClassLoader();

		InputStream inputStream = DBConnectionUtilClass.getResourceAsStream("DBConnectionClassNameProperties.config");

		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		DBConnectionClassName = properties.getProperty("connectionClassName");

		return DBConnectionClassName;
	}
}
