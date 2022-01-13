package com.tsci.notes.dao;

import java.sql.Date;
import java.util.List;

import com.tsci.notes.model.Note;

public interface NoteRepository {
	
	List<Note> findNotes();
	List<Note> findNotesByID(int id);
	List<Note> findNotesAfterDate(Date date);

}
