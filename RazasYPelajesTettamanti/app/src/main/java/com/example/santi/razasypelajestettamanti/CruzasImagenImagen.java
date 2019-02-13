package com.example.santi.razasypelajestettamanti;

import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CruzasImagenImagen extends InteraccionMinijuego {

    protected ConstraintLayout setLayout(){
        return (ConstraintLayout) View.inflate(this, R.layout.interaccion_imagen_imagen, null);
    }

    protected Class getSiguienteMinijuego(){
        return RazasYPelajes.class;
    };

    protected void setContenidoAOpcion(View v, int indiceCaballos){
        ImageView image = (ImageView) v;
        image.setBackgroundResource(caballos[indiceCaballos].imagen);
    }

    protected void setIncognita(){
        ImageView imagenCaballo = (ImageView) findViewById(R.id.imagenCaballo2);
        imagenCaballo.setImageResource(caballoGanador.imagen);
    }

    protected void pantallaGanador() {
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

    }
