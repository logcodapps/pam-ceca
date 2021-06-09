
package org.logcodapps.pamceca.service;

import java.util.List;
import org.logcodapps.pamceca.model.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface ServiceUsuario {

    @GET("usuarios")
    public Call<List<Usuario>> catalogoUsuarios();
   
    @POST("usuarios")
    public Call<Usuario> enviarUsuario(@Body Usuario usuario);
    
   @GET("usuarios/especifico/{login}")
    public Call<Usuario> usuarioLogado(@Path("login") String login);
       
   @GET("usuarios/{chave}")
   public Call<Usuario> usuarioChave(@Path("chave") String chave);
}
