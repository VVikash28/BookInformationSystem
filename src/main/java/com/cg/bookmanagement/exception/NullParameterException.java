package com.cg.bookmanagement.exception;

@SuppressWarnings("serial")
public class NullParameterException extends RuntimeException{

	public NullParameterException(String message) {
		super(message);
	}

}
