package pol.una.py.tpfrontend2.Adapters;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;
        import pol.una.py.tpfrontend2.Modelos.Reserva;
        import pol.una.py.tpfrontend2.R;

        import java.util.List;

public class AdaparteReservarConsulta extends
        RecyclerView.Adapter<AdaparteReservarConsulta.AdaparteReservarConsultaHolder>
    implements View.OnClickListener
{

    private int[] checkedList;

    private View.OnClickListener listener;

    List<Reserva> lista;

    public AdaparteReservarConsulta(List<Reserva> lista) {
        this.lista=lista;
        checkedList = new int[lista.size()];
    }

    @NonNull
    @Override
    public AdaparteReservarConsultaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_disponibles_reserva, parent,false);
        AdaparteReservarConsultaHolder ac=new AdaparteReservarConsultaHolder(v);
        v.setOnClickListener(this);

        return ac;

    }

    @Override
    public void onBindViewHolder(@NonNull AdaparteReservarConsultaHolder holder, int position) {

        if(lista.get(position).getHoraInicioCadena()!=null){
            holder.tvHoraIni.setText("Hora Inicio:"+fortmatHour(lista.get(position).getHoraInicioCadena()));
        }

        if(lista.get(position).getHoraFinCadena()!=null){
            holder.tvHoraFin.setText("Hora Fin:"+fortmatHour(lista.get(position).getHoraFinCadena()));
        }

        if(lista.get(position).getIdCliente()!=null){
            holder.tvDisponibilidad.setText("Ocupado");
            //holder.rb.setEnabled(false);
        }else{
            holder.tvDisponibilidad.setText("Libre");
        }

        holder.tvTicket.setText("Nro: "+position);



    }

    private String fortmatHour(String hour){
        String ret = hour.substring(0,2)+":"+hour.substring(2,4);
        return ret;
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    @Override
    public void onClick(View v) {
        listener.onClick(v);
    }


    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }


    public static class AdaparteReservarConsultaHolder extends RecyclerView.ViewHolder {
        TextView tvHoraIni;
        TextView tvHoraFin;
        TextView tvDisponibilidad;
        //RadioButton rb;
        TextView tvTicket;


        public AdaparteReservarConsultaHolder(View v){
            super(v);
            tvHoraIni=v.findViewById(R.id.txtHoraIni);
            tvHoraFin=v.findViewById(R.id.txtHoraFin);
            tvDisponibilidad=v.findViewById(R.id.txtDisponiblidad);
           // rb = v.findViewById(R.id.rbSelecionado);
            tvTicket = v.findViewById(R.id.tvTicket);
        }
    }


}
