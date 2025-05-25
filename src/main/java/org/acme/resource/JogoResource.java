package org.acme.resource;

import java.util.List;

import org.acme.dto.JogoDTO;
import org.acme.dto.JogoResponseDTO;
import org.acme.model.Jogo;
import org.acme.service.JogoService;
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
@Path("/jogos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class JogoResource {
    @Inject
    JogoService jogoService;

    @POST
    public JogoResponseDTO incluir(@Valid JogoDTO dto) {
        return jogoService.inserir(dto);
    }

    @PUT
    @Path("/{id}")
    public void alterar(@PathParam("id") Long id, JogoDTO jogoDTO) {
        jogoService.alterar(id,jogoDTO);
    }

    @DELETE
    @Path("/{id}")
    public void apagar(@PathParam("id")Long id) {
       jogoService.deletar(id);
    }

    @GET
    @Path("/nome/{nome}")
    @Transactional
    public JogoResponseDTO procurarJogo(@PathParam("nome") String nome) {
     return  jogoService.procurarNome(nome);
    }
    @GET
    @Path("/id/{id}")
    public JogoResponseDTO procuraJogoId(@PathParam("id") Long id) {
    return  jogoService.procurarjogo(id);
    }
    
    @GET
     @Path("/procura todos")
    public List<Jogo> procuraTodos() {
    return  jogoService.procurartodos();
    }
}

