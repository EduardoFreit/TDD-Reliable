package main.java.entidades;

public class Pagamento {
	private Cartao cartao;
	private PIX pix;
	private Double valor;
	
	
	public Pagamento() {
		// TODO Auto-generated constructor stub
	}

	public Pagamento( PIX pix, Cartao cartao, Double valor) {
		this.cartao = cartao;
		this.pix = pix;
		this.valor = valor;
	}


	public Cartao getCartao() {
		return cartao;
	}


	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}


	public PIX getPix() {
		return pix;
	}


	public void setPix(PIX pix) {
		this.pix = pix;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
