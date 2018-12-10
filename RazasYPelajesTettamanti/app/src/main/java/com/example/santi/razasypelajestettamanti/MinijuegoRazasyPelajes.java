package com.example.santi.razasypelajestettamanti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MinijuegoRazasyPelajes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minijuego_razasy_pelajes_interaccion_b);

        TextView pelajeORaza = (TextView) findViewById(R.id.pelajeORaza);
        String pelaje= getResources().getStringArray(R.array.pelajes)[1];
        pelajeORaza.append(pelaje);

        LinearLayout imagenes = (LinearLayout) findViewById(R.id.imagenes);
        int cantImagenes = imagenes.getChildCount();
        for (int i=0; i<cantImagenes; i++){
            imagenes.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    LinearLayout resultado = (LinearLayout) findViewById(R.id.layout_resultado);
                    resultado.setVisibility(View.VISIBLE);
                    TextView texto_resultado = (TextView) findViewById(R.id.resultado);
                    texto_resultado.setText("");
                    ImageView image_resultado = (ImageView) findViewById(R.id.imagen_resultado);
                    if (v.getId() == R.id.imagen1) {
                        texto_resultado.append(getResources().getString(R.string.resultado_correcto));
                        image_resultado.setImageResource(R.drawable.check);

                    }
                    else {
                        texto_resultado.append(getResources().getString(R.string.resultado_incorrecto));
                        image_resultado.setImageResource(R.drawable.x);

                    }
                }
            });
        }


    }
}