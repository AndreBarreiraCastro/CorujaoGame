package org.acme.dto;

import org.acme.model.Estado;
import org.acme.model.Municipio;
import org.acme.model.Perfil;
import org.acme.model.Usuario;

public record EstadoResponseDTO(Long id,String nome,String sigla) {

public static EstadoResponseDTO valueOf(Estado estado) {
        return new EstadoResponseDTO (
            estado.getId(),
            estado.getNome(),
            estado.getSigla());
    }
}