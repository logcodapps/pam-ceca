package org.logcodapps.pamceca.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Basico implements ConfigConnection{
	
	String url="jdbc:mariadb://localhost:3306/questoesbasica";
	String user="root";
	String passwd="";
	
	@Override
	public Connection createConnection() {
		try {
			return DriverManager.getConnection(url, user, passwd);
		} catch (Exception e) {
			System.out.println(e);
			return null; 
		}
		
	}

}
