package com.tsci.notes.service;

import java.util.List;

import com.tsci.notes.exception.UserNotFoundException;
import com.tsci.notes.model.User;

public interface NotesService {

	List<User> findUsers() throws UserNotFoundException;
	List<User> findByTitle(String title) throws UserNotFoundException;
	List<User> findByName(String name) throws UserNotFoundException;
	
}
