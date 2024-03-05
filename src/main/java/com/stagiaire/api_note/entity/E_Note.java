package com.stagiaire.api_note.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "e_note")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class E_Note {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "commentaire")
    private String commentaire;
}
