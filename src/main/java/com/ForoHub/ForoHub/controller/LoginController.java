package com.ForoHub.ForoHub.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            return "redirect:/home"; // Si el usuario ya está autenticado, redirigir a /home
        }
        return "login"; // Si no está autenticado, mostrar la página de login
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "home"; // Página principal después de un login exitoso
    }
}
