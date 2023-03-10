package main.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.java.entidades.AvaliacaoServico;
import main.java.entidades.FiltroBuscaServico;
import main.java.entidades.Servico;
import main.java.negocio.ServicoNegocio;
import main.java.repositorio.ServicoRepositorio;

public class ServicoTests {
	
	ServicoRepositorio sr;
	ServicoNegocio sn;
	
	@Before
	public void initTestes() {
		List<Servico> servicos = new ArrayList<>();
		
		Servico servico1 = new Servico();
		servico1.setId(1);
		servico1.setNome("Limpeza de Casa");
		servico1.setCategoria("Limpeza");
		servico1.setDisponibilidade("Manhã");
		servico1.setValor(80.0);
		servico1.setDiferenciais("Profissional");
		servico1.setRestricoes("Nenhuma");
		
		Servico servico2 = new Servico();
		servico2.setId(2);
		servico2.setNome("Manutenção de Carro");
		servico2.setCategoria("Mecanica");
		servico2.setDisponibilidade("Manhã/Tarde");
		servico2.setValor(500.0);
		servico2.setDiferenciais("Troca de Oleo");
		servico2.setRestricoes("Nenhuma");
		
		servicos.add(servico1);
		servicos.add(servico2);
		
		
		sr = new ServicoRepositorio(servicos);
		sn = new ServicoNegocio(sr);
	}
	
	@Test
	public void excluirServicoTest() {
		/*
		 * RF008 -  Excluir Serviço - Luiz Freitas
		 * CASES TESTS - 24
		 */
		Integer idServico = 1;
		
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
		sn = new ServicoNegocio(sr);
		
		filtro.setNome("cozinha");
		
		List<Servico> servicos = sn.buscarServico(filtro);
		
		assertEquals(0, servicos.size());
	}
	
	@Test
	public void editarServicoTest() {
		/*
		 * RF007  - Editar Serviço - Davidson Felix
		 * CASES TESTS - 20
		 */
		Integer idServico = 1;
		
		Servico servico = sr.getServico(idServico);
		
		assertTrue(servico.getNome().equals("Limpeza de Casa"));
		assertTrue(servico.getCategoria().equals("Limpeza"));
		assertTrue(servico.getDisponibilidade().equals("Manhã"));
		assertTrue(servico.getValor().equals(80.0));
		assertTrue(servico.getDiferenciais().equals("Profissional"));
		assertTrue(servico.getRestricoes().equals("Nenhuma"));
		
		Servico servicoEditar = new Servico();
		
		servicoEditar.setNome("Limpeza de Carro");
		servicoEditar.setCategoria("Limpeza Carro");
		servicoEditar.setDisponibilidade("Tarde");
		servicoEditar.setValor(100.0);
		servicoEditar.setDiferenciais("Nenhuma");
		servicoEditar.setRestricoes("Nenhuma");
		
		Boolean editou = sn.editarServico(servico, servicoEditar);
		assertTrue(editou);
		
		assertTrue(servico.getNome().equals("Limpeza de Carro"));
		assertTrue(servico.getCategoria().equals("Limpeza Carro"));
		assertTrue(servico.getDisponibilidade().equals("Tarde"));
		assertTrue(servico.getValor().equals(100.0));
		assertTrue(servico.getDiferenciais().equals("Nenhuma"));
		assertTrue(servico.getRestricoes().equals("Nenhuma"));
	}
	
	@Test
	public void cadastrarServicoTest() {
		/*
		 * RF006  - Cadastrar Serviço - Davidson Felix
		 * CASES TESTS - 22
		 */
		Servico servicoCadastrar = new Servico();
		
		servicoCadastrar.setNome("Sabor da Terra");
		servicoCadastrar.setCategoria("Alimentação");
		servicoCadastrar.setDisponibilidade("Tarde");
		servicoCadastrar.setValor(35.0);
		servicoCadastrar.setDiferenciais("Adultos: Galeto completo");
		servicoCadastrar.setRestricoes("Nenhuma");
		
		assertTrue(sr.totalServicos() == 2);
		
		Boolean cadastrou = sn.cadastrarServico(servicoCadastrar);
		assertTrue(cadastrou);
		
		assertTrue(sr.totalServicos() == 3);
	}
	
	@Test
	public void avaliarServicoTest() {
		/*
		 * RF015  - Avaliar Serviço - Davidson Felix
		 * CASES TESTS - 23
		 */
		Integer idUsuario = 2;
		Integer idServico = 1;
		
		AvaliacaoServico avaliacao = new AvaliacaoServico();
		avaliacao.setRate(4);
		avaliacao.setComentario("Serviço Bom");
		avaliacao.setIdUsuario(idUsuario);
		
		Servico servicoAvaliar = sr.getServico(idServico);
		
		assertTrue(servicoAvaliar.getAvaliacoes().size() == 0);
		
		Boolean avaliado = sn.avaliarServico(servicoAvaliar, avaliacao);
		
		assertTrue(avaliado);
		
		assertTrue(servicoAvaliar.getAvaliacoes().size() == 1);
	}

}
