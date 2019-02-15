package com.example.santi.razasypelajestettamanti;

import android.preference.ListPreference;
import android.preference.MultiSelectListPreference;
import android.preference.PreferenceActivity;
import android.os.Bundle;

import java.util.HashSet;
import java.util.Set;


public class Preferences extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PreferencesFragment preferencesFragment = new PreferencesFragment();
        Bundle b = getIntent().getExtras();
        Bundle args = new Bundle();
        if(b != null)
            args.putBoolean("lastMinijuego", b.getBoolean("lastMinijuego"));
        else
            args.putBoolean("lastMinijuego", false);
        preferencesFragment.setArguments(args);
        getFragmentManager().beginTransaction().replace(android.R.id.content,preferencesFragment).commit();

    }



}
