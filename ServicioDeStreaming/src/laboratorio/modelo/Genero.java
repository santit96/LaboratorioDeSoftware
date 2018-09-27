package laboratorio.modelo;

public enum Genero {
	ACCION("Acción"),
	CIENCIA_FICCION("Ciencia"),
	COMEDIA("Comedia"),
	DRAMA("Drama"),
	FANTASIA("Fantasía"),
	MUSICAL("Musical"),
	ROMANCE("Romance"),
	SUSPENSO("Suspenso");
	
	private String nombre;
	Genero(String nombre){
		this.nombre=nombre;
		
	}
	
	public String toString(){
		return this.nombre;
	}

}
