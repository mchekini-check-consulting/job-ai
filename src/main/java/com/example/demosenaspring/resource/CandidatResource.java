package com.example.demosenaspring.resource;

import com.example.demosenaspring.Candidat;
import com.example.demosenaspring.repository.CandidatRepository;
import com.example.demosenaspring.service.CandidatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/candidat")
public class CandidatResource {


    private final CandidatService candidatService;

    public CandidatResource(CandidatService candidatService) {
        this.candidatService = candidatService;
    }

    @GetMapping
    public List<Candidat> getAllCandidates() {
        return candidatService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Candidat> getCandidatById(@PathVariable("id") Long id) {
        return candidatService.findById(id);
    }

    @GetMapping("searchByLastName")
    public List<Candidat> getCandidatByLastName(@RequestParam("lastName") String lastName) {

        return candidatService.findByLastName(lastName);

    }

    @PostMapping
    public void createCandidat(@RequestBody Candidat candidat) {



        candidatService.save(candidat);
    }
}
