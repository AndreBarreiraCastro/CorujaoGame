package org.acme.resource;

import java.util.List;

import org.acme.dto.JogoDTO;
import org.acme.dto.JogoResponseDTO;
import org.acme.model.Jogo;
import org.acme.model.Municipio;
import org.acme.repository.JogoRepository;
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
@Path("/jogos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class JogoResource {
    @Inject
    JogoService jogoService;
    @Inject 
    JogoRepository jogoRepository;

    @POST
    @Path("/inserir")
    public JogoResponseDTO incluir(@Valid JogoDTO dto) {
        return jogoService.inserir(dto);
    }

    @PUT
    @Path("/alterar")
    public void alterar(JogoDTO jogoDTO) {
        jogoService.alterar(jogoDTO);
    }

    @DELETE
    @Path("/{id}")
    public void apagar(@PathParam("id")Long id) {
       jogoService.deletar(id);
    }

    @GET
    @Path("/buscar/{nome}")
    @Transactional
     @Produces(MediaType.APPLICATION_JSON)
public List<Jogo> procuraJogo(@PathParam("nome") String nome) {
    return jogoRepository.find("nome like ?1", "%" + nome + "%").list();
}
    @GET
    @Path("/id/{id}")
    public JogoResponseDTO procuraJogoId(@PathParam("id") Long id) {
    return  jogoService.procurarjogo(id);
    }
    
    @GET
    public List<Jogo> procuraTodos(@QueryParam("page") @DefaultValue("0") int page,@QueryParam("page_size") @DefaultValue("100") int pageSize) { 
        return jogoService.procurartodos(page, pageSize);
    }
      @GET
    @Path("/count")
    public long total() {
        return jogoService.count();
    }    
}


