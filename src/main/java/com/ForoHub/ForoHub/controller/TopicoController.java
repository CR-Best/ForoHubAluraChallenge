package com.ForoHub.ForoHub.controller;

import com.ForoHub.ForoHub.model.Topico;
import com.ForoHub.ForoHub.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public Topico saveTopico(@RequestBody @Valid Topico topico) {
        try {
            return topicoService.saveTopico(topico);
        } catch (ResponseStatusException e) {
            throw e;  // Lanzar la excepción si ya existe el tópico
        }
    }
}
