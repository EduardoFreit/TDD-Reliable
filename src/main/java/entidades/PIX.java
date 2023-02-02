package main.java.entidades;

public class PIX {
	
	private String tipoChave;
	private String chavePIX;
	
	public PIX() {
		// TODO Auto-generated constructor stub
	}

	public PIX(String tipoChave, String chavePIX) {
		super();
		this.tipoChave = tipoChave;
		this.chavePIX = chavePIX;
	}

	public String getTipoChave() {
		return tipoChave;
	}

	public void setTipoChave(String tipoChave) {
		this.tipoChave = tipoChave;
	}

	public String getChavePIX() {
		return chavePIX;
	}

	public void setChavePIX(String chavePIX) {
		this.chavePIX = chavePIX;
	}
	
}
