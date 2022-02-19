package br.com.capgemini.academia.java.model;
import java.util.ArrayList;

import br.com.capgemini.academia.java.exception.LovalizadorDeAnagramaException;

/**
 * Responsável por localizar os anagramas contidos em uma classe.
 *
 * @author Ueverson Ramos Gonçalves
 * @version 1.0
 */
public class LocalizadorDeAnagrama {

	
	/**
	 * Pesquisar.
	 *
	 * @param palavra que será analisada
	 * @return lista de anagramas localizados
	 */
	public ArrayList<String> pesquisar(String palavra) {
		
		if(palavra.equals("") || palavra == null) {
			throw new LovalizadorDeAnagramaException("Palavra informada é inválida");
		}
		
		
		ArrayList<String> anagramas = new ArrayList<String>();

		for (int i = 0; i < palavra.length(); i++) {

			for (int j = 1; j < palavra.length(); j++) {

				if (palavra.charAt(i) == palavra.charAt(j) && i != j && i < j) {

					if (palavra.charAt(i) == palavra.charAt(i + 1)) {

						String x = palavra.substring(i, i + 1);
						anagramas.add(x);

					} else {

						String y = palavra.substring(i, j);
						String z = palavra.substring(i + 1, j + 1);
						String h = palavra.substring(i, i + 1);

						anagramas.add(h);
						anagramas.add(y);
						anagramas.add(z);
					}
				}
			}
		}

		return anagramas;
	}

	
}
