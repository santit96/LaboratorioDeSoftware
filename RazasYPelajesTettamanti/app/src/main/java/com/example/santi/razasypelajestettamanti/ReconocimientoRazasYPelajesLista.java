package com.example.santi.razasypelajestettamanti;


public class ReconocimientoRazasYPelajesLista extends ReconocimientoLista {

    protected void setCaballos(){
        caballos = new Caballos(getActivity()).caballos;
    }

    protected String getTituloReconocimiento(){
        return "Razas y Pelajes";
    }

}
