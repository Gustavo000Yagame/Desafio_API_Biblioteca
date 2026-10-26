package com.example.api_biblioteca.service;

import com.example.api_biblioteca.dto.LivroRequestDTO;
import com.example.api_biblioteca.dto.LivroResponseDTO;
import com.example.api_biblioteca.model.Autor;
import com.example.api_biblioteca.model.Livro;
import com.example.api_biblioteca.repository.AutorRepository;
import com.example.api_biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    private LivroResponseDTO convertLivroParaResponse(Livro livro) {
        return new LivroResponseDTO(
                livro.getIdLivro(),
                livro.getTitulo(),
                livro.getIsbn(),
                livro.getAnoPublicado(),
                livro.getQtDisponivel(),
                livro.getAutor().getIdAutor(),
                livro.getAutor().getNome(),
                livro.getAutor().getNacionalidade()
        );
    }

    public List<LivroResponseDTO> listarLivros() {
        return livroRepository.findAll()
                .stream()
                .map(this::convertLivroParaResponse)
                .toList();
    }

    public LivroResponseDTO cadastrarLivro(LivroRequestDTO dto) {
        Autor autor = autorRepository.findById(dto.autorId())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado" + "|" + dto.autorId() + "|"));
        Livro livro = new Livro();

        livro.setTitulo(dto.titulo());
        livro.setIsbn(dto.isbn());
        livro.setAnoPublicado(dto.anoPublicado());
        livro.setQtDisponivel(dto.QtDisponivel());
        livro.setAutor(autor);

        Livro cadLivro = livroRepository.save(livro);
        return convertLivroParaResponse(cadLivro);

    }

    public LivroResponseDTO atualizarLivro(Long idLivro, LivroRequestDTO dto) {
        Livro livro = livroRepository.findById(idLivro).orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        Autor autor = autorRepository.findById(dto.autorId())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado" + "|" + dto.autorId() + "|"));

        livro.setTitulo(dto.titulo());
        livro.setIsbn(dto.isbn());
        livro.setAnoPublicado(dto.anoPublicado());
        livro.setQtDisponivel(dto.QtDisponivel());
        livro.setAutor(autor);

        Livro attLivro = livroRepository.save(livro);
        return convertLivroParaResponse(attLivro);
    }
}
