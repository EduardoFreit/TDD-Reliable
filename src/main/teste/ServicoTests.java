package main.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;

import main.java.entidades.FiltroBuscaServico;
import main.java.entidades.Servico;
import main.java.negocio.ServicoNegocio;
import main.java.repositorio.ServicoRepositorio;

public class ServicoTests {
	
	ServicoRepositorio sr;
	ServicoNegocio sn;
	
	@Test
	public void excluirServicoTest() {
		/*
		 * RF008 -  Excluir Serviço - Luiz Freitas
		 * CASES TESTS - 24
		 */
		Integer idServico = 1;
		sr = new ServicoRepositorio();
		
		List<Servico> servicosUsuarioAntes = sr.listarServicos();
		
		assertEquals(2, servicosUsuarioAntes.size());
		
		Servico servicoDeletar = sr.getServico(idServico);
		
		Boolean deletou = sr.rmvServico(servicoDeletar);
		
		assertTrue(deletou);
		
		List<Servico> servicosUsuarioDepois = sr.listarServicos();
		
		assertEquals(1, servicosUsuarioDepois.size());
		
		
	}
	
	@Test
	public void buscarServicoTest() {
		/*
		 * RF009 - Buscar Serviço - Luiz Freitas
		 * CASES TESTS - 25
		 */
		FiltroBuscaServico filtro = new FiltroBuscaServico();
		sr = new ServicoRepositorio();
		sn = new ServicoNegocio(sr);
		
		filtro.setNome("Casa");
		filtro.setCategoria("Limpeza");
		filtro.setDisponibilidade("Manhã");
		filtro.setValorInicio(0.0);
		filtro.setValorFinal(100.0);
		filtro.setDiferenciais("Profissional");
		filtro.setRestricoes("Nenhuma");
		
		List<Servico> servicos = sn.buscarServico(filtro);
		
		assertEquals(2, servicos.size());
		assertEquals(1, servicos.get(0).getId().intValue());
		assertEquals(2, servicos.get(1).getId().intValue());
	}
	
	@Test
	public void buscarServicoNomeTest() {
		/*
		 * RF009 - Buscar Serviço - Luiz Freitas
		 * CASES TESTS - 25
		 */
		FiltroBuscaServico filtro = new FiltroBuscaServico();
		sr = new ServicoRepositorio();
		sn = new ServicoNegocio(sr);
		
		filtro.setNome("Casa");
		
		List<Servico> servicos = sn.buscarServico(filtro);
		
		assertEquals(1, servicos.size());
		assertEquals(1, servicos.get(0).getId().intValue());
	}
	
	@Test
	public void buscarServicoCategoriaTest() {
		/*
		 * RF009 - Buscar Serviço - Luiz Freitas
		 * CASES TESTS - 25
		 */
		FiltroBuscaServico filtro = new FiltroBuscaServico();
		sr = new ServicoRepositorio();
		sn = new ServicoNegocio(sr);
		
		filtro.setCategoria("Mecanica");
		
		List<Servico> servicos = sn.buscarServico(filtro);
		
		assertEquals(1, servicos.size());
		assertEquals(2, servicos.get(0).getId().intValue());
	}
	
	@Test
	public void buscarServicoDisponibilidadeTest() {
		/*
		 * RF009 - Buscar Serviço - Luiz Freitas
		 * CASES TESTS - 25
		 */
		FiltroBuscaServico filtro = new FiltroBuscaServico();
		sr = new ServicoRepositorio();
		sn = new ServicoNegocio(sr);
		
		filtro.setDisponibilidade("Manhã");
		
		List<Servico> servicos = sn.buscarServico(filtro);
		
		assertEquals(2, servicos.size());
		assertEquals(1, servicos.get(0).getId().intValue());
		assertEquals(2, servicos.get(1).getId().intValue());
		
	}
	
	@Test
	public void buscarServicoValorTest() {
		/*
		 * RF009 - Buscar Serviço - Luiz Freitas
		 * CASES TESTS - 25
		 */
		FiltroBuscaServico filtro = new FiltroBuscaServico();
		sr = new ServicoRepositorio();
		sn = new ServicoNegocio(sr);
		
		filtro.setValorInicio(100.0);
		filtro.setValorFinal(500.0);
		
		List<Servico> servicos = sn.buscarServico(filtro);
		
		assertEquals(1, servicos.size());
		assertEquals(2, servicos.get(0).getId().intValue());
	}
	
	@Test
	public void buscarServicoDiferenciaisTest() {
		/*
		 * RF009 - Buscar Serviço - Luiz Freitas
		 * CASES TESTS - 25
		 */
		FiltroBuscaServico filtro = new FiltroBuscaServico();
		sr = new ServicoRepositorio();
		sn = new ServicoNegocio(sr);
		
		filtro.setDiferenciais("Oleo");
		
		List<Servico> servicos = sn.buscarServico(filtro);
		
		assertEquals(1, servicos.size());
		assertEquals(2, servicos.get(0).getId().intValue());
	}
	
	@Test
	public void buscarServicoRestricoesTest() {
		/*
		 * RF009 - Buscar Serviço - Luiz Freitas
		 * CASES TESTS - 25
		 */
		FiltroBuscaServico filtro = new FiltroBuscaServico();
		sr = new ServicoRepositorio();
		sn = new ServicoNegocio(sr);
		
		filtro.setRestricoes("Nenhuma");
		
		List<Servico> servicos = sn.buscarServico(filtro);
		
		assertEquals(2, servicos.size());
		assertEquals(1, servicos.get(0).getId().intValue());
		assertEquals(2, servicos.get(1).getId().intValue());
	}
	
	@Test
	public void buscarServicoNenhumTest() {
		/*
		 * RF009 - Buscar Serviço - Luiz Freitas
		 * CASES TESTS - 25
		 */
		FiltroBuscaServico filtro = new FiltroBuscaServico();
		sr = new ServicoRepositorio();
		sn = new ServicoNegocio(sr);
		
		filtro.setNome("cozinha");
		
		List<Servico> servicos = sn.buscarServico(filtro);
		
		assertEquals(0, servicos.size());
	}

}
