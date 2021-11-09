package com.example.tpfrontend2.servicios;

import com.example.tpfrontend2.Lista;
import com.example.tpfrontend2.modelos.SubCategoria;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SubCategoriaService {

    @GET("tipoProducto")
    Call<Lista<SubCategoria>> obtenerSubCategorias(@Query("orderBy") String orderBy,
                                                   @Query("orderDir") String orderDir,
                                                   @Query("ejemplo") String ejemplo
    );
}
