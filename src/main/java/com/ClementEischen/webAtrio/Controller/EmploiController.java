package com.ClementEischen.webAtrio.Controller;

import com.ClementEischen.webAtrio.DTO.CreateEmploiDTO;
import com.ClementEischen.webAtrio.Entity.Emploi;
import com.ClementEischen.webAtrio.Service.EmploiService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personnes/{personneId}/emplois")
public class EmploiController {

    private final EmploiService emploiService;

    public EmploiController(EmploiService emploiService) {
        this.emploiService = emploiService;
    }

    @PostMapping
    public ResponseEntity<Emploi> addEmploiToPersonne(
        @PathVariable Long 
        personneId,
        @Valid @RequestBody 
        CreateEmploiDTO dto
    ){
        Emploi emploi = emploiService.addEmploiToPersonne(personneId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(emploi);
    }
}
