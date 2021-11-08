package pol.una.py.tpfrontend2.WebService;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import pol.una.py.tpfrontend2.Modelos.Archivo;
import pol.una.py.tpfrontend2.Modelos.Categoria;
import pol.una.py.tpfrontend2.Modelos.FichaClinica;
import pol.una.py.tpfrontend2.Modelos.Lista;
import pol.una.py.tpfrontend2.Modelos.Paciente;
import pol.una.py.tpfrontend2.Modelos.PersonaLogin;
import pol.una.py.tpfrontend2.Modelos.Reserva;
import pol.una.py.tpfrontend2.Modelos.TipoProducto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiRest {

    @GET("reserva")
    Call<Lista<Reserva>> obtenerReservas(@Query("orderBy") String orderBy,
                                         @Query("orderDir") String orderDir);

    @GET("reserva")
    Call<Lista<Reserva>> obtenerReservasSimple();

    @GET("reserva")
    Call<Lista<Reserva>> obtenerReservasFilter(@Query("ejemplo") JSONObject obj);

    @GET("reserva/{id}")
    Call<Reserva> obtenerReserva(@Path("id") int idReserva);

    @GET("persona/{id}/agenda")
    Call<List<Reserva>> obtenerAgenda(@Path("id") int idMedico, @Query("fecha") String fecha,@Query("disponible") String disponible);

    @Headers({
            "Content-Type: application/json",
            "usuario:gustavo"
    })
    @POST("reserva")
    Call<Reserva> guardarReserva(@Body Reserva obj);


    @GET("categoria")
    Call<Lista<Categoria>> obtenerCategorias(@Query("orderBy") String orderBy,
                                             @Query("orderDir") String orderDir);

    @POST("categoria")
    Call<Categoria> agregarCategoria(@Body Categoria categoria);

    @PUT("categoria")
    Call<Categoria> actualizarCategoria(@Body Categoria categoria);

    @GET("fichaClinica")
    Call<Lista<FichaClinica>> obtenerFichasClinicas();

    @Headers({
            "Content-Type: application/json",
            "usuario:gustavo"
    })
    @PUT("fichaClinica")
    Call<FichaClinica> actualizarFichaClinica(@Body FichaClinica obj);

    @Headers({
            "Content-Type: application/json",
            "usuario:gustavo"
    })
    @POST("fichaClinica")
    Call<FichaClinica> guardarFichaClinica(@Body FichaClinica obj);

    @GET("fichaClinica")
    Call<Lista<FichaClinica>> obtenerFichasClinicasFilter(@Query("ejemplo") JSONObject obj);

    @GET("persona")
    Call<Lista<PersonaLogin>> obtenerPersonas(@Query("ejemplo") JSONObject obj);

    @Headers("Content-Type: application/json")
    @POST("persona")
    Call<Paciente> guardarPaciente(@Body Paciente obj);

    @Headers({
            "Content-Type: application/json",
            "usuario:gustavo"
    })
    @PUT("persona")
    Call<Void> actualizarPaciente(@Body Paciente obj);

    @GET("persona")
    Call<Lista<Paciente>> obtenerPacientesFilter(@Query("ejemplo") JSONObject obj, @Query("like") String like);

    @GET("persona")
    Call<Lista<Paciente>> obtenerPacientes();

    @GET("tipoProducto")
    Call<Lista<TipoProducto>> obtenerTipoProductos();


    @FormUrlEncoded
    @POST("fichaArchivo/archivo")
    Call<String> guardarArchivo(@FieldMap Map<String,Object> params);

    @GET("fichaArchivo")
    Call<Lista<Archivo>> getArchivo(@Query("orderBy") String orderBy,
                                             @Query("orderDir") String orderDir);

    @GET("fichaArchivo")
    Call<Lista<Archivo>> getArchivos(@Query("idFichaClinica") Integer id);

    @DELETE("fichaArchivo/{id}")
    Call<Void> deleteArchivo(@Path("id") Integer idFichaArchivo);

}
