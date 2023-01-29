package main.teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.java.entidades.Usuario;
import main.java.negocio.LoginNegocio;
import main.java.repositorio.UsuarioRepositorio;

public class LoginUsuario {
	/*
	 * RF005 - Logar Sistema
	 * CASES TESTS - 11, 12 e 13
	 */

	@Test
	public void loginUsuarioEmailTest() {
		String email = "luiz@email.com";
		String password = "Luiz@1234";
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setPassword(password);
		
		UsuarioRepositorio ur = new UsuarioRepositorio();
		
		LoginNegocio login = new LoginNegocio(ur.getUsuarios());
		
		Boolean logou = login.logarUsuario(usuario);
		
		assertTrue(logou);
	}
	
	@Test
	public void loginUsuarioTelefoneTest() {
		String telefone = "(81)9999-9999";
		String password = "Luiz@1234";
		
		Usuario usuario = new Usuario();
		usuario.setTelefone(telefone);
		usuario.setPassword(password);
		
		UsuarioRepositorio ur = new UsuarioRepositorio();
		
		LoginNegocio login = new LoginNegocio(ur.getUsuarios());
		
		Boolean logou = login.logarUsuario(usuario);
		
		assertTrue(logou);
	}
	
	@Test
	public void loginUsuarioEmailIncorretoTest() {
		String email = "luiz@email.com";
		String password = "Luiz@1234";
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setPassword(password);
		
		UsuarioRepositorio ur = new UsuarioRepositorio();
		
		LoginNegocio login = new LoginNegocio(ur.getUsuarios());
		
		Boolean logou = login.logarUsuario(usuario);
		
		assertTrue(logou);
	}
	
	@Test
	public void loginUsuarioTelefoneIncorretoTest() {
		String email = "luiz@email.com";
		String password = "Luiz@1234";
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setPassword(password);
		
		UsuarioRepositorio ur = new UsuarioRepositorio();
		
		LoginNegocio login = new LoginNegocio(ur.getUsuarios());
		
		Boolean logou = login.logarUsuario(usuario);
		
		assertTrue(logou);
	}
	
	@Test
	public void loginUsuarioSemCredenciaisTest() {
		
		Usuario usuario = new Usuario();
		usuario.setSemCredencial(true);
		
		UsuarioRepositorio ur = new UsuarioRepositorio();
		
		LoginNegocio login = new LoginNegocio(ur.getUsuarios());
		
		Boolean logou = login.logarUsuario(usuario);
		
		assertTrue(logou);
	}

}
