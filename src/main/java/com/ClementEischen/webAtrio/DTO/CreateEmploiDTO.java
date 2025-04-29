package com.ClementEischen.webAtrio.DTO;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateEmploiDTO(
    @NotBlank 
    String nomEntreprise,
    @NotBlank 
    String poste,
    @NotNull 
    LocalDate dateDebut,
    LocalDate dateFin
) {}