package main.java.negocio;

import main.java.entidades.Usuario;
import main.java.repositorio.UsuarioRepositorio;

public class UsuarioNegocio {
	
	
	
	private UsuarioRepositorio repo;
	
	public UsuarioNegocio(UsuarioRepositorio rep) {
		this.repo = rep;
	}
	
	public boolean cadastrarUsuario(Usuario u) {
		boolean ret = false;
		
		if (u.getNome().length() <= 50) {
			ret = this.repo.addUsuario(u);
		}		
		
		return ret;
	}

}
