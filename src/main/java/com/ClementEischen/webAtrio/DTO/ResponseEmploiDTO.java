package com.ClementEischen.webAtrio.DTO;

import java.time.LocalDate;

public record ResponseEmploiDTO(
    Long id,
    String nomEntreprise,
    String poste,
    LocalDate dateDebut,
    LocalDate dateFin
) {}