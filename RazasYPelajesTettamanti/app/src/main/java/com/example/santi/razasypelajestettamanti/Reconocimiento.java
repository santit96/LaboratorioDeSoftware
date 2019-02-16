package com.example.santi.razasypelajestettamanti;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        LinearLayout fragContainer = (LinearLayout) findViewById(R.id.listaLista);

        if (formato.equals("Lista")) {
            getFragmentManager().beginTransaction().add(fragContainer.getId(), new ReconocimientoRazasYPelajesLista(), "someTag1").commit();
        }
        else {
            getFragmentManager().beginTransaction().add(fragContainer.getId(), new ReconocimientoRazasYPelajesMatriz(), "someTag1").commit();
        }
    }

    private void setHomeBehaviour(){
        ImageButton botonHome = (ImageButton) findViewById(R.id.home_reconocimiento);
        botonHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent homeIntent = new Intent(v.getContext(), RazasYPelajes.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });
    }

}
