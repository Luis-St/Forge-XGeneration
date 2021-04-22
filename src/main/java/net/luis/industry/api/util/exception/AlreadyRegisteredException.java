package net.luis.industry.api.util.exception;

public class AlreadyRegisteredException extends RuntimeException {
	
	private static final long serialVersionUID = 6936289692706578936L;
	
	public AlreadyRegisteredException() {
		super();
	}
	
	public AlreadyRegisteredException(String message) {
		super(message);
	}
	
	public AlreadyRegisteredException(int id) {
		super("The ID " + id + ", already exists");
	}
	
}
