package org.acme.repository;

import org.acme.model.Endereco;
import org.acme.model.Estado;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class EnderecoRepository implements PanacheRepository<Endereco> {
    
}
