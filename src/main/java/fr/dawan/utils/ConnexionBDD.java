package fr.dawan.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnexionBDD {
	public static Connection getConnection() throws IOException, SQLException, ClassNotFoundException {
		Properties p=new Properties();
		p.load(Thread.currentThread().getContextClassLoader().getSystemResourceAsStream("config.properties"));
		Class.forName(p.getProperty("driver"));
		Connection cnx = DriverManager.getConnection(p.getProperty("url"),p.getProperty("user"),p.getProperty("pwd"));
		return cnx;
	}
}
