package pol.una.py.tpfrontend2.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TipoProducto {

    @SerializedName("idTipoProducto")
    @Expose
    private Integer idTipoProducto;

    @SerializedName("idCategoria")
    @Expose
    private Categoria idCategoria;

    TipoProducto(Integer id, Categoria cat){
        idTipoProducto = id;
        idCategoria = cat;
    }

    public String getNombreCategoria() {
        return idCategoria.getDescripcion();
    }

    public Integer getIdTipoProducto(){return idTipoProducto;}
}
