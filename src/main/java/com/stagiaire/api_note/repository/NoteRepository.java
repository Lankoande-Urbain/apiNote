package com.stagiaire.api_note.repository;


import com.stagiaire.api_note.entity.E_Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<E_Note, Long> {


//    List<E_Note> findAll(final Long id, final String titre, final String commentaire);
}
