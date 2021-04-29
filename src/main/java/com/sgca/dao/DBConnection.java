package com.sgca.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Class to get the connection variable
 * 
 * @author alwin
 * @version 1.0
 */
public class DBConnection {

    /**
     * static function which gets the connection varibale to the database
     * @return Connection variable to the database
     */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection
			         ("jdbc:mysql://localhost:3306/application","root","admin");
		} catch(Exception e) {
			 System.out.println(e.getMessage());
		}
		return conn;
	}
}