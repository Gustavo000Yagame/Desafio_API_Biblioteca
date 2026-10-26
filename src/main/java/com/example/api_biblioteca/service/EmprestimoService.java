package com.example.api_biblioteca.service;

import com.example.api_biblioteca.dto.EmprestimoResponseDTO;
import com.example.api_biblioteca.model.Emprestimo;
import com.example.api_biblioteca.repository.EmprestimoRepository;
import com.example.api_biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;

    private EmprestimoResponseDTO converterEmprestimoParaResponse(Emprestimo emprestimo) {
        return new EmprestimoResponseDTO(
                emprestimo.getIdEmprestimo(),
                emprestimo.getNomeLeitor(),
                emprestimo.getCpfLeitor(),
                emprestimo.getDataEmprestimo(),
                emprestimo.getDataPrevistaDevolucao(),
                emprestimo.getDataDevolucao(),
                emprestimo.getStatus(),
                emprestimo.getValorMulta(),
                emprestimo.getLivro().getIdLivro(),
                emprestimo.getLivro().getTitulo(),
                emprestimo.getLivro().getIsbn()
        );
    }

        public List<EmprestimoResponseDTO> listarEmprestimos() {
            return emprestimoRepository.findAll()
                    .stream()
                    .map(this::converterEmprestimoParaResponse)
                    .toList();
        }
    }

