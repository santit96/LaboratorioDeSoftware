package com.example.santi.razasypelajestettamanti;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class RazasYPelajes extends AppCompatActivity {

    private int currentActivity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razas_y_pelajes);

        this.setBotonSettingsBehaviour();

        this.setBotonReconocimientoBehaviour();

        this.setBotonJugarBehaviour();

        this.setBotonAyudaBehaviour();

        Bundle b = getIntent().getExtras();
        if(b != null)
            currentActivity = b.getInt("currentActivity");

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
    }

    private void setBotonSettingsBehaviour(){
        ImageButton settingsButton = (ImageButton) findViewById(R.id.botonConfiguracion);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentSettings = new Intent(RazasYPelajes.this, Preferences.class);
                if (currentActivity == 3) {
                    Bundle b = new Bundle();
                    b.putBoolean("lastMinijuego", true);
                    intentSettings.putExtras(b);
                }
                startActivity(intentSettings);
            }
        });
    }

    private void setBotonJugarBehaviour(){
        ImageButton playButton = (ImageButton) findViewById(R.id.botonJugar);
        playButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(v.getContext());
                String formato = sp.getString("list_mini_juego","Razas y Pelajes: Imagen-Palabras");
                Intent intentMinijuego;
                switch (currentActivity) {
                    case 2:
                        if (formato.equals("Razas y Pelajes: Imagen-Palabras"))
                            intentMinijuego = new Intent(RazasYPelajes.this, RazasyPelajesImagenPalabra.class);
                        else
                            intentMinijuego = new Intent(RazasYPelajes.this, RazasyPelajesPalabraImagen.class);
                        break;
                    case 3:
                        intentMinijuego = new Intent(RazasYPelajes.this, CruzasImagenImagen.class);
                        break;
                    default:
                        if (formato.equals("Razas y Pelajes: Imagen-Palabras"))
                            intentMinijuego = new Intent(RazasYPelajes.this, RazasyPelajesImagenPalabra.class);
                        else
                            intentMinijuego = new Intent(RazasYPelajes.this, RazasyPelajesPalabraImagen.class);
                        Bundle b = new Bundle();
                        b.putBoolean("firstActivity", true);
                        intentMinijuego.putExtras(b);
                        break;
                }
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
                Bundle b = new Bundle();
                b.putInt("currentActivity", currentActivity);
                intentReconocimiento.putExtras(b);
                startActivity(intentReconocimiento);
            }
        });
    }
}
