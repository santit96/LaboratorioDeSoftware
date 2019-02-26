package com.example.santi.razasypelajestettamanti;

import android.content.Context;

public class Caballos {

    public final Caballo[] caballos;
    public final CaballoCruza[] cruzas;

    private Context context;

    private int[] imagenes_cruzas = new int[]{R.drawable.cruza_bella,R.drawable.cruza_huayra,R.drawable.cruza_mancha,R.drawable.cruza_nalito,R.drawable.cruza_orita,R.drawable.cruza_pirata};
    private int[] imagenes_padres = new int[]{R.drawable.cruza_bella_padres,R.drawable.cruza_huayra_padres,R.drawable.cruza_mancha_padres,R.drawable.cruza_nalito_padres,R.drawable.cruza_orita_padres,R.drawable.cruza_pirata_padres};

    private int[] imagenes_caballos = new int[]{
            R.drawable.caballo_amapola_petisoargentino_rosillo,R.drawable.caballo_ambar_mestizocruzaarabe_alazantostado,
            R.drawable.caballo_antu_mestizo_overozaino,R.drawable.caballo_hualfin_criollo_horsepicaso,
            R.drawable.caballo_juana_cuartodemilla_bayo,R.drawable.caballo_primavera_sillaargentino_alazan,
            R.drawable.caballo_angola_spc_zainocolorado, R.drawable.caballo_bionda_mestizo_alazanruano,
            R.drawable.caballo_blanco_mestizo_blanco, R.drawable.caballo_bonita_mestizoqhconcriollo_overoazulejo,
            R.drawable.caballo_cacique_mestizo_alazan,R.drawable.caballo_candelaria_mestizo_tobiano,
            R.drawable.caballo_ciro_mestizo_tordillocanela,R.drawable.caballo_felipe_mestizo_zaino,
            R.drawable.caballo_mora_petisoargentino_tordillomoro,R.drawable.caballo_munieco_mestizo_overorosado,
            R.drawable.caballo_nala_mestizo_moro,R.drawable.caballo_pamperito_petisoargentino_zaino,
            R.drawable.caballo_pintada_mestizo_alazanpintado, R.drawable.caballo_pochito_mestizo_zaino,
            R.drawable.caballo_tigre_criollo_bayogateado, R.drawable.caballo_tupac_mestizo_zainooscuro,
            R.drawable.caballo_zorzal_mestizo_tordillo};

    Caballos (Context context){
        this.context = context;
        this.caballos = crearCaballos();
        this.cruzas = crearCruzas();
    }

    private Caballo[] crearCaballos(){
        Caballo[] caballos_array = new Caballo[imagenes_caballos.length];
        for (int i = 0; i< imagenes_caballos.length; i++){
            Caballo caballo = new Caballo();
            caballo.imagen = imagenes_caballos[i];
            caballo.raza = context.getResources().getStringArray(R.array.razas)[i];
            caballo.pelaje = context.getResources().getStringArray(R.array.pelajes)[i];
            caballo.texto_desriptivo = context.getResources().getStringArray(R.array.texto_descriptivo)[i];
            //audios femeninos
            caballo.audio_pelaje_femenino = context.getResources().getIdentifier("voz_femenina_pelaje_"+(i+1), "raw",context.getPackageName());
            caballo.audio_raza_femenino = context.getResources().getIdentifier("voz_femenina_raza_"+(i+1), "raw",context.getPackageName());
            caballo.audio_pelajeyraza_femenino = context.getResources().getIdentifier("voz_femenina_razaypelaje_"+(i+1), "raw",context.getPackageName());
            //audios masculinos
            caballo.audio_pelaje_masculino = context.getResources().getIdentifier("voz_masculina_pelaje_"+(i+1), "raw",context.getPackageName());
            caballo.audio_raza_masculino = context.getResources().getIdentifier("voz_masculina_raza_"+(i+1), "raw",context.getPackageName());
            caballo.audio_pelajeyraza_masculino = context.getResources().getIdentifier("voz_masculina_razaypelaje_"+(i+1), "raw",context.getPackageName());

            caballos_array[i] = caballo;
        }
        return caballos_array;
    }

    private CaballoCruza[] crearCruzas(){
        CaballoCruza[] cruzas_array = new CaballoCruza[imagenes_cruzas.length];
        for (int i = 0; i< imagenes_cruzas.length; i++){
            CaballoCruza cruza = new CaballoCruza();

            cruza.imagen = imagenes_cruzas[i];
            cruza.imagen_padres = imagenes_padres[i];

            cruza.raza = context.getResources().getStringArray(R.array.razas_cruza)[i];
            cruza.pelaje = context.getResources().getStringArray(R.array.pelajes_cruza)[i];
            cruza.texto_desriptivo = context.getResources().getStringArray(R.array.texto_descriptivo_cruzas)[i];
            //audios femeninos
            cruza.audio_pelajeyraza_femenino = context.getResources().getIdentifier("voz_femenina_raza_cruza_"+(i+1), "raw",context.getPackageName());
            //audios masculinos
            cruza.audio_raza_masculino = context.getResources().getIdentifier("voz_masculina_raza_cruza_"+(i+1), "raw",context.getPackageName());

            cruzas_array[i] = cruza;
        }
        return cruzas_array;
    }
}
