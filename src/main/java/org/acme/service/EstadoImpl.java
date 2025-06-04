package org.acme.service;

import java.util.List;

import org.acme.dto.EstadoDTO;
import org.acme.dto.EstadoResponseDTO;
import org.acme.dto.MunicipioResponseDTO;
import org.acme.dto.EstadoDTO;
import org.acme.dto.EstadoResponseDTO;
import org.acme.model.Estado;
import org.acme.model.Estado;
import org.acme.model.Estado;
import org.acme.repository.EstadoRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

import org.acme.repository.EstadoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
@ApplicationScoped
public class EstadoImpl implements Estadoservice {

    @Inject EstadoRepository repository;

    @Override
    public EstadoResponseDTO inserir(EstadoDTO estado) {
        Estado novoEstasdo = new Estado();
        novoEstasdo.setNome(estado.getNome());
        novoEstasdo.setSigla(estado.getSigla());
        repository.persist(novoEstasdo);
        return EstadoResponseDTO.valueOf(novoEstasdo);
    }

    @Override
    public EstadoResponseDTO alterar(Long id,Estado estado) {
        Estado novoEstado = repository.findById(id);

                
            novoEstado.setNome(estado.getNome());
            novoEstado.setSigla(estado.getSigla());
       return EstadoResponseDTO.valueOf(novoEstado);
    }

    @Override
    public void deletar(Long id) {
        repository.delete(repository.findById(id));
    }

    @Override
    public EstadoResponseDTO procurarEstado(Long id) {
         Estado estado = repository.findById(id);
 if(estado==null){
    throw new IllegalArgumentException("Município não pode ser nulo"+ estado);
 }
    if (estado == null) {
        throw new NotFoundException("Município não encontrado com id: " + id);
    }
    return EstadoResponseDTO.valueOf(estado);
    }

    @Override
    public EstadoResponseDTO procurarNome(String nome) {
         return EstadoResponseDTO.valueOf(repository.findEstado(nome));
    }

    @Override
    public List<Estado> procurartodos(Integer page, Integer pageSize) {
        PanacheQuery<Estado> query = null;
        if (page == null || pageSize == null)
            query = repository.find("ORDER BY id");
        else 
            query = repository.find("ORDER BY id").page(page, pageSize);

        return query.list();
    }

    @Override
    public long count() {
return repository.findAll().count();
    }
   
}
