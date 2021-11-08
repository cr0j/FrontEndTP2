package pol.una.py.tpfrontend2.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Categoria {
    @SerializedName("idCategoria")
    @Expose
    private Integer idCategoria;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("flagVisible")
    @Expose
    private String flagVisible;
    @SerializedName("posicion")
    @Expose
    private Integer posicion;

    public Categoria() {
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFlagVisible() {
        return flagVisible;
    }

    public void setFlagVisible(String flagVisible) {
        this.flagVisible = flagVisible;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }
}
