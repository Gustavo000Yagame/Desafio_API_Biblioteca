package com.example.api_biblioteca.dto;

import com.example.api_biblioteca.model.enums.StatusEmprestimo;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmprestimoResponseDTO (

        Long idEmprestimo,
        String nomeLeitor,
        String cpfLeitor,
        LocalDate dataEmprestimo,
        LocalDate dataPrevistaDevolucao,
        LocalDate dataDevolucao,
        StatusEmprestimo status,
        BigDecimal valorMulta,
        Long livroId,
        String tituloLivro,
        String isbn
){}
