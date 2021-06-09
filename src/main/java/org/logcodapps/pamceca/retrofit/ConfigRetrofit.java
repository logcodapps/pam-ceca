package org.logcodapps.pamceca.retrofit;

import org.logcodapps.pamceca.service.ServiceUsuario;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ConfigRetrofit {

    protected Retrofit retrofit = null;

    public ConfigRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public ServiceUsuario usuarioService() {
        return this.retrofit.create(ServiceUsuario.class);
    }
    
     
    

}
