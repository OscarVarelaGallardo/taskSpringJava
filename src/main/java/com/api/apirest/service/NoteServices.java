package com.api.apirest.service;

import com.api.apirest.dto.NotesDto;
import com.api.apirest.model.Notes;
import com.api.apirest.model.User;
import com.api.apirest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.api.apirest.repository.NotesRepository;
import com.api.apirest.dto.ApiResponse;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServices {

    @Autowired
    private NotesRepository notesRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<ApiResponse<List<Notes>>> getAllNotesById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("error", "Usuario no encontrado", Collections.emptyList()));
        }

        List<Notes> notes = notesRepository.findNotesByUserId(id);

        return ResponseEntity.ok(
                new ApiResponse<>("success", notes.isEmpty() ? "Sin notas para el usuario" : "Notas obtenidas correctamente", notes)
        );
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
