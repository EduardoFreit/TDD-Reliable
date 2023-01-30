package main.java.negocio;

import java.util.Date;

import main.java.entidades.CartaoPagamento;
import main.java.repositorio.PagamentoRepositorio;

public class PagamentoNegocio {
	
	private PagamentoRepositorio pr;
	
	public PagamentoNegocio(PagamentoRepositorio pr) {
		this.pr = pr;
	}
	
	public Boolean cadastrarFormaPagamento(CartaoPagamento cartao) {
		boolean cadastrou = false;
		Date dateNow = new Date();
		
		if (cartao.getValidade().after(dateNow)) {
			cadastrou = this.pr.addFormaPagamento(cartao);
		}
		
		return cadastrou;
	}

}
