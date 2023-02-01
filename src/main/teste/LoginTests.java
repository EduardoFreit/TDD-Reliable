package main.teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.java.entidades.Usuario;
import main.java.negocio.LoginNegocio;
import main.java.repositorio.UsuarioRepositorio;

public class LoginTests {
	
	UsuarioRepositorio ur;
	LoginNegocio lgn;

	@Test
	public void loginUsuarioEmailTest() {
		/*
		 * RF005 -  Logar Sistema - Luiz Freitas
		 * CASES TESTS - 11
		 */
		String email = "luiz@email.com";
		String password = "Luiz@1234";
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(password);
		
		ur = new UsuarioRepositorio();
		lgn = new LoginNegocio(ur.getUsuarios());
		
		Boolean logou = lgn.logarUsuario(usuario);
		
		assertTrue(logou);
	}
	
	@Test
	public void loginUsuarioTelefoneTest() {
		/*
		 * RF005 -  Logar Sistema - Luiz Freitas
		 * CASES TESTS - 11
		 */
		String telefone = "(81)9999-9999";
		String password = "Luiz@1234";
		
		Usuario usuario = new Usuario();
		usuario.setTelefone(telefone);
		usuario.setSenha(password);
		
		ur = new UsuarioRepositorio();
		
		lgn = new LoginNegocio(ur.getUsuarios());
		
		Boolean logou = lgn.logarUsuario(usuario);
		
		assertTrue(logou);
	}
	
	@Test
	public void loginUsuarioEmailIncorretoTest() {
		/*
		 * RF005 -  Logar Sistema - Luiz Freitas
		 * CASES TESTS - 13
		 */
		String email = "luiz@email.com";
		String password = "Luiz@1234";
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(password);
		
		ur = new UsuarioRepositorio();
		
		lgn = new LoginNegocio(ur.getUsuarios());
		
		Boolean logou = lgn.logarUsuario(usuario);
		
		assertTrue(logou);
	}
	
	@Test
	public void loginUsuarioTelefoneIncorretoTest() {
		/*
		 * RF005 -  Logar Sistema - Luiz Freitas
		 * CASES TESTS - 13
		 */
		String telefone = "(81)0000-0000";
		String password = "Luiz@1234";
		
		Usuario usuario = new Usuario();
		usuario.setTelefone(telefone);
		usuario.setSenha(password);
		
		ur = new UsuarioRepositorio();
		
		lgn = new LoginNegocio(ur.getUsuarios());
		
		Boolean logou = lgn.logarUsuario(usuario);
		
		assertFalse(logou);
	}
	
	@Test
	public void loginUsuarioSenhaIncorretoTest() {
		/*
		 * RF005 -  Logar Sistema - Luiz Freitas
		 * CASES TESTS - 13
		 */
		String telefone = "(81)9999-9999";
		String password = "Luiz@12345555";
		
		Usuario usuario = new Usuario();
		usuario.setTelefone(telefone);
		usuario.setSenha(password);
		
		ur = new UsuarioRepositorio();
		
		lgn = new LoginNegocio(ur.getUsuarios());
		
		Boolean logou = lgn.logarUsuario(usuario);
		
		assertFalse(logou);
	}
	
	@Test
	public void loginUsuarioSemCredenciaisTest() {
		/*
		 * RF005 -  Logar Sistema - Luiz Freitas
		 * CASES TESTS - 12
		 */
		Usuario usuario = new Usuario();
		usuario.setSemCredencial(true);
		
		ur = new UsuarioRepositorio();
		
		lgn = new LoginNegocio(ur.getUsuarios());
		
		Boolean logou = lgn.logarUsuario(usuario);
		
		assertTrue(logou);
	}

}
