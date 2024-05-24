package net.javaguides.springbootbackend.auth.signup;

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
public class SignUpService {
  final  private StagiaireRepository  signUpRepository;


  public ResponseEntity<?> SignUp(Stagiaire stagiaire){
    boolean   result =signUpRepository.existsByEmail(stagiaire.getEmail());
try {
  if (result==false) {
    signUpRepository.save(stagiaire);
    return ResponseEntity.ok( ).body("User created successfully");

}
else
{ 
    return ResponseEntity.badRequest( ).body("Email already exists");
}
} catch (Exception e) {
  return ResponseEntity.badRequest().body("Email already exists");}
  
  
    
  }}
