package practica5;

public enum DuracionNota {
	W1("w"),
	H1_2("h"),
	Q1_4("q"),
	I1_8("i"),
	S1_32("s"),
	T1_64("t"),
	X1_128("x");
	
	private String duracion;
	DuracionNota(String duracion){
		this.duracion=duracion;
	}
	
	public String toString() {
		return this.duracion;
	}
	

}
