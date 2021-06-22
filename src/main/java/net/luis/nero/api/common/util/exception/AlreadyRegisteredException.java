package net.luis.nero.api.common.util.exception;

import java.util.UUID;

public class AlreadyRegisteredException extends RuntimeException {
	
	private static final long serialVersionUID = 6936289692706578936L;
	
	public AlreadyRegisteredException() {
		super();
	}
	
	public AlreadyRegisteredException(String message) {
		super(message);
	}
	
	public AlreadyRegisteredException(UUID id) {
		super("The ID " + id.toString() + ", already exists");
	}
	
}
