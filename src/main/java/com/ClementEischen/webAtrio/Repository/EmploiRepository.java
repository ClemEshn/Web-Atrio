package com.ClementEischen.webAtrio.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ClementEischen.webAtrio.Entity.Emploi;
import com.ClementEischen.webAtrio.Entity.Personne;

public interface EmploiRepository extends JpaRepository<Emploi, Long> {
    @Query("""
    SELECT e FROM Emploi e
    WHERE e.personne = :personne
    AND (
        (e.dateFin IS NULL AND e.dateDebut <= :to) OR
        (e.dateFin IS NOT NULL AND e.dateDebut <= :to AND e.dateFin >= :from)
    )
    """)
    List<Emploi> findOverlappingJobs(
    @Param("personne") Personne personne,
    @Param("from") LocalDate from,
    @Param("to") LocalDate to
    );

}
