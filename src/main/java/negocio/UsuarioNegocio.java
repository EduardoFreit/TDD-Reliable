package main.java.negocio;

import main.java.entidades.Usuario;
import main.java.repositorio.UsuarioRepositorio;

public class UsuarioNegocio {
	
	private UsuarioRepositorio ur;
	
	public UsuarioNegocio(UsuarioRepositorio ur) {
		this.ur = ur;
	}
	
	public void favoritarUsuario(Usuario usuarioQueFavoritou, Integer idUsuarioFavorito) {
		Usuario usuarioFavorito = ur.getUsuario(idUsuarioFavorito);
		
		if(!usuarioQueFavoritou.equals(usuarioFavorito)) {
			usuarioQueFavoritou.getFavoritos().add(usuarioFavorito);
		}
	}
	
	public void desfavoritarUsuario(Usuario usuarioQueFavoritou, Integer idUsuarioFavorito) {
		Usuario usuarioFavorito = ur.getUsuario(idUsuarioFavorito);
		
		if(usuarioQueFavoritou.getFavoritos().contains(usuarioFavorito)) {
			usuarioQueFavoritou.getFavoritos().remove(usuarioFavorito);
		}
	}
	
	

}
