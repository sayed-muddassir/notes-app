package com.NotesApplication.backend.controller;

import com.NotesApplication.backend.dao.Notes;
import com.NotesApplication.backend.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes/v1")
@CrossOrigin(origins = "*")
public class NotesRestController {

    @Autowired
    NotesService notesService;

    @GetMapping(path = "/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping(path = "/getAll")
    public List<Notes> getAllNotes(@RequestParam String userName){
        return notesService.getAllNotesForUser(userName);
    }

    @GetMapping(path = "/getById")
    public Notes getNoteBySpecificId(@RequestParam Integer id){
        return notesService.getNoteByNotesId(id);
    }

    @PostMapping(path = "/add")
    public Notes addNote(@RequestBody Notes note){
        return notesService.addNote(note);
    }

    @DeleteMapping(path = "/deleteAll")
    public String deleteAllNotes(@RequestParam String userName){
        return notesService.deleteAllNotesForUser(userName);
    }

    @DeleteMapping(path = "/deleteById")
    public String deleteNoteById(@RequestParam Integer id){
        return notesService.deleteNoteByNoteId(id);
    }
}
