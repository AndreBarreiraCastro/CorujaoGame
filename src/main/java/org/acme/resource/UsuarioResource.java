package org.acme.resource;

import java.io.IOException;
import java.util.List;

import org.acme.dto.EstadoDTO;
import org.acme.dto.MunicipioDTO;
import org.acme.dto.UsuarioDTO;
import org.acme.dto.UsuarioResponseDTO;
import org.acme.dto.MunicipioResponseDTO;
import org.acme.form.UsuarioImageForm;
import org.acme.model.Estado;
import org.acme.model.Municipio;
import org.acme.model.Usuario;
import org.acme.repository.UsuarioRepository;
import org.acme.service.MinIOService;
import org.acme.service.UsuarioService;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import io.vertx.core.cli.annotations.DefaultValue;
import jakarta.annotation.security.RolesAllowed;
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
//import jakarta.ws.rs.DefaultValue;
@Path("/usuarios")
@RolesAllowed({"admin", "user"})
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    @Inject
    UsuarioService usuarioService;
    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    MinIOService minIOService;

    @POST
    @Transactional
    public UsuarioResponseDTO incluir(@Valid UsuarioDTO dto) {
        return usuarioService.insert(dto);
    }

     @GET
    @Path("/id/{id}")
    public Usuario procurarUsuarioId(@PathParam("id") Long id) {
    return  usuarioRepository.findById(id);
    } 

   @GET
    @Path("/nome/{nome}")
  @Produces(MediaType.APPLICATION_JSON)
public List<Usuario> procuraMunicipio(@PathParam("nome") String nome) {
    return usuarioRepository.find("nome like ?1", "%" + nome + "%").list();
}

    @DELETE
    @Path("/{id}")
    @Transactional
    public void apagar(Long id) {
       usuarioService.delete(id);
    }


    @GET
    @Path("/imagem/{nome}")
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
@Transactional
public Response salvarImagem(@MultipartForm UsuarioImageForm form) {
    // 1. Buscar usuário pelo ID
    Usuario usuario = usuarioRepository.findById(form.getIdUsuario());
    if (usuario == null) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity("Usuário não encontrado com ID: " + form.getIdUsuario())
                .build();
    }

    try {
        // 2. Salvar no MinIO
        byte[] imagemBytes = form.getImagem();
        String nomeImagem = form.getNomeImagem();
        minIOService.salvarImagem(imagemBytes, nomeImagem);

        // 3. Atualizar usuário com nome da imagem
        usuario.setImagemPerfil(nomeImagem);
        usuarioRepository.persist(usuario);

        return Response.ok().entity("Imagem salva e vinculada ao usuário com sucesso.").build();
    } catch (Exception e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Erro ao processar a imagem: " + e.getMessage())
                .build();
    }
}




    @GET
    public List<Usuario> procuraTodos(@QueryParam("page") @jakarta.ws.rs.DefaultValue("0") int page,@QueryParam("page_size") @jakarta.ws.rs.DefaultValue("100") int pageSize) { 
        return usuarioService.procurartodos(page, pageSize);
    }
    @GET
    @Path("/count")
    public long total() {
        return usuarioRepository.count();
    }  

        @PUT
    @Path("/alterar")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
    public Response alterar(@Valid UsuarioDTO usuario) {
        return usuarioService.alterar(usuario);
        
    }
}
