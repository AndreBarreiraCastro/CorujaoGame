package org.acme.service;

import java.util.List;

import org.acme.dto.PedidoResponseDTO;
import org.acme.dto.PedigoDTO;

public interface PedidoService {

    List<PedidoResponseDTO> findByUsername(String username);
    PedidoResponseDTO findById(long idPedido, String username); 
    PedidoResponseDTO create(PedigoDTO pedido, String username);
    
}