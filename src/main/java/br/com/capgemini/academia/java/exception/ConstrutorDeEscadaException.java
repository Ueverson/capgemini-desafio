package br.com.capgemini.academia.java.exception;

public class ConstrutorDeEscadaException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ConstrutorDeEscadaException(String mensagem) {
		super(mensagem);
	}

}
