package com.stagiaire.api_note.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "e_note")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class E_Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "description")
    private String description;

    @Column(name = "userId")
    private int userId;
}
