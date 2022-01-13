package com.tsci.notes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class UserBadRequestException extends Exception {
	
	public UserBadRequestException(String message) {
		super(message);
	}
}
