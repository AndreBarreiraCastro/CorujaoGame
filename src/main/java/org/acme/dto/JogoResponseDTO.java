package org.acme.dto;

import java.math.BigDecimal;

import org.acme.model.GeneroJogo;
import org.acme.model.Jogo;

public record JogoResponseDTO(Long id,String nome,int quantidade,GeneroJogo generoJogo,BigDecimal valorUnitario) {

public static JogoResponseDTO valueOf(Jogo jogo) {
        return new JogoResponseDTO (
            jogo.getId(),
            jogo.getNome(),
            jogo.getQuantidade(),
            jogo.getJogoGenero(),
            jogo.getValorUnitario());
    }
}