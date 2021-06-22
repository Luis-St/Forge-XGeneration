package net.luis.nero.api.common.util.exception;

public class NotRegisteredException extends RuntimeException {
	
	private static final long serialVersionUID = -7233914446240576811L;

	public NotRegisteredException() {
		super();
	}
	
	public NotRegisteredException(String message) {
		super(message);
	}
	
	public NotRegisteredException(Object object) {
		super("The Object{\"" + object.toString() + "\"}, does not exists!");
	}
	
}