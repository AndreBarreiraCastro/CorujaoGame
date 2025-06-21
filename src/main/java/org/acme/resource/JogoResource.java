package org.acme.resource;

import java.io.IOException;
import java.util.List;

import org.acme.dto.JogoDTO;
import org.acme.dto.JogoResponseDTO;
import org.acme.form.UsuarioImageForm;
import org.acme.model.Jogo;
import org.acme.model.Municipio;
import org.acme.model.Usuario;
import org.acme.repository.JogoRepository;
import org.acme.service.JogoService;
import org.acme.service.MinIOService;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
@Path("/jogos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class JogoResource {
    @Inject
    JogoService jogoService;
    @Inject 
    JogoRepository jogoRepository;

    
    @Inject
    MinIOService minIOService;


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
    @PATCH
@Path("/image/upload")
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Transactional
public Response salvarImagem(@MultipartForm UsuarioImageForm form) {
    // 1. Buscar usuário pelo ID
    Jogo jogo = jogoRepository.findById(form.getIdUsuario());
    if (jogo == null) {
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
        jogo.setImagens(nomeImagem);
        jogoRepository.persist(jogo);

        return Response.ok().entity("Imagem salva e vinculada ao usuário com sucesso.").build();
    } catch (Exception e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Erro ao processar a imagem: " + e.getMessage())
                .build();
    }
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
}


