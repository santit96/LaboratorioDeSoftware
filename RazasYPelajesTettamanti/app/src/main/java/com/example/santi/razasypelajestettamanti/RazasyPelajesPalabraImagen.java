package com.example.santi.razasypelajestettamanti;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class RazasyPelajesPalabraImagen extends Minijuego {

    int imagenGanadora;

    protected ConstraintLayout setLayout(){
        return (ConstraintLayout) View.inflate(this, R.layout.interaccion_palabra_imagen, null);
    }

    protected Class getSiguienteMinijuego(){
        return RazasYPelajes.class;
    };

    protected void updateRonda(){
        this.setRazaOPelajeText();
        this.setImages();
        this.setImagesBehaviour();
    }

    private void setImages(){
        LinearLayout imagenes = (LinearLayout) findViewById(R.id.imagenes);
        Random rand = new Random();
        int posicionGanadora = rand.nextInt(4);
        for (int i=0; i<imagenes.getChildCount(); i++){
            if (i == posicionGanadora) {
                imagenes.getChildAt(i).setBackgroundResource(caballoGanador.imagen);
                imagenGanadora = imagenes.getChildAt(i).getId();
            }
            else if (caballos[i].imagen == caballoGanador.imagen)
                imagenes.getChildAt(i).setBackgroundResource(caballos[i+1].imagen);
            else
                imagenes.getChildAt(i).setBackgroundResource(caballos[i].imagen);

        }

    }

    private void setImagesBehaviour() {
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
                    MediaPlayer mp;
                    if (v.getId() == imagenGanadora) {
                        texto_resultado.append(getResources().getString(R.string.resultado_correcto));
                        texto_resultado.setTextColor(getResources().getColor(R.color.colorGanador));
                        image_resultado.setImageResource(R.drawable.check);
                        mp = MediaPlayer.create(v.getContext(),R.raw.correcto);

                    }
                    else {
                        texto_resultado.append(getResources().getString(R.string.resultado_incorrecto));
                        texto_resultado.setTextColor(getResources().getColor(R.color.colorPerdedor));
                        image_resultado.setImageResource(R.drawable.x);
                        mp = MediaPlayer.create(v.getContext(),R.raw.incorrecto);

                    }
                    mp.start();
                    nuevaRonda();
                }
            });
        }
    }

    private void setRazaOPelajeText(){
        TextView pelajeORaza = (TextView) findViewById(R.id.pelajeORaza);
        String pelajeORazaText = this.setPelajeORaza();
        pelajeORaza.setText("");
        pelajeORaza.append(pelajeORazaText);
    }

    private String setPelajeORaza(){
        Random rand = new Random();
        int eleccion = rand.nextInt(2);
        if (eleccion == 1)
            return caballoGanador.pelaje;
        else
            return caballoGanador.raza;
    }

    protected void setAyudaBehaviour(){
        ImageButton botonAyuda = (ImageButton) findViewById(R.id.botonAyuda);
        botonAyuda.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                AyudaFragment ayuda = new AyudaFragment();
                setAyudaText(ayuda);
                ayuda.show(fragmentManager, "dialog");
            }
        });
    }

    protected void setAyudaText(AyudaFragment ayuda){
        ayuda.setText(R.string.ayudaMinijuego);

    }
}

