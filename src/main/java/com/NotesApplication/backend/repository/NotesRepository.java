package com.NotesApplication.backend.repository;

import com.NotesApplication.backend.dao.Notes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends CrudRepository<Notes, Long> {

    List<Notes> getAllNotesByAuthor(String authorName);
    List<Notes> deleteAllNotesByAuthor(String authorName);
}
