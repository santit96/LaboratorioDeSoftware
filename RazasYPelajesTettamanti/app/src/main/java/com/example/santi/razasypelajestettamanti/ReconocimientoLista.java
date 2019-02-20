package com.example.santi.razasypelajestettamanti;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public abstract class ReconocimientoLista extends Fragment {

    protected Caballo[] caballos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_reconocimiento_lista, container, false);
        LinearLayout listaReconocimiento = (LinearLayout) view.findViewById(R.id.listaReconocimiento);
        setCaballos();
        this.setListaCaballos(listaReconocimiento);
        return view;

    }

    protected abstract void setCaballos();

    protected abstract String getTituloReconocimiento();

    private void setListaCaballos(LinearLayout listaReconocimiento) {
        ((TextView) listaReconocimiento.getChildAt(0)).setText(getTituloReconocimiento());
        for (int i = 1; i < listaReconocimiento.getChildCount(); i++) {
            LinearLayout infoCaballo = (LinearLayout) listaReconocimiento.getChildAt(i);
            if (i <= caballos.length) {
                ImageView imagenCaballo = (ImageView) infoCaballo.getChildAt(0);
                imagenCaballo.setImageResource(caballos[i - 1].imagen);
                LinearLayout textoYAudio = (LinearLayout) infoCaballo.getChildAt(1);
                TextView pelajeYRaza = (TextView) textoYAudio.getChildAt(0);
                pelajeYRaza.setText(caballos[i - 1].raza);
                pelajeYRaza.append(" y ");
                pelajeYRaza.append(caballos[i - 1].pelaje);
                ImageView audio = (ImageView) textoYAudio.getChildAt(1);
                final int index = i - 1;
                audio.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(v.getContext());
                        boolean voz_femenina = sp.getBoolean("switch_voz", false);
                        if (voz_femenina) {
                            MediaPlayer mp = MediaPlayer.create(v.getContext(), caballos[index].audio_pelajeyraza_femenino);
                            mp.start();
                        }
                    }
                });
            }
            else
            {
             infoCaballo.setVisibility(View.GONE);
            }

        }
    }

}
