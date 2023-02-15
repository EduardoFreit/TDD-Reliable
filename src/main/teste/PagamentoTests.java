package main.teste;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import main.java.entidades.CarrinhoCompra;
import main.java.entidades.Cartao;
import main.java.entidades.PIX;
import main.java.entidades.Pagamento;
import main.java.entidades.Servico;
import main.java.entidades.Usuario;
import main.java.negocio.CarrinhoCompraNegocio;
import main.java.negocio.PagementoNegocio;
import main.java.repositorio.CarrinhoCompraRepositorio;
import main.java.repositorio.ServicoRepositorio;
import main.java.repositorio.UsuarioRepositorio;
import main.java.service.PagamentoApiService;

@RunWith(MockitoJUnitRunner.class)
public class PagamentoTests {
	
	CarrinhoCompraRepositorio cr;
	CarrinhoCompraNegocio cn;
	ServicoRepositorio sr;
	UsuarioRepositorio ur;
	
	@InjectMocks
	PagementoNegocio pn;
	
	@Mock
	PagamentoApiService ps;
	
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
	public void addServicoCarrinhoPixTest() {
		/*
		 * RF011 - Pagar Serviço - Luiz Freitas
		 * CASES TESTS - 27
		 */
		Integer idServico = 1;
		Integer idUsuario = 1;
		String tipoChave = "EMAIL";
		String chavePIX = "luiz@email.com";
		
		
		CarrinhoCompra carrinho = cn.getCarrinho(idUsuario);
		Servico servicoAddCarrinho = sr.getServico(idServico);
		cn.adicionarServicoCarrinho(carrinho, servicoAddCarrinho);
		
		Double totalCarrinho = carrinho.valorTotal();
		
		assertTrue(80.0f == totalCarrinho.floatValue());
		
		PIX pix = new PIX(tipoChave, chavePIX);
		
		Pagamento pagamento = new Pagamento(pix, null, totalCarrinho);
		
		when(ps.pagamentoExterno(pagamento)).thenReturn(200);
		
		Boolean valorPago = pn.pagamentoValor(pagamento);
		
		assertTrue(valorPago);
		
	}
	
	@Test
	public void addServicoCarrinhoPixInvalidoTest() {
		/*
		 * RF011 - Pagar Serviço - Luiz Freitas
		 * CASES TESTS - 28
		 */
		Integer idServico = 1;
		Integer idUsuario = 1;
		String tipoChave = "EMAIL";
		String chavePIX = "luiz_invalido@email.com";
		
		CarrinhoCompra carrinho = cn.getCarrinho(idUsuario);
		Servico servicoAddCarrinho = sr.getServico(idServico);
		cn.adicionarServicoCarrinho(carrinho, servicoAddCarrinho);
		
		Double totalCarrinho = carrinho.valorTotal();
		
		assertTrue(80.0f == totalCarrinho.floatValue());
		
		PIX pix = new PIX(tipoChave, chavePIX);
		
		Pagamento pagamento = new Pagamento(pix, null, totalCarrinho);
		
		when(ps.pagamentoExterno(pagamento)).thenReturn(405);
		
		Boolean valorPago = pn.pagamentoValor(pagamento);
		
		assertFalse(valorPago);
	}
	
	@Test
	public void addServicoCarrinhoCartaoTest() {
		/*
		 * RF011 - Pagar Serviço - Luiz Freitas
		 * CASES TESTS - 29
		 */
		Integer idServico = 1;
		Integer idUsuario = 1;
		String nomeCartao = "Luiz j F Silva";
		String numeroCartao = "1234123412341234";
		String CVVCartao = "123";
		String validadeCartao = "07/30";
		
		CarrinhoCompra carrinho = cn.getCarrinho(idUsuario);
		Servico servicoAddCarrinho = sr.getServico(idServico);
		cn.adicionarServicoCarrinho(carrinho, servicoAddCarrinho);
		
		Double totalCarrinho = carrinho.valorTotal();
		
		assertTrue(80.0f == totalCarrinho.floatValue());
		
		Cartao cartao = new Cartao(nomeCartao, numeroCartao, CVVCartao, validadeCartao);
		
		Pagamento pagamento = new Pagamento(null, cartao, totalCarrinho);
		
		when(ps.pagamentoExterno(pagamento)).thenReturn(200);
		
		Boolean valorPago = pn.pagamentoValor(pagamento);
		
		assertTrue(valorPago);
		
	}
	
	@Test
	public void addServicoCarrinhoCartaoInvalidoTest() {
		/*
		 * RF011 - Pagar Serviço - Luiz Freitas
		 * CASES TESTS - 30
		 */
		Integer idServico = 1;
		Integer idUsuario = 1;
		String nomeCartao = "Luiz j F Silva";
		String numeroCartao = "123412341234";
		String CVVCartao = "123";
		String validadeCartao = "07/22";
		
		CarrinhoCompra carrinho = cn.getCarrinho(idUsuario);
		Servico servicoAddCarrinho = sr.getServico(idServico);
		cn.adicionarServicoCarrinho(carrinho, servicoAddCarrinho);
		
		Double totalCarrinho = carrinho.valorTotal();
		
		assertTrue(80.0f == totalCarrinho.floatValue());
		
		Cartao cartao = new Cartao(nomeCartao, numeroCartao, CVVCartao, validadeCartao);
		
		Pagamento pagamento = new Pagamento(null, cartao, totalCarrinho);
		
		when(ps.pagamentoExterno(pagamento)).thenReturn(405);
		
		Boolean valorPago = pn.pagamentoValor(pagamento);
		
		assertFalse(valorPago);
		
	}
}
