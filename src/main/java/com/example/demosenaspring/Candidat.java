package com.example.demosenaspring;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Candidat {

    @Id
    private Long id;
    private String lastName;
    private String firstName;
    private String post;
}
