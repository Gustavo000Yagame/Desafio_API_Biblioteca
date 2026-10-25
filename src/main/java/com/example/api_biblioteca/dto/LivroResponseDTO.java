package com.example.api_biblioteca.dto;

public record LivroResponseDTO (

        Long idLivro,
        String titulo,
        String isbn ,
        Integer anoPublicado,
        Integer QtDisponivel,
        Long autorId,
        String nomeAutor,
        String nacionalidade
){}
