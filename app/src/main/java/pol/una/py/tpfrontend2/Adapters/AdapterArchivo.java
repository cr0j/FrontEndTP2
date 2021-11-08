package pol.una.py.tpfrontend2.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import pol.una.py.tpfrontend2.Modelos.Archivo;
import pol.una.py.tpfrontend2.R;

public class AdapterArchivo extends RecyclerView.Adapter<AdapterArchivo.AdapterArchivoHolder>
        implements View.OnClickListener{

    private View.OnClickListener listener;

    Archivo[] lista;

    public AdapterArchivo(Archivo[] lista) {
        this.lista=lista;
    }

    @NonNull
    @Override
    public AdapterArchivoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_archivo, parent,false);
        v.setOnClickListener(this);
        AdapterArchivoHolder ac=new AdapterArchivoHolder(v);

        return ac;

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterArchivoHolder holder, final int position) {
        if(lista[position].getIdFichaClinica()!=null)
            holder.tvFichaId.setText("Archivo " + lista[position].getIdFichaClinica());
        if(lista[position].getNombre()!=null)
            holder.tvNombre.setText(lista[position].getNombre());
        if(lista[position].getUrlImagen()!=null)
            holder.tvUrl.setText(lista[position].getUrlImagen());
    }

    @Override
    public int getItemCount() {
        return lista.length;
    }

    @Override
    public void onClick(View v) {
        listener.onClick(v);
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public static class AdapterArchivoHolder extends RecyclerView.ViewHolder {
        TextView tvFichaId;
        TextView tvUrl;
        TextView tvNombre;

        public AdapterArchivoHolder(View v){
            super(v);
            tvNombre=v.findViewById(R.id.txtArchivoNombre);
            tvFichaId=v.findViewById(R.id.txtArchivoFichaId);
            tvUrl=v.findViewById(R.id.txtArchivoURL);
        }
    }

}