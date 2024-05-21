package com.NotesApplication.backend.service;

import com.NotesApplication.backend.dao.Notes;
import com.NotesApplication.backend.repository.NotesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotesServiceImpl implements NotesService{
    @Autowired
    public NotesRepository notesRepository;

    @Override
    public List<Notes> getAllNotesForUser(String userName) {
        return notesRepository.getAllNotesByAuthor(userName);
    }

    @Override
    public Notes getNoteByNotesId(Integer notesId) {
        Optional<Notes> notesById = notesRepository.findById(Long.valueOf(notesId));
        return notesById.orElse(null);
    }

    @Override
    public Notes addNote(Notes note) {
        return notesRepository.save(note);
    }

    @Override
    @Transactional
    public String deleteAllNotesForUser(String userName) {
        notesRepository.deleteAllNotesByAuthor(userName);
        return "Successfully Deleted all the notes for the author: " + userName;
    }

    @Override
    @Transactional
    public String deleteNoteByNoteId(Integer notesId) {
        notesRepository.deleteById(Long.valueOf(notesId));
        return "Successfully Deleted the note with id: " + notesId;
    }
}
