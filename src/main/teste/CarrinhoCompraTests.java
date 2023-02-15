package main.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import main.java.entidades.CarrinhoCompra;
import main.java.entidades.Servico;
import main.java.entidades.Usuario;
import main.java.negocio.CarrinhoCompraNegocio;
import main.java.repositorio.CarrinhoCompraRepositorio;
import main.java.repositorio.ServicoRepositorio;
import main.java.repositorio.UsuarioRepositorio;

public class CarrinhoCompraTests {
	
	CarrinhoCompraRepositorio cr;
	CarrinhoCompraNegocio cn;
	ServicoRepositorio sr;
	UsuarioRepositorio ur;
	
	@Before
	public void initTestes() {
		
		List<Usuario> usuarios = new ArrayList<>();
		
		Usuario usuario = new Usuario();
		
		usuario.setEmail("luiz@email.com");
		usuario.setTelefone("(81)9999-9999");
		usuario.setSenha("Luiz@1234");
		usuario.setId(1);
		
		Usuario usuario2 = new Usuario();
		
		usuario2.setEmail("luiz@email.com");
		usuario2.setTelefone("(81)9999-9999");
		usuario2.setSenha("Luiz@1234");
		usuario2.setId(2);
		
		usuarios.add(usuario);
		usuarios.add(usuario2);
		
		
		ur = new UsuarioRepositorio(usuarios);
		cr = new CarrinhoCompraRepositorio(ur);
		cn = new CarrinhoCompraNegocio(cr);
		sr = new ServicoRepositorio();
	}
	
	@Test
	public void addServicoCarrinhoTest() {
		/*
		 * RF011 - Adicionar ao Carrinho - Luiz Freitas
		 * CASES TESTS - 26
		 */
		Integer idServico = 1;
		Integer idUsuario = 1;
		
		
		CarrinhoCompra carrinho = cn.getCarrinho(idUsuario);
		Servico servicoAddCarrinho = sr.getServico(idServico);
		
		assertEquals(0, carrinho.getServicos().size());
		
		Boolean adicionou = cn.adicionarServicoCarrinho(carrinho, servicoAddCarrinho);
		
		assertTrue(adicionou);
		assertEquals(1, carrinho.getServicos().size());
	}
}
