package com.example.santi.razasypelajestettamanti;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RazasyPelajesPalabraImagen extends InteraccionMinijuego {

    private List<String> pelajesEnuso = new ArrayList<>();
    private List<String> razasEnuso = new ArrayList<>();

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

    protected int setContenidoAOpcion(View v, int indiceCaballos,int indiceOpcion){
        ImageView image = (ImageView) v;
        while (this.razaOPelajeRepetido(indiceCaballos)){
            indiceCaballos++;
            if (indiceCaballos== caballos.length)
                indiceCaballos=0;
        }
        image.setBackgroundResource(caballos[indiceCaballos].imagen);
        razasEnuso.add(caballos[indiceCaballos].raza);
        pelajesEnuso.add(caballos[indiceCaballos].pelaje);
        return indiceCaballos;
    }

    private boolean razaOPelajeRepetido(int indiceCaballos){
        if (firstActivity)
            return (razasEnuso.contains(caballos[indiceCaballos].raza) || pelajesEnuso.contains(caballos[indiceCaballos].pelaje));
        else
            return (razasEnuso.contains(caballos[indiceCaballos].raza) && pelajesEnuso.contains(caballos[indiceCaballos].pelaje));
    }

    protected void setIncognita(){
        TextView pelajeORaza = (TextView) findViewById(R.id.pelajeORaza);
        String pelajeORazaText = this.setPelajeORaza();
        pelajeORaza.setText("");
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        boolean voz_femenina = sp.getBoolean("switch_voz",false);
        if (firstActivity) {
            pelajeORaza.append(pelajeORazaText);
            if (this.pelajeORaza == 1 && voz_femenina){
                    this.setAudio(caballoGanador.audio_pelaje_femenino);
            }
            else if (this.pelajeORaza == 1){
                    this.setAudio(caballoGanador.audio_pelaje_masculino);
            }
            else if (voz_femenina){
                    this.setAudio(caballoGanador.audio_raza_femenino);
            }
            else{
                this.setAudio(caballoGanador.audio_raza_masculino);
            }
        }
        else{
            pelajeORaza.append(caballoGanador.raza);
            pelajeORaza.append("\n + \n");
            pelajeORaza.append(caballoGanador.pelaje);
            if (voz_femenina)
                this.setAudio(caballoGanador.audio_pelajeyraza_femenino);
            else
                this.setAudio(caballoGanador.audio_pelajeyraza_masculino);
        }

        razasEnuso.clear();
        pelajesEnuso.clear();
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

