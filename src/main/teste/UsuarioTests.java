package main.teste;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import main.java.entidades.Usuario;
import main.java.negocio.UsuarioNegocio;
import main.java.repositorio.UsuarioRepositorio;

public class UsuarioTests {
	
	UsuarioRepositorio ur;
	UsuarioNegocio un;
	
	@Before
	public void initTestes() {

		List<Usuario> usuarios = new ArrayList<>();
		
		Usuario usuario = new Usuario();
		
		usuario.setEmail("luiz@email.com");
		usuario.setTelefone("(81)9999-9999");
		usuario.setSenha("Luiz@1234");
		usuario.setId(1);
		
		Usuario usuario2 = new Usuario();
		
		usuario2.setEmail("Davidson@email.com");
		usuario2.setTelefone("(81)9999-9999");
		usuario2.setSenha("Luiz@1234");
		usuario2.setId(2);
		
		usuarios.add(usuario);
		usuarios.add(usuario2);
		
		Usuario usuario3 = new Usuario();
		
		usuario3.setEmail("Rafael@email.com");
		usuario3.setTelefone("(81)9999-9999");
		usuario3.setSenha("Rafael@1234");
		usuario3.setId(3);
		
		usuario.getFavoritos().add(usuario3);
		
		usuarios.add(usuario);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		
		
		ur = new UsuarioRepositorio(usuarios);
		un = new UsuarioNegocio(ur);
	}
	
	@Test
	public void favoritarUsuarioTest() {
		/*
		 * RF017  - Favoritar Usuário - Davidson Felix
		 * CASES TESTS - 21
		 */
		Integer idUsuario1 = 1;
		Integer idUsuario2 = 2;
		
		Usuario usuario = ur.getUsuario(idUsuario1);
		
		assertTrue(usuario.getFavoritos().size() == 1);
		
		Boolean favoritou = un.favoritarUsuario(usuario, idUsuario2);
		
		assertTrue(favoritou);
		
		assertTrue(usuario.getFavoritos().size() == 2);
	}
	
	@Test
	public void desfavoritarUsuarioTest() {
		/*
		 * RF017  - Desfavoritar Usuario - Davidson Felix
		 * CASES TESTS - 21
		 */
		Integer idUsuario1 = 1;
		Integer idUsuario2 = 3;
		
		Usuario usuario = ur.getUsuario(idUsuario1);
		
		assertTrue(usuario.getFavoritos().size() == 1);
		
		Boolean desfavoritou = un.desfavoritarUsuario(usuario, idUsuario2);
		
		assertTrue(desfavoritou);
		
		assertTrue(usuario.getFavoritos().size() == 0);
	}


}
