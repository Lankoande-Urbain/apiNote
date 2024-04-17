package com.stagiaire.api_note.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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

    @Column(name = "creationDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @PrePersist
    protected void onCreate() {
        creationDate = new Date();
    }
}
