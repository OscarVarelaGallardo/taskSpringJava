package com.api.apirest.service;

import com.api.apirest.dto.NotesDto;
import com.api.apirest.model.Notes;
import com.api.apirest.model.User;
import com.api.apirest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.apirest.repository.NotesRepository;

import java.util.List;
@Service
public class NoteServices {

    @Autowired
    private NotesRepository notesRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Notes> getAllNotes(Long id) {
        List<Notes> notes = notesRepository.findNotesByUserId(id);
        if (notes.isEmpty()) {
            throw new RuntimeException("No hay notas");
        }
        return notes;
    }
    public void createNote(Long userId, NotesDto request){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Notes note = new Notes();
        note.setTask(request.getTask());
        note.setDate(request.getDate());
        note.setColor(request.getColor());
        note.setUser(user);
        notesRepository.save(note);
    }
}
