package com.example.santi.razasypelajestettamanti;

public class ReconocimientoCruzasMatriz extends ReconocimientoMatriz {
    protected void setCaballos(){
        caballos = new Caballos(getActivity()).caballos;
    }

    protected String getTituloReconocimiento(){
        return "Cruzas";
    }
}
