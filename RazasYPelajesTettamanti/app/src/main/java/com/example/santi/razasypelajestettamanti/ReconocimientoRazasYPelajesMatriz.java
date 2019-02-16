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
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ReconocimientoRazasYPelajesMatriz extends Fragment {

    public ReconocimientoRazasYPelajesMatriz() {
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
        View view = inflater.inflate(R.layout.fragment_reconocimiento_razas_y_pelajes_matriz, container, false);
        TableLayout matrizReconocimiento = (TableLayout) view.findViewById(R.id.matrizReconocimiento);
        setReconocimientoCaballos(matrizReconocimiento);
        return  view;
    }

    private void setReconocimientoCaballos(TableLayout matrizReconocimiento) {
        final Caballo[] caballos = new Caballos(getActivity()).caballos;
        for (int i = 0; i < matrizReconocimiento.getChildCount(); i++) {
            TableRow rowCaballos = (TableRow) matrizReconocimiento.getChildAt(i);
            LinearLayout infoCaballo = (LinearLayout) rowCaballos.getChildAt(0);
            //ImageView imagenCaballo = (ImageView) infoCaballo.getChildAt(0);
            //imagenCaballo.setImageResource(caballos[2*i+k].imagen);
            TextView pelajeYRaza = (TextView) infoCaballo.getChildAt(1);
            pelajeYRaza.setText(caballos[i].raza);
            pelajeYRaza.append(" y ");
            pelajeYRaza.append(caballos[i].pelaje);
            ImageView audio = (ImageView) infoCaballo.getChildAt(2);
            final int index = i;
            audio.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    MediaPlayer mp = MediaPlayer.create(v.getContext(), caballos[index].audio_pelajeyraza_femenino);
                    mp.start();
                }
            });



            LinearLayout infoCaballo1 = (LinearLayout) rowCaballos.getChildAt(1);
            TextView pelajeYRaza1 = (TextView) infoCaballo1.getChildAt(1);
            pelajeYRaza1.setText(caballos[i+1].raza);
            pelajeYRaza1.append(" y ");
            pelajeYRaza1.append(caballos[i+1].pelaje);
            ImageView audio1 = (ImageView) infoCaballo1.getChildAt(2);
            final int index1 = i+1;
            audio1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    MediaPlayer mp = MediaPlayer.create(v.getContext(), caballos[index1].audio_pelajeyraza_femenino);
                    mp.start();
                }
            });

        }
    }

}
