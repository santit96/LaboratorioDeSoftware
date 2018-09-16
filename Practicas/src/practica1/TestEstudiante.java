package practica1;
public class TestEstudiante {

	public static void main(String [] args) {
		Estudiante [] array = new Estudiante[5];
		for (int i=0;i<5;i++){
			Estudiante e= new Estudiante();
			e.setApellido("apellido"+i);
			e.setNombre("nombre"+i);
			e.setLegajo("legajo"+i);
			array[i]=e;
			System.out.println(e);
		}
		
		
	} 
}
