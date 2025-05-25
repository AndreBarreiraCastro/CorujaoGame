package org.acme.repository;

import java.util.List;

import org.acme.dto.MunicipioDTO;
import org.acme.dto.MunicipioResponseDTO;
import org.acme.model.Municipio;
import org.acme.model.Municipio;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MunicipioRepository implements PanacheRepository<Municipio> {
    
    public Municipio findByNome(String nome){
        return find("nome",nome).firstResult();
    }
    // public Municipio findByID(Long id){
    //     return find("id",id).firstResult();
    // }
}
