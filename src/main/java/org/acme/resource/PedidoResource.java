package org.acme.resource;

import org.acme.dto.PedidoResponseDTO;
import org.acme.dto.PedigoDTO;
import org.acme.service.PedidoService;
import org.eclipse.microprofile.jwt.JsonWebToken;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("pedido")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoResource {

    @Inject
    JsonWebToken jwt;

    @Inject
    PedidoService pedidoService;
    
    @POST
    @RolesAllowed({"user"})
    @Path("/criarpedido")
    public Response criarPedido(PedigoDTO dto) { 

        // obtendo o username do token
        String username = jwt.getSubject();

        // criando no bd o pedido 
        PedidoResponseDTO pedido = pedidoService.create(dto, username);

        return Response.ok().entity(pedido).build();
    }

}