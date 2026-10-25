package com.example.api_biblioteca.model;

import com.example.api_biblioteca.model.enums.StatusEmprestimo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Emprestimo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idEmprestimo;

    @Column(nullable = false, length = 100)
    private String nomeLeitor;

    @Column(nullable = false, length = 11)
    private String cpfLeitor;

    @Column(nullable = false)
    private LocalDate dataEmprestimo;

    @Column(nullable = false)
    private LocalDate dataPrevistaDevolucao;

    private LocalDate dataDevolucao;

    @Enumerated(EnumType.STRING)
    private StatusEmprestimo status;

    @Column(precision = 10, scale = 2)
    private BigDecimal valorMulta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Livro")
    private Livro livro;
}
