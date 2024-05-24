package net.javaguides.springbootbackend;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration

public class CorsConfig  implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:4200") // Autoriser les requêtes depuis localhost:4200
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // Autoriser les méthodes HTTP GET, POST, PUT, DELETE
    }

}
