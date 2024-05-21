package com.NotesApplication.backend.service;

import com.NotesApplication.backend.dao.Notes;

import java.util.List;

public interface NotesService {

    List<Notes> getAllNotesForUser(String userName);
    Notes getNoteByNotesId(Integer notesId);
    Notes addNote(Notes note);
    String deleteAllNotesForUser(String userName);
    String deleteNoteByNoteId(Integer notesId);
}
