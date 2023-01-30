package main.java.repositorio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import main.java.entidades.CartaoPagamento;

public class PagamentoRepositorio {
	
	private List<CartaoPagamento> cartoesPagamento;
	
	public PagamentoRepositorio() {
		try {
			this.cartoesPagamento = new ArrayList<>();
			
			CartaoPagamento cartao = new CartaoPagamento();
			cartao.setNumero("4567456745674567");
			cartao.setValidade(new SimpleDateFormat("MM/yyyy").parse("07/2028"));
			cartao.setCVV("456");
			cartao.setNome("Joao P L Silva");
			cartao.setCpf("000.000.000-05");
			cartao.setIdUsuario(1L);
			
			this.cartoesPagamento.add(cartao);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<CartaoPagamento> listarFormaPagamento(Long idUsuario) {
		List<CartaoPagamento> result = new ArrayList<>();
		
		for (CartaoPagamento cartaoPagamento : this.cartoesPagamento) {
			if(cartaoPagamento.getIdUsuario().equals(idUsuario)) {
				result.add(cartaoPagamento);
			}
		}
		return result;
	}
	
	public Boolean addFormaPagamento(CartaoPagamento cartaoPagamento) {
		return this.cartoesPagamento.add(cartaoPagamento);
	}

}
