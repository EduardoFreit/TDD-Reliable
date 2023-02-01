package main.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import main.java.entidades.Servico;
import main.java.repositorio.ServicoRepositorio;

public class ServicoTests {
	
	ServicoRepositorio sr;
	
	
	@Test
	public void excluirServicoTest() {
		/*
		 * RF008 -  Excluir Serviço
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

}
