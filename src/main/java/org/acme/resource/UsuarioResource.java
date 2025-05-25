package org.acme.resource;

import java.io.IOException;
import java.util.List;

import org.acme.dto.EstadoDTO;
import org.acme.dto.UsuarioDTO;
import org.acme.dto.UsuarioResponseDTO;
import org.acme.dto.MunicipioResponseDTO;
import org.acme.form.UsuarioImageForm;
import org.acme.model.Estado;
import org.acme.model.Usuario;
import org.acme.service.MinIOService;
import org.acme.service.UsuarioService;
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
@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    @Inject
    UsuarioService usuarioService;

    @Inject
    MinIOService minIOService;

    @POST
    public UsuarioResponseDTO incluir(@Valid UsuarioDTO dto) {
        return usuarioService.insert(dto);
    }

    @PUT
    @Path("/{id}")
    public void alterar(Long id, UsuarioDTO usuario) {
        usuarioService.update(usuario,id);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void apagar(Long id) {
       usuarioService.delete(id);
    }


    @GET
    @Path("/faixa/imagem/{nome}")
    @Produces("image/png") // ou image/jpeg, conforme necessário
    public Response downloadImagem(@PathParam("nome") String nome) {
        try {
            byte[] imagem = minIOService.downloadImagem(nome);
            return Response.ok(imagem).build();
        } catch (IOException e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                           .entity("Erro ao baixar imagem: " + e.getMessage())
                           .build();
        }
    }
    @PATCH
    @Path("/image/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@MultipartForm UsuarioImageForm form) {
        try {
            // Converte o InputStream do formulário em byte[]
            byte[] imagemBytes = form.getImagem();
    
            // Chama o serviço passando os dados
           minIOService.salvarImagem(imagemBytes, form.getNomeImagem());
    
            return Response.noContent().build();
        } catch (IOException e) {
            return Response.status(Status.CONFLICT)
            .entity("Erro ao salvar imagem: " + e.getMessage())
            .build();
        }
    }
}
