package com.ForoHub.ForoHub.service;

import com.ForoHub.ForoHub.model.Topico;
import com.ForoHub.ForoHub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import jakarta.validation.Valid;
import java.util.Optional;  // Agregar esta línea

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public Topico saveTopico(@Valid Topico topico) {
        // Verificar si el tópico ya existe
        Optional<Topico> existingTopico = topicoRepository.findByTituloAndMensaje(topico.getTitulo(), topico.getMensaje());
        if (existingTopico.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El tópico con el mismo título y mensaje ya existe");
        }
        return topicoRepository.save(topico);
    }
}
