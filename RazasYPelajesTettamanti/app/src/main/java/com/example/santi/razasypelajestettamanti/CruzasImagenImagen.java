package com.example.santi.razasypelajestettamanti;

import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

public class CruzasImagenImagen extends InteraccionMinijuego {

    protected ConstraintLayout setLayout(){
        return (ConstraintLayout) View.inflate(this, R.layout.interaccion_imagen_imagen, null);
    }

    protected Class getSiguienteMinijuego(){
        return RazasYPelajes.class;
    };

    protected void setOpciones(){
        LinearLayout imagenes = (LinearLayout) findViewById(R.id.opciones);
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

    protected void setIncognita(){
        ImageView imagenCaballo = (ImageView) findViewById(R.id.imagenCaballo2);
        imagenCaballo.setImageResource(caballoGanador.imagen);
    }

}
