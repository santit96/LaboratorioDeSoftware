package com.example.santi.razasypelajestettamanti;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
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
            for (int k=0; k<3; k++) {
                final int indice = 3 * i + k;
                LinearLayout infoCaballo = (LinearLayout) rowCaballos.getChildAt(k);
                if (indice < caballos.length) {
                    ImageView imagenCaballo = (ImageView) infoCaballo.getChildAt(0);
                    imagenCaballo.setImageResource(caballos[indice].imagen);
                    TextView pelajeYRaza = (TextView) infoCaballo.getChildAt(1);
                    pelajeYRaza.setText(caballos[indice].raza);
                    pelajeYRaza.append("\n + \n");
                    pelajeYRaza.append(caballos[indice].pelaje);
                    ImageView audio = (ImageView) infoCaballo.getChildAt(2);
                    audio.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(v.getContext());
                            boolean voz_femenina = sp.getBoolean("switch_voz", false);
                            MediaPlayer mp;
                            if (voz_femenina) {
                               mp = MediaPlayer.create(v.getContext(), caballos[indice].audio_pelajeyraza_femenino);
                            }
                            else{
                               mp = MediaPlayer.create(v.getContext(), caballos[indice].audio_raza_masculino);
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
    }

}