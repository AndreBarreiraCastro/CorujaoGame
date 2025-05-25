package org.acme.resource;

import java.util.List;

import org.acme.dto.EstadoDTO;
import org.acme.dto.EstadoResponseDTO;
import org.acme.model.Estado;
import org.acme.service.Estadoservice;
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
@Path("/estados")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class EstadoResource {
    @Inject
    Estadoservice estadoService;

    @POST
    public EstadoResponseDTO incluir(@Valid EstadoDTO dto) {
        return estadoService.inserir(dto);
    }

    @PUT
    @Path("/{id}")
    public void alterar(@PathParam("id") Long id, EstadoDTO estado) {
        estadoService.alterar(id,estado);
    }

    @DELETE
    @Path("/deletar/{id}")
    public void apagar(@PathParam("id")Long id) {
       estadoService.deletar(id);
    }

    @GET
    @Path("/nome/{nome}")
    @Transactional
    public EstadoResponseDTO procurarEstado(@PathParam("nome") String nome) {
     return  estadoService.procurarNome(nome);
    }
    @GET
    @Path("/id/{id}")
    public EstadoResponseDTO procurarEstadoId(@PathParam("id") Long id) {
    return  estadoService.procurarEstado(id);
    }
    
    @GET
     @Path("/procura todos")
    public List<Estado> procuraTodos() {
    return  estadoService.procurartodos();
    }
}

