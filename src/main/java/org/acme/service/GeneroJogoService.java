package org.acme.service;

import java.util.List;

import org.acme.dto.GeneroJogoDTO;
import org.acme.dto.GeneroJogoResponseDTO;
import org.acme.model.GeneroJogo;

public interface GeneroJogoService {
    GeneroJogoResponseDTO inserir(GeneroJogoDTO genero);
    GeneroJogoResponseDTO alterar(Long id,GeneroJogoDTO generojogoDTO);
    void deletar(Long id);
   GeneroJogoResponseDTO procurarNome(String nome);
   List<GeneroJogo> procurartodos(Integer page, Integer pageSize);
    Long count();
}
