package main.java.negocio;

import main.java.entidades.CredencialExterna;
import main.java.service.LoginExternoService;

public class LoginExternoNegocio {
	
	private LoginExternoService lgs;
	
	public Boolean loginExterno(CredencialExterna credExt) {
		Integer status = lgs.autenticarServicoExterno(credExt);
		switch (status) {
		case 200:
			return true;
		default:
			return false;
		}
	}

}
