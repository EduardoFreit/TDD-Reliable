package main.java.entidades;

public class Usuario {
	
	private Integer id;
	private String email;
	private String telefone;
	private String senha;
	private Boolean semCredencial;
	
	public Usuario() {
		this.semCredencial = false;
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

}
