package pol.una.py.tpfrontend2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView button= (CardView) findViewById(R.id.card_fichas);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FichaClinicaActivity.class));
            }
        });

        CardView btnReserva= (CardView) findViewById(R.id.card_reservas);
        btnReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ReservasActivity.class));
            }

        });

        CardView btnPaciente= (CardView) findViewById(R.id.card_pacientes);
        btnPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PacientesActivity.class));
            }

        });


    }


}
