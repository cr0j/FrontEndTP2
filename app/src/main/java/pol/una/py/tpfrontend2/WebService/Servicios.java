package pol.una.py.tpfrontend2.WebService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Servicios {
    public static ApiRest getServicio() {
        return getClient("https://equipoyosh.com/stock-nutrinatalia/").create(ApiRest.class);
    }
    public static Retrofit getClient(String baseUrl) {

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
}
