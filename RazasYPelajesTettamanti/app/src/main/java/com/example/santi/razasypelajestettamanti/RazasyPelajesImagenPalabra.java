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

public class RazasyPelajesImagenPalabra extends Minijuego {

    protected ConstraintLayout setLayout(){
        return (ConstraintLayout) View.inflate(this, R.layout.interaccion_imagen_palabra, null);
    }

    protected Class getSiguienteMinijuego(){
        return CruzasImagenImagen.class;
    };

    protected void updateRonda(){
        this.setImagen();
        this.setTextos();
        this.setTextosBehaviour();
    }

    private void setTextos(){
        LinearLayout textos = (LinearLayout) findViewById(R.id.razasOPelajes);
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

    private void setTextosBehaviour() {
        LinearLayout textos = (LinearLayout) findViewById(R.id.razasOPelajes);
        int cantTextos = textos.getChildCount();
        for (int i=0; i<cantTextos; i++){
            ((LinearLayout) textos.getChildAt(i)).getChildAt(0).setOnClickListener(new View.OnClickListener() {
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
        ImageView imagenCaballo = (ImageView) findViewById(R.id.imagenCaballo);
        imagenCaballo.setImageResource(caballoGanador.imagen);
    }

    protected void setAyudaBehaviour(){
        ImageButton botonAyuda = (ImageButton) findViewById(R.id.botonAyuda2);
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
