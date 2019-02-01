package com.example.santi.razasypelajestettamanti;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class RazasYPelajes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razas_ypelajes);

        this.setBotonSettingsBehaviour();

        this.setBotonReconocimientoBehaviour();

        this.setBotonJugarBehaviour();

        this.setBotonAyudaBehaviour();

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
    }

    private void setBotonSettingsBehaviour(){
        ImageButton settingsButton = (ImageButton) findViewById(R.id.botonConfiguracion);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentSettings = new Intent(RazasYPelajes.this, Preferences.class);
                startActivity(intentSettings);
            }
        });
    }

    private void setBotonJugarBehaviour(){
        ImageButton playButton = (ImageButton) findViewById(R.id.botonJugar);
        playButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentMinijuego = new Intent(RazasYPelajes.this, MinijuegoRazasyPelajes.class);
                startActivity(intentMinijuego);
            }
        });
    }

    private void setBotonAyudaBehaviour(){
        ImageButton botonAyuda = (ImageButton) findViewById(R.id.botonAyuda);
        botonAyuda.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                AyudaFragment ayuda = new AyudaFragment();
                ayuda.setText(R.string.ayudaPrincipal);
                ayuda.show(fragmentManager, "dialog");
            }
        });
    }

    private void setBotonReconocimientoBehaviour(){
        ImageButton botonReconocimiento = (ImageButton) findViewById(R.id.botonReconocimiento);
        botonReconocimiento.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentReconocimiento = new Intent(RazasYPelajes.this, Reconocimiento.class);
                startActivity(intentReconocimiento);
            }
        });
    }
}
