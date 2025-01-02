package com.ForoHub.ForoHub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Retorna el nombre de la vista login.html desde resources/templates
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "home"; // Página principal después de un login exitoso
    }
}
