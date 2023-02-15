package main.java.repositorio;

import java.util.List;

import main.java.entidades.Usuario;

public class UsuarioRepositorio {

	private List<Usuario> usuarios;
	
	public UsuarioRepositorio (List<Usuario> usuarios) {
		this.usuarios = usuarios;
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
