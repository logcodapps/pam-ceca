package org.logcodapps.pamceca.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class UsuarioSistema implements ConfigConnection {
	String url="jdbc:mariadb://localhost:3306/usuariosistema";
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
