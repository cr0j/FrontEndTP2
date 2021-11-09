package com.example.tpfrontend2.servicios;

import com.example.tpfrontend2.Lista;
import com.example.tpfrontend2.modelos.FichaArchivo;
import com.example.tpfrontend2.modelos.FichaClinica;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FichaClinicaService {
    @GET("fichaClinica")
    Call<Lista<FichaClinica>> obtenerFichas(@Query("orderBy") String orderBy,
                                            @Query("ejemplo") String ejemplo
    );


    @Headers("Content-Type: application/json")
    @POST("fichaClinica")
    Call<FichaClinica> cargarFicha(@Body FichaClinica fichaClinica, @Header("usuario") String usuario);

    @Headers("Content-Type: application/json")
    @PUT("fichaClinica")
    Call<FichaClinica> modificarFicha(@Body FichaClinica fichaClinica, @Header("usuario") String usuario);

    @DELETE("fichaClinica/{id}")
    Call<Void> cancelarFicha(@Path("id") int id);

    @GET("fichaClinica/{id}")
    Call<FichaClinica> obtenerFicha(@Path("id") int id);

    @Multipart
    @POST("fichaArchivo/archivo")
    Call<String> cargarArchivo(@Part("file") RequestBody file, @Part("nombre") RequestBody nombre, @Part("idFichaClinica") RequestBody id );

    @GET("fichaArchivo")
    Call<Lista<FichaArchivo>> obtenerArchivos(@Query("idFichaClinica") int id);

    @DELETE("fichaArchivo/{id}")
    Call<Integer> eliminarArchivo(@Path("id") int id);

}
