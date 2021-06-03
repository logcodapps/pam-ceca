package org.logcodapps.pamceca;

import java.sql.SQLException;

import org.logcodapps.pamceca.config.DataSourceConfigFactory;
import org.logcodapps.pamceca.config.UsuarioSistema;
import org.logcodapps.pamceca.model.Usuario;
import org.logcodapps.pamceca.repository.UsuarioRepository;
import org.logcodapps.pamceca.service.UsuarioService;

public class TestConsole {

	public static void main(String[] args) throws SQLException {
		
		UsuarioService usuarioService = new UsuarioService(
				new UsuarioRepository(
						new DataSourceConfigFactory(
								new UsuarioSistema())));
	    System.out.println(usuarioService.virificacaoUsuario("mafesa@ifba.edu.br","12345"));

	}

}
