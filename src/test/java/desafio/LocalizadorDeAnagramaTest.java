package desafio;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.capgemini.academia.java.model.LocalizadorDeAnagrama;

public class LocalizadorDeAnagramaTest {

	private LocalizadorDeAnagrama localizador = new LocalizadorDeAnagrama();

	@Test
	public void localizarEmPalavraInvalida() {
		try {
			localizador.pesquisar("");
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("Palavra informada é inválida"));
		}
	}

	@Test
	public void localizarAnagramaEmOvo() {
		List<String> anagramas = localizador.pesquisar("ovo");
		assertEquals(anagramas.get(0), "o");
		assertEquals(anagramas.get(1), "ov");
		assertEquals(anagramas.get(2), "vo");
	}
	
	@Test
	public void localizarAnagramaEmIfailuhkqq() {
		List<String> anagramas = localizador.pesquisar("ifailuhkqq");
		assertEquals(anagramas.get(0), "i");
		assertEquals(anagramas.get(1), "ifa");
		assertEquals(anagramas.get(2), "fai");
		assertEquals(anagramas.get(3), "q");
	}
	
	
}
