package com.example.api_biblioteca.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Autor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idAutor;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 50)
    private String nacionalidade;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 11)
    private String telefone;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livro;
}
