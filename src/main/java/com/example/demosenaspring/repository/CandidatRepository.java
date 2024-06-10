package com.example.demosenaspring.repository;

import com.example.demosenaspring.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long> {

    List<Candidat> findByLastName(String lastName);

    boolean existsByFirstNameAndLastName(String firstName, String lastName);

}
