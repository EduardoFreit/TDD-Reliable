package main.java.repositorio;

import java.util.ArrayList;
import java.util.List;

import main.java.entidades.Usuario;

public class UsuarioRepositorio {

	private List<Usuario> usuarios;
	
	public UsuarioRepositorio (List<Usuario> usuarios) {
		this.usuarios = usuarios;
		/*Usuario usuario = new Usuario();
		
		usuario.setEmail("luiz@email.com");
		usuario.setTelefone("(81)9999-9999");
		usuario.setSenha("Luiz@1234");
		usuario.setId(1);
		
		Usuario usuario2 = new Usuario();
		
		usuario2.setEmail("luiz@email.com");
		usuario2.setTelefone("(81)9999-9999");
		usuario2.setSenha("Luiz@1234");
		usuario2.setId(2);
		
		this.usuarios.add(usuario);
		this.usuarios.add(usuario2);*/
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public Usuario getUsuario(Integer idUsuario) {
		for (Usuario usuario : usuarios) {
			if(usuario.getId().equals(idUsuario)) {
				return usuario;
			}
		}
		return null;
	}

}
