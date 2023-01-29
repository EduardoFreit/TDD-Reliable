package main.java.entidades;

public class Usuario {
	
	private String email;
	private String telefone;
	private String password;
	private Boolean semCredencial;
	
	public Usuario() {
		this.semCredencial = false;
		// TODO Auto-generated constructor stub
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean isSemCredencial() {
		return semCredencial;
	}

	public void setSemCredencial(Boolean semCredencial) {
		this.semCredencial = semCredencial;
	}
	
	public Boolean equalsCredenciaisLogin(Usuario usr) {
		if(usr.getEmail() == this.getEmail() && usr.getPassword() == this.getPassword()) {
			return true;
		} else if (usr.getTelefone() == this.getTelefone() && usr.getPassword() == this.getPassword()) {
			return true;
		} else {
			return false;
		}
	}

}
