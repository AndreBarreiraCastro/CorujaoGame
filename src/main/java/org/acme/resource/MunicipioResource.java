package org.acme.resource;

import java.util.List;

import org.acme.dto.EstadoResponseDTO;
import org.acme.dto.MunicipioDTO;
import org.acme.dto.MunicipioResponseDTO;
import org.acme.model.Estado;
import org.acme.model.Municipio;
import org.acme.repository.MunicipioRepository;
import org.acme.service.MunicipioService;
import jakarta.ws.rs.core.Response;
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
@Path("/municipios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class MunicipioResource {
    @Inject
    MunicipioService municipioService;
    @Inject
    MunicipioRepository repository;
    @POST
    @Path("/")
    public Response incluir(@Valid MunicipioDTO dto) {
       return municipioService.inserir(dto); 
    }

    @PUT
    @Path("/alterar")
    @Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
    public Response alterar(@Valid MunicipioDTO municipio) {
        return municipioService.alterar(municipio);
        
    }

    @DELETE
    @Path("/{id}")
    public Response apagar(@Valid @PathParam("id")Long id) {
     return  municipioService.deletar(id);
    }
    @GET
    @Path("/nome/{nome}")
  @Produces(MediaType.APPLICATION_JSON)
public List<Municipio> procuraMunicipio(@PathParam("nome") String nome) {
    return repository.find("nome like ?1", "%" + nome + "%").list();
}
    
   @GET
    public List<Municipio> procuraTodos(@QueryParam("page") @DefaultValue("0") int page,@QueryParam("page_size") @DefaultValue("100") int pageSize) { 
        return municipioService.procurartodos(page, pageSize);
    }
 @GET
    @Path("/id/{id}")
    public MunicipioResponseDTO procurarMunicipioId(@PathParam("id") Long id) {
    return  municipioService.procurarMunicipio(id);
    }
       @GET
    @Path("/count")
    public long total() {
        return municipioService.count();
    }    
}

