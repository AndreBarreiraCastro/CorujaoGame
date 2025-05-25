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
    public EstadoResponseDTO alterar(Long id, EstadoDTO estado) {
        Estado novoEstado = repository.findById(id);

                if(novoEstado.getNome()!= estado.getNome() && estado.getNome()!=null){
            novoEstado.setNome(estado.getNome());
        }
        if(novoEstado.getSigla()!=estado.getSigla() && estado.getSigla()!=null){
            novoEstado.setSigla(estado.getSigla());
        }
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
    public List<Estado> procurartodos() {
        return repository.listAll();
    }
   
}
