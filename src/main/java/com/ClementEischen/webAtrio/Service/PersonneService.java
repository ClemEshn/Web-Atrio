package com.ClementEischen.webAtrio.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ClementEischen.webAtrio.DTO.CreatePersonneDTO;
import com.ClementEischen.webAtrio.Entity.Personne;
import com.ClementEischen.webAtrio.Repository.EmploiRepository;
import com.ClementEischen.webAtrio.Repository.PersonneRepository;

@Service
public class PersonneService {

    private final PersonneRepository personneRepository;
    private final EmploiRepository emploiRepository;

    public PersonneService(PersonneRepository personneRepository, EmploiRepository emploiRepository) {
        this.personneRepository = personneRepository;
        this.emploiRepository = emploiRepository;
    }

    public Personne createPersonne(CreatePersonneDTO dto) {
        long age = ChronoUnit.YEARS.between(dto.dateNaissance(), LocalDate.now());
        if (age > 150) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La personne a plus de 150 ans");
        }

        Personne personne = new Personne();
        personne.setNom(dto.nom());
        personne.setPrenom(dto.prenom());
        personne.setDateNaissance(dto.dateNaissance());

        return personneRepository.save(personne);
    }
    public List<Personne> getAllPersonnes() {
        return personneRepository.findAll();
    }
    
}
