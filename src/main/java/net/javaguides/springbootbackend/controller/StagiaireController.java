package net.javaguides.springbootbackend.controller;

import java.util.List;
import java.util.Map;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import net.javaguides.springbootbackend.model.Stagiaire;
import net.javaguides.springbootbackend.service.StagiaireService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StagiaireController {

    private final StagiaireService stagiaireService;

    @PostMapping("/stagiaire")
    public ResponseEntity<?> postStagiaire(@RequestBody Stagiaire stagiaire) {
        Stagiaire newStagiaire = stagiaireService.postStagiaire(stagiaire);
        if (newStagiaire != null) {
            return ResponseEntity.ok().body(newStagiaire); // Retourner le stagiaire créé
        } else {
            return ResponseEntity.badRequest().body("La création du stagiaire a échoué.");
        }
    }

    @GetMapping("/stagiaires")
    public ResponseEntity<List<Stagiaire>> getAllStagiaire() {
        List<Stagiaire> stagiaires = stagiaireService.getAllStagiaire();
        return ResponseEntity.ok(stagiaires);
    }

    @GetMapping("/stagiaireEmail/{email}")
    public ResponseEntity<Stagiaire> getStagiaireEmail(@PathVariable String email) {
        Stagiaire stagiaires = stagiaireService.FindByEmail(email);
        return ResponseEntity.ok(stagiaires);
    }

    @GetMapping("/stagiaire/{id}")
    public ResponseEntity<?> getStagiaireById(@PathVariable Long id) {
        Stagiaire stagiaire = stagiaireService.getStagiaireById(id);
        if (stagiaire != null) {
            return ResponseEntity.ok(stagiaire);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/stagiaire/{id}")
    public ResponseEntity<?> updateStagiaire(@PathVariable Long id, @RequestBody Stagiaire stagiaire) {
        Stagiaire existingStagiaire = stagiaireService.getStagiaireById(id);
        if (existingStagiaire != null) {
            existingStagiaire.setName(stagiaire.getName());
            existingStagiaire.setEmail(stagiaire.getEmail());
            existingStagiaire.setPhone(stagiaire.getPhone());
            Stagiaire updatedStagiaire = stagiaireService.updateStagiaire(existingStagiaire);
            return ResponseEntity.ok().body("Stagiaire mis à jour avec succès.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/stagiaire/{id}")
    public ResponseEntity<?> deleteStagiaire(@PathVariable Long id) {
        Stagiaire existingStagiaire = stagiaireService.getStagiaireById(id);
        if (existingStagiaire != null) {
            stagiaireService.deleteStagiaire(id);
            return ResponseEntity.ok().body("Stagiaire supprimé avec succès.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        if (email != null && !email.isEmpty()) {
            stagiaireService.sendResetPasswordEmail(email);
            return ResponseEntity.ok().body("Reset password email sent successfully.");
        } else {
            return ResponseEntity.badRequest().body("Email is required.");
        }
    }
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String newPassword = request.get("newPassword");
        if (email != null && !email.isEmpty() && newPassword != null && !newPassword.isEmpty()) {
            boolean isUpdated = stagiaireService.updatePassword(email, newPassword);
            if (isUpdated) {
                return ResponseEntity.ok().body("Password updated successfully.");
            } else {
                return ResponseEntity.badRequest().body("Failed to update password.");
            }
        } else {
            return ResponseEntity.badRequest().body("Email and new password are required.");
        }
    }


}