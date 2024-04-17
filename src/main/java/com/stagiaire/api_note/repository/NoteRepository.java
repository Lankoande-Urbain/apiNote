package com.stagiaire.api_note.repository;


import com.stagiaire.api_note.entity.E_Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<E_Note, Long> {

    @Query("SELECT n FROM E_Note n WHERE LOWER(n.titre) LIKE LOWER(CONCAT('%', :titre, '%'))")
    List<E_Note> findByTitreIgnoreCase(String titre);
}
