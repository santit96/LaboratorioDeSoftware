package com.example.santi.razasypelajestettamanti;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.Array;

public class Caballos {

    public final Caballo[] caballos;

    private Context context;

    private int[] imagenes = new int[]{R.drawable.imagen1,R.drawable.imagen2,R.drawable.imagen3,R.drawable.imagen4};

    Caballos (Context context){
        this.context = context;
        this.caballos = crearCaballos();
    }

    private Caballo[] crearCaballos(){
        Caballo[] caballos_array = new Caballo[imagenes.length];
        for (int i=0; i<imagenes.length; i++){
            Caballo caballo = new Caballo();
            caballo.imagen = imagenes[i];
            caballo.raza = context.getResources().getStringArray(R.array.razas)[i];
            caballo.pelaje = context.getResources().getStringArray(R.array.pelajes)[i];
            caballos_array[i] = caballo;
        }
        return caballos_array;
    }
}
