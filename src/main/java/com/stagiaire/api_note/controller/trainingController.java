package com.stagiaire.api_note.controller;


import com.stagiaire.api_note.dto.noteDto;
import com.stagiaire.api_note.service.TrainingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class trainingController {
    public final TrainingService trainingService;

    @GetMapping( "/") //ecoute GET sur le /
    public String home() {
        return "\nBienvenue sur le REST de Note  fait par PRINCE.COM";

    }

    @GetMapping("/notes")
    public List<noteDto> fetchNotes() {
        final List<noteDto> respServ = trainingService.fetchNotes();
        return respServ;
    }

    @PostMapping("/notes")
    public ResponseEntity<noteDto> postNote(
            @RequestBody @Valid noteDto noteDtos)  {
        final noteDto respServ = this.trainingService.postNote(noteDtos);

        log.info("Saving a Notes : {}", noteDtos.getTitre().toUpperCase());
        //Retouner l'objet avec un code sattus
        return new ResponseEntity<>(respServ, HttpStatus.CREATED);
    }

//    @GetMapping("/Notes")
//    public
}
