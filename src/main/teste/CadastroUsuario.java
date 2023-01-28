package main.teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.java.entidades.Usuario;
import main.java.negocio.UsuarioNegocio;
import main.java.repositorio.UsuarioRepositorio;

public class CadastroUsuario {

	@Test
	public void addUsuarioTest() {
		Usuario u = new Usuario("Vilmar", 40, "1111111");
		
		UsuarioRepositorio ur = new UsuarioRepositorio();
		Boolean cadastrou = ur.addUsuario(u);
		assertTrue(cadastrou);
	}
	
	@Test
	public void cadastrarUsuarioDadosCorretosTest() {
		Usuario u = new Usuario("Vilmar", 40, "1111111");
		
		UsuarioRepositorio ur = new UsuarioRepositorio();
		
		UsuarioNegocio un = new UsuarioNegocio(ur);
		
		Boolean cadastrou = un.cadastrarUsuario(u);
		assertTrue(cadastrou);
	}
	
	
	@Test
	public void cadastrarUsuarioNomeIncorretoTest() {
		Usuario u = new Usuario("Vilmar Santgtgggggggggggggggggggggggggggggggggggggggggggggggggos De alcantara Nepomuceno lima segundo", 40, "1111111");
		
		UsuarioRepositorio ur = new UsuarioRepositorio();
		
		UsuarioNegocio un = new UsuarioNegocio(ur);
		
		Boolean cadastrou = un.cadastrarUsuario(u);
		assertFalse(cadastrou);
	}
}
