package org.logcodapps.pamceca;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.logcodapps.pamceca.model.Usuario;
import org.logcodapps.pamceca.retrofit.ConfigRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestConsole {

	public static void main(String[] args) throws IOException {
		Call<Usuario> logado = 
				new ConfigRetrofit()
				.usuarioService()
				.usuarioLogado("renato2@gmail.com");
		Usuario usuario=null;
		Response<Usuario> response = logado.execute();
		if(response.isSuccessful())
		 usuario = response.body();
		
	    System.out.println(usuario);
	}

}
