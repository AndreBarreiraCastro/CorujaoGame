package org.acme.resource;

import java.io.IOException;
import java.util.List;

import org.acme.dto.EstadoDTO;
import org.acme.dto.MunicipioDTO;
import org.acme.dto.MunicipioResponseDTO;
import org.acme.form.UsuarioImageForm;
import org.acme.model.Estado;
import org.acme.model.Municipio;
import org.acme.model.Usuario;
import org.acme.service.MinIOService;
import org.acme.service.MunicipioService;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import io.vertx.core.cli.annotations.DefaultValue;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
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

    @POST
    public MunicipioResponseDTO incluir(@Valid MunicipioDTO dto) {
        return municipioService.inserir(dto);
    }

    @PUT
    @Path("/{id}")
    public void alterar(@PathParam("id") Long id, MunicipioDTO municipio) {
        municipioService.alterar(id,municipio);
    }

    @DELETE
    @Path("/{id}")
    public void apagar(@PathParam("id")Long id) {
       municipioService.deletar(id);
    }

    @GET
    @Path("/nome/{nome}")
    @Transactional
    public MunicipioResponseDTO procurarMunicipio(@PathParam("nome") String nome) {
     return  municipioService.procurarNome(nome);
    }
    @GET
    @Path("/id/{id}")
    public MunicipioResponseDTO procurarMunicipioId(@PathParam("id") Long id) {
    return  municipioService.procurarMunicipio(id);
    }
    
    @GET
     @Path("/procura todos")
    public List<Municipio> procuraTodos() {
    return  municipioService.procurartodos();
    }
}

