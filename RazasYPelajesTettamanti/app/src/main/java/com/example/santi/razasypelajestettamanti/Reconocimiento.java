package com.example.santi.razasypelajestettamanti;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Reconocimiento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String formato = sp.getString("list_formato_reconocimiento","");
        if (formato.equals("Lista"))
            setContentView(R.layout.activity_reconocimiento_lista);
        else
            setContentView(R.layout.activity_reconocimiento_matriz);
    }

}
