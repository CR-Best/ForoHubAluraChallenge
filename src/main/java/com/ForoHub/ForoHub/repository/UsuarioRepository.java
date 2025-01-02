package com.ForoHub.ForoHub.repository;

import com.ForoHub.ForoHub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

// La interfaz extiende JpaRepository, donde el primer parámetro es el tipo de la entidad (Usuario),
// y el segundo parámetro es el tipo de la clave primaria (Long).
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Aquí puedes agregar métodos personalizados si los necesitas
    // Ejemplo: List<Usuario> findByNombre(String nombre);
}
