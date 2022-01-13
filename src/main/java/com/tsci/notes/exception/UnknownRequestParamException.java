package com.tsci.notes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class UnknownRequestParamException extends Exception {

	public UnknownRequestParamException(String message) {
		super(message);
	}
	
}