package com.project.note.service;

import java.util.List;
import java.util.Optional;

import com.project.note.model.Note;
import com.project.note.repository.NoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
	@Autowired
	NoteRepository noteRepository;

	public void save(Note note) {
		noteRepository.save(note);
	}

	public List<Note> findAll() {
		return noteRepository.findAll();
	}

	public Note findOrCreate(long id) {
		return noteRepository.findById(id).orElse(new Note());
	}
}
