package com.example.santi.razasypelajestettamanti;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ReconocimientoRazasYPelajesLista extends Fragment {

    public ReconocimientoRazasYPelajesLista() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_reconocimiento_razas_y_pelajes_lista, container, false);
        LinearLayout listaReconocimiento = (LinearLayout) view.findViewById(R.id.listaReconocimiento);
        this.setListaCaballos(listaReconocimiento);
        return view;

    }


    private void setListaCaballos(LinearLayout listaReconocimiento) {
        final Caballo[] caballos = new Caballos(getActivity()).caballos;
        for (int i = 0; i < listaReconocimiento.getChildCount(); i++) {
            LinearLayout infoCaballo = (LinearLayout) listaReconocimiento.getChildAt(i);
            ImageView imagenCaballo = (ImageView) infoCaballo.getChildAt(0);
            imagenCaballo.setImageResource(caballos[i].imagen);
            LinearLayout textoYAudio = (LinearLayout) infoCaballo.getChildAt(1);
            TextView pelajeYRaza = (TextView) textoYAudio.getChildAt(0);
            pelajeYRaza.setText(caballos[i].raza);
            pelajeYRaza.append(" y ");
            pelajeYRaza.append(caballos[i].pelaje);
            ImageView audio = (ImageView) textoYAudio.getChildAt(1);
            final int index = i;
            audio.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    MediaPlayer mp = MediaPlayer.create(v.getContext(), caballos[index].audio_pelajeyraza_femenino);
                    mp.start();
                }
            });

        }
    }

}
