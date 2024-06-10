package com.example.demosenaspring.service;

import com.example.demosenaspring.Candidat;
import com.example.demosenaspring.repository.CandidatRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CandidatService {

    private final CandidatRepository candidatRepository;

    public CandidatService(CandidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }

    public List<Candidat> findAll() {
        return candidatRepository.findAll();
    }

    public Optional<Candidat> findById(Long id) {
        return candidatRepository.findById(id);
    }

    public List<Candidat> findByLastName(String lastName) {
        return candidatRepository.findByLastName(lastName);
    }

    public void save(Candidat candidat) {
        candidat.setLastName(candidat.getLastName().toUpperCase());
        candidat.setFirstName(candidat.getFirstName().substring(0, 1).toUpperCase()
                + candidat.getFirstName().substring(1).toLowerCase());

        if (!candidatRepository.existsByFirstNameAndLastName(candidat.getFirstName(), candidat.getLastName()))
            candidatRepository.save(candidat);
        else {
            log.error("impossible de créer ce candiat car le nom et le prénom existent dèjà");
        }
    }
}
