package com.example.api_biblioteca.dto;

import com.example.api_biblioteca.model.enums.StatusEmprestimo;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmprestimoRequestDTO(

     @NotBlank(message = "O nome do leitor é  obrigatio!")
     String nomeLeitor,
     @NotBlank(message = "O nome do cpf do Leitor é obrigatio!")
     String cpfLeitor,

     @Min(value = 1)
     @Max(value = 30)
     LocalDate dataEmprestimo,

     LocalDate dataPrevistaDevolucao,
     LocalDate dataDevolucao,
     StatusEmprestimo status,

     BigDecimal valorMulta,
     Long livroId
){}
