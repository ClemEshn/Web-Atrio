package com.ClementEischen.webAtrio.Service;

import com.ClementEischen.webAtrio.DTO.CreateEmploiDTO;
import com.ClementEischen.webAtrio.Entity.Emploi;
import com.ClementEischen.webAtrio.Entity.Personne;
import com.ClementEischen.webAtrio.Repository.EmploiRepository;
import com.ClementEischen.webAtrio.Repository.PersonneRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmploiService {

    private final PersonneRepository personneRepository;
    private final EmploiRepository emploiRepository;

    public EmploiService(PersonneRepository personneRepository, EmploiRepository emploiRepository) {
        this.personneRepository = personneRepository;
        this.emploiRepository = emploiRepository;
    }

    public Emploi addEmploiToPersonne(Long personneId, CreateEmploiDTO dto) {
        Personne personne = personneRepository.findById(personneId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Personne non trouvée"));

        Emploi emploi = new Emploi();
        emploi.setEntreprise(dto.nomEntreprise());
        emploi.setPoste(dto.poste());
        emploi.setDateDebut(dto.dateDebut());
        emploi.setDateFin(dto.dateFin());
        emploi.setPersonne(personne);

        return emploiRepository.save(emploi);
    }
}
