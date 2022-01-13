package com.tsci.notes.dao.jdbc;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tsci.notes.dao.NoteRepository;
import com.tsci.notes.model.Note;
import com.tsci.notes.web.NotesRestController;

@Repository
public class NoteRepositoryJDBCImpl implements NoteRepository {

	private static final Logger LOG = LoggerFactory.getLogger(NoteRepositoryJDBCImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Note> rowMapperNote = new RowMapper<Note>() {

		@Override
		public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Note note = new Note();
			note.setId(rs.getInt("NoteID"));
			note.setDeadline(rs.getDate("Deadline"));
			note.setNote(rs.getString("Note"));
			return note;
		}
		
	};

	@Override
	public List<Note> findNotes() {
		// Query to get all notes
		String sql = "SELECT * FROM [Notes]";
		// returning all notes by jdbcTemplate query
		return jdbcTemplate.query(sql, rowMapperNote);
		
	}

	@Override
	public List<Note> findNotesByUserID(int id) {
		// Query to get wanted id'd Note 
		String sql = "SELECT * FROM [Notes] n "
				+ "WHERE n.NoteID in (SELECT un.NoteID FROM [User-Note] un WHERE un.UserID = ?)";
		LOG.info(sql);
		List<Note> notes = jdbcTemplate.query(sql, rowMapperNote, id);
		return notes;
	}

	@Override
	public List<Note> findNotesAfterDate(Date date) {
		String sql = "SELECT * FROM [Notes] n WHERE n.Deadline > ?";
		List<Note> notes = jdbcTemplate.query(sql, rowMapperNote, date);
		return notes;
	}
	
	
}
