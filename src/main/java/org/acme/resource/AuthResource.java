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

@Path("auth")
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
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(AuthDTO dto) {
        String hash = null;
        try {
            hash = hashService.getHashSenha(dto.getSenha());
            System.out.println(hash);
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }

        UsuarioResponseDTO usuario = usuarioService.findByUsernameAndSenha(dto.getUsername(), hash);

        if (usuario == null) 
          return Response.noContent().build();
        
        String token = jwtService.generateJwt(usuario);
        return Response.ok().header("Authorization", token).build();
            
    }
    
}