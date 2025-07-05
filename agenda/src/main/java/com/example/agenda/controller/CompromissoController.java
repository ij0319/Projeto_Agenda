package com.example.agenda.controller;

import com.example.agenda.model.Compromisso;
import com.example.agenda.service.CompromissoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/compromissos")
public class CompromissoController {

    private final CompromissoService service;

    public CompromissoController(CompromissoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Compromisso> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compromisso> buscar(@PathVariable Long id) {
        Compromisso c = service.buscarPorId(id);
        return c != null ? ResponseEntity.ok(c) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Compromisso> criar(@RequestBody Compromisso compromisso) {
        Compromisso salvo = service.salvar(compromisso);
        return ResponseEntity.ok(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

