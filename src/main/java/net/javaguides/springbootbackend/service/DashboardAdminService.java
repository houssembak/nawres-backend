package net.javaguides.springbootbackend.service;
import net.javaguides.springbootbackend.model.DemandeStagiaire;
import net.javaguides.springbootbackend.repository.DemandeStagiaireRepository;
import org.springframework.stereotype.Service;


import java.util.List;




@Service
public class DashboardAdminService {
    private final DemandeStagiaireRepository demandeStagiaireRepository;

    public DashboardAdminService(DemandeStagiaireRepository demandeStagiaireRepository) {
        this.demandeStagiaireRepository = demandeStagiaireRepository;
    }

    public List<DemandeStagiaire> getAllDemandesStagiaires() {
        return demandeStagiaireRepository.findAll();
    }





}
