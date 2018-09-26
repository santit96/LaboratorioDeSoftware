package practica5;

public enum FrecuenciasDeLA {
	HZ440(440,"Organización Internacional de Estandarización ISO 16"),
	HZ444(444,"Afinación de cámara"),
	HZ446(446,"Renacimiento"),
	HZ480(480,"Órganos alemanes que tocaba Bach");
	
	private int frecuencia;
	private String descripcion;
	FrecuenciasDeLA(int frecuencia, String descripcion){
		this.frecuencia=frecuencia;
		this.descripcion=descripcion;
	}
	
	public String toString() {
			return Integer.toString(this.frecuencia)+"Hz "+this.descripcion;
	}
	
	

}
