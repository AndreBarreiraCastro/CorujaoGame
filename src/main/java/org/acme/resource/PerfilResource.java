package org.acme.resource;

import java.util.List;

import org.acme.dto.EstadoDTO;
import org.acme.dto.EstadoResponseDTO;
import org.acme.model.Estado;
import org.acme.model.Perfil;
import org.acme.repository.EstadoRepository;
import org.acme.repository.PerfilRepository;
import org.acme.service.Estadoservice;

import io.minio.credentials.AssumeRoleBaseProvider.Response;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.DefaultValue;
@Path("/perfis")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class PerfilResource {

    @Inject
    PerfilRepository repository;
    
    @GET
    public List<Perfil> procuraTodos() { 
        return repository.listAll();
    }
    @GET
    @Path("/procuraId/{id}")
    public Perfil procuraPorId(@PathParam("id") Long id) { 
        return repository.findById(id);
    }



}

