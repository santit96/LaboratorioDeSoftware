package practica5;

public class TestGuitarra {
	public static void main(String [] args) {
		Guitarra guitarra= new Guitarra();
		System.out.println(guitarra.queEs());
		guitarra.hacerSonar(Notas.DO,DuracionNota.Q1_4);
		guitarra.hacerSonar();
		guitarra.afinar(FrecuenciasDeLA.HZ480);
		
	}
}
