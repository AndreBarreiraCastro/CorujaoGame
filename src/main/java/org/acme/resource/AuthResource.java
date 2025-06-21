package org.acme.resource;


import org.acme.dto.AuthDTO;
import org.acme.dto.UsuarioResponseDTO;
import org.acme.repository.UsuarioRepository;
import org.acme.service.Hashservice;
import org.acme.service.JwtService;
import org.acme.service.UsuarioService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    Hashservice hashService;

    @Inject
    JwtService jwtService;

    @Inject
    UsuarioService usuarioService;
    @Inject
    UsuarioRepository usuarioRepository;

       @POST
    public Response login(AuthDTO authDTO) {
        String hash = hashService.getHashSenha(authDTO.getSenha());

        UsuarioResponseDTO usuario = usuarioService.findByUsernameAndSenha(authDTO.getUsername(), hash);

        if (usuario == null || usuario.idperfilUsuario().getId() ==2 ) {
            return Response.status(Status.NOT_FOUND)
                .entity("Usuario não encontrado").build();
        } 
        return Response.ok(usuario)
            .header("Authorization", jwtService.generateJwt(usuario))
            .build();
        
    }
    
}