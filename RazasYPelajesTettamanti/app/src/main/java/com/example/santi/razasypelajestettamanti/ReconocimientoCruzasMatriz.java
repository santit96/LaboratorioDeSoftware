package com.example.santi.razasypelajestettamanti;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

public class ReconocimientoCruzasMatriz extends ReconocimientoMatriz {

    protected void setCaballos(){
        caballos = new Caballos(getActivity()).cruzas;
    }

    protected int getCurrentFragment(){return R.layout.fragment_reconocimiento_cruzas_matriz;}

    protected String getTituloReconocimiento(){
        return "Cruzas";
    }


    protected void setReconocimientoCaballos(TableLayout matrizReconocimiento) {
        for (int i = 0; i < matrizReconocimiento.getChildCount(); i++) {
            TableRow rowCaballos = (TableRow) matrizReconocimiento.getChildAt(i);
            for (int k=0; k<3; k++) {
                final int indice = 3 * i + k;
                LinearLayout infoCaballo = (LinearLayout) rowCaballos.getChildAt(k);
                if (indice < caballos.length) {
                    ImageView imagenCaballo = (ImageView) infoCaballo.getChildAt(0);
                    imagenCaballo.setImageResource(caballos[indice].imagen);
                    ImageView imagenPadres = (ImageView) infoCaballo.getChildAt(2);
                    imagenPadres.setImageResource(((CaballoCruza)caballos[indice]).imagen_padres);
                }
                else
                {
                    infoCaballo.setVisibility(View.GONE);
                }
            }

        }
    }
}
