package org.acme.dto;

import java.util.List;

import io.smallrye.common.constraint.NotNull;

public class PedigoDTO {
   @NotNull
   Double total;
   @NotNull
    List<ItemPedidoDTO> itens;
   public Double getTotal() {
    return total;
   }
   public List<ItemPedidoDTO> getItens() {
    return itens;
   }


}
