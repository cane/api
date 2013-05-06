package org.canedata.exception;

import java.util.Arrays;

public class EntityNotFoundException extends DataAccessException {

	private static final long serialVersionUID = -4936067284305719279L;

	public EntityNotFoundException() {
	}
	
	public EntityNotFoundException(String entityName, String... keys) {
		super("Primary key [" + entityName + "#" + Arrays.toString(keys) + "] don't exists.");
	}

	public EntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityNotFoundException(String message) {
		super(message);
	}

	public EntityNotFoundException(Throwable cause) {
		super(cause);
	}

}
