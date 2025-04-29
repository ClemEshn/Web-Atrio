package com.ClementEischen.webAtrio.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;

    private LocalDate dateNaissance;
    @Transient
    private int age;
    

    @OneToMany(mappedBy = "personne", cascade = CascadeType.ALL)
    private List<Emploi> emplois = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public List<Emploi> getEmplois() {
        return emplois;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    //to do : changer en addEmploi et remove emploi 
    public void setEmplois(List<Emploi> emplois) {
        this.emplois = emplois;
    }

    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    
}
