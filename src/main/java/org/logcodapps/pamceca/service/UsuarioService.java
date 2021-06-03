package org.logcodapps.pamceca.service;

import java.sql.SQLException;
import java.util.List;

import org.logcodapps.pamceca.model.Usuario;
import org.logcodapps.pamceca.repository.UsuarioRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class UsuarioService {
	
	private UsuarioRepository repository ;
	
	public String enviandoUsuario(Usuario usuario) throws SQLException {
		
		if (!virificacaoUsuario(usuario.getLogin(), usuario.getSenha())) {
			return repository.createUsuario(usuario);
		}
		return "Usuario já foi cadastrado.";
	}
	public List<Usuario> catalogoUsuarios() throws SQLException{
		return repository.catalogoUsuarios();
	}
			
	public Usuario findByUsuario(Long chave) throws SQLException{
		return repository.findByUsuario(chave);
	}
	
	public boolean virificacaoUsuario(String login, String senha) throws SQLException{
		return repository.virificacaoUsuario(login, senha);
	}

}
