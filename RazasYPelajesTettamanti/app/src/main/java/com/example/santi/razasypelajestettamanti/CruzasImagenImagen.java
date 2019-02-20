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

    protected int setContenidoAOpcion(View v, int indiceCaballos, int indiceOpcion){
        ImageView image = (ImageView) v;
        image.setBackgroundResource(((CaballoCruza) caballos[indiceCaballos]).imagen);
        return indiceCaballos;
    }

    protected void setIncognita(){
        ImageView imagenCaballoPadre = (ImageView) findViewById(R.id.imagenCaballoPadre);
        imagenCaballoPadre.setImageResource(((CaballoCruza)caballoGanador).imagen_padre);
        ImageView imagenCaballoMadre = (ImageView) findViewById(R.id.imagenCaballoMadre);
        imagenCaballoMadre.setImageResource(((CaballoCruza)caballoGanador).imagen_madre);
    }

    protected void pantallaGanador() {
        siguienteMinijuego();
    }

    protected int getCurrentActivityNumber(){
        return 3;
    }

}
