package com.pacon.apionce.exception;

public class UserNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5314733474946735620L;

	public UserNotFoundException(String message) {
        super(message);
    }

}
