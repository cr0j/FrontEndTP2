package com.example.tpfrontend2.servicios;

import com.example.tpfrontend2.Lista;
import com.example.tpfrontend2.modelos.Doctor;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DoctorService {

    @GET("persona")
    Call<Lista<Doctor>> obtenerDoctores(@Query("orderBy") String orderBy,
                                        @Query("orderDir") String orderDir,
                                        @Query("ejemplo") String ejemplo,
                                        @Query("like") String like
    );
}
