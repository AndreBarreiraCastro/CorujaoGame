package org.acme.repository;

import org.acme.model.Estado;
import org.acme.model.Jogo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JogoRepository implements PanacheRepository<Jogo> {
     public Jogo findJogo(String nome){
  return  find("nome", nome).firstResult();
   }
}
