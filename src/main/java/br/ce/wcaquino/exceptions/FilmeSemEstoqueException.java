package br.ce.wcaquino.exceptions;

public class FilmeSemEstoqueException extends Exception {

	private static final long serialVersionUID = -4970527916966267734L;

	public FilmeSemEstoqueException() {
	}

	public FilmeSemEstoqueException(String message) {
		super(message);
	}

	public FilmeSemEstoqueException(String message, Throwable cause) {
		super(message, cause);
	}

	public FilmeSemEstoqueException(Throwable cause) {
		super(cause);
	}

	public FilmeSemEstoqueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	

}
