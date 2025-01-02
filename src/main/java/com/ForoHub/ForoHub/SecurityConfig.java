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
        http
                .csrf().disable()  // Desactivar CSRF (si es necesario)
                .authorizeRequests()
                .requestMatchers("/login", "/register").permitAll() // Permitir acceso público a login y register
                .anyRequest().authenticated()  // El resto de las rutas requieren autenticación
                .and()
                .formLogin()
                .loginPage("/login")  // Página personalizada de login
                .defaultSuccessUrl("/home", true) // Redirigir a la página principal después del login exitoso
                .permitAll()  // Permitir acceso público a la página de login
                .and()
                .logout()
                .permitAll();  // Permitir cierre de sesión

        return http.build();
    }
}
