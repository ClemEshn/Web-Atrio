package com.ClementEischen.webAtrio.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ClementEischen.webAtrio.Entity.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
    @Query("SELECT DISTINCT p FROM Personne p JOIN FETCH p.emplois e WHERE LOWER(e.entreprise) = LOWER(:nom)")
    List<Personne> findAllByEntreprise(String nom);
}
