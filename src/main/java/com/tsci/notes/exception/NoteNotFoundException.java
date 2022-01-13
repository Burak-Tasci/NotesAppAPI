package com.tsci.notes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class NoteNotFoundException extends Exception {

	public NoteNotFoundException(String message) {
		super(message);
	}
	
}