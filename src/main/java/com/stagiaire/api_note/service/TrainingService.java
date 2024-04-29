package com.stagiaire.api_note.service;

import com.stagiaire.api_note.config.Mymapper;
import com.stagiaire.api_note.dto.noteDto;
import com.stagiaire.api_note.entity.E_Note;
import com.stagiaire.api_note.repository.NoteRepository;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor //balise de creation de Constructeurs avec les arguments requisent
@NoArgsConstructor(force = true)
@Service                                   // balise indiquant un fichier de service
@Slf4j
public class TrainingService {

    @Autowired
    private final NoteRepository noteRepository;
    private final Mymapper mapper = Mappers.getMapper(Mymapper.class);



    // Tasks
    public List<noteDto> fetchNotes() {
        final List<E_Note> resp = this.noteRepository.findAll();

        //
        List<noteDto> listNotes = new ArrayList<>(); //conversion de la liste retournant l'entité YtCategory en DTO
        resp.forEach(e -> {
            noteDto d =  mapper.maps(e);
            listNotes.add(d);
        });
        return listNotes;
    }

    public List<noteDto> fetchNotesByUserId(String userId) {
        final List<E_Note> resp = this.noteRepository.findByUserId(userId);

        //
        List<noteDto> listNotes = new ArrayList<>(); //conversion de la liste retournant l'entité YtCategory en DTO
        resp.forEach(e -> {
            noteDto d =  mapper.maps(e);
            listNotes.add(d);
        });
        return listNotes;
    }

    public List<noteDto> findNotesByTitre(String userId, String titre) {
        final List<E_Note> resp = this.noteRepository.findByTitreIgnoreCase(userId, titre);

        List<noteDto> listNotes = new ArrayList<>();
        resp.forEach(e -> {
            noteDto d = mapper.maps(e);
            listNotes.add(d);
        });
        return listNotes;
    }


    public noteDto postNote(final noteDto noteDtos)  {
        noteDtos.setId(null);
        // Procéder a l' enregistrement dans la base de basse en construisant l' entité a partir du DTO

        final E_Note entity = mapper.maps(noteDtos);

        //sauvegarde de la note dans la base de donnees
        this.noteRepository.save(entity);

        // Retourner l' objet avec un identifiant
        return noteDtos;
    }
    public noteDto updateNote( final Long id, final noteDto noteDtos) {
        final E_Note note = this.noteRepository.getReferenceById(id);

        //Procedure de la modification
        note.setTitre(noteDtos.getTitre());
        note.setDescription(noteDtos.getDescription());

        //Retourner l'objet avec un identifiant
        this.noteRepository.save(note);

        return noteDtos;
    }
    public void deleteNote(final Long id) {

        //Procedure de suppression
        this.noteRepository.deleteById(id);

    }
}
