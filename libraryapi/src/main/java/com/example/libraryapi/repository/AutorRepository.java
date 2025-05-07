package com.example.libraryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.libraryapi.model.Autor;
import java.util.UUID;
import java.util.List;
public interface AutorRepository extends JpaRepository<Autor, UUID> {
    
 List<Autor> findByNome(String nome);
 List<Autor> findByNacionalidade(String nacionalidade);
 List<Autor> findByNomeAndNacionalidade(String nome, String nacionalidade);
}
