package practica9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Carrera {
	private int llegada=10;
	private String ganador="";


	public synchronized void setGanador(String name) {
		if (this.ganador.equals(""))
			this.ganador=name;
	}
	
	public String getGanador() {
		return this.ganador;
	}

	public int getLlegada() {
		return llegada;
	}
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(5);
		Carrera carrera=new Carrera();
		for ( int i = 0; i < 5; i++)
			exec.execute(new Corredor(carrera));
		exec.shutdown();

	}

}
