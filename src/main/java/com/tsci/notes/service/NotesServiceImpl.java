package com.tsci.notes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsci.notes.dao.UserRepository;
import com.tsci.notes.exception.UserNotFoundException;
import com.tsci.notes.model.User;

@Service
public class NotesServiceImpl implements NotesService {

	// Create User Repository object
	private UserRepository userRepository;
	// Connect userRepository with service
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findUsers() throws UserNotFoundException {
		
		List<User> users = userRepository.findUsers();
		if(users == null) throw new UserNotFoundException("There are no user found!");
		else return users;
	}

	@Override
	public List<User> findByTitle(String title) throws UserNotFoundException {

		List<User> users = userRepository.findByTitle(title);
		if(users == null) throw new UserNotFoundException(String.format("There are no user found with title %s", title));
		else return users;
	}

	@Override
	public List<User> findByName(String name) throws UserNotFoundException {

		List<User> users = userRepository.findByName(name);
		if(users == null) throw new UserNotFoundException(String.format("There are no user found with name %s", name));
		else return users;
	}

}
