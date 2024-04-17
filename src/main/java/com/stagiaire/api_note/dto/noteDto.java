package com.stagiaire.api_note.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class noteDto {

    private Long id;

    private String titre;
    private String description;
    private int userId;
}
