package com.stagiaire.api_note.controller;

import com.stagiaire.api_note.dto.noteDto;
import com.stagiaire.api_note.service.TrainingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*") // Autorise toutes les origines
public class TrainingController {
    private final TrainingService trainingService;

    @GetMapping("/")
    public String home() {
        return "\nBienvenue sur le REST de Note, réalisé par PRINCE.COM";
    }

    @GetMapping("/notes")
    public List<noteDto> fetchNotes() {
        final List<noteDto> respService = trainingService.fetchNotes();
        log.info("Les informations sont renvoyées");
        return respService;
    }
    @GetMapping("/notes/{userId}")
    public List<noteDto> fetchNotesByUserId(@PathVariable("userId") String userId) {
        log.info("Recherche de note par userId '{}'",userId);
        final List<noteDto> rsltService = trainingService.fetchNotesByUserId(userId);
        return rsltService;
    }

    @GetMapping("/notes/user/{userId}/titre/{titre}")
    public List<noteDto> findNotesByTitre(@PathVariable("userId") String userId, @PathVariable("titre") String titreNote){
        log.info("Recherche de note par titre '{}'",titreNote.toUpperCase());
        final List<noteDto> rsltService = trainingService.findNotesByTitre(userId, titreNote);
        return rsltService;
    }


    @PostMapping("/notes")
    public ResponseEntity<noteDto> postNote(@RequestBody @Valid noteDto noteDtos) {
        final noteDto respServ = this.trainingService.postNote(noteDtos);
        log.info("Enregistrement d'une note : {}", noteDtos.getTitre().toUpperCase());
        return new ResponseEntity<>(respServ, HttpStatus.OK);
    }

    @PutMapping("notes/{id}")
    public ResponseEntity<noteDto> updateNote(@PathVariable("id") Long idnote, @RequestBody @Valid noteDto catDto) {
        log.info("Mise à jour d'une note : {}", idnote);
        final noteDto respServ = this.trainingService.updateNote(idnote, catDto);
        return new ResponseEntity<>(respServ, HttpStatus.OK);
    }

    @DeleteMapping("notes/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable("id") Long idnote) {
        log.warn("Suppression d'une note : {}", idnote);
        trainingService.deleteNote(idnote);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
