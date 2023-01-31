package main.java.negocio;

import java.util.Date;

import main.java.entidades.CartaoPagamento;
import main.java.repositorio.PagamentoRepositorio;

public class PagamentoNegocio {
	
private PagamentoRepositorio pr;
	
	public PagamentoNegocio(PagamentoRepositorio pr) {
		this.pr = pr;
	}
	
	public Boolean validarValidade(CartaoPagamento cartao) {
		return cartao.getValidade().after(new Date());
	}
	
	public Boolean validarNumero(CartaoPagamento cartao) {
		return cartao.getNumero().length() == 16 ;
	}
	
	public Boolean validarCPF(CartaoPagamento cartao) {
		return cartao.getCpf().length() == 14;
	}
	
	public Boolean validarCartao(CartaoPagamento cartao) {
		return this.validarCPF(cartao) && this.validarNumero(cartao) && this.validarValidade(cartao);
	}
	
	public Boolean cadastrarFormaPagamento(CartaoPagamento cartao) {
		boolean cadastrou = false;
		
		if (this.validarCartao(cartao)) {
			cadastrou = this.pr.addFormaPagamento(cartao);
		}
		
		return cadastrou;
	}

}
