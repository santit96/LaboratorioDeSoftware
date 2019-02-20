package com.example.santi.razasypelajestettamanti;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class RazasyPelajesImagenPalabra extends InteraccionMinijuego {

    private int pelajeORaza = -1;

    protected ConstraintLayout setLayout(){
        return (ConstraintLayout) View.inflate(this, R.layout.interaccion_imagen_palabra, null);
    }

    protected Class getSiguienteMinijuego(){
        if (firstActivity)
            return RazasyPelajesImagenPalabra.class;
        else
            return CruzasImagenImagen.class;
    }

    protected void setContenidoAOpcion(View v, int indiceCaballos, int indiceOpcion){
        TextView texto = (TextView) v;
        texto.setText("");
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(v.getContext());
        boolean voz_femenina = sp.getBoolean("switch_voz",false);
        if (firstActivity) {
            int eleccion = this.pelajeORaza();
            if (eleccion == 1) {
                texto.append(caballos[indiceCaballos].pelaje);
                if (voz_femenina)
                    setAudio(indiceOpcion,caballos[indiceCaballos].audio_pelaje_femenino);
                else
                    setAudio(indiceOpcion,caballos[indiceCaballos].audio_pelaje_masculino);
            }
            else {
                texto.append(caballos[indiceCaballos].raza);
                if (voz_femenina)
                    setAudio(indiceOpcion,caballos[indiceCaballos].audio_raza_femenino);
                else
                    setAudio(indiceOpcion,caballos[indiceCaballos].audio_raza_masculino);
            }

        }
        else{
            texto.append(caballos[indiceCaballos].raza);
            texto.append(" y ");
            texto.append(caballos[indiceCaballos].pelaje);
            if (voz_femenina)
                setAudio(indiceOpcion,caballos[indiceCaballos].audio_pelajeyraza_femenino);
        }
    }

    private void setAudio(int indiceOpcion, int audioId){
        final int id = audioId;
        LinearLayout opciones = (LinearLayout) findViewById(R.id.opciones);
        ImageView audio = (ImageView) ((LinearLayout) opciones.getChildAt(indiceOpcion)).getChildAt(1);
        audio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(v.getContext(), id);
                mp.start();
            }
        });

    }

    private int pelajeORaza(){
        if (pelajeORaza != -1) {
            Random rand = new Random();
            pelajeORaza = rand.nextInt(2);
        }
        return pelajeORaza;
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
