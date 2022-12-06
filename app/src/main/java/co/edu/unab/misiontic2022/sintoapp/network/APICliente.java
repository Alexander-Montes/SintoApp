package co.edu.unab.misiontic2022.sintoapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APICliente {
    private static final String URL = "https://servicio.miproyecto.xyz/api/";
    private static APIService instance;

    public static APIService getAPIService(){
        if (instance == null){
            Retrofit httpp = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            instance = httpp.create(APIService.class);
        }
        return instance;
    }
}
