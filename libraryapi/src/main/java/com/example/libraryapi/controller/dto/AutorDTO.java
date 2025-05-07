/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package com.example.libraryapi.controller.dto;

import java.time.LocalDate;
import java.util.UUID;
import com.example.libraryapi.model.Autor;


/**
 *
 * @author zooy
 */
public record AutorDTO(
        UUID id,
        String nome,
        LocalDate dataNascimento,
        String nacionalidade) {

    public Autor mapearParaAutor() {
        Autor autor = new Autor();
        autor.setNome(this.nome);
        autor.setDataNascimento(this.dataNascimento);
        autor.setNacionalidade(this.nacionalidade);
        return autor;
    }
}
