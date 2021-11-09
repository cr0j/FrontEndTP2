package com.example.tpfrontend2.servicios;

import com.example.tpfrontend2.Lista;

import com.example.tpfrontend2.modelos.Reserva;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ReservaService {

    @GET("reserva")
    Call<Lista<Reserva>> obtenerReservas(@Query("orderBy") String orderBy,
                                         @Query("ejemplo") String ejemplo);

    /*@Headers({
            "Content-Type: application/json",
            "usuario:gustavo"
    })*/

    @POST("reserva")
    Call<Reserva> agregarReserva(@Body Reserva reserva);

    @Headers({
            "Content-Type:application/json",
            "usuario:usuario1"
    })

    @PUT("reserva")
    //Call<Void> modificarReserva(@Body Reserva reserva, @Header("usuario") String usuario);
    Call<Void> modificarReserva(@Body Reserva reserva);

    @DELETE("reserva/{id}")
    Call<Integer> cancelarReserva(@Path("id") int id);

    @GET("persona/{id}/agenda")
    Call<Reserva[]> obtenerHorarios(@Path("id") int id, @Query("fecha") String fecha,@Query("disponible") String disponible
    );

    @Headers({
            "Content-Type: application/json",
            "usuario: usuario1"
    })
    //@Headers("Content-Type: application/json")

    //@POST("/stock-nutrinatalia/reserva")
    @POST("reserva")
    //Call<Reserva> cargarReserva(@Body Reserva reserva, @Header("usuario") String usuario);
    Call<Reserva> cargarReserva(@Body Reserva reserva);
}
