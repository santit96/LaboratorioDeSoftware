package com.example.santi.razasypelajestettamanti;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Campeon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campeon);
        setCopa();
        setTextoCampeon();
        setHomeBehaviour();
    }


    private void setCopa(){
        ImageView copa = (ImageView) findViewById(R.id.copa);
        setCopaAnimation(copa);
    }

    private void setCopaAnimation(ImageView copa){
        final AnimationDrawable anim;
        anim = new AnimationDrawable();
        for (int i=1;i<81;i+=30) {
            String name = "copa_"+i;
            System.gc();
            anim.addFrame(getResources().getDrawable(getResources().getIdentifier(name, "drawable", getPackageName())), 200);
        }
        anim.setOneShot(false);
        copa.setImageDrawable(anim);
        Runnable run = new Runnable() {
            @Override
            public void run() {
                anim.start();
            }
        };
        copa.post(run);
    }

    private void setTextoCampeon(){
        TextView texto_campeon = (TextView) findViewById(R.id.texto_campeon);
        texto_campeon.setText(getResources().getString(R.string.text_campeon));
        TextView texto_campeon2 = (TextView) findViewById(R.id.texto_campeon2);
        texto_campeon2.setText("CAMPEON");
    }

    private void setHomeBehaviour() {
        ImageButton botonHome = (ImageButton) findViewById(R.id.home) ;
        botonHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainActivity = new Intent(getBaseContext(), RazasYPelajes.class);
                mainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mainActivity);
                finish();
            }
        });
    }
}
