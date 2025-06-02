package org.acme.service;

import java.util.List;

import org.acme.dto.MunicipioDTO;
import org.acme.dto.MunicipioResponseDTO;
import org.acme.model.Estado;
import org.acme.model.Municipio;

import jakarta.ws.rs.core.Response;

public interface MunicipioService {
    Response inserir(MunicipioDTO Municipio);
    Response alterar(Long id,MunicipioDTO MunicipioDTO);
    Response deletar(Long id);
    MunicipioResponseDTO procurarMunicipio(Long id);
    MunicipioResponseDTO procurarNome(String nome);
    List<Municipio> procurartodos(Integer page, Integer pageSize);
    long count();
}
