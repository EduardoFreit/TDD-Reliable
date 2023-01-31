package main.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

import main.java.entidades.CartaoPagamento;
import main.java.negocio.PagamentoNegocio;
import main.java.repositorio.PagamentoRepositorio;

public class AdicionarFormaPagamentoTests {
	/*
	 * RF028 - Adicionar forma de pagamento
	 * CASES TESTS - 26, 27
	 */
	
	PagamentoRepositorio pr;
	PagamentoNegocio pn;
	
	@Test
	public void addFormaPagamentoTest() throws Exception {
		Long idUsuario = 1L;
		pr = new PagamentoRepositorio();
		pn = new PagamentoNegocio(pr);
		
		CartaoPagamento cartao = new CartaoPagamento();
		cartao.setNumero("1234123412341234");
		cartao.setValidade(new SimpleDateFormat("MM/yyyy").parse("07/2030"));
		cartao.setCVV("123");
		cartao.setNome("Joao P L Silva");
		cartao.setCpf("000.000.000-05");
		cartao.setIdUsuario(idUsuario);
		
		List<CartaoPagamento> formasPagamentoAntes = pr.listarFormaPagamento(idUsuario);
		assertEquals(1, formasPagamentoAntes.size());
		
		Boolean adicionado = pr.addFormaPagamento(cartao);
		assertTrue(adicionado);
		
		List<CartaoPagamento> formasPagamentoDepois = pr.listarFormaPagamento(idUsuario);
		assertEquals(2, formasPagamentoDepois.size());
	}
	
	@Test
	public void addFormaPagamentoValidoTest() throws Exception {
		Long idUsuario = 1L;
		pr = new PagamentoRepositorio();
		pn = new PagamentoNegocio(pr);
		
		CartaoPagamento cartao = new CartaoPagamento();
		cartao.setNumero("1234123412341234");
		cartao.setValidade(new SimpleDateFormat("MM/yyyy").parse("07/2030"));
		cartao.setCVV("123");
		cartao.setNome("Joao P L Silva");
		cartao.setCpf("000.000.000-05");
		cartao.setIdUsuario(idUsuario);
		
		List<CartaoPagamento> formasPagamentoAntes = pr.listarFormaPagamento(idUsuario);
		assertEquals(1, formasPagamentoAntes.size());
		
		Boolean adicionado = pn.cadastrarFormaPagamento(cartao);
		assertTrue(adicionado);
		
		List<CartaoPagamento> formasPagamentoDepois = pr.listarFormaPagamento(idUsuario);
		assertEquals(2, formasPagamentoDepois.size());
	}
	
	@Test
	public void addFormaPagamentoInvalidoValidadeTest() throws Exception {
		Long idUsuario = 1L;
		pr = new PagamentoRepositorio();
		pn = new PagamentoNegocio(pr);
		
		CartaoPagamento cartao = new CartaoPagamento();
		cartao.setNumero("1234123412341234");
		cartao.setValidade(new SimpleDateFormat("MM/yyyy").parse("07/2022"));
		cartao.setCVV("123");
		cartao.setNome("Joao P L Silva");
		cartao.setCpf("000.000.000-05");
		cartao.setIdUsuario(idUsuario);
		
		List<CartaoPagamento> formasPagamentoAntes = pr.listarFormaPagamento(idUsuario);
		assertEquals(1, formasPagamentoAntes.size());
		
		Boolean adicionado = pn.cadastrarFormaPagamento(cartao);
		assertFalse(adicionado);
		
		List<CartaoPagamento> formasPagamentoDepois = pr.listarFormaPagamento(idUsuario);
		assertEquals(1, formasPagamentoDepois.size());
	}
	
	@Test
	public void addFormaPagamentoInvalidoCPFTest() throws Exception {
		Long idUsuario = 1L;
		pr = new PagamentoRepositorio();
		pn = new PagamentoNegocio(pr);
		
		CartaoPagamento cartao = new CartaoPagamento();
		cartao.setNumero("1234123412341234");
		cartao.setValidade(new SimpleDateFormat("MM/yyyy").parse("07/2030"));
		cartao.setCVV("123");
		cartao.setNome("Joao P L Silva");
		cartao.setCpf("0000000000");
		cartao.setIdUsuario(idUsuario);
		
		List<CartaoPagamento> formasPagamentoAntes = pr.listarFormaPagamento(idUsuario);
		assertEquals(1, formasPagamentoAntes.size());
		
		Boolean adicionado = pn.cadastrarFormaPagamento(cartao);
		assertFalse(adicionado);
		
		List<CartaoPagamento> formasPagamentoDepois = pr.listarFormaPagamento(idUsuario);
		assertEquals(1, formasPagamentoDepois.size());
	}
	
	@Test
	public void addFormaPagamentoInvalidoNumeroTest() throws Exception {
		Long idUsuario = 1L;
		pr = new PagamentoRepositorio();
		pn = new PagamentoNegocio(pr);
		
		CartaoPagamento cartao = new CartaoPagamento();
		cartao.setNumero("123412341234");
		cartao.setValidade(new SimpleDateFormat("MM/yyyy").parse("07/2030"));
		cartao.setCVV("123");
		cartao.setNome("Joao P L Silva");
		cartao.setCpf("00000000005");
		cartao.setIdUsuario(idUsuario);
		
		List<CartaoPagamento> formasPagamentoAntes = pr.listarFormaPagamento(idUsuario);
		assertEquals(1, formasPagamentoAntes.size());
		
		Boolean adicionado = pn.cadastrarFormaPagamento(cartao);
		assertFalse(adicionado);
		
		List<CartaoPagamento> formasPagamentoDepois = pr.listarFormaPagamento(idUsuario);
		assertEquals(1, formasPagamentoDepois.size());
	}
}
