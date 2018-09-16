package practica1;

public class EstudianteUniversitario extends Estudiante {
	private String fechaDeIngreso;
	
	EstudianteUniversitario(String nombre, String apellido, String legajo,String fechaDeIngreso){
		super(nombre,apellido,legajo);
		this.setFechaDeIngreso(fechaDeIngreso);
	}

	public String getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public void setFechaDeIngreso(String fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
}
