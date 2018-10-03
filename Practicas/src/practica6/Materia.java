package practica6;

import java.util.TreeSet;

public class Materia {
	
	private TreeSet<Alumno> alumnos= new TreeSet<>();
	private String nombre;
	
	Materia(String nombre){
		this.nombre=nombre;
	}
	
	
	public void agregarAlumno(Alumno a) {
		alumnos.add(a);
	}
	
	public TreeSet<Alumno> getAlumnos(){
		return alumnos;
	}
	
	public String toString() {
		return this.nombre;
	}
	
	public static void main(String[] args) {
		Alumno alumno1=new Alumno("Santiago","Tettamanti",1,2);
		Alumno alumno2=new Alumno("Jorge","ALismi",2,3);
		Alumno alumno3=new Alumno("Juan","Rei",3,4);
		Alumno alumno4=new Alumno("Osvaldo","Lopex",4,5);
		Materia materia=new Materia("Lab");
		materia.agregarAlumno(alumno3);
		materia.agregarAlumno(alumno4);
		materia.agregarAlumno(alumno1);
		materia.agregarAlumno(alumno2);
		
		
		for (Alumno a : materia.getAlumnos()) {
			System.out.println(a);
		} 
	}

}
