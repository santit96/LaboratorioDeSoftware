package practica6;

public class Alumno implements Comparable<Alumno>{
	private String nombre;
	private String apellido;
	private int legajo;
	private int dni;
	
	Alumno(String nombre, String apellido, int legajo, int dni){
		this.setApellido(apellido);
		this.setDni(dni);
		this.setLegajo(legajo);
		this.setNombre(nombre);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public String toString() {
		return this.nombre+" "+this.apellido;
	}
	@Override
	public int compareTo(Alumno alumno) {
	    return this.getApellido().compareTo(alumno.getApellido());
	}

}
