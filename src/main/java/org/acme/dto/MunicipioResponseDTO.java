package org.acme.dto;

import org.acme.model.Estado;
import org.acme.model.Municipio;
import org.acme.repository.EstadoRepository;

public record MunicipioResponseDTO(String nome,String sigla,Estado estadoMunicipio) {

public static MunicipioResponseDTO valueOf(Municipio municipio) {
       if (municipio == null) {
            throw new IllegalArgumentException("Município não pode ser nulo");
        }
        return new MunicipioResponseDTO (
            municipio.getNome(),
            municipio.getSigla(),
            municipio.getEstadoMunicipio());
    }
}