package com.api.apirest.controller;

import com.api.apirest.dto.NotesDto;
import com.api.apirest.model.Notes;
import com.api.apirest.service.NoteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private NoteServices noteServices;

    @GetMapping("/{id}")
    public List<Notes> getNotesByUser(@PathVariable Long id) {
            return noteServices.getAllNotes(id);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String    > createNotes(@PathVariable Long id, @RequestBody NotesDto request ){
         noteServices.createNote(id, request);
        return ResponseEntity.ok("message: Nota creada exitosamente");

    }

}
