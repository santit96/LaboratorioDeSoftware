package com.example.santi.razasypelajestettamanti;

import android.preference.ListPreference;
import android.preference.MultiSelectListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.os.Bundle;

import java.util.HashSet;
import java.util.Set;


public class PreferencesFragment extends PreferenceFragment {

    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        this.setPreferencesDefaults();

        Bundle args = getArguments();
        boolean lastMinijuego = args.getBoolean("lastMinijuego", false);
        this.enableDisableFormatosMinijuego(lastMinijuego);


    }

    private void setPreferencesDefaults(){
        ListPreference formatoReconocimiento = (ListPreference) findPreference ("list_formato_reconocimiento");
        if (formatoReconocimiento.getValue() ==null)
            formatoReconocimiento.setValueIndex(0);
        MultiSelectListPreference modoReconocimiento = (MultiSelectListPreference) findPreference ("multi_select_modo_reconocimiento");
        if (modoReconocimiento.getValues().isEmpty()){
            Set set = new HashSet();
            set.add("Razas y pelajes");
            modoReconocimiento.setValues(set);
        }

        modoReconocimiento.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                Set<String> value = (Set<String>) newValue;
                if (value.isEmpty()){
                    return false;
                }
                return true;

            }
        });
    }


    private void enableDisableFormatosMinijuego(boolean lastMinijuego){
        ListPreference formatoMinjuego = (ListPreference) findPreference ("list_mini_juego");
        if (lastMinijuego) {
            formatoMinjuego.setEntries(R.array.miniJuegosDisabled);
            formatoMinjuego.setEnabled(false);
            formatoMinjuego.setValueIndex(0);
        }
        else{
            formatoMinjuego.setEntries(R.array.miniJuegos);
            if (formatoMinjuego.getValue() == null)
                formatoMinjuego.setValueIndex(0);
        }
    }


}
