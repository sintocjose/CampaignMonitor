package com.campaignmonitor.exceptions;

/**
 * @author Sinto
 *
 */
public class InvalidTriangleException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidTriangleException() {
	}

	/**
	 * @param message
	 */
	public InvalidTriangleException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidTriangleException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidTriangleException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidTriangleException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
