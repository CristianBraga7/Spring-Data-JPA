package com.example.libraryapi.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import com.example.libraryapi.model.GeneroLivro;
import com.example.libraryapi.model.Livro;
import com.example.libraryapi.model.Autor;


@SpringBootTest
public class LivroRepositoryTeste {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private AutorRepository autorRepository;

    @Test
    void salvarTeste() {
        Livro livro = new Livro();
        livro.setIsbn("90887-84874");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.CIENCIA);
        livro.setTitulo("cientista");
        livro.setDataPublicacao(LocalDate.of(2021, 1, 1));

        Autor autor = autorRepository.findById(UUID.fromString("7f478f22-7c23-4570-b2d2-c7117a8ae3cd"))
                .orElse(null);
                
                livro.setAutor(autor);
        repository.save(livro);
    }
}
