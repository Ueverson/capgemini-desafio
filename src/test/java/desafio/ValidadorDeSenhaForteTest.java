package desafio;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.capgemini.academia.java.model.ValidadorSenhaForte;

public class ValidadorDeSenhaForteTest {
	
	private ValidadorSenhaForte validador = new ValidadorSenhaForte();
	
	@Test
	public void validaSenhaForte() {
		assertTrue(validador.executar("Uev2@22"));
	}

	@Test
	public void validaSenhaComMenos6Digitos() {
		try {
			validador.executar("Uev");
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("A SENHA NAO POSSUI O MINIMO DE 6 CARACTERES.NECESSÁRIO INCLUIR MAIS "));
		}
		
	}

	@Test
	public void validaSenhaSemDigitoMiusculo() {
		try {
			validador.executar("UEV2@22");
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("A SENHA DEVE CONTER NO MINIMO 1 LETRA EM MINUSCULO"));
		}
		
	}
	
	@Test
	public void validaSenhaSemDigitoMaiusculo() {
		try {
			validador.executar("uev2@22");
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("A SENHA DEVE CONTER NO MINIMO 1 LETRA EM MAIUSCULO."));
		}
		
	}

	@Test
	public void validaSenhaSemNumero() {
		try {
			validador.executar("Uev@#$%");
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("A SENHA DEVE CONTER NO MINIMO 1 DIGITO."));
		}
		
	}
	
	@Test
	public void validaSenhaSemCaractereEspecial() {
		try {
			validador.executar("Uev2022");
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("A SENHA DEVE CONTER NO MINIMO 1 CARACTER ESPECIAL !@#$%^&*()-+ "));
		}
		
	}
	
}
