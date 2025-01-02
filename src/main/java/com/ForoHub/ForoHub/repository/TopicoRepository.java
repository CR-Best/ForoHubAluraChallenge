package com.ForoHub.ForoHub.repository;

import com.ForoHub.ForoHub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    // Método para verificar si existe un tópico con el mismo título y mensaje
    Optional<Topico> findByTituloAndMensaje(String titulo, String mensaje);
}
