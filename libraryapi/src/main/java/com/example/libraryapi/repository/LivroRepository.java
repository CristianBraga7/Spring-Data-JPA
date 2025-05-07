package com.example.libraryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.libraryapi.model.Livro;
import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
    
}
