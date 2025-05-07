package com.example.libraryapi.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import java.math.BigDecimal;

//import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "livro", schema = "public")
@Data
// @NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "isbn", length = 100, nullable = false)
    private String isb;

    @Column(name = "titulo", length = 100, nullable = false)
    private String titulo;

    @Column(name = "data_publicacao")
    private LocalDate data_Publicacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero", length = 30, nullable = false)
    private GeneroLivro genero;

    @Column(name = "preco", precision = 18, scale = 2, nullable = false)
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @Deprecated
    public Livro() {
    }

    public Livro(String isb, String titulo, LocalDate data_Publicacao, GeneroLivro genero, BigDecimal preco, Autor autor) {
        this.isb = isb;
        this.titulo = titulo;
        this.data_Publicacao = data_Publicacao;
        this.genero = genero;
        this.preco = preco;
        this.autor = autor;
    }
}
