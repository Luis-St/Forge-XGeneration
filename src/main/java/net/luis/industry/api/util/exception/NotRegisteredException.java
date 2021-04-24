package net.luis.industry.api.util.exception;

public class NotRegisteredException extends RuntimeException {
	
	private static final long serialVersionUID = -7233914446240576811L;

	public NotRegisteredException() {
		super();
	}
	
	public NotRegisteredException(String message) {
		super(message);
	}
	
	public NotRegisteredException(int id) {
		super("An recipe with id " + id + ", does not exists");
	}
	
}