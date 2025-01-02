package com.ForoHub.ForoHub.repository;

import com.ForoHub.ForoHub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email); // Si tienes un campo de correo electrónico
    boolean existsByEmail(String email); // Para verificar si el correo ya existe
}
