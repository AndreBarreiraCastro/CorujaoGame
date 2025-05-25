package org.acme.service;

import java.util.List;

import org.acme.dto.MunicipioDTO;
import org.acme.dto.MunicipioResponseDTO;
import org.acme.model.Municipio;

public interface MunicipioService {
    MunicipioResponseDTO inserir(MunicipioDTO Municipio);
    MunicipioResponseDTO alterar(Long id,MunicipioDTO MunicipioDTO);
    void deletar(Long id);
    MunicipioResponseDTO procurarMunicipio(Long id);
    MunicipioResponseDTO procurarNome(String nome);
    List<Municipio> procurartodos();
}
