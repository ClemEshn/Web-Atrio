package com.ClementEischen.webAtrio.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ClementEischen.webAtrio.DTO.CreatePersonneDTO;
import com.ClementEischen.webAtrio.Entity.Emploi;
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
        List<Personne> personnes = personneRepository.findAll(Sort.by("nom").ascending());
    
        for (Personne p : personnes) {
            p.getEmplois().size();
            int age = (int) ChronoUnit.YEARS.between(p.getDateNaissance(), LocalDate.now());
            p.setAge(age);
    
            List<Emploi> emploisActuels = p.getEmplois().stream()
                    .filter(e -> e.getDateFin() == null || e.getDateFin().isAfter(LocalDate.now()))
                    .collect(Collectors.toList());
    
            p.setEmplois(emploisActuels);
        }
    
        return personnes;
    }

    public List<Personne> getPersonnesByEntreprise(String nomEntreprise) {
        List<Personne> personnes = personneRepository.findAllByEntreprise(nomEntreprise);
    
        for (Personne p : personnes) {    
            int age = (int) ChronoUnit.YEARS.between(p.getDateNaissance(), LocalDate.now());
            p.setAge(age);
    
            List<Emploi> emploisDansEntreprise = p.getEmplois().stream()
                    .filter(e -> e.getNomEntreprise().equalsIgnoreCase(nomEntreprise))
                    .collect(Collectors.toList());
    
            p.setEmplois(emploisDansEntreprise);
        }
    
        return personnes;
    }
    public List<Emploi> getEmploisByDateRange(Long personneId, LocalDate from, LocalDate to) {
        Personne personne = personneRepository.findById(personneId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Personne non trouvée"));
        return emploiRepository.findOverlappingJobs(personne, from, to);
    }
    
    
}
