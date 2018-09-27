package laboratorio.modelo;

public enum RangoValoracion {
	DE0A2(new Rango(0,2)),
	DE2A4(new Rango(2,4)),
	DE4A7(new Rango(4,7)),
	DE7A10(new Rango(7,10));
	
	private Rango rango;
	RangoValoracion(Rango rango){
		this.rango=rango;
	}
	
	public String toString() {
		return rango.getLimiteInferior()+"-"+rango.getLimiteSuperor();
	}
	
	public Rango getRango() {
		return new Rango(rango.getLimiteInferior(),rango.getLimiteSuperor());
	}
	
	
}
