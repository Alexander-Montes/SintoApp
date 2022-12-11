package co.edu.unab.misiontic2022.sintoapp.network;

import java.util.List;

import co.edu.unab.misiontic2022.sintoapp.entity.EnviarReporte;
import co.edu.unab.misiontic2022.sintoapp.entity.ObtenerCursos;
import co.edu.unab.misiontic2022.sintoapp.entity.ObtenerDocente;
import co.edu.unab.misiontic2022.sintoapp.entity.ObtenerEstudiante;
import co.edu.unab.misiontic2022.sintoapp.entity.ObtenerLista;
import co.edu.unab.misiontic2022.sintoapp.entity.ObtenerReportes;
import co.edu.unab.misiontic2022.sintoapp.entity.RespuestaLogin;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIService {
    @FormUrlEncoded
    @POST("login")
    Call<RespuestaLogin> login(@Field("email") String email,
                               @Field("password") String password);
    @GET("reporte/usuario/{id}")
    Call<List<ObtenerReportes>> obtenerHistorial(@Header("Authorization") String auth,
                                                 @Path("id") int id);
    @GET("docente/{id}")
    Call<ObtenerDocente> obtenerDocente(@Header("Authorization") String auth,
                                        @Path("id") int id);
    @GET("estudiante/{id}")
    Call<ObtenerEstudiante> obtenerEstudiante(@Header("Authorization") String auth,
                                              @Path("id") int id);
    @GET("docente/{id}/cursos")
    Call<List<ObtenerCursos>> obtenerCursos(@Header("Authorization") String auth,
                                            @Path("id") int id);
    //NO TRAE NINGUN DATO (NULL)
    @GET("docente/{id}/cursos/{curso_id}/estudiante")
    Call<List<ObtenerLista>> obtenerLista(@Header("Authorization") String auth,
                                          @Path("id") int id,
                                          @Path("curso_id") int curso_id);
    /*NO INTEGRADO
    @FormUrlEncoded
    @POST("reporte")
    Call<EnviarReporte> enviarReporte(@Header("Authorization") String auth,
                                      @Field("usuario_id") int usuario,
                                      @Field("fecha") String fecha,
                                      @Field("p1") int p1,
                                      @Field("p2") int p2,
                                      @Field("p3") int p3,
                                      @Field("p4") int p4,
                                      @Field("p5") int p5,
                                      @Field("estado") int estado);*/
}
