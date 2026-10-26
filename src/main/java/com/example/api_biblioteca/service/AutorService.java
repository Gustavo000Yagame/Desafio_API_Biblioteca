package com.example.api_biblioteca.service;

import com.example.api_biblioteca.dto.AutorRequestDTO;
import com.example.api_biblioteca.dto.AutorResponseDTO;
import com.example.api_biblioteca.model.Autor;
import com.example.api_biblioteca.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;

    private AutorResponseDTO converterParaResponse(Autor autor){
      return new AutorResponseDTO(

              autor.getIdAutor(),
              autor.getNome(),
              autor.getNacionalidade(),
              autor.getEmail(),
              autor.getTelefone()
      );
    }

    public List<AutorResponseDTO> listaALLAutores(){
        return autorRepository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    public AutorResponseDTO cadastrarAutor(AutorRequestDTO dto){
        Autor autor = new Autor();

        autor.setNome(dto.nome());
        autor.setNacionalidade(dto.nacionalidade());
        autor.setEmail(dto.email());
        autor.setTelefone(dto.telefone());

        Autor salvo = autorRepository.save(autor);
        return converterParaResponse(salvo);
    }


    public AutorResponseDTO buscarAutorPorId(Long idAutor){
        Autor autor = autorRepository.findById(idAutor)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado" + idAutor));
        return converterParaResponse(autor);
    }

    public AutorResponseDTO atualizarAutor(Long idAutor, AutorRequestDTO dto){
        Autor autor = autorRepository.findById(idAutor)
                .orElseThrow(() -> new RuntimeException("Não foi possivel atualizar esse autor" + idAutor + " | " + dto.nome()));

        autor.setNome(dto.nome());
        autor.setNacionalidade(dto.nacionalidade());
        autor.setEmail(dto.email());
        autor.setTelefone(dto.telefone());

        Autor attAutor = new Autor();
        return converterParaResponse(attAutor);
    }

    public void deletarAutor(Long idAutor){
        Autor autor = autorRepository.findById(idAutor)
                .orElseThrow(() -> new RuntimeException(" | "+"ERRO "+" | "+"  Não foi possivel deletar o Autor"));
        autorRepository.delete(autor);
    }
}
