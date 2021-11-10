package com.example.tpfrontend2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tpfrontend2.modelos.Paciente;
import com.example.tpfrontend2.modelos.Reserva;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditarAgregarReservaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //Calendario para obtener fecha & hora
    public final Calendar c = Calendar.getInstance();

    //Variables para obtener la fecha
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);

    Reserva reserva_modificar = null;
    Integer idReservaEditar = null;
    EditText txtObservacion;
    CheckBox AsistioSi;
    Paciente paciente;
    Paciente doctor;
    TextView paciente_txt;
    TextView doctor_txt;
    TextView HoraInicio_txt;
    TextView HoraFin_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_agregar_reserva);
        txtObservacion=findViewById(R.id.txtObservacion);
        AsistioSi = (CheckBox) findViewById(R.id.ckAsistioSi);
        paciente_txt = findViewById(R.id.txtPaciente);
        doctor_txt = findViewById(R.id.txtDoctor);
        HoraInicio_txt = findViewById(R.id.txtHoraInicio);
        HoraFin_txt = findViewById(R.id.txtHoraFin);

        Bundle bundle = this.getIntent().getExtras();

        if (bundle!=null && bundle.containsKey("reservaEditar")) {
            reserva_modificar = (Reserva) bundle.getSerializable("reservaEditar");
            getSupportActionBar().setTitle("Ver Reserva "+reserva_modificar.getIdReserva());
            txtObservacion.setEnabled(true);
            AsistioSi.setEnabled(true);
            cargarCampos();
        }

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
    public void cancelarReserva(View v){
        if(reserva_modificar.getFlagAsistio()!= null || reserva_modificar.getFlagEstado().compareTo("C")== 0 || compararFecha(reserva_modificar.getFecha())<0) {
            Toast.makeText(EditarAgregarReservaActivity.this, "Reserva no se puede ser cancelada", Toast.LENGTH_LONG).show();
        }else {
            Call<Integer> callCancelarReserva = Servicios.getReservaService().cancelarReserva(reserva_modificar.getIdReserva());
            callCancelarReserva.enqueue(new Callback<Integer>() {
                @Override
                public void onResponse(Call<Integer> call, Response<Integer> response) {
                    Toast.makeText(EditarAgregarReservaActivity.this, "Reserva cancelada", Toast.LENGTH_SHORT).show();
                    finish();
                }

                @Override
                public void onFailure(Call<Integer> call, Throwable t) {

                }
            });
        }
    }

    private void cargarCampos(){
        txtObservacion.setText(reserva_modificar.getObservacion());
        AsistioSi.setChecked(reserva_modificar.getFlagAsistio() != null && reserva_modificar.getFlagAsistio().compareTo("S") == 0);

        doctor_txt.setText(reserva_modificar.getIdEmpleado().getNombre());
        paciente_txt.setText(reserva_modificar.getIdCliente().getNombre());
        HoraInicio_txt.setText(reserva_modificar.getHoraInicio());
        HoraFin_txt.setText(reserva_modificar.getHoraFin());
    }

    public void guardar(View view) {

        Reserva reserva=new Reserva();
        if(reserva_modificar != null){

            if(reserva_modificar.getFlagAsistio()!= null || reserva_modificar.getFlagEstado().compareTo("C")== 0 || compararFecha(reserva_modificar.getFecha())<0){
                Toast.makeText(EditarAgregarReservaActivity.this,"Reserva no se puede modificar",Toast.LENGTH_LONG).show();
            }else {

                reserva.setIdReserva(reserva_modificar.getIdReserva());
                reserva.setObservacion(txtObservacion.getText().toString());

                reserva.setFlagAsistio(AsistioSi.isChecked() ? "S" : null);

                //Call<Void> callReserva = Servicios.getReservaService().modificarReserva(reserva, "gustavo");
                Call<Void> callReserva = Servicios.getReservaService().modificarReserva(reserva);
                callReserva.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(response.code()<400) {
                            Toast.makeText(EditarAgregarReservaActivity.this, "Reserva modificada exitosamente", Toast.LENGTH_LONG).show();
                            finish();
                        }
                        else{
                            Toast.makeText(EditarAgregarReservaActivity.this, "Ocurrio un error", Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(EditarAgregarReservaActivity.this, "Ocurrio un error", Toast.LENGTH_LONG).show();
                        Log.w("warning", t.getCause());
                    }
                });
            }
        }


    }
    public static boolean isEmpty(EditText editText) {

        String input = editText.getText().toString().trim();
        return input.length() == 0;

    }

    public static void setError(EditText editText, String errorString) {

        editText.setError(errorString);

    }

    public int compararFecha(String fechaReserva){
        int DIA;
        int Mes;
        int Anio;
        final int mesActual = mes + 1;


        Anio = Integer.parseInt(fechaReserva.substring(0,4));
        Mes = Integer.parseInt(fechaReserva.substring(5,7));
        DIA = Integer.parseInt(fechaReserva.substring(8,10));

        if(Anio < anio)
            return -1;
        else if (Mes < mesActual)
            return  -1;
        else if(DIA <= dia)
            return -1;
        else
            return 1;
    }
}
