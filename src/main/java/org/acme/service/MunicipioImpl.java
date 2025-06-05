package org.acme.service;

import java.util.List;

import org.acme.dto.MunicipioDTO;
import org.acme.dto.MunicipioResponseDTO;
import org.acme.model.Estado;
import org.acme.model.Municipio;
import org.acme.repository.EstadoRepository;
import org.acme.repository.MunicipioRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
@ApplicationScoped
public class MunicipioImpl implements MunicipioService {

    @Inject MunicipioRepository repository;
    @Inject EstadoRepository estadorepository;

    @Override
    public Response inserir(@Valid MunicipioDTO municipio) {
        Municipio novoMunicipio = new Municipio();
        novoMunicipio.setNome(municipio.getNome());
        novoMunicipio.setSigla(municipio.getSigla());
        novoMunicipio.setEstadoMunicipio(estadorepository.findById(municipio.getEstado().getId()));
        repository.persist(novoMunicipio);
        return Response.status(Response.Status.CREATED)
        .entity(MunicipioResponseDTO.valueOf(novoMunicipio)).build();
    }

    @Override
    public Response alterar( MunicipioDTO municipioDTO) {
        Municipio municipioAlterado = new Municipio();
        municipioAlterado = repository.findById(municipioDTO.getidMunicipio());
        if(municipioAlterado.getNome()!= municipioDTO.getNome() && municipioDTO.getNome()!=null){
            municipioAlterado.setNome(municipioDTO.getNome());
        }
        if(municipioAlterado.getSigla()!=municipioDTO.getSigla() && municipioDTO.getSigla()!=null){
            municipioAlterado.setSigla(municipioDTO.getSigla());
        }
        if(municipioAlterado.getEstadoMunicipio()!=municipioDTO.getEstado() && municipioDTO.getEstado()!=null){
            municipioAlterado.setEstadoMunicipio(municipioDTO.getEstado());
        }
        return Response.ok().entity(MunicipioResponseDTO.valueOf(municipioAlterado)).build();
    }

@Override
@Transactional
public MunicipioResponseDTO procurarMunicipio(Long id) {
 Municipio municipio = repository.findById(id);
 if(municipio==null){
    throw new IllegalArgumentException("Município não pode ser nulo"+ municipio);
 }
    if (municipio == null) {
        throw new NotFoundException("Município não encontrado com id: " + id);
    }
    return MunicipioResponseDTO.valueOf(municipio);
}


    @Override
    public Response deletar(Long id) {
        repository.delete(repository.findById(id));
       return Response.ok().build();
    }

    @Override
    @Transactional
    public MunicipioResponseDTO procurarNome(String nome) {
        return MunicipioResponseDTO.valueOf(repository.findByNome(nome));
    }
    
 @Override
    public List<Municipio> procurartodos(Integer page, Integer pageSize) {
        PanacheQuery<Municipio> query = null;
        if (page == null || pageSize == null)
            query = repository.findAll();
        else 
            query = repository.findAll().page(page, pageSize);

        return query.list();
    }

 @Override
 public long count() {
   return repository.findAll().count();
 }

    
}
