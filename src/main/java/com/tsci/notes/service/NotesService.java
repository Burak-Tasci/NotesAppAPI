package com.tsci.notes.service;

import java.sql.Date;
import java.util.List;

import com.tsci.notes.exception.NoteNotFoundException;
import com.tsci.notes.exception.UserNotFoundException;
import com.tsci.notes.model.Note;
import com.tsci.notes.model.User;

public interface NotesService {

	// User Repository methods
	List<User> findUsers() throws UserNotFoundException;
	List<User> findByTitle(String title) throws UserNotFoundException;
	List<User> findByName(String name) throws UserNotFoundException;

	// Note Repository methods
	List<Note> findNotes() throws NoteNotFoundException;
	List<Note> findNotesByUserID(int id) throws NoteNotFoundException;
	List<Note> findNotesAfterDate(Date date) throws NoteNotFoundException;
}
