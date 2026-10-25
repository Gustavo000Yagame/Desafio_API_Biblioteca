package com.example.api_biblioteca.service;

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
}
