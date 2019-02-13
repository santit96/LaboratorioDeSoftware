package com.example.santi.razasypelajestettamanti;

import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;

public class CruzasImagenImagen extends InteraccionMinijuego {

    protected ConstraintLayout setLayout(){
        return (ConstraintLayout) View.inflate(this, R.layout.interaccion_imagen_imagen, null);
    }

    protected Class getSiguienteMinijuego(){
        return Campeon.class;
    };

    protected void setContenidoAOpcion(View v, int indiceCaballos){
        ImageView image = (ImageView) v;
        image.setBackgroundResource(caballos[indiceCaballos].imagen);
    }

    protected void setIncognita(){
        ImageView imagenCaballo = (ImageView) findViewById(R.id.imagenCaballo2);
        imagenCaballo.setImageResource(caballoGanador.imagen);
    }

    protected void pantallaGanador() {
        siguienteMinijuego();
    }

}
