package com.tsci.notes.dao;

import java.util.List;

import com.tsci.notes.model.User;

public interface UserRepository {

	List<User> findUsers();
	List<User> findByTitle(String title);
	List<User> findByName(String name);
	void createUser();
	
}
