package net.javaguides.springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springbootbackend.model.DemandeStagiaire;



@Repository
public interface DemandeStagiaireRepository extends JpaRepository<DemandeStagiaire, Long> {

}