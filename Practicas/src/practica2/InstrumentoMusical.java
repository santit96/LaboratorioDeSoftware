package practica2;

import practica5.Notas;
import practica5.FrecuenciasDeLA;
import practica5.DuracionNota;

public interface InstrumentoMusical {
	 void hacerSonar();
	 void hacerSonar(Notas n, DuracionNota duracion);
	 String queEs();
	 void afinar();
	 void afinar(FrecuenciasDeLA frecuencia);
	 
	 
}
