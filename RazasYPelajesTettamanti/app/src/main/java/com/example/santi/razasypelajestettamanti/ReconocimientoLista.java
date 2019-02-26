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
        View view =  inflater.inflate(this.getCurrentFragment(), container, false);
        LinearLayout listaReconocimiento = (LinearLayout) view.findViewById(R.id.listaReconocimiento);
        setCaballos();
        ((TextView) listaReconocimiento.getChildAt(0)).setText(getTituloReconocimiento());
        this.setListaCaballos(listaReconocimiento);
        return view;

    }

    protected abstract int getCurrentFragment();

    protected abstract void setCaballos();

    protected abstract String getTituloReconocimiento();

    protected abstract void setListaCaballos(LinearLayout listaReconocimiento);

}
