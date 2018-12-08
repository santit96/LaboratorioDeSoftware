package com.example.santi.razasypelajestettamanti;

import android.preference.PreferenceFragment;
import android.os.Bundle;


public class PreferencesFragment extends PreferenceFragment {

    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

    }


}
