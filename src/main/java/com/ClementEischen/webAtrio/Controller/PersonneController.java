package com.ClementEischen.webAtrio.Controller;

import com.ClementEischen.webAtrio.DTO.CreatePersonneDTO;
import com.ClementEischen.webAtrio.Entity.Personne;
import com.ClementEischen.webAtrio.Service.PersonneService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnes")
public class PersonneController {

    private final PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @PostMapping
    public ResponseEntity<Personne> createPersonne(@Valid @RequestBody CreatePersonneDTO dto) {
        Personne saved = personneService.createPersonne(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Personne>> getAllPersonnes() {
        List<Personne> personnes = personneService.getAllPersonnes();
        return ResponseEntity.ok(personnes);
    }

    @GetMapping("/entreprise")
    public ResponseEntity<List<Personne>> getPersonnesByEntreprise(@RequestParam String nom) {
        return ResponseEntity.ok(personneService.getPersonnesByEntreprise(nom));
    }

}
