package com.example.santi.razasypelajestettamanti;

import android.preference.PreferenceActivity;
import android.os.Bundle;


public class Preferences extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new PreferencesFragment()).commit();
    }
}
