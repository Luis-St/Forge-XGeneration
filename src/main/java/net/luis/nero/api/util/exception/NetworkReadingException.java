package net.luis.nero.api.util.exception;

public class NetworkReadingException extends RuntimeException {
	
	private static final long serialVersionUID = 8001970706544407710L;
	
	public NetworkReadingException() {
		super();
	}
	
	public NetworkReadingException(String message) {
		super(message);
	}

}
