package com.example.api_biblioteca.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Livro {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idLivro;

    @Column(nullable = false, length = 50)
    private String titulo;

    @Column(nullable = false, length = 13)
    private String isbn;

    @Column(nullable = false)
    private Integer anoPublicado;

    @Column(nullable = false)
    private Integer QtDisponivel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor", nullable = false)
    private Autor autor;

    @OneToMany(mappedBy = "livro")
    private List<Emprestimo> emprestimo;
}
