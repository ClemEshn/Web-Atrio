package com.ClementEischen.webAtrio.DTO;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record CreatePersonneDTO(
    @NotBlank 
    String nom,
    @NotBlank 
    String prenom,
    @NotNull 
    @Past 
    LocalDate dateNaissance
) {}
