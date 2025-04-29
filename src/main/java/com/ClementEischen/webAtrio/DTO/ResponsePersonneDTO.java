package com.ClementEischen.webAtrio.DTO;

import java.time.LocalDate;
import java.util.List;

public record ResponsePersonneDTO(
    Long id,
    String nom,
    String prenom,
    LocalDate dateNaissance,
    int age,
    List<ResponseEmploiDTO> emploisActuels
) {}