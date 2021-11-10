package com.example.tpfrontend2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import actividadPaciente.PacientesActivity;

public class MenuPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }

    public void abrir(View v){
        String tag=v.getTag().toString();
        Intent intentNewActivity;
        Bundle b = new Bundle();
        //b.putString("usuario",campoNombreUsuario.getText().toString());
        switch (tag){
            case "Reservas":
                intentNewActivity = new Intent(MenuPrincipalActivity.this, ReservaActivity.class);
                intentNewActivity.putExtras(b);
                startActivity(intentNewActivity);
                break;
            case "Pacientes":
                intentNewActivity = new Intent(MenuPrincipalActivity.this, PacientesActivity.class);
                intentNewActivity.putExtras(b);
                startActivity(intentNewActivity);
                break;
            case "Fichas":
                intentNewActivity = new Intent(MenuPrincipalActivity.this, ListaFichaActivity.class);
                intentNewActivity.putExtras(b);
                startActivity(intentNewActivity);
                break;
            default:
                break;
        }





    }
}
