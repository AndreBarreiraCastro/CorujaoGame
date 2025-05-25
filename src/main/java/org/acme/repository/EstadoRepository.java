package org.acme.repository;

import java.util.List;

import org.acme.dto.EstadoDTO;
import org.acme.model.Estado;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstadoRepository implements PanacheRepository<Estado> {
    
   public Estado findEstado(String nome){
  return  find("nome", nome).firstResult();
   }
}
