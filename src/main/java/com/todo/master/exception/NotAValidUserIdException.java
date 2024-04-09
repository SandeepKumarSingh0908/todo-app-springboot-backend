package com.todo.master.exception;

public class NotAValidUserIdException extends RuntimeException {
	public NotAValidUserIdException(String msg) {
		super(msg);
	}
}
