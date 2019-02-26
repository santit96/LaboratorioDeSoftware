package com.example.santi.razasypelajestettamanti;


import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ReconocimientoRazasYPelajesMatriz extends ReconocimientoMatriz {

    protected void setCaballos(){
        caballos = new Caballos(getActivity()).caballos;
    }

    protected int getCurrentFragment(){return R.layout.fragment_reconocimiento_razasypelajes_matriz;}

    protected String getTituloReconocimiento(){
        return "Razas y Pelajes";
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
                                mp = MediaPlayer.create(v.getContext(), caballos[indice].audio_pelajeyraza_masculino);
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
