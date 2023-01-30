package main.teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import main.java.entidades.CredencialExterna;
import main.java.negocio.LoginExternoNegocio;
import main.java.service.LoginExternoService;

@RunWith(MockitoJUnitRunner.class)
public class LoginUsuarioExternoTests {
	/*
	 * RF003 -  Login no sistema pelo Google, Facebook ou Outlook
	 * CASES TESTS - 24, 25
	 */
	@InjectMocks
	LoginExternoNegocio lgn;
	
	@Mock
	LoginExternoService lgs;
	
	@Test
	public void loginUsuarioGoogleTest() {
		CredencialExterna credencialExterna = new CredencialExterna();
		credencialExterna.setServicoExterno("Google");
		credencialExterna.setEmail("luiz@gmail.com");
		
		when(lgs.autenticarServicoExterno(credencialExterna)).thenReturn(200);
		
		Boolean logou = lgn.loginExterno(credencialExterna);
		
		assertTrue(logou);
	}
	
	@Test
	public void loginUsuarioFacebookTest() {
		CredencialExterna credencialExterna = new CredencialExterna();
		credencialExterna.setServicoExterno("Facebook");
		credencialExterna.setEmail("luiz@facebook.com");
		
		when(lgs.autenticarServicoExterno(credencialExterna)).thenReturn(200);
		
		Boolean logou = lgn.loginExterno(credencialExterna);
		
		assertTrue(logou);
	}
	
	@Test
	public void loginUsuarioOutlookTest() {
		CredencialExterna credencialExterna = new CredencialExterna();
		credencialExterna.setServicoExterno("Outlook");
		credencialExterna.setEmail("luiz@outlook.com");
		
		when(lgs.autenticarServicoExterno(credencialExterna)).thenReturn(200);
		
		Boolean logou = lgn.loginExterno(credencialExterna);
		
		assertTrue(logou);
	}
	
	@Test
	public void loginUsuarioGoogleFailTest() {
		CredencialExterna credencialExternaIncorreta = new CredencialExterna();
		credencialExternaIncorreta.setServicoExterno("Google");
		credencialExternaIncorreta.setEmail("luiz_fail@gmail.com");
		
		when(lgs.autenticarServicoExterno(credencialExternaIncorreta)).thenReturn(401);
		
		Boolean logou = lgn.loginExterno(credencialExternaIncorreta);
		
		assertFalse(logou);
	}
	
	@Test
	public void loginUsuarioFacebookFailTest() {
		CredencialExterna credencialExternaIncorreta = new CredencialExterna();
		credencialExternaIncorreta.setServicoExterno("Facebook");
		credencialExternaIncorreta.setEmail("luiz_fail@facebook.com");
		
		when(lgs.autenticarServicoExterno(credencialExternaIncorreta)).thenReturn(401);
		
		Boolean logou = lgn.loginExterno(credencialExternaIncorreta);
		
		assertFalse(logou);
	}
	
	@Test
	public void loginUsuarioOutlookFailTest() {
		CredencialExterna credencialExternaIncorreta = new CredencialExterna();
		credencialExternaIncorreta.setServicoExterno("Outlook");
		credencialExternaIncorreta.setEmail("luiz_fail@outlook.com");
		
		when(lgs.autenticarServicoExterno(credencialExternaIncorreta)).thenReturn(401);
		
		Boolean logou = lgn.loginExterno(credencialExternaIncorreta);
		
		assertFalse(logou);
	}
}
