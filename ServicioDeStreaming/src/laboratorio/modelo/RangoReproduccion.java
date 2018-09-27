package laboratorio.modelo;

public enum RangoReproduccion {
	MENORA10("10 <",new Rango(0,10)),
	DE10A99("10-99",new Rango(10,99)),
	DE100A499("100-499",new Rango(100,499)),
	DE500A999("500-999",new Rango(500,999)),
	MASDE1000("> 1000",new Rango(1000,Integer.MAX_VALUE));
	
	private Rango rango;
	private String descripcion;

	RangoReproduccion(String descripcion,Rango rango){
		this.rango=rango;
		this.descripcion=descripcion;
	}
	
	public Rango getRango() {
		return new Rango(rango.getLimiteInferior(),rango.getLimiteSuperor());
	}
	
	public String toString() {
		return descripcion;
	}
	
	
}

