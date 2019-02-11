package com.example.santi.razasypelajestettamanti;

import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class RazasyPelajesImagenPalabra extends InteraccionMinijuego {

    protected ConstraintLayout setLayout(){
        return (ConstraintLayout) View.inflate(this, R.layout.interaccion_imagen_palabra, null);
    }

    protected Class getSiguienteMinijuego(){
        if (firstActivity)
            return RazasyPelajesImagenPalabra.class;
        else
            return CruzasImagenImagen.class;
    };

    protected void setOpciones(){
        LinearLayout textos = (LinearLayout) findViewById(R.id.opciones);
        Random rand = new Random();
        int posicionGanadora = rand.nextInt(4);
        for (int i=0; i<textos.getChildCount(); i++){
            LinearLayout caja = (LinearLayout) textos.getChildAt(i);
            TextView texto = ((TextView) caja.getChildAt(0));
            texto.setText("");
            if (i == posicionGanadora) {
                texto.append(caballoGanador.raza);
                idGanador = texto.getId();
            }
            else if (caballos[i].imagen == caballoGanador.imagen) {
                int index = i+1;
                if (index == textos.getChildCount())
                    index = 0;
                texto.append(caballos[index].raza);
            }
            else
                texto.append(caballos[i].raza);
        }

    }

    @Override
    protected View getOpcionesChild(LinearLayout opciones, int index){
        return ((LinearLayout) opciones.getChildAt(index)).getChildAt(0);
    }

    protected void setIncognita(){
        ImageView imagenCaballo = (ImageView) findViewById(R.id.imagenCaballo);
        imagenCaballo.setImageResource(caballoGanador.imagen);
    }

}
