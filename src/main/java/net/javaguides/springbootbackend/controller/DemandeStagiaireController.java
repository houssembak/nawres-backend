package net.javaguides.springbootbackend.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springbootbackend.model.DemandeStagiaire;
import net.javaguides.springbootbackend.service.DemandeStagiaireService;

@RestController
@RequestMapping("/api/demandes")
public class DemandeStagiaireController {

    private final DemandeStagiaireService demandeStagiaireService;

    @Autowired
    public DemandeStagiaireController(DemandeStagiaireService demandeStagiaireService) {
        this.demandeStagiaireService = demandeStagiaireService;
    }

    @GetMapping
    public ResponseEntity<List<DemandeStagiaire>> getAllDemandesStagiaires() {
        List<DemandeStagiaire> demandes = demandeStagiaireService.getAllDemandesStagiaires();
        return new ResponseEntity<>(demandes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DemandeStagiaire> createDemandeStagiaire(@RequestBody DemandeStagiaire demandeStagiaire) {
        DemandeStagiaire createdDemande = demandeStagiaireService.createDemandeStagiaire(demandeStagiaire);
        return new ResponseEntity<>(createdDemande, HttpStatus.CREATED);
    }

    
}