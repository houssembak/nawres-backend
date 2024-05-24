package net.javaguides.springbootbackend.auth.login;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import net.javaguides.springbootbackend.model.Stagiaire;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api")
public class LoginController {
    final private LoginService signUpService;

    @PostMapping("/Login")
    public ResponseEntity<?> login(@RequestBody Stagiaire stagiaire) {
     return   signUpService.login(stagiaire);
    }

}
