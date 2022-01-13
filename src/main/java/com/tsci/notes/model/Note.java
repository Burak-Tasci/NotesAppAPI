package com.tsci.notes.model;

import java.sql.Date;

public class Note {

	// Attributes
	private int id;
	private String note;
	private Date deadline;
	public Note(int Id, String Note, Date Deadline) {
		super();
		this.id = Id;
		this.note = Note;
		this.deadline = Deadline;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	@Override
	public String toString() {
		return "Note [id=" + id + ", note=" + note + ", deadline=" + deadline + "]";
	}
	
	
	
	
}
