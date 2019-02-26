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
        View view = inflater.inflate(this.getCurrentFragment(), container, false);
        ((TextView) view.findViewById(R.id.tituloReconocimientoMatriz)).setText(this.getTituloReconocimiento());
        TableLayout matrizReconocimiento = (TableLayout) view.findViewById(R.id.matrizReconocimiento);
        this.setCaballos();
        setReconocimientoCaballos(matrizReconocimiento);
        return  view;
    }

    protected abstract int getCurrentFragment();

    protected abstract void setCaballos();

    protected abstract String getTituloReconocimiento();

    protected abstract void setReconocimientoCaballos(TableLayout matrizReconocimiento);

}