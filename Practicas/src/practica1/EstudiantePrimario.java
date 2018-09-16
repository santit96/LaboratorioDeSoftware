package practica1;

public class EstudiantePrimario extends Estudiante {
	private int cantidadDeAusencias;
	private boolean repitio;
	
	EstudiantePrimario(String nombre, String apellido, String legajo,boolean repitio,int cantidadDeAusencias){
		super(nombre,apellido,legajo);
		this.setCantidadDeAusencias(cantidadDeAusencias);
		this.setRepitio(repitio);
	}
	
	public int getCantidadDeAusencias() {
		return cantidadDeAusencias;
	}
	public void setCantidadDeAusencias(int cantidadDeAusencias) {
		this.cantidadDeAusencias = cantidadDeAusencias;
	}
	public boolean isRepitio() {
		return repitio;
	}
	public void setRepitio(boolean repitio) {
		this.repitio = repitio;
	}
}
