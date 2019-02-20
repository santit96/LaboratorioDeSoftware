package com.example.santi.razasypelajestettamanti;

import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;

public class CruzasImagenImagen extends InteraccionMinijuego {

    protected ConstraintLayout setLayout(){
        return (ConstraintLayout) View.inflate(this, R.layout.interaccion_imagen_imagen, null);
    }

    protected Caballo[] getCaballos(){
        return new Caballos(getBaseContext()).cruzas;
    }

    protected Class getSiguienteMinijuego(){
        return Campeon.class;
    };

    protected void setContenidoAOpcion(View v, int indiceCaballos, int indiceOpcion){
        ImageView image = (ImageView) v;
        image.setBackgroundResource(((CaballoCruza) caballos[indiceCaballos]).imagen_madre);
    }

    protected void setIncognita(){
        ImageView imagenCaballo = (ImageView) findViewById(R.id.imagenCaballo2);
        imagenCaballo.setImageResource(caballoGanador.imagen);
    }

    protected void pantallaGanador() {
        siguienteMinijuego();
    }

    protected int getCurrentActivityNumber(){
        return 3;
    }

}
