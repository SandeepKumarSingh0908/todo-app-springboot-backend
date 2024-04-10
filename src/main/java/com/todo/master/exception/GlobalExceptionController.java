package com.todo.master.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {
	
	@ExceptionHandler(NotAValidUserIdException.class)
	public ResponseEntity<String> handleNotAValidUserIdException(NotAValidUserIdException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleUnIdentifiedException(Exception ex){
		return new ResponseEntity<String>("Internal Server Error, Please contact support team.",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
