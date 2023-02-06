package com.HBS.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionUtil implements IDBConnectionUtil {

	public Connection getDBConnection() {
		Connection connection = null;		
		try {
			Class.forName(getDBDriverName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(DBConnectionParametersUtil.getDbUrl(), DBConnectionParametersUtil.getDbUserName(), DBConnectionParametersUtil.getDbPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;

	}

	private static String getDBDriverName() {
		String DBDriverName = null;

		Properties properties = new Properties();

		ClassLoader dbDriverClassLoader = DBConnectionUtil.class.getClassLoader();

		InputStream inputStream = dbDriverClassLoader.getResourceAsStream("DBConnectionParameters.config");

		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		DBDriverName = properties.getProperty("dbDriverName");

		return DBDriverName;
	}
}
