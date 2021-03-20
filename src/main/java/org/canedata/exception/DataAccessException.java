package org.canedata.exception;

import java.text.MessageFormat;

public class DataAccessException extends RuntimeException {

	private static final long serialVersionUID = -1482548993264902769L;
	private int status = 0;

	public DataAccessException() {
		super();
	}

	public DataAccessException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataAccessException(String message) {
		super(message);
	}

	public DataAccessException(Throwable cause) {
		super(cause);
	}

	public static DataAccessException of(int status) {
		return new DataAccessException().status(status);
	}

	public static DataAccessException of(String message) {
		return new DataAccessException(message);
	}

	public static DataAccessException of(String message, Object...args) {
		if(args == null || args.length == 0) {
			return new DataAccessException(message);
		}

		MessageFormat mf = new MessageFormat(message);
		return new DataAccessException(mf.format(args));
	}

	public static DataAccessException of(int status, String message) {
		return new DataAccessException(message).status(status);
	}

	public static DataAccessException of(int status, String message, Object...args) {
		return DataAccessException.of(message, args).status(status);
	}

	public static DataAccessException of(int status, Throwable throwable) {
		return new DataAccessException(throwable).status(status);
	}

	public DataAccessException status(int status) {
		this.status = status;
		return this;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
