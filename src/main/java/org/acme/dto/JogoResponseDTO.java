package org.acme.dto;

import java.math.BigDecimal;
import java.util.List;

import org.acme.model.GeneroJogo;

import org.acme.model.Jogo;

public record JogoResponseDTO(Long id,String nome,int quantidade,GeneroJogo generoJogo,Double valorUnitario,String imagemJogo) {

public static JogoResponseDTO valueOf(Jogo jogo) {
        return new JogoResponseDTO (
            jogo.getId(),
            jogo.getNome(),
            jogo.getQuantidade(),
            jogo.getJogoGenero(),
            jogo.getValorUnitario(),
            jogo.getImagens());
    }
}