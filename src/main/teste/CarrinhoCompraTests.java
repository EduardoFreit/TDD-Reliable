package main.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import main.java.entidades.CarrinhoCompra;
import main.java.entidades.Servico;
import main.java.negocio.CarrinhoCompraNegocio;
import main.java.repositorio.CarrinhoCompraRepositorio;
import main.java.repositorio.ServicoRepositorio;

public class CarrinhoCompraTests {
	
	CarrinhoCompraRepositorio cr;
	CarrinhoCompraNegocio cn;
	ServicoRepositorio sr;
	
	@Test
	public void addServicoCarrinhoTest() {
		/*
		 * RF011 - Adicionar ao Carrinho - Luiz Freitas
		 * CASES TESTS - 26
		 */
		Integer idServico = 1;
		Integer idUsuario = 1;
		cr = new CarrinhoCompraRepositorio();
		cn = new CarrinhoCompraNegocio(cr);
		sr = new ServicoRepositorio();
		
		CarrinhoCompra carrinho = cn.getCarrinho(idUsuario);
		Servico servicoAddCarrinho = sr.getServico(idServico);
		
		assertEquals(0, carrinho.getServicos().size());
		
		Boolean adicionou = cn.adicionarServicoCarrinho(carrinho, servicoAddCarrinho);
		
		assertTrue(adicionou);
		assertEquals(1, carrinho.getServicos().size());
	}
}
