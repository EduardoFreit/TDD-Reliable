package main.java.entidades;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private Integer id;
	private String email;
	private String telefone;
	private String senha;
	private Boolean semCredencial;
	private List<Usuario> favoritos;
	
	public Usuario() {
		this.semCredencial = false;
		this.favoritos = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String password) {
		this.senha = password;
	}

	public Boolean isSemCredencial() {
		return semCredencial;
	}

	public void setSemCredencial(Boolean semCredencial) {
		this.semCredencial = semCredencial;
	}
	
	public Boolean equalsCredenciaisLogin(Usuario usr) {
		if(usr.getEmail() == this.getEmail() && usr.getSenha() == this.getSenha()) {
			return true;
		} else if (usr.getTelefone() == this.getTelefone() && usr.getSenha() == this.getSenha()) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<Usuario> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(List<Usuario> favoritos) {
		this.favoritos = favoritos;
	}

	@Override
	public boolean equals(Object obj) {
		Usuario usr = (Usuario) obj;
		if(usr.getId() == this.id) {
			return true;
		}
		return false;
	}

}
