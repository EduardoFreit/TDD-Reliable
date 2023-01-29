package main.java.repositorio;

import java.util.ArrayList;
import java.util.List;

import main.java.entidades.Usuario;

public class UsuarioRepositorio {

	private List<Usuario> usuarios;
	
	public UsuarioRepositorio () {
		this.usuarios = new ArrayList<Usuario>();
		Usuario usuarioTesteLogin = new Usuario();
		
		usuarioTesteLogin.setEmail("luiz@email.com");
		usuarioTesteLogin.setTelefone("(81)9999-9999");
		usuarioTesteLogin.setPassword("Luiz@1234");
		
		this.usuarios.add(usuarioTesteLogin);
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

}
