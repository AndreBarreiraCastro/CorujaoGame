package org.acme.dto;

import org.acme.model.ItemPedido;

public record ItemPedidoResponseDTO(
    Long idProduto,
    Integer qtd,
    Double preco) {

    public static ItemPedidoResponseDTO valueOf(ItemPedido itemPedido) {
        return new ItemPedidoResponseDTO (
            itemPedido.getJogo().getId(), 
            itemPedido.getQuantidade(),
            itemPedido.getPreco());
    }
}