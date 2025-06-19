package org.acme.service;

import java.util.List;

import org.acme.dto.EnderecoDTO;
import org.acme.dto.EnderecoResponseDTO;
import org.acme.model.Endereco;

public interface EnderecoService {
    EnderecoResponseDTO inserir (EnderecoDTO dto);
    List<Endereco> buscartodos ();
    void deletar (Long id);
    EnderecoResponseDTO alterar (EnderecoDTO dto);
    EnderecoResponseDTO buscarId (Long id);
}
