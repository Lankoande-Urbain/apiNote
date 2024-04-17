/*
package com.stagiaire.api_note.service;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.stagiaire.api_note.config.Mymapper;
import com.stagiaire.api_note.controller.TrainingController;
import com.stagiaire.api_note.dto.noteDto;
import com.stagiaire.api_note.entity.E_Note;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@WebMvcTest(TrainingController.class)
public class TrainingServiceTest {
   @Autowired
   MockMvc mockMvc;

   @MockBean
   TrainingService trainingService;

    @Autowired
    ObjectMapper mapper;
    private final Mymapper mymapper = Mappers.getMapper(Mymapper.class);

    E_Note notes1 =new E_Note(1L, "Test de Titre", "Test de commentaire");
    E_Note notes2 =new E_Note(2L, "Test de Titre", "Test de commentaire");
    E_Note notes3 =new E_Note(3L, "Test de Titre", "Test de commentaire");

   @Test
   public void getAllNotes_success() throws Exception {
      List<E_Note> records = new ArrayList<>(Arrays.asList(notes1, notes2, notes3));

       List<noteDto> listNotes = new ArrayList<>(); //conversion de la liste retournant l'entité YtCategory en DTO
       records.forEach(e -> {
           noteDto d =  mymapper.maps(e);
           listNotes.add(d);
       });

      Mockito.when(trainingService.fetchNotes()).thenReturn(listNotes);

      mockMvc.perform(MockMvcRequestBuilders
                      .get("/notes")
                      .contentType(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk())
              .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
              .andExpect(MockMvcResultMatchers.jsonPath("$[2].id", is(3)));
   }

    @Test
    public void createNote_success() throws Exception {
        E_Note record = new E_Note(1L, "Test de Titre", "Test de commentaire");

        noteDto notes ;
        notes =  mymapper.maps(record);

        Mockito.when(trainingService.postNote(notes)).thenReturn(notes);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/notes")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(notes));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)));
    }

//    @Test
//    public void updatePatientRecord_nullId() throws Exception {
//        E_Note updatedRecord = E_Note.builder()
//                .id(1L)
//                .titre("Test de Titre")
//                .commentaire("Test de Commentaire")
//                .build();
//
//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/notes")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.mapper.writeValueAsString(updatedRecord));
//
//        mockMvc.perform(mockRequest)
//                .andExpect(status().isBadRequest())
//                .andExpect(result ->
//                        assertTrue(result.getResolvedException() instanceof TrainingController.InvalidRequestException))
//                .andExpect(result ->
//                        assertEquals("PatientRecord or ID must not be null!", result.getResolvedException().getMessage()));
//    }
//
//    @Test
//    public void deletePatientById_success() throws Exception {
//        Mockito.when(trainingService.deleteNote(notes2.getId())).thenReturn(Optional.of(notes2));
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .delete("/notes/2")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void deletePatientById_notFound() throws Exception {
//        Mockito.when(trainingService.fetchNotes(2L)).thenReturn(null);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .delete("/notes/2")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isBadRequest())
//                .andExpect(result ->
//                        assertTrue(result.getResolvedException() instanceof ChangeSetPersister.NotFoundException))
//                .andExpect(result ->
//                        assertEquals("Note with ID 2 does not exist.", result.getResolvedException().getMessage()));
//    }
}


 */