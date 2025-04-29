package com.ClementEischen.webAtrio.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ClementEischen.webAtrio.Entity.Emploi;
import com.ClementEischen.webAtrio.Entity.Personne;

public interface EmploiRepository extends JpaRepository<Emploi, Long> {
    List<Emploi> findByPersonneAndDateDebutGreaterThanEqualAndDateFinLessThanEqual(
        Personne personne, 
        LocalDate dateDebut, 
        LocalDate dateFin
    );
}
