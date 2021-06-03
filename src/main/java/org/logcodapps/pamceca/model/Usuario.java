package org.logcodapps.pamceca.model;

import lombok.Data;

@Data
public class Usuario {
	
	private long chave;
	private String nome;
	private String contato;
	private String login;
	private String senha;
	private boolean logado;

}
