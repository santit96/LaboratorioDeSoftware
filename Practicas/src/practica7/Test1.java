package practica7;

public class Test1 {

	public static void main(String[] args)  {
	     try {
             throw new Exception2();
         } 
	     catch( Exception2 e2) {
        		 System.out.println("Se capturó la Excepción2");
        		 }
   }
}

