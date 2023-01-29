package main.service;

import main.java.entidades.CredencialExterna;

public class LoginExternoService {
	
	public Integer autenticarServicoExterno(CredencialExterna credExt) {
		ContasExternasWebService cews = new ContasExternasWebService();
		for (CredencialExterna credencialExterna : cews.getCredenciaisExternas()) {
			if(credencialExterna.equalsCredenciais(credExt) && credencialExterna.permitirVinculo()) {
				return 200;
			}
		}
		return 401;
	}
	
}
