package practica9;

public class Corredor implements Runnable {
	
	private Carrera carrera;
	private int pasos=0;
	
	public Corredor(Carrera carrera) {
		this.carrera=carrera;
	}
	@Override
	public void run() {
		for (int i=0;i<carrera.getLlegada();i++)
			pasos++;
		carrera.setGanador(Thread.currentThread().getName());
		System.out.println("Llegué: "+Thread.currentThread().getName());
		if (carrera.getGanador().equals(Thread.currentThread().getName()))
			System.out.println("Gane yo: "+Thread.currentThread().getName());
		else
			System.out.println("Perdí: "+Thread.currentThread().getName());

	}

}
