package main.java.negocio;

import java.util.Iterator;
import java.util.List;

import main.java.entidades.Usuario;

public class LoginNegocio {
	
	private List<Usuario> usuarios;
	
	public LoginNegocio(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public Boolean logarUsuario(Usuario usr) {
		Boolean loginBemSucedido = false;
		for (Usuario usuario : usuarios) {
			if(usuario.equalsCredenciaisLogin(usr) || usr.isSemCredencial()) {
				loginBemSucedido = true;
			}
		}
		return loginBemSucedido;
	}

}
