package main.java.negocio;

import main.java.entidades.CarrinhoCompra;
import main.java.entidades.Servico;
import main.java.repositorio.CarrinhoCompraRepositorio;

public class CarrinhoCompraNegocio {
	
	private CarrinhoCompraRepositorio cr;
	
	public CarrinhoCompraNegocio(CarrinhoCompraRepositorio cr) {
		this.cr = cr;
	}
	
	public CarrinhoCompra getCarrinho(Integer idUsuario) {
		CarrinhoCompra carrinho = null;
		
		for (CarrinhoCompra car : cr.getCarrinhos()) {
			if(car.getUsuario().getId().equals(idUsuario)) {
				carrinho = car;
			}
		}
		
		return carrinho;
	}
	
	public Boolean adicionarServicoCarrinho(CarrinhoCompra carrinho, Servico servico) {
		return carrinho.getServicos().add(servico);
	}

}
