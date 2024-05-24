package net.javaguides.springbootbackend.auth.login;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.springbootbackend.model.Stagiaire;
import net.javaguides.springbootbackend.repository.StagiaireRepository;

@Service
@AllArgsConstructor
public class LoginService {
  final  private StagiaireRepository  loginRepository;



  public ResponseEntity<?> login(Stagiaire stagiaire) {
    Optional<Stagiaire> result = loginRepository.findByEmailAndPassword(stagiaire.getEmail(), stagiaire.getPassword());

    if (result.isPresent()) {
        return ResponseEntity.ok(result.get());
    } else {
        return ResponseEntity.badRequest().body("Invalid email or password");
    }
}
}
