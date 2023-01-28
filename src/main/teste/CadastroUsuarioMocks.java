package main.teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import main.java.entidades.Usuario;
import main.java.negocio.UsuarioNegocio;
import main.java.repositorio.UsuarioRepositorio;

@RunWith(MockitoJUnitRunner.class)
public class CadastroUsuarioMocks {
	
	@Mock
	UsuarioRepositorio ur;
	
	@Test
	public void cadastrarUsuarioDadosCorretosTest() {
		Usuario u = new Usuario("Vilmar", 40, "1111111");
				
		when(ur.addUsuario(u)).thenReturn(true);
		UsuarioNegocio un = new UsuarioNegocio(ur);
		
		Boolean cadastrou = un.cadastrarUsuario(u);
		assertTrue(cadastrou);
	}
	
	@Test
	public void cadastrarUsuarioNomeIncorretoTest() {
		Usuario u = new Usuario("Vilmar Santgtgggggggggggggggggggggggggggggggggggggggggggggggggos De alcantara Nepomuceno lima segundo", 40, "1111111");
		
		UsuarioNegocio un = new UsuarioNegocio(ur);
		
		Boolean cadastrou = un.cadastrarUsuario(u);
		
		verify(ur, times(0)).addUsuario(u);
		assertFalse(cadastrou);
	}

}
