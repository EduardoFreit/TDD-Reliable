package main.java.negocio;

import main.java.entidades.Usuario;
import main.java.repositorio.UsuarioRepositorio;

public class UsuarioNegocio {
	
	private UsuarioRepositorio ur;
	
	public UsuarioNegocio(UsuarioRepositorio ur) {
		this.ur = ur;
	}
	
	public Boolean favoritarUsuario(Usuario usuarioQueFavoritou, Integer idUsuarioFavorito) {
		Usuario usuarioFavorito = ur.getUsuario(idUsuarioFavorito);
		
		if(!usuarioQueFavoritou.equals(usuarioFavorito)) {
			return usuarioQueFavoritou.getFavoritos().add(usuarioFavorito);
		}
		return false;
	}
	
	public Boolean desfavoritarUsuario(Usuario usuarioQueFavoritou, Integer idUsuarioFavorito) {
		Usuario usuarioFavorito = ur.getUsuario(idUsuarioFavorito);
		
		if(usuarioQueFavoritou.getFavoritos().contains(usuarioFavorito)) {
			return usuarioQueFavoritou.getFavoritos().remove(usuarioFavorito);
		}
		return false;
	}
	
	

}
