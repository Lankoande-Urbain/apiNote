package com.stagiaire.api_note.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class noteDto {

    private Long id;

    private String titre;
    private String description;
    private String userId;
    private Date creationDate;
}
