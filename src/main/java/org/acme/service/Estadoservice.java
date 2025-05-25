package org.acme.service;

import java.util.List;

import org.acme.dto.EstadoDTO;
import org.acme.dto.EstadoResponseDTO;
import org.acme.dto.EstadoDTO;
import org.acme.dto.EstadoResponseDTO;
import org.acme.model.Estado;
import org.acme.model.Estado;

public interface Estadoservice {
       EstadoResponseDTO inserir(EstadoDTO estado);
    EstadoResponseDTO alterar(Long id,EstadoDTO estado);
    void deletar(Long id);
    EstadoResponseDTO procurarEstado(Long id);
    EstadoResponseDTO procurarNome(String nome);
    List<Estado> procurartodos();
}
