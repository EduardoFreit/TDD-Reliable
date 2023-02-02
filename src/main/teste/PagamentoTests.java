package main.teste;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

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
import main.java.negocio.CarrinhoCompraNegocio;
import main.java.negocio.PagementoNegocio;
import main.java.repositorio.CarrinhoCompraRepositorio;
import main.java.repositorio.ServicoRepositorio;
import main.java.service.PagamentoApiService;

@RunWith(MockitoJUnitRunner.class)
public class PagamentoTests {
	
	CarrinhoCompraRepositorio cr;
	CarrinhoCompraNegocio cn;
	ServicoRepositorio sr;
	
	@InjectMocks
	PagementoNegocio pn;
	
	@Mock
	PagamentoApiService ps;
	
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
		cr = new CarrinhoCompraRepositorio();
		cn = new CarrinhoCompraNegocio(cr);
		sr = new ServicoRepositorio();
		
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
		cr = new CarrinhoCompraRepositorio();
		cn = new CarrinhoCompraNegocio(cr);
		sr = new ServicoRepositorio();
		
		
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
		cr = new CarrinhoCompraRepositorio();
		cn = new CarrinhoCompraNegocio(cr);
		sr = new ServicoRepositorio();
		
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
		cr = new CarrinhoCompraRepositorio();
		cn = new CarrinhoCompraNegocio(cr);
		sr = new ServicoRepositorio();
		
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
