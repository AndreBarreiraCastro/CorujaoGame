package org.acme.resource;

import java.util.List;

import org.acme.dto.EstadoDTO;
import org.acme.dto.EstadoResponseDTO;
import org.acme.model.Estado;
import org.acme.repository.EstadoRepository;
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
@Path("/estados")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class EstadoResource {
    @Inject
    Estadoservice estadoService;
    @Inject
    EstadoRepository repository;

    @POST
    public EstadoResponseDTO incluir(@Valid EstadoDTO dto) {
        return estadoService.inserir(dto);
    }

    @PUT
    @Path("/alterar/{id}")
    public void alterar(@PathParam("id") Long id,Estado estado) {
        estadoService.alterar(id,estado);
    }

    @DELETE
    @Path("/apagar/{id}")
    public void apagar(@PathParam("id")Long id) {
       estadoService.deletar(id);
    }

    // @GET
    // @Path("/nome/{nome}")
    // @Transactional
    // public EstadoResponseDTO procurarEstado(@PathParam("nome") String nome) {
    //  return  estadoService.procurarNome(nome);
    // }
    @GET
    @Path("/id/{id}")
    public EstadoResponseDTO procurarEstadoId(@PathParam("id") Long id) {
    return  estadoService.procurarEstado(id);
    }
    
    @GET
    public List<Estado> procuraTodos(@QueryParam("page") @DefaultValue("0") int page,@QueryParam("page_size") @DefaultValue("100") int pageSize) { 
        return estadoService.procurartodos(page, pageSize);
    }
@GET
@Path("/buscar/{nome}")
@Produces(MediaType.APPLICATION_JSON)
public List<Estado> buscarPorNome(@PathParam("nome") String nome) {
    return repository.find("nome like ?1", "%" + nome + "%").list();
}

@GET
@Path("/count")
public Long countEstados() {
    return estadoService.count();
}

}

