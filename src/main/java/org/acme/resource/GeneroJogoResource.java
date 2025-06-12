package org.acme.resource;

import java.util.List;

import org.acme.dto.GeneroJogoDTO;
import org.acme.dto.GeneroJogoResponseDTO;
import org.acme.model.GeneroJogo;
import org.acme.model.Jogo;
import org.acme.model.Municipio;
import org.acme.service.GeneroJogoImpl;
import org.acme.service.JogoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
@Path("/generojogos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class GeneroJogoResource {
    @Inject
    GeneroJogoImpl generoJogoService;

    @POST
    public GeneroJogoResponseDTO incluir(@Valid GeneroJogoDTO dto) {
        return generoJogoService.inserir(dto);
    }

    @PUT
    @Path("/{id}")
    public void alterar(@PathParam("id") Long id, GeneroJogoDTO jogoDTO) {
        generoJogoService.alterar(id,jogoDTO);
    }

    @DELETE
    @Path("/{id}")
    public void apagar(@PathParam("id")Long id) {
       generoJogoService.deletar(id);
    }

    @GET
    @Path("/nome/{nome}")
    @Transactional
    public GeneroJogoResponseDTO procurarGeneroJogo(@PathParam("nome") String nome) {
     return  generoJogoService.procurarNome(nome);
    }
    // @GET
    // @Path("/id/{id}")
    // public GeneroJogoResponseDTO procuraGeneroJogoId(@PathParam("id") Long id) {
    // return  generoJogoService.procurarjogo(id);
    // }
    
     @GET
    public List<GeneroJogo> procuraTodos(@QueryParam("page") @DefaultValue("0") int page,@QueryParam("page_size") @DefaultValue("100") int pageSize) { 
        return generoJogoService.procurartodos(page, pageSize);
    }

        @GET
    @Path("/count")
    public long total() {
        return generoJogoService.count();
    } 
}

