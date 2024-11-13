package com.EVO.gym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubpaginasController {
    
    @GetMapping("/index")
    public String index() {
        return "index"; // Retorna el nombre de la vista (index.html)
    }
    
    @GetMapping("/nosotros")
    public String nosotros() {
        return "nosotros"; // Retorna el nombre de la vista (nosotros.html)
    }
    
    @GetMapping("/login")
    public String login() {
        return "login"; // Retorna el nombre de la vista (login.html)
    }
    
    @GetMapping("/perfil")
    public String perfil() {
        return "perfil"; // Retorna el nombre de la vista (perfil.html)
    }
    
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // Retorna el nombre de la vista (dashboard.html)
    }
         @GetMapping("/membresias")
    public String membresias() {
        return "membresias"; // Retorna el nombre de la vista (membresias.html)
    }
}
