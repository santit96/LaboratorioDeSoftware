package com.example.santi.razasypelajestettamanti;

import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class RazasyPelajesPalabraImagen extends InteraccionMinijuego {

    protected ConstraintLayout setLayout(){
        return (ConstraintLayout) View.inflate(this, R.layout.interaccion_palabra_imagen, null);
    }

    protected Class getSiguienteMinijuego(){
        if (firstActivity)
            return RazasyPelajesPalabraImagen.class;
        else
            return CruzasImagenImagen.class;
    };

    protected void setContenidoAOpcion(View v, int indiceCaballos){
        ImageView image = (ImageView) v;
        image.setBackgroundResource(caballos[indiceCaballos].imagen);
    }


    protected void setIncognita(){
        TextView pelajeORaza = (TextView) findViewById(R.id.pelajeORaza);
        String pelajeORazaText = this.setPelajeORaza();
        pelajeORaza.setText("");
        if (firstActivity) {
            pelajeORaza.append(pelajeORazaText);
        }
        else{
            pelajeORaza.append(caballoGanador.pelaje);
            pelajeORaza.append(" y ");
            pelajeORaza.append(caballoGanador.raza);
        }
    }

    private String setPelajeORaza(){
        Random rand = new Random();
        int eleccion = rand.nextInt(2);
        if (eleccion == 1)
            return caballoGanador.pelaje;
        else
            return caballoGanador.raza;
    }

}

