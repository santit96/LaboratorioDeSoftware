package com.example.santi.razasypelajestettamanti;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import java.util.Random;

public abstract class Minijuego extends AppCompatActivity {

    protected final int CANTIDAD_RONDAS = 5;

    protected int rondasJugadas = 0;

    protected Caballo[] caballos;
    protected Caballo caballoGanador;

    protected ConstraintLayout currentLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentLayout = setLayout();
        this.createBotonHome();
        setContentView(currentLayout);
        this.setAyudaBehaviour();

        caballos = new Caballos(getBaseContext()).caballos;
        this.nuevaRonda();
    }

    protected abstract ConstraintLayout setLayout();

    protected abstract void updateRonda();

    protected abstract Class getSiguienteMinijuego();

    protected abstract void setAyudaBehaviour();

    protected abstract void setAyudaText(AyudaFragment ayuda);

    protected void nuevaRonda() {
        if (rondasJugadas == CANTIDAD_RONDAS){
            Intent siguienteMinijuego = new Intent(this, this.getSiguienteMinijuego());
            siguienteMinijuego.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(siguienteMinijuego);
        }
        else{
            rondasJugadas++;
            this.setCaballoGanador();
            this.updateRonda();
        }

    }

    protected void setCaballoGanador(){
        Random rand = new Random();
        caballoGanador = caballos[rand.nextInt(caballos.length)];
    }

    protected void createBotonHome(){
        ImageButton botonHome = new ImageButton(this);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,ConstraintLayout.LayoutParams.WRAP_CONTENT);
        params.setMarginStart(160);
        params.setMargins(160,160,160,160);
        botonHome.setLayoutParams(params);
        botonHome.setImageDrawable(getResources().getDrawable(R.drawable.home));
        botonHome.setBackgroundColor(getResources().getColor(R.color.transparente));
        currentLayout.addView(botonHome);
        this.setHomeBehaviour(botonHome);
    }

    private void setHomeBehaviour(ImageButton botonHome){
        botonHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent homeIntent = new Intent(v.getContext(), RazasYPelajes.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });
    }

    protected void createBotonAyuda(){
        ImageButton botonAyuda = new ImageButton(this);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,ConstraintLayout.LayoutParams.WRAP_CONTENT);
        params.setMarginEnd(40);
        params.topMargin = 40;
        botonAyuda.setLayoutParams(params);
        botonAyuda.setImageDrawable(getResources().getDrawable(R.drawable.ayuda));
        botonAyuda.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        currentLayout.addView(botonAyuda);
        this.setAyudaBehaviour(botonAyuda);
    }

    protected void setAyudaBehaviour(ImageButton botonAyuda){
        botonAyuda.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                AyudaFragment ayuda = new AyudaFragment();
                setAyudaText(ayuda);
                ayuda.show(fragmentManager, "dialog");
            }
        });
    }

}
