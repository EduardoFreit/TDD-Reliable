package main.service;

import java.util.List;

import main.java.entidades.CredencialExterna;

public class ContasExternasWebService {
	
	private List<CredencialExterna> credenciaisExternas;
	
	public ContasExternasWebService() {}
	/*public ContasExternasWebService() {
		CredencialExterna credencialExternaGoogle = new CredencialExterna();
		CredencialExterna credencialExternaFacebook = new CredencialExterna();
		CredencialExterna credencialExternaOutlook = new CredencialExterna();
		CredencialExterna credencialExternaFailGoogle = new CredencialExterna();
		CredencialExterna credencialExternaFailFacebook = new CredencialExterna();
		CredencialExterna credencialExternaFailOutlook = new CredencialExterna();
		
		credencialExternaGoogle.setServicoExterno("Google");
		credencialExternaGoogle.setEmail("luiz@gmail.com");
		credencialExternaGoogle.setPermitirVinculo(true);
		credencialExternaGoogle.setServicoExterno("Facebook");
		credencialExternaGoogle.setEmail("luiz@facebook.com");
		credencialExternaGoogle.setPermitirVinculo(true);
		credencialExternaGoogle.setServicoExterno("Outlook");
		credencialExternaGoogle.setEmail("luiz@outlook.com");
		credencialExternaGoogle.setPermitirVinculo(true);
		
		credencialExternaFailGoogle.setServicoExterno("Google");
		credencialExternaFailGoogle.setEmail("luiz_fail@gmail.com");
		credencialExternaFailGoogle.setPermitirVinculo(false);
		credencialExternaFailFacebook.setServicoExterno("Facebook");
		credencialExternaFailFacebook.setEmail("luiz_fail@facebook.com");
		credencialExternaFailFacebook.setPermitirVinculo(false);
		credencialExternaFailOutlook.setServicoExterno("Outlook");
		credencialExternaFailOutlook.setEmail("luiz_fail@outlook.com");
		credencialExternaFailOutlook.setPermitirVinculo(false);
		
		credenciaisExternas.add(credencialExternaGoogle);
		credenciaisExternas.add(credencialExternaFacebook);
		credenciaisExternas.add(credencialExternaOutlook);
		credenciaisExternas.add(credencialExternaFailGoogle);
		credenciaisExternas.add(credencialExternaFailFacebook);
		credenciaisExternas.add(credencialExternaFailOutlook);
	}*/
	
	public List<CredencialExterna> getCredenciaisExternas() {
		return credenciaisExternas;
	}

	public void setCredenciaisExternas(List<CredencialExterna> credenciaisExternas) {
		this.credenciaisExternas = credenciaisExternas;
	}
}
