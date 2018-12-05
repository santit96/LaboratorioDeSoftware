package com.example.santi.razasypelajestettamanti;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RazasYPelajes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razas_ypelajes);

       FloatingActionButton settingButton = (FloatingActionButton) findViewById(R.id.settingsButton);
        settingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentSettings = new Intent(RazasYPelajes.this, Preferences.class);
                startActivity(intentSettings);
            }
       });

       Button playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               Intent intentMinijuego = new Intent(RazasYPelajes.this, MinijuegoRazasyPelajes.class);
               startActivity(intentMinijuego);
           }
       });
    }
}
