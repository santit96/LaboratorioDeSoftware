package practica1;

import java.util.List;

public class EstudianteSecundario extends Estudiante {
	private List<String> materiasPrevias;
	private float promedioGeneral;
	
	EstudianteSecundario(String nombre, String apellido, String legajo, List<String> materiasPrevias, float promedioGeneral){
		super(nombre,apellido,legajo);
		this.setMateriasPrevias(materiasPrevias);
		this.setPromedioGeneral(promedioGeneral);
	}
	public List<String> getMateriasPrevias() {
		return materiasPrevias;
	}
	public void setMateriasPrevias(List<String> materiasPrevias) {
		this.materiasPrevias = materiasPrevias;
	}
	public float getPromedioGeneral() {
		return promedioGeneral;
	}
	public void setPromedioGeneral(float promedioGeneral) {
		this.promedioGeneral = promedioGeneral;
	}
}
