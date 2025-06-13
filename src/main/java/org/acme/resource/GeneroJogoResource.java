package org.acme.resource;

import java.util.List;

import org.acme.dto.GeneroJogoDTO;
import org.acme.dto.GeneroJogoResponseDTO;
import org.acme.dto.MunicipioResponseDTO;
import org.acme.model.Estado;
import org.acme.model.GeneroJogo;
import org.acme.model.Jogo;
import org.acme.model.Municipio;
import org.acme.repository.GeneroJogoRepository;
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

    @Inject
    GeneroJogoRepository generoJogoRepository;

    @POST
    public GeneroJogoResponseDTO incluir(@Valid GeneroJogoDTO dto) {
        return generoJogoService.inserir(dto);
    }

    @PUT
    @Path("/alterar")
    public void alterar( GeneroJogoDTO jogoDTO) {
        generoJogoService.alterar(jogoDTO);
    }

    @DELETE
    @Path("/apagar/{id}")
    public void apagar(@PathParam("id")Long id) {
       generoJogoService.deletar(id);
    }

  @GET
@Path("/buscar/{nome}")
@Produces(MediaType.APPLICATION_JSON)
public List<GeneroJogo> buscarPorNome(@PathParam("nome") String nome) {
    return generoJogoRepository.find("nome like ?1", "%" + nome + "%").list();
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

     @GET
    @Path("/id/{id}")
    public GeneroJogo procurarGeneroJogoId(@PathParam("id") Long id) {
    return  generoJogoRepository.findById(id);
    }
}

