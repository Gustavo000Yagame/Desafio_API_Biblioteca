package com.example.api_biblioteca.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AutorRequestDTO(

        @NotBlank(message = "Nome do Autor e Obrigatorio")
        @Size(max = 100)
        String nome,

        String nacionalidade, //Acho que isso não precisa ser obrigatorio

        @Email(message = "Email e obrigatorio, Não esqueça de digitar!!")
        @NotBlank(message = "Não esqueça do Email")
        String email,

        @Pattern(regexp = "^[0-9]{10,11}$",
        message = "Deve conter entre 10 e 11 dígitos")
        String telefone

){}
