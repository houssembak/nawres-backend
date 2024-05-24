package net.javaguides.springbootbackend.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.javaguides.springbootbackend.model.DemandeStagiaire;
import net.javaguides.springbootbackend.repository.DemandeStagiaireRepository;

@RequiredArgsConstructor
@Service

public class DemandeStagiaireService {

    private final DemandeStagiaireRepository demandeStagiaireRepository;

    public List<DemandeStagiaire> getAllDemandesStagiaires() {
        return demandeStagiaireRepository.findAll();
    }

    public DemandeStagiaire createDemandeStagiaire(DemandeStagiaire demandeStagiaire) {
        return demandeStagiaireRepository.save(demandeStagiaire);
    }


}