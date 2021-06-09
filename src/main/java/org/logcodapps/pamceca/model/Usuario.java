package org.logcodapps.pamceca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	
	private long chave;
	private String nome;
	private String contato;
	private String login;
	private String senha;
	private boolean logado;

}
