package pol.una.py.tpfrontend2.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Archivo {
    @SerializedName("idFichaArchivo")
    @Expose
    private Integer idFichaArchivo;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("urlImagen")
    @Expose
    private String urlImagen;

    public Archivo(){}
    public Integer getIdFichaClinica() {
        return idFichaArchivo;
    }

    public void setIdFichaClinica(Integer idFichaClinica) {
        this.idFichaArchivo = idFichaClinica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
