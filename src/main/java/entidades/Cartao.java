package main.java.entidades;

public class Cartao {
	private String nomeCartao;
	private String numeroCartao;
	private String CVV;
	private String validade;
	
	public Cartao() {
		// TODO Auto-generated constructor stub
	}

	public Cartao(String nomeCartao, String numeroCartao, String CVV, String validade) {
		super();
		this.nomeCartao = nomeCartao;
		this.numeroCartao = numeroCartao;
		this.CVV = CVV;
		this.validade = validade;
	}

	public String getNomeCartao() {
		return nomeCartao;
	}

	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getCVV() {
		return CVV;
	}

	public void setCVV(String cVV) {
		CVV = cVV;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}
	
}
