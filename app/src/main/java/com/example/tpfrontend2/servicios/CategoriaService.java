package com.example.tpfrontend2.servicios;

import com.example.tpfrontend2.Lista;
import com.example.tpfrontend2.modelos.Categoria;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CategoriaService {
    @GET("categoria")
    Call<Lista<Categoria>> obtenerCategorias(@Query("orderBy") String orderBy,
                                             @Query("orderDir") String orderDir
    );
}
