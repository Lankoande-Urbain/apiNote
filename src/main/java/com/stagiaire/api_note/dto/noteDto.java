package com.stagiaire.api_note.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class noteDto {

    private Long id;


    private String titre;
    private String commentaire;
}
