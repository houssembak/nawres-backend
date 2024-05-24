package net.javaguides.springbootbackend.service;
import lombok.RequiredArgsConstructor;
import net.javaguides.springbootbackend.auth.forgotpassword.EmailService;
import net.javaguides.springbootbackend.model.Stagiaire;
import net.javaguides.springbootbackend.repository.StagiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class StagiaireService {
    private final  StagiaireRepository stagiaireRepository;
    @Autowired
    private EmailService emailService;


    public Stagiaire postStagiaire(Stagiaire stagiaire){

        return stagiaireRepository.save(stagiaire);

    }
    public List<Stagiaire> getAllStagiaire(){
        return stagiaireRepository.findAll();
    }
    public Stagiaire getStagiaireById(Long id){
        return stagiaireRepository.findById(id).orElse(null);

    }
    public Stagiaire updateStagiaire(Stagiaire stagiaire){
        return  stagiaireRepository.save(stagiaire);
    }
    public void deleteStagiaire(Long id){
        stagiaireRepository.deleteById(id);
    }

    public Stagiaire FindByEmail( String email){
        return stagiaireRepository.findByEmail(email);
    }
    public void sendResetPasswordEmail(String email) {
        Stagiaire stagiaire = stagiaireRepository.findByEmail(email);
        if (stagiaire != null) {
            String resetLink = "http://localhost:4200/reset-password/" + email;
            String subject = "Reset Password";
            String body = "Click the link to reset your password: " + resetLink;
            emailService.sendEmail(email, subject, body);
        }
    }
    public boolean updatePassword(String email, String newPassword) {
        Stagiaire stagiaire = stagiaireRepository.findByEmail(email);
        if (stagiaire != null) {
            stagiaire.setPassword(newPassword);
            stagiaireRepository.save(stagiaire);
            return true;
        }
        return false;
    }




}