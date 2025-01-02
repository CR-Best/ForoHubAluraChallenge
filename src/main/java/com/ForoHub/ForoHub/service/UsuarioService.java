package com.ForoHub.ForoHub.service;

import com.ForoHub.ForoHub.model.Usuario;
import com.ForoHub.ForoHub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtener todos los usuarios
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por ID
    public Optional<Usuario> getUsuarioById(Long id) {
        // Verifica si el usuario existe
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            // Lógica en caso de no encontrar el usuario, puede lanzar una excepción
            throw new RuntimeException("Usuario no encontrado con id: " + id);
        }
        return usuario;
    }

    // Guardar un usuario
    public Usuario saveUsuario(Usuario usuario) {
        // Validación de datos del usuario, por ejemplo, asegurarse de que el usuario no sea nulo
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }

        // Verifica si ya existe un usuario con el mismo correo (o cualquier otro campo único)
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("Ya existe un usuario con el correo: " + usuario.getEmail());
        }

        return usuarioRepository.save(usuario);
    }

    // Eliminar un usuario por ID
    public void deleteUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar, usuario no encontrado con id: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    public boolean existsByEmail(String email) {
        return false;
    }
}
