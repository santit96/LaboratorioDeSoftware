package com.example.santi.razasypelajestettamanti;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.Random;

public abstract class InteraccionMinijuego extends AppCompatActivity {

    protected final int CANTIDAD_RONDAS = 5;
    protected final int RONDAS_A_GANAR = 3;

    protected int rondasJugadas = 0;
    protected int rondasGanadas = 0;

    protected Caballo[] caballos;
    protected Caballo caballoGanador;
    protected int idGanador;
    protected boolean firstActivity = false;

    protected ConstraintLayout currentLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentLayout = setLayout();
        this.createBotonHome();
        setContentView(currentLayout);

        Bundle b = getIntent().getExtras();
        if(b != null)
            firstActivity = b.getBoolean("firstActivity");

        caballos = new Caballos(getBaseContext()).caballos;
        this.nuevaRonda();
    }

    protected abstract ConstraintLayout setLayout();

    protected abstract Class getSiguienteMinijuego();

    protected abstract void setIncognita();

    protected abstract void setContenidoAOpcion(View v, int indiceCaballo);


    protected void nuevaRonda() {
        if (rondasJugadas == CANTIDAD_RONDAS && rondasGanadas >= RONDAS_A_GANAR ){
            pantallaGanador();
        }
        else if (rondasJugadas == CANTIDAD_RONDAS){
           pantallaPerdedor();
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

    protected void updateRonda(){
        this.setOpciones();
        this.setIncognita();
        this.setOpcionesBehaviour();
    }

    private void setOpciones(){
        LinearLayout opciones = (LinearLayout) findViewById(R.id.opciones);
        Random rand = new Random();
        int indiceCaballos = rand.nextInt(caballos.length);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean dificil = sp.getBoolean("switch_nivel",false);
        int posicionGanadora;
        if (dificil)
            posicionGanadora = rand.nextInt(4);
        else
            posicionGanadora = rand.nextInt(2)+1;
        for (int i=0; i<opciones.getChildCount(); i++){
            View opcion =  this.getOpcionesChild(opciones,i);
            if (indiceCaballos == caballos.length)
                indiceCaballos = 0;
            if (i == posicionGanadora) {
                caballoGanador = caballos[indiceCaballos];
                idGanador = opcion.getId();
            }
            this.setContenidoAOpcion(opcion,indiceCaballos);
            indiceCaballos++;
        }
        if (!dificil){
            opciones.getChildAt(0).setVisibility(View.INVISIBLE);
            opciones.getChildAt(3).setVisibility(View.INVISIBLE);
        }

    }

    private void setOpcionesBehaviour() {
        LinearLayout opciones = (LinearLayout) findViewById(R.id.opciones);
        int cantImagenes = opciones.getChildCount();
        for (int i=0; i<cantImagenes; i++){
            this.getOpcionesChild(opciones, i).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    setResultado(v);
                }
            });
        }
    }

    protected View getOpcionesChild(LinearLayout opciones, int index){
        return opciones.getChildAt(index);
    }

    private void setResultado(View v){
        LinearLayout resultado = (LinearLayout) findViewById(R.id.layout_resultado);
        resultado.setVisibility(View.VISIBLE);
        TextView texto_resultado = (TextView) findViewById(R.id.resultado);
        texto_resultado.setText("");
        ImageView image_resultado = (ImageView) findViewById(R.id.imagen_resultado);
        MediaPlayer mp;
        if (v.getId() == idGanador) {
            rondasGanadas++;
            texto_resultado.append(getResources().getString(R.string.resultado_correcto));
            texto_resultado.setTextColor(getResources().getColor(R.color.colorGanador));
            image_resultado.setImageResource(R.drawable.check);
            mp = MediaPlayer.create(v.getContext(),R.raw.relincho);

        }
        else {
            texto_resultado.append(getResources().getString(R.string.resultado_incorrecto));
            texto_resultado.setTextColor(getResources().getColor(R.color.colorPerdedor));
            image_resultado.setImageResource(R.drawable.x);
            mp = MediaPlayer.create(v.getContext(),R.raw.resoplido);

        }
        mp.start();
        nuevaRonda();
    }

    protected void createBotonHome(){
        ImageButton botonHome = new ImageButton(this);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,ConstraintLayout.LayoutParams.WRAP_CONTENT);
        params.setMarginStart(160);
        params.setMargins(160,160,160,160);
        botonHome.setLayoutParams(params);
        botonHome.setImageDrawable(getResources().getDrawable(R.drawable.home_regular));
        botonHome.setBackgroundColor(getResources().getColor(R.color.transparente));
        currentLayout.addView(botonHome);
        this.setHomeBehaviour(botonHome);
    }

    private void setHomeBehaviour(ImageButton botonHome){
        botonHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                volverHome();
            }
        });
    }

    protected void pantallaGanador(){
        setAnimation();
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.ventanaFinMinijuego);
        layout.setVisibility(View.VISIBLE);
        TextView text = (TextView) findViewById(R.id.infoFinMinijuego);
        text.append("");
        text.append(getResources().getString(R.string.info_ganador));
        Button boton = (Button) findViewById(R.id.botonFinMinijuego);
        boton.setText(getResources().getString(R.string.siguiente_minijuego));
        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                siguienteMinijuego();
            }
        });
    }

    private void pantallaPerdedor(){
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.ventanaFinMinijuego);
        layout.setVisibility(View.VISIBLE);
        TextView text = (TextView) findViewById(R.id.infoFinMinijuego);
        text.append("");
        text.append(getResources().getString(R.string.info_perdedor));
        Button boton = (Button) findViewById(R.id.botonFinMinijuego);
        boton.setText(getResources().getString(R.string.nuevo_intento));
        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                volverHome();
            }
        });
    }

    private void volverHome(){
        Intent mainActivity = new Intent(this, RazasYPelajes.class);
        mainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(mainActivity);
    }

    protected void siguienteMinijuego(){
        Intent siguienteMinijuego = new Intent(this, this.getSiguienteMinijuego());
        siguienteMinijuego.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(siguienteMinijuego);
    }

    private void setAnimation(){
        final AnimationDrawable anim;
        ImageView img = new ImageView(getBaseContext());
        img.setLayoutParams(new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT));
        //img.setImageResource(R.drawable.confetti);
        anim = new AnimationDrawable();
        for (int i=0;i<6;i++) {
            String name = "confetti_"+i;
            anim.addFrame(getResources().getDrawable(getResources().getIdentifier(name, "drawable", getPackageName())), 200);
        }
        img.setImageDrawable(anim);
        currentLayout.addView(img);
        //anim = (AnimationDrawable)img.getDrawable();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                anim.start();
            }
        };


        img.post(run);
    }
}
