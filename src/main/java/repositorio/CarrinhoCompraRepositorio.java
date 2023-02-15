package main.java.repositorio;

import java.util.ArrayList;
import java.util.List;

import main.java.entidades.CarrinhoCompra;
import main.java.entidades.Usuario;

public class CarrinhoCompraRepositorio {
	
	private List<CarrinhoCompra> carrinhos;
	
	public CarrinhoCompraRepositorio(UsuarioRepositorio ur) {
		this.carrinhos = new ArrayList<>();
		Usuario user = ur.getUsuarios().get(0);
		
		CarrinhoCompra carrinho = new CarrinhoCompra();
		carrinho.setUsuario(user);
		carrinho.setServicos(new ArrayList<>());
		
		this.carrinhos.add(carrinho);
	}
	
	public List<CarrinhoCompra> getCarrinhos() {
		return carrinhos;
	}

}
