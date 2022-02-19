package br.com.capgemini.academia.java.model;

import br.com.capgemini.academia.java.exception.ValidadorDeSenhaForteException;

/**
 * Classe responsável por realizar a validação de senha.
 * @author Ueverson Ramos Gonçalves
 * @version 1.0
 */
public class ValidadorSenhaForte {

	/** Define tamanho minino de uma senha forte. */
	private final int tamanhoMinino = 6;

	/**
	 * Realiza a validação de uma senha forte, lançando uma exceção caso a senha seja fraca
	 *
	 * @param senha recebida para validação
	 */
	public boolean executar(String senha) {
		boolean achouNumero = false;
		boolean achouMaiuscula = false;
		boolean achouMinuscula = false;
		boolean achouSimbolo = false;

		int tamanhoSenha = senha.length();

		if (tamanhoSenha < tamanhoMinino) {
			int qtdCaracteresPendentes = tamanhoMinino - tamanhoSenha;
			throw new ValidadorDeSenhaForteException("A SENHA NAO POSSUI O MINIMO DE 6 CARACTERES.NECESSÁRIO INCLUIR MAIS " + qtdCaracteresPendentes + " CARACTERES.");
		}

		for (char visualizarCaracter : senha.toCharArray()) {
			if (visualizarCaracter >= '0' && visualizarCaracter <= '9') {
				achouNumero = true;
			} else if (visualizarCaracter >= 'A' && visualizarCaracter <= 'Z') {
				achouMaiuscula = true;
			} else if (visualizarCaracter >= 'a' && visualizarCaracter <= 'z') {
				achouMinuscula = true;
			} else if ("!@#$%^&*()-+".contains(String.valueOf(visualizarCaracter))) {
				achouSimbolo = true;
			}
		}

		if (!achouNumero) {
			throw new ValidadorDeSenhaForteException("A SENHA DEVE CONTER NO MINIMO 1 DIGITO.");
		}

		if (!achouMaiuscula) {
			throw new ValidadorDeSenhaForteException("A SENHA DEVE CONTER NO MINIMO 1 LETRA EM MAIUSCULO.");
		}

		if (!achouMinuscula) {
			throw new ValidadorDeSenhaForteException("A SENHA DEVE CONTER NO MINIMO 1 LETRA EM MINUSCULO");
		}

		if (!achouSimbolo) {
			throw new ValidadorDeSenhaForteException("A SENHA DEVE CONTER NO MINIMO 1 CARACTER ESPECIAL !@#$%^&*()-+ ");
		}
		
		return true;
	}
}
