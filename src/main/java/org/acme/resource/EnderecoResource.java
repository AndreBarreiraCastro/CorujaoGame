package org.acme.resource;

import org.acme.dto.EnderecoDTO;
import org.acme.dto.EnderecoResponseDTO;
import org.acme.model.Endereco;
import org.acme.service.EnderecoService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/enderecos")
@RolesAllowed({"admin", "user"})
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class EnderecoResource {

    @Inject
    EnderecoService service;

    @POST
    public Response inserir(EnderecoDTO dto) {
        EnderecoResponseDTO endereco = service.inserir(dto);
        return Response.status(Response.Status.CREATED).entity(endereco).build();
    }

    @GET
    public Response listarTodos() {
        List<Endereco> lista = service.buscartodos();
        return Response.ok(lista).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        EnderecoResponseDTO endereco = service.buscarId(id);
        return Response.ok(endereco).build();
    }

    @PUT
    public Response alterar(EnderecoDTO dto) {
        EnderecoResponseDTO endereco = service.alterar(dto);
        return Response.ok(endereco).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        service.deletar(id);
        return Response.noContent().build();
    }
}
