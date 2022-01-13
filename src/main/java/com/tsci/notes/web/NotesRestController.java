package com.tsci.notes.web;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsci.notes.exception.NoteNotFoundException;
import com.tsci.notes.exception.UnknownRequestParamException;
import com.tsci.notes.exception.UserNotFoundException;
import com.tsci.notes.model.Note;
import com.tsci.notes.model.User;
import com.tsci.notes.service.NotesService;


@RestController
@RequestMapping("/")
public class NotesRestController {
	
	private static final Logger LOG = LoggerFactory.getLogger(NotesRestController.class);

	@Autowired
	private NotesService notesService;
	
	@RequestMapping(method=RequestMethod.GET, value="users")
	public ResponseEntity<List<User>> findUsers() throws UserNotFoundException{
		
		List<User> users = notesService.findUsers();
		if (users != null) return ResponseEntity.ok(users);
		else throw new UserNotFoundException("There are no users in database");
		
	}
	@RequestMapping(method=RequestMethod.GET, value="user")
	public ResponseEntity<List<User>> findByQuery(@RequestParam(value="title",required=false) String title,
			@RequestParam(value="name",required=false) String name) throws UserNotFoundException, UnknownRequestParamException{
				
		if(name != null) return ResponseEntity.ok(notesService.findByName(name));
		else if (title != null) return ResponseEntity.ok(notesService.findByTitle(title));
		else throw new UnknownRequestParamException("RequestParam is not valid!");
	}
	@RequestMapping(method=RequestMethod.GET, value="notes")
	public ResponseEntity<List<Note>> findNotes() throws NoteNotFoundException{
		
		List<Note> notes = notesService.findNotes();
		if (notes != null) return ResponseEntity.ok(notes);
		else throw new NoteNotFoundException("There are no notes in database");		
	}
	@RequestMapping(method=RequestMethod.GET, value="notes/id={id}")
	public ResponseEntity<List<Note>> findNotesByUserID(@PathVariable int id) throws NoteNotFoundException{
		
		List<Note> notes = notesService.findNotesByUserID(id);
		if (notes != null) return ResponseEntity.ok(notes);
		else throw new NoteNotFoundException(String.format("There are no notes with user id %s",id));		
	}
	@RequestMapping(method=RequestMethod.GET, value="notes/date={date}")
	public ResponseEntity<List<Note>> findNotesAfterDate(@PathVariable Date date) throws NoteNotFoundException{
		
		List<Note> notes = notesService.findNotesAfterDate(date);
		if (notes != null) return ResponseEntity.ok(notes);
		else throw new NoteNotFoundException(String.format("There are no notes with date %s",date));	
	}
}
