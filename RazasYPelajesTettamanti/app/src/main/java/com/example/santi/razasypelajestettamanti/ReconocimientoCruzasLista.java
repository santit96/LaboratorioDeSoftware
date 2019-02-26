package com.example.santi.razasypelajestettamanti;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ReconocimientoCruzasLista extends ReconocimientoLista {
    protected void setCaballos(){
            caballos = new Caballos(getActivity()).cruzas;
    }

    protected int getCurrentFragment(){ return R.layout.fragment_reconocimiento_cruzas_lista;}

    protected String getTituloReconocimiento(){
            return "Cruzas";
    }

    protected void setListaCaballos(LinearLayout listaReconocimiento) {
        for (int i = 1; i < listaReconocimiento.getChildCount(); i++) {
            LinearLayout infoCaballo = (LinearLayout) listaReconocimiento.getChildAt(i);
            if (i <= caballos.length) {
                ImageView imagenCaballo = (ImageView) infoCaballo.getChildAt(0);
                imagenCaballo.setImageResource(caballos[i - 1].imagen);
                LinearLayout textoEImagen = (LinearLayout) infoCaballo.getChildAt(1);
                ImageView imagenPadres = (ImageView)textoEImagen.getChildAt(1);
                imagenPadres.setImageResource(((CaballoCruza) caballos[i - 1]).imagen_padres);
                TextView texto_descriptivo = (TextView) infoCaballo.getChildAt(2);
                texto_descriptivo.setText(caballos[i - 1].texto_desriptivo);
            } else {
                infoCaballo.setVisibility(View.GONE);
            }
        }
    }
}

