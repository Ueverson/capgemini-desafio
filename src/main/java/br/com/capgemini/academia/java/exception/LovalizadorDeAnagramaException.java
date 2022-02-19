package br.com.capgemini.academia.java.exception;

public class LovalizadorDeAnagramaException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public LovalizadorDeAnagramaException(String mensagem) {
		super(mensagem);
	}

}
