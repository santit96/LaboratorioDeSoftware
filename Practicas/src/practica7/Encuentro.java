package practica7;

public class Encuentro extends Partido implements Tormenta {
	
	Encuentro() throws Lluvia,FutbolException{}

	Encuentro (String fecha) throws Falta,FutbolException{};
	
	//No se puede  porque la exception es distinta a la del metodo sobreescrito
	//void penal() throws Mano{}
	void penal() {}
	
	//Falta la excepcion declarada en el método evento() de la clase padre, no de la interfaz
	//Pero si agregamos ese sería incompatible tanto con el método de la interfaz como con el de
	//la superclase por lo que al no lanzar excepciones lo hacemos compatible con ambos
	//public void evento() throws Lluvia{}
	public void evento() {}
	
	
	void jugada() throws Mano{
		System.out.println("Golazo");
		throw new Mano();
	}
	
	@Override
	public void diluvio() throws Lluvia {

	}
	
	public static void main (String[] args) {
	     try {
	        Encuentro enc = new Encuentro();
	        enc.jugada();
	     } 
	     catch(Mano e) {
	   	    System.out.println(e+" Penal para Boke");
	     } 
	     catch(Lluvia e) {}
	     catch(FutbolException e) {
	         try {
	            Partido par = new Encuentro();
	            par.jugada();
	         } 
	         catch(EquipoIncompleto ex) {} 
	         catch(Falta ex) {
	        	 System.out.println(e+" Penal para Boke");
	         } 
	         catch(Lluvia ex) {} 
	         catch(FutbolException ex) {}
	    }
	}

}
