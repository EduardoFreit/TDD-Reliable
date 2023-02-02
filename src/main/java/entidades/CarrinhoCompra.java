package main.java.entidades;

import java.util.List;

public class CarrinhoCompra {
	
	private List<Servico> servicos;
	private Usuario usuario;
	
	public CarrinhoCompra() {
		// TODO Auto-generated constructor stub
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
