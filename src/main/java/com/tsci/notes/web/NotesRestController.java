package com.tsci.notes.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsci.notes.exception.UnknownRequestParamException;
import com.tsci.notes.exception.UserNotFoundException;
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
		return ResponseEntity.ok(users);
	}
	@RequestMapping(method=RequestMethod.GET, value="user")
	public ResponseEntity<List<User>> findByQuery(@RequestParam(value="title",required=false) String title,
			@RequestParam(value="name",required=false) String name) throws UserNotFoundException, UnknownRequestParamException{
				
		if(name != null) return ResponseEntity.ok(notesService.findByName(name));
		else if (title != null) return ResponseEntity.ok(notesService.findByTitle(title));
		else throw new UnknownRequestParamException("RequestParam is not valid!");
	}

}
