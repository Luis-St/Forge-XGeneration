package net.luis.nero.api.common.util.exception;

import java.util.UUID;

public class NotRegisteredException extends RuntimeException {
	
	private static final long serialVersionUID = -7233914446240576811L;

	public NotRegisteredException() {
		super();
	}
	
	public NotRegisteredException(String message) {
		super(message);
	}
	
	public NotRegisteredException(UUID id) {
		super("An recipe with id " + id.toString() + ", does not exists");
	}
	
}