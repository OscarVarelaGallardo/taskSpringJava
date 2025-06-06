package com.api.apirest.repository;

import com.api.apirest.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface NotesRepository extends JpaRepository<Notes, Long> {
    List<Notes> findNotesByUserId(Long userId);}
