package laboratorio.modelo;

public enum Genero {
	ACCION("Acción"),
	CIENCIA("Ciencia"),
	FICCION("Ficción"),
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
