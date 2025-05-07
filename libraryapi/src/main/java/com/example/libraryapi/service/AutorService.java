package com.example.libraryapi.service;

import org.springframework.stereotype.Service;
import com.example.libraryapi.model.Autor;
import com.example.libraryapi.repository.AutorRepository;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Service
public class AutorService {

    private final AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public void salvar(Autor autor) {
        if (autor.getId() == null) {
            throw new RuntimeException("Para atulizar é necessário que o autor esteja salvo");
        }
        repository.save(autor);
    }

    public Autor atualizar(Autor autor) {
        return repository.save(autor);
    }

    public Optional<Autor> obterPorId(UUID id) {
        return repository.findById(id);
    }

    public void deletar(Autor autor) {
        repository.delete(autor);
    }

    public List<Autor> pesquisar(String nome, String nacionalidade) {
        if (nome != null && nacionalidade != null) {
            return repository.findByNomeAndNacionalidade(nome, nacionalidade);

        }
        if (nome != null) {
            return repository.findByNome(nome);
        }

        if (nacionalidade != null) {
            return repository.findByNacionalidade(nacionalidade);
        }

        return repository.findAll();
    }
}
