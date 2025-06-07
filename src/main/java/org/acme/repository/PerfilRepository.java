package org.acme.repository;

import java.util.List;

import org.acme.dto.EstadoDTO;
import org.acme.model.Estado;
import org.acme.model.Perfil;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PerfilRepository implements PanacheRepository<Perfil> {
    
}
