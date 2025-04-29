package com.ClementEischen.webAtrio.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Emploi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String entreprise;
    private String poste;

    private LocalDate dateDebut;
    private LocalDate dateFin;

    @ManyToOne
    @JoinColumn(name = "personne_id")
    @JsonIgnore
    private Personne personne;

    public Long getId() {
        return id;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public String getPoste() {
        return poste;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    
    
}
