package com.tsci.notes.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tsci.notes.dao.NoteRepository;
import com.tsci.notes.model.Note;

@Repository
public class NoteRepositoryJDBCImpl implements NoteRepository {

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
	
	
}
