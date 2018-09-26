package practica5;

import practica2.InstrumentoMusical;

public enum Cantautores {
    CHARLY_GARCIA(new Piano());
	
	private InstrumentoMusical instrumento;
	
	Cantautores(InstrumentoMusical instrumento){
		this.instrumento=instrumento;
	}
	
    public void tocarInstrumento(NotaMusical[] melodia) {
    	for (NotaMusical notaMusical : melodia) {
    		instrumento.hacerSonar(notaMusical.getNota(),notaMusical.getDuracion());
    	}
    }
}
