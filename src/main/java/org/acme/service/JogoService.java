package org.acme.service;

import java.util.List;

import org.acme.dto.JogoDTO;
import org.acme.dto.JogoResponseDTO;
import org.acme.model.Jogo;
import org.acme.model.Municipio;

public interface JogoService {
    JogoResponseDTO inserir(JogoDTO jogo);
    JogoResponseDTO alterar(Long id,JogoDTO jogoDTO);
    void deletar(Long id);
    JogoResponseDTO procurarjogo(Long id);
    JogoResponseDTO procurarNome(String nome);
   List<Jogo> procurartodos(Integer page, Integer pageSize);
    long count();
}
