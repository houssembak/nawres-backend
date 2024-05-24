package net.javaguides.springbootbackend.controller;


import net.javaguides.springbootbackend.model.DemandeStagiaire;
import net.javaguides.springbootbackend.service.DashboardAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.parser.Entity;
import java.util.List;
@CrossOrigin("*")
@Controller
@RequestMapping
public class AdminDashboardController {
    @Autowired
    private final DashboardAdminService dashboardAdminService;

    public AdminDashboardController(DashboardAdminService dashboardAdminService) {
        this.dashboardAdminService = dashboardAdminService;
    }

    @GetMapping("/dashboard-admin")
    public ResponseEntity<List<DemandeStagiaire>> dashboard() {
        List<DemandeStagiaire> demandes = dashboardAdminService.getAllDemandesStagiaires();
        return  new ResponseEntity<>(demandes, HttpStatus.OK);
    }


}
