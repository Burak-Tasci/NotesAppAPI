package com.tsci.notes.dao;

import java.sql.Date;
import java.util.List;

import com.tsci.notes.model.Note;

public interface NoteRepository {
	
	List<Note> findNotes();
	List<Note> findNotesByUserID(int id);
	List<Note> findNotesAfterDate(Date date);

}
