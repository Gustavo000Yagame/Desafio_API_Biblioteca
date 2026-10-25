package com.example.api_biblioteca.dto;

import jakarta.persistence.Column;

public record AutorResponseDTO(

        Long idAutor,
        String nome,
        String nacionalidade,
        String email,
        String telefone

){}
