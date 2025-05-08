package com.example.libraryapi.validador;

import com.example.libraryapi.repository.AutorRepository;
import com.example.libraryapi.model.Autor;
import java.util.Optional;
import com.example.libraryapi.execeptions.RegistroDuplicadoException;
import org.springframework.stereotype.Component;

@Component
public class AutorValidador {

    private AutorRepository repository;

    public AutorValidador(AutorRepository repository) {
        this.repository = repository;
    }

    public void validar(Autor autor) {
        if (existeAutorComMesmoNome(autor)) {
            throw new RegistroDuplicadoException("Autor já cadastrado");
        }
    }

    private boolean existeAutorComMesmoNome(Autor autor) {
        Optional<Autor> autorEncontrado = repository.findByNomeAndNacionalidadeAndDataNascimento(
                autor.getNome(),
                autor.getNacionalidade(),
                autor.getDataNascimento());

        if (autor.getId() == null) {
            return autorEncontrado.isPresent();
        }
        return autor.getId().equals(autorEncontrado.get().getId()) && autorEncontrado.isPresent();

    }

}