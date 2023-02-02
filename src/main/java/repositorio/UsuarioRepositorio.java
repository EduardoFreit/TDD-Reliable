package main.java.repositorio;

import java.util.ArrayList;
import java.util.List;

import main.java.entidades.Usuario;

public class UsuarioRepositorio {

	private List<Usuario> usuarios;
	
	public UsuarioRepositorio () {
		this.usuarios = new ArrayList<Usuario>();
		Usuario usuario = new Usuario();
		
		usuario.setEmail("luiz@email.com");
		usuario.setTelefone("(81)9999-9999");
		usuario.setSenha("Luiz@1234");
		usuario.setId(1);
		
		this.usuarios.add(usuario);
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

}
