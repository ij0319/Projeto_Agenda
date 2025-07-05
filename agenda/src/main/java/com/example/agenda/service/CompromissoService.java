package com.example.agenda.service;

import com.example.agenda.model.Compromisso;
import com.example.agenda.repository.CompromissoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompromissoService {

    private final CompromissoRepository repo;

    public CompromissoService(CompromissoRepository repo) {
        this.repo = repo;
    }

    public List<Compromisso> listar() {
        return repo.findAll();
    }

    public Compromisso salvar(Compromisso c) {
        return repo.save(c);
    }

    public Compromisso buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
