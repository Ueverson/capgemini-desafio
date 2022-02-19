package desafio;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.capgemini.academia.java.model.ConstrutorDeEscada;

public class ConstrutorDeEscadaTest {

	private final ConstrutorDeEscada construtorDeEscada = new ConstrutorDeEscada();
	
	@Test
	void construirEscadaCom6Degraus() {
		String escadaEsperda = "     *\n    **\n   ***\n  ****\n *****\n******\n";
		assertEquals(escadaEsperda, construtorDeEscada.construir(6));
	}
	
	@Test
	void construirEscadaSemDegrau() {
		try {
			construtorDeEscada.construir(-1);
		}catch (Exception e) {
			assertEquals(e.getMessage(), "Numero de degraus insulficientes");
		}
	}
	
	
}
