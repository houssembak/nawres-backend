package net.javaguides.springbootbackend.repository;
import net.javaguides.springbootbackend.model.Stagiaire;

import org.hibernate.internal.util.collections.ConcurrentReferenceHashMap.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StagiaireRepository extends JpaRepository<Stagiaire, Long>{

    Stagiaire findByEmail(String email);
 Boolean existsByEmail(String email);
Optional<Stagiaire>findByEmailAndPassword(String email , String password);




}
