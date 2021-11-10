package com.example.tpfrontend2;

import com.example.tpfrontend2.servicios.CategoriaService;
import com.example.tpfrontend2.servicios.DoctorService;
import com.example.tpfrontend2.servicios.FichaClinicaService;
import com.example.tpfrontend2.servicios.ReservaService;
import com.example.tpfrontend2.servicios.SubCategoriaService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Servicios {
    public static FichaClinicaService getFichaClinicaService() {
        return getClient("https://equipoyosh.com/stock-nutrinatalia/").create(FichaClinicaService.class);
    }

    public static CategoriaService getCategoriaService() {
        return getClient("https://equipoyosh.com/stock-nutrinatalia/").create(CategoriaService.class);
    }

    public static SubCategoriaService getSubCategoriaService() {
        return getClient("https://equipoyosh.com/stock-nutrinatalia/").create(SubCategoriaService.class);
    }

    public static DoctorService getDoctorService() {
        return getClient("https://equipoyosh.com/stock-nutrinatalia/").create(DoctorService.class);
    }
    public static ReservaService getReservaService() {
        return getClient("https://equipoyosh.com/stock-nutrinatalia/").create(ReservaService.class);
        //return getClient("https://equipoyosh.com").create(ReservaService.class);
    }


    public static Retrofit getClient(String baseUrl) {

        return new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

    }
}
