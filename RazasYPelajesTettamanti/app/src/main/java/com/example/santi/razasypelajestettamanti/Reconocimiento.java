package com.example.santi.razasypelajestettamanti;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.Set;

public class Reconocimiento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reconocimiento);
        setFragmentListaOMatriz();
        setHomeBehaviour();
    }

    private void setFragmentListaOMatriz(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String formato = sp.getString("list_formato_reconocimiento", "");
        Set<String> modosReconocimiento = sp.getStringSet("multi_select_modo_reconocimiento",null);
        LinearLayout fragContainer = (LinearLayout) findViewById(R.id.listaLista);

        if (formato.equals("Lista")) {
            if (modosReconocimiento.contains("Razas y pelajes"))
                getFragmentManager().beginTransaction().add(fragContainer.getId(), new ReconocimientoRazasYPelajesLista(), "someTag1").commit();
            if (modosReconocimiento.contains("Cruzas"))
                getFragmentManager().beginTransaction().add(fragContainer.getId(), new ReconocimientoCruzasLista(), "someTag1").commit();
        }
        else {
            if (modosReconocimiento.contains("Razas y pelajes"))
                getFragmentManager().beginTransaction().add(fragContainer.getId(), new ReconocimientoRazasYPelajesMatriz(), "someTag1").commit();
            if (modosReconocimiento.contains("Cruzas"))
                getFragmentManager().beginTransaction().add(fragContainer.getId(), new ReconocimientoCruzasMatriz(), "someTag1").commit();
        }
    }

    private void setHomeBehaviour(){
        ImageButton botonHome = (ImageButton) findViewById(R.id.home_reconocimiento);
        botonHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent homeIntent = new Intent(v.getContext(), RazasYPelajes.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Bundle b = getIntent().getExtras();
                if(b != null) {
                    b.putInt("currentActivity", b.getInt("currentActivity"));
                    homeIntent.putExtras(b);
                }
                startActivity(homeIntent);
            }
        });
    }

}
