package org.logcodapps.pamceca.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.logcodapps.pamceca.config.DataSourceConfigFactory;
import org.logcodapps.pamceca.model.Usuario;
import org.logcodapps.pamceca.sql.SqlInsert;

import lombok.Data;

@Data
public class UsuarioRepository {

	protected DataSourceConfigFactory config;
	protected Connection connection;

	public UsuarioRepository(DataSourceConfigFactory config) {
		this.config = config;
		connection = config.abrirTransation();

	}

	public String createUsuario(Usuario usuario) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(SqlInsert.insertUsuarioSQL());
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getContato());
		stmt.setString(3, usuario.getLogin());
		stmt.setString(4, usuario.getSenha());
		stmt.execute();
		return "Enviado";
	}

	public List<Usuario> catalogoUsuarios() throws SQLException {

		PreparedStatement stmt = connection.prepareStatement(SqlInsert.catalogoUsuarios());
		List<Usuario> usuarios = new ArrayList<Usuario>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setChave(rs.getLong(1));
			usuario.setNome(rs.getString(2));
			usuario.setContato(rs.getString(3));
			usuario.setLogin(rs.getString(4));
			usuario.setSenha(rs.getString(5));
			usuarios.add(usuario);
		}
		return usuarios;

	}

	public Usuario findByUsuario(Long chave) throws SQLException {

		PreparedStatement stmt = connection.prepareStatement(SqlInsert.retornaUsuario());
		stmt.setLong(1, chave);
		ResultSet rs = stmt.executeQuery();
		Usuario usuario = new Usuario();
		if (rs.next()) {
			usuario.setChave(rs.getLong(1));
			usuario.setNome(rs.getString(2));
			usuario.setContato(rs.getString(3));
			usuario.setLogin(rs.getString(4));
			usuario.setSenha(rs.getString(5));
		}
		return usuario;

	}

	public boolean virificacaoUsuario(String login, String senha) throws SQLException {

		PreparedStatement stmt = connection.prepareStatement(SqlInsert.retornaUsuarioLoginSenha());
		stmt.setString(1, login);
		stmt.setString(2, senha);
		ResultSet rs = stmt.executeQuery();
		boolean verifica = false;
		if (rs.next()) {
			verifica = true;
		}
		return verifica;

	}

}
