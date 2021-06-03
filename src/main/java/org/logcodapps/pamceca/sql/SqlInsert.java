package org.logcodapps.pamceca.sql;

public class SqlInsert {
	
	public static String insertUsuarioSQL() {
		return "insert into  usuario (nome,contato,login,senha) values (?,?,?,?)";
	}
	
	public static String catalogoUsuarios() {
		return "select * from usuario u";
	}
	
	public static String retornaUsuario() {
		return "select * from usuario u where chave = ?";
	}
	
	public static String retornaUsuarioLoginSenha() {
		return "select login,senha from usuario u where login = ? and senha = ?";
	}
	

}
