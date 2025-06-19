package org.acme.repository;

import org.acme.model.Estado;
import org.acme.model.ItemPedido;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class ItemPedidoRepository implements PanacheRepository<ItemPedido> {
    
}
