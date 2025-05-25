package org.acme.repository;

import org.acme.model.GeneroJogo;
import org.acme.model.Jogo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GeneroJogoRepository implements PanacheRepository<GeneroJogo> {
     public GeneroJogo findGeneroJogo(String nome){
  return  find("nome", nome).firstResult();
   }
}
