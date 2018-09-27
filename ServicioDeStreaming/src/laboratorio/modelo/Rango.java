package laboratorio.modelo;

public class Rango {
	private Integer limiteInferior;
	private Integer limiteSuperor;
	
	
	public Rango(Integer limiteInferior, Integer limiteSuperor) {
		super();
		this.limiteInferior = limiteInferior;
		this.limiteSuperor = limiteSuperor;
	}
	public Integer getLimiteInferior() {
		return limiteInferior;
	}
	public void setLimiteInferior(int limiteInferior) {
		this.limiteInferior = limiteInferior;
	}
	public Integer getLimiteSuperor() {
		return limiteSuperor;
	}
	public void setLimiteSuperor(int limiteSuperor) {
		this.limiteSuperor = limiteSuperor;
	}
	
	public String toString() {
		return this.getLimiteInferior()+"-"+this.getLimiteSuperor();
	}
	
	
}
