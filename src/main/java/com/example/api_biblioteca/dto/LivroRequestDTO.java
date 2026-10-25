package com.example.api_biblioteca.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroRequestDTO (

        @NotBlank(message = "O titulo e obrigatorio!")
        String titulo,

        @NotBlank(message = "O isbn e obrigatorio!")
        String isbn,

        @NotNull(message = "O ano de Publicado e obrigatorio!")
        @DecimalMin(value = "1200")
        @DecimalMax(value = "2026")
        Integer anoPublicado,

        @NotNull(message = "A quanidade em estoque é obrigaoria")
        Integer QtDisponivel,

        Long autorId
){}
