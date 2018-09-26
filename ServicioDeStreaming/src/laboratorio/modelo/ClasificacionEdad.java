package laboratorio.modelo;

public enum ClasificacionEdad {
	ATP("APT","Apto para todo público"),
	Mayores18("+18","Apta para mayores de 18 años"),
	Mayores16("+16","Apta para mayores de 16 años"),
	Mayores13("+13","Apta para mayores de 13 años");
	
	private String identificador;
	private String descripcion;
	ClasificacionEdad(String identificador,String descripcion){
		this.identificador=identificador;
		this.descripcion=descripcion;
	}
	
	public String toString() {
			return this.identificador+": "+this.descripcion;
	}

}
