package com.example.santi.razasypelajestettamanti;

import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class CruzasImagenImagen extends Minijuego {

    protected ConstraintLayout setLayout(){
        return (ConstraintLayout) View.inflate(this, R.layout.interaccion_imagen_imagen, null);
    }

    protected Class getSiguienteMinijuego(){
        return RazasYPelajes.class;
    };

    protected void updateRonda(){
        this.setImagen();
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
                idGanador = imagenes.getChildAt(i).getId();
            }
            else if (caballos[i].imagen == caballoGanador.imagen) {
                int index = i+1;
                if (index == imagenes.getChildCount())
                    index = 0;
                imagenes.getChildAt(i).setBackgroundResource(caballos[index].imagen);
            }
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
                    MediaPlayer mp;
                    if (v.getId() == idGanador) {
                        mp = MediaPlayer.create(v.getContext(),R.raw.relincho);
                    }
                    else {
                        mp = MediaPlayer.create(v.getContext(),R.raw.resoplido);
                    }
                    mp.start();
                    nuevaRonda();
                }
            });
        }
    }

    private void setImagen(){
        ImageView imagenCaballo = (ImageView) findViewById(R.id.imagenCaballo2);
        imagenCaballo.setImageResource(caballoGanador.imagen);
    }

    protected void setAyudaBehaviour(){
        ImageButton botonAyuda = (ImageButton) findViewById(R.id.botonAyuda3);
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
