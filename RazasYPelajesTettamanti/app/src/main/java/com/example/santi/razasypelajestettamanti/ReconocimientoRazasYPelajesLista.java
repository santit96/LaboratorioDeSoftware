package com.example.santi.razasypelajestettamanti;


import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ReconocimientoRazasYPelajesLista extends ReconocimientoLista {

    protected void setCaballos(){
        caballos = new Caballos(getActivity()).caballos;
    }

    protected int getCurrentFragment(){ return R.layout.fragment_reconocimiento_razasypelajes_lista;}

    protected void setListaCaballos(LinearLayout listaReconocimiento) {
        for (int i = 1; i < listaReconocimiento.getChildCount(); i++) {
            LinearLayout infoCaballo = (LinearLayout) listaReconocimiento.getChildAt(i);
            if (i <= caballos.length) {
                ImageView imagenCaballo = (ImageView) infoCaballo.getChildAt(0);
                imagenCaballo.setImageResource(caballos[i - 1].imagen);
                LinearLayout textoYAudio = (LinearLayout) infoCaballo.getChildAt(1);
                TextView pelajeYRaza = (TextView) textoYAudio.getChildAt(0);
                pelajeYRaza.setText(caballos[i - 1].raza);
                pelajeYRaza.append("\n + \n");
                pelajeYRaza.append(caballos[i - 1].pelaje);
                ImageView audio = (ImageView) textoYAudio.getChildAt(1);
                TextView texto_descriptivo = (TextView) infoCaballo.getChildAt(2);
                texto_descriptivo.setText(caballos[i - 1].texto_desriptivo);
                final int index = i - 1;
                audio.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(v.getContext());
                        boolean voz_femenina = sp.getBoolean("switch_voz", false);
                        MediaPlayer mp;
                        if (voz_femenina) {
                            mp = MediaPlayer.create(v.getContext(), caballos[index].audio_pelajeyraza_femenino);
                        }
                        else{
                            mp = MediaPlayer.create(v.getContext(), caballos[index].audio_pelajeyraza_masculino);
                        }
                        mp.start();
                    }
                });
            }
            else
            {
                infoCaballo.setVisibility(View.GONE);
            }

        }
    }

    protected String getTituloReconocimiento(){
        return "Razas y Pelajes";
    }

}
