package com.cg.bookmanagement.exception;

@SuppressWarnings("serial")
public class EmptyBookListException extends RuntimeException {

	public EmptyBookListException(String message) {
		super(message);
	}
	

}
