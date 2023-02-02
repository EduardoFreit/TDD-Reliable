package main.java.negocio;

import main.java.entidades.Pagamento;
import main.java.service.PagamentoApiService;

public class PagementoNegocio {
	
	private PagamentoApiService ps;
	
	public PagementoNegocio() {
		// TODO Auto-generated constructor stub
	}
	
	public Boolean pagamentoValor(Pagamento pagamento) {
		Integer status = ps.pagamentoExterno(pagamento);
		
		switch (status) {
		case 200:
			return true;
		default:
			return false;
		}
	}
}
