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
    }

    protected void setContenidoAOpcion(View v, int indiceCaballos){
        TextView texto = (TextView) v;
        texto.setText("");
        if (firstActivity) {
            texto.append(this.pelajeORaza(indiceCaballos));
        }
        else{
            texto.append(caballos[indiceCaballos].pelaje);
            texto.append(" y ");
            texto.append(caballos[indiceCaballos].raza);
        }
    }

    private String pelajeORaza(int index){
        Random rand = new Random();
        int eleccion = rand.nextInt(2);
        if (eleccion == 1)
            return caballos[index].pelaje;
        else
            return caballos[index].raza;
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
