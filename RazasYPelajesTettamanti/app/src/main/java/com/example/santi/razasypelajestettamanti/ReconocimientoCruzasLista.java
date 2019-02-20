package com.example.santi.razasypelajestettamanti;

public class ReconocimientoCruzasLista extends ReconocimientoLista {
    protected void setCaballos(){
            caballos = new Caballos(getActivity()).cruzas;
    }

    protected String getTituloReconocimiento(){
            return "Cruzas";
    }


}
