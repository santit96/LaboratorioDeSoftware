package practica1;

public class Estudiante {
    private String apellido;
    private String nombre;
    private String legajo;
   
    Estudiante() {
	   
   }
   Estudiante(String nombre, String apellido, String legajo){
	   this.setApellido(apellido);
	   this.setLegajo(legajo);
	   this.setNombre(nombre);
   }
   public String toString(){
	   StringBuffer buffer= new StringBuffer();
	   buffer.append(apellido);
	   buffer.append(' ');
	   buffer.append(nombre);
	   buffer.append(' ');
	   buffer.append(legajo);
	   return buffer.toString();
    }

	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getLegajo() {
		return legajo;
	}
	
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	} 
   
}
