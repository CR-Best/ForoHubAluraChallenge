package com.ForoHub.ForoHub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configuración de las rutas públicas y protegidas
        http
                .csrf().disable() // Si lo necesitas, puedes deshabilitar CSRF
                .authorizeRequests()
                .requestMatchers("/login", "/register").permitAll() // Acceso público a estas rutas
                .anyRequest().authenticated() // El resto requiere autenticación
                .and()
                .formLogin()
                .loginPage("/login") // Página personalizada de login (si la tienes)
                .permitAll()
                .and()
                .logout()
                .permitAll(); // Permitir cierre de sesión

        return http.build();
    }
}
