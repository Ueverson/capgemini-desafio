package br.com.capgemini.academia.java.exception;

public class ValidadorDeSenhaForteException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ValidadorDeSenhaForteException(String mensagem) {
		super(mensagem);
	}

}
