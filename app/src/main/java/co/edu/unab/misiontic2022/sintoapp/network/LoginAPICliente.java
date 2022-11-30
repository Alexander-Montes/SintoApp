package co.edu.unab.misiontic2022.sintoapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginAPICliente {
    private static final String URL = "https://servicio.miproyecto.xyz/api/";
    private static LoginAPIService instance;

    public static LoginAPIService getLoginAPIService(){
        if (instance == null){
            Retrofit httpd = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            instance = httpd.create(LoginAPIService.class);
        }
        return instance;
    }
}
