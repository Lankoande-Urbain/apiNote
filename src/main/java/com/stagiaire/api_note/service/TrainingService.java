package com.stagiaire.api_note.service;

import com.stagiaire.api_note.config.Mymapper;
import com.stagiaire.api_note.controller.trainingController;
import com.stagiaire.api_note.dto.noteDto;
import com.stagiaire.api_note.entity.E_Note;
import com.stagiaire.api_note.repository.NoteRepository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor //balise de creation de Constructeurs avec les arguments requisent
@Service                                   // balise indiquant un fichier de service
@Slf4j
public class TrainingService {

    private final trainingController notesController;
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

    public noteDto postNote(final noteDto noteDtos)  {
        Long nouveauId = new Random().nextLong();
        noteDtos.setId(nouveauId);
        // Procéder a l' enregistrement dans la base de basse en construisant l' entité a partir du DTO

        final E_Note entity = mapper.maps(noteDtos);



        //sauvegarde de la catégorie dans la base de donnees
        this.noteRepository.save(entity);

        // Retourner l' objet avec un identifiant
        return noteDtos;


    }

}
