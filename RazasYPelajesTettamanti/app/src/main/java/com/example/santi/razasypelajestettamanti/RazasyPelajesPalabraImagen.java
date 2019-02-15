package com.example.santi.razasypelajestettamanti;

import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class RazasyPelajesPalabraImagen extends InteraccionMinijuego {

    private int pelajeORaza;

    protected ConstraintLayout setLayout(){
        return (ConstraintLayout) View.inflate(this, R.layout.interaccion_palabra_imagen, null);
    }

    protected Class getSiguienteMinijuego(){
        if (firstActivity)
            return RazasyPelajesPalabraImagen.class;
        else
            return CruzasImagenImagen.class;
    };

    protected void setContenidoAOpcion(View v, int indiceCaballos, int indiceOpcion){
        ImageView image = (ImageView) v;
        image.setBackgroundResource(caballos[indiceCaballos].imagen);
    }


    protected void setIncognita(){
        TextView pelajeORaza = (TextView) findViewById(R.id.pelajeORaza);
        String pelajeORazaText = this.setPelajeORaza();
        pelajeORaza.setText("");
        if (firstActivity) {
            pelajeORaza.append(pelajeORazaText);
            if (this.pelajeORaza == 1)
                this.setAudio(caballoGanador.audio_pelaje_femenino);
            else
                this.setAudio(caballoGanador.audio_pelaje_masculino);
        }
        else{
            pelajeORaza.append(caballoGanador.pelaje);
            pelajeORaza.append(" y ");
            pelajeORaza.append(caballoGanador.raza);
            this.setAudio(caballoGanador.audio_pelaje_femenino);
        }


    }

    private void setAudio(int id){
        final int audioId = id;
        ImageView audio = (ImageView) findViewById(R.id.voz);
        audio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(v.getContext(),audioId);
                mp.start();
            }
        });

    }

    private String setPelajeORaza(){
        Random rand = new Random();
        pelajeORaza = rand.nextInt(2);
        if (pelajeORaza == 1)
            return caballoGanador.pelaje;
        else
            return caballoGanador.raza;
    }

}

