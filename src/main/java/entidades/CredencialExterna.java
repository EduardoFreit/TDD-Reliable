package main.java.entidades;

public class CredencialExterna {
	
	private String servicoExterno;
	private String email;
	
	public CredencialExterna() {
		// TODO Auto-generated constructor stub
	}

	public String getServicoExterno() {
		return servicoExterno;
	}

	public void setServicoExterno(String servicoExterno) {
		this.servicoExterno = servicoExterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean equalsCredenciais(CredencialExterna crd) {
		if(crd.getEmail() == this.getEmail() && crd.getServicoExterno() == this.getServicoExterno()) {
			return true;
		} else {
			return false;
		}
	}
	
}
