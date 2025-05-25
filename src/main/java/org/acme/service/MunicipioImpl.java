package org.acme.service;

import java.util.ArrayList;
import java.util.List;

import org.acme.dto.EstadoDTO;
import org.acme.dto.MunicipioDTO;
import org.acme.dto.MunicipioResponseDTO;
import org.acme.model.Estado;
import org.acme.model.Municipio;
import org.acme.repository.EstadoRepository;
import org.acme.repository.MunicipioRepository;

import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
@ApplicationScoped
public class MunicipioImpl implements MunicipioService {

    @Inject MunicipioRepository repository;
    @Inject EstadoRepository estadorepository;

    @Override
    public MunicipioResponseDTO inserir(MunicipioDTO municipio) {
        Municipio novoMunicipio = new Municipio();
        novoMunicipio.setNome(municipio.getNome());
        novoMunicipio.setSigla(municipio.getSigla());
        novoMunicipio.setEstadoMunicipio(estadorepository.findById(municipio.getEstadoMunicipio()));
        repository.persist(novoMunicipio);
        return MunicipioResponseDTO.valueOf(novoMunicipio);
    }

    @Override
    public MunicipioResponseDTO alterar(Long id, MunicipioDTO municipioDTO) {
        Municipio municipioAlterado = new Municipio();
        municipioAlterado = repository.findById(id);
        if(municipioAlterado.getNome()!= municipioDTO.getNome() && municipioDTO.getNome()!=null){
            municipioAlterado.setNome(municipioDTO.getNome());
        }
        if(municipioAlterado.getSigla()!=municipioDTO.getSigla() && municipioDTO.getSigla()!=null){
            municipioAlterado.setSigla(municipioDTO.getSigla());
        }
        if(municipioAlterado.getEstadoMunicipio().getId()!=municipioDTO.getEstadoMunicipio() && municipioDTO.getEstadoMunicipio()!=null){
            municipioAlterado.setEstadoMunicipio(estadorepository.findById(municipioDTO.getEstadoMunicipio()));
        }
        return MunicipioResponseDTO.valueOf(municipioAlterado);
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
    public void deletar(Long id) {
        repository.delete(repository.findById(id));
    }

    @Override
    @Transactional
    public MunicipioResponseDTO procurarNome(String nome) {
        return MunicipioResponseDTO.valueOf(repository.findByNome(nome));
    }

    @Override
    public List<Municipio> procurartodos() {

        return repository.listAll();

    
    }
    
}
