package org.acme.repository;

import java.util.List;

import org.acme.dto.EstadoDTO;
import org.acme.model.Estado;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstadoRepository implements PanacheRepository<Estado> {
    
   public Estado findEstado(String nome){
  return  find("nome", nome).firstResult();
   }
   
    public PanacheQuery<Estado> findByNome(String nome) {
        return find("SELECT e FROM Estado e WHERE e.nome LIKE ?1 ", "%"+nome+"%");
    }
}
