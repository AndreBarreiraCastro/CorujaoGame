package org.acme.dto;

import org.acme.model.GeneroJogo;

public record GeneroJogoResponseDTO(Long id,String nome) {

public static GeneroJogoResponseDTO valueOf(GeneroJogo generoJogo) {
        return new GeneroJogoResponseDTO (
            generoJogo.getId(),
            generoJogo.getNome()
            );
    }
}