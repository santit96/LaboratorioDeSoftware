package com.example.santi.razasypelajestettamanti;


public class ReconocimientoRazasYPelajesMatriz extends ReconocimientoMatriz {

    protected void setCaballos(){
        caballos = new Caballos(getActivity()).caballos;
    }

    protected String getTituloReconocimiento(){
        return "Razas y Pelajes";
    }
}
