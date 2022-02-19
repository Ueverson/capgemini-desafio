package br.com.capgemini.academia.java.model;

import br.com.capgemini.academia.java.exception.ConstrutorDeEscadaException;

/**
 * ConstrutorDeEscada é responsável pela criação visual de uma escada.
 * @author Ueverson Ramos Gonçalves
 * @version 1.0
 */
public class ConstrutorDeEscada {

	/**
	 * Método que constroi a escada ao receber a quantidade de graus
	 * 
	 * @param qtdDegraus  quantidade de degraus da escada
	 */
	public String construir(int qtdDegraus) {
		
		if(qtdDegraus <= 0) {
			throw new ConstrutorDeEscadaException("Numero de degraus insulficientes");
		}
		
		StringBuilder escada = new StringBuilder();

		for (int i = 1; i <= qtdDegraus; i++) {

			for (int j = 0; j < qtdDegraus; j++) {

				if (j < qtdDegraus - i) {
					escada.append(" ");
				} else {
					escada.append("*");
				}
			}
			escada.append("\n");
		}

		return escada.toString();
	}
	
	
}
