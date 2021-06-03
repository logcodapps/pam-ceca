package org.logcodapps.pamceca.config;

import java.sql.Connection;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataSourceConfigFactory {

	private ConfigConnection configConnection;
	
	public Connection abrirTransation() {
		return configConnection.createConnection();
	}

}
