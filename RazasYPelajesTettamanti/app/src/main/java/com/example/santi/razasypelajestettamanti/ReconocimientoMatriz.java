package com.example.santi.razasypelajestettamanti;

import android.media.MediaPlayer;
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

public abstract class ReconocimientoMatriz extends Fragment {

    protected Caballo[] caballos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reconocimiento_matriz, container, false);
        ((TextView) view.findViewById(R.id.tituloReconocimientoMatriz)).setText(this.getTituloReconocimiento());
        TableLayout matrizReconocimiento = (TableLayout) view.findViewById(R.id.matrizReconocimiento);
        this.setCaballos();
        setReconocimientoCaballos(matrizReconocimiento);
        return  view;
    }

    protected abstract void setCaballos();

    protected abstract String getTituloReconocimiento();


    private void setReconocimientoCaballos(TableLayout matrizReconocimiento) {
        for (int i = 0; i < matrizReconocimiento.getChildCount(); i++) {
            TableRow rowCaballos = (TableRow) matrizReconocimiento.getChildAt(i);
            for (int k=0; k<2; k++) {
                LinearLayout infoCaballo = (LinearLayout) rowCaballos.getChildAt(k);
                final int indice = 2*i+k;
                ImageView imagenCaballo = (ImageView) infoCaballo.getChildAt(0);
                imagenCaballo.setImageResource(caballos[indice].imagen);
                TextView pelajeYRaza = (TextView) infoCaballo.getChildAt(1);
                pelajeYRaza.setText(caballos[indice].raza);
                pelajeYRaza.append(" y ");
                pelajeYRaza.append(caballos[indice].pelaje);
                ImageView audio = (ImageView) infoCaballo.getChildAt(2);
                audio.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        MediaPlayer mp = MediaPlayer.create(v.getContext(), caballos[indice].audio_pelajeyraza_femenino);
                        mp.start();
                    }
                });
            }

        }
    }

}