package org.acme.dto;

import org.acme.model.Estado;
import org.acme.model.Municipio;
import org.acme.repository.EstadoRepository;

public record MunicipioResponseDTO(Long id,String nome,String sigla,Estado estadoMunicipio) {

public static MunicipioResponseDTO valueOf(Municipio municipio) {
        return new MunicipioResponseDTO (
            municipio.getId(),
            municipio.getNome(),
            municipio.getSigla(),
            municipio.getEstadoMunicipio());
    }
}