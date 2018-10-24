package practica8;

@Archivo
public class Mapped {
	
	@AlmacenarAtributo
	private String valor="valor1";
	

	@AlmacenarAtributo
	private int valorInt=234324;
	
	@AlmacenarAtributo
	private Float valorFloat=5.4f;
	
	@AlmacenarAtributo
	private String valorPublic="mirenme";
	
	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getValorInt() {
		return valorInt;
	}

	public void setValorInt(int valorInt) {
		this.valorInt = valorInt;
	}

	public Float getValorFloat() {
		return valorFloat;
	}

	public void setValorFloat(Float valorFloat) {
		this.valorFloat = valorFloat;
	}

	public String getValorPublic() {
		return valorPublic;
	}

	public void setValorPublic(String valorPublic) {
		this.valorPublic = valorPublic;
	}

}
