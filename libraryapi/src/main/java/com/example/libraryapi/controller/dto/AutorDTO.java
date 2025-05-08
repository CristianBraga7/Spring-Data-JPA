/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package com.example.libraryapi.controller.dto;

import java.time.LocalDate;
import java.util.UUID;
import com.example.libraryapi.model.Autor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Past;
/**
 *
 * @author zooy
 */
public record AutorDTO(
        UUID id,
        @NotBlank(message = "Campo obrigatório") 
        @Size(min = 2, max = 100, message = "Campo fora do padrão") String nome,
        @NotNull(message = "Campo obrigatório") 
        @Past(message = "Data de nascimento inválida") LocalDate dataNascimento, 
        @NotBlank(message = "Campo obrigatório") 
        @Size(min = 2, max = 50, message = "Campo fora do padrão") String nacionalidade) {

    public Autor mapearParaAutor() {
        Autor autor = new Autor();
        autor.setNome(this.nome);
        autor.setDataNascimento(this.dataNascimento);
        autor.setNacionalidade(this.nacionalidade);
        return autor;
    }
}
