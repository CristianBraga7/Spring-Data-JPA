package com.example.libraryapi.service;

import org.springframework.stereotype.Service;
import com.example.libraryapi.model.Autor;
import com.example.libraryapi.repository.AutorRepository;
import com.example.libraryapi.validador.AutorValidador;
import com.example.libraryapi.execeptions.OperacaoNaoPermitidaException;
import java.util.Optional;
import java.util.UUID;
import java.util.List;
import com.example.libraryapi.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository repository;
    private final AutorValidador validador;
    private final LivroRepository livroRepository;

    public Autor salvar(Autor autor) {
        validador.validar(autor);
        return repository.save(autor);
    }

    public Autor atualizar(Autor autor) {
        if (autor.getId() == null) {
            throw new RuntimeException("Para atulizar é necessário que o autor esteja salvo");
        }
        validador.validar(autor);
        return repository.save(autor);
    }

    public Optional<Autor> obterPorId(UUID id) {
        return repository.findById(id);
    }

    public void deletar(Autor autor) {
        if (possuiLivro(autor)) {
            throw new OperacaoNaoPermitidaException("Autor possui livros cadastrados");
        }
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

    public List<Autor> pesquisarByExample(String nome, String nacionalidade) {
        var autor = new Autor();
        autor.setNome(nome);
        autor.setNacionalidade(nacionalidade);

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnorePaths("id", "dataNascimento", "dataCadastro")
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(StringMatcher.CONTAINING);

        Example<Autor> autorExample = Example.of(autor, matcher);
        return repository.findAll(autorExample);
    }

    public boolean possuiLivro(Autor autor) {
        return livroRepository.existsByAutor(autor);
    }
}
