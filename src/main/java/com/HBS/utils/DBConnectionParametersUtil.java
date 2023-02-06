package com.HBS.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConnectionParametersUtil {
	static String dbUrl = getDBParameters("DBConnectionParameters.config").getProperty("url");
	static String dbUserName = getDBParameters("DBConnectionParameters.config").getProperty("userName");
	static String dbPassword = getDBParameters("DBConnectionParameters.config").getProperty("password");

	private static Properties getDBParameters(String propertiesfileName) {

		Properties properties = new Properties();
		ClassLoader dbParametersClassLoader = DBConnectionParametersUtil.class.getClassLoader();
		InputStream inputStream = dbParametersClassLoader.getResourceAsStream("DBConnectionParameters.config");

		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;

	}

	public static String getDbUrl() {
		return dbUrl;
	}

	public static String getDbUserName() {
		return dbUserName;
	}

	public static String getDbPassword() {
		return dbPassword;
	}
}
