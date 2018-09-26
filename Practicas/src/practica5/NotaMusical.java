package practica5;

public class NotaMusical {
    private Notas nota;
    private DuracionNota duracion;
    
    NotaMusical(Notas nota, DuracionNota duracion){
    	this.nota=nota;
    	this.duracion=duracion;
    }

	public Notas getNota() {
		return nota;
	}

	public void setNota(Notas nota) {
		this.nota = nota;
	}

	public DuracionNota getDuracion() {
		return duracion;
	}

	public void setDuracion(DuracionNota duracion) {
		this.duracion = duracion;
	}
}
