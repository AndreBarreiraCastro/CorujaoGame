package org.acme.service;

import java.util.List;

import org.acme.dto.UsuarioResponseDTO;
import org.acme.dto.UsuarioDTO;
import org.acme.dto.UsuarioResponseDTO;
import org.acme.model.Usuario;
import org.acme.model.Perfil;
import org.acme.model.Usuario;
import org.acme.repository.UsuarioRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class UsuarioImpl implements UsuarioService{

    @Inject
    UsuarioRepository repository;


     @Override
    public List<Usuario> procurartodos(Integer page, Integer pageSize) {
        PanacheQuery<Usuario> query = null;
        if (page == null || pageSize == null)
            query = repository.findAll();
        else 
            query = repository.findAll().page(page, pageSize);

        return query.list();
    }
     @Override
    @Transactional
    public UsuarioResponseDTO insert(UsuarioDTO dto) {
       
        if (repository.findByUsername(dto.nome()) != null) {
            throw new ValidationException("nome");
        }
     
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(dto.nome());
        novoUsuario.setCpf(dto.cpf());
        novoUsuario.setSobrenome(dto.sobrenome());
        novoUsuario.setTelefone(dto.telefone());
        novoUsuario.setEmail(dto.email());
        novoUsuario.setPerfilUsuario(dto.idperfilUsuario());

        repository.persist(novoUsuario);

        return UsuarioResponseDTO.valueOf(novoUsuario);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO update(UsuarioDTO dto) {
        return null;

    }

    @Override
    @Transactional
    public void delete(Long id) {
    }

    @Override
    public UsuarioResponseDTO findById(Long id) {
         return null;
    }

    @Override
    public List<UsuarioResponseDTO> findByNome(String nome) {
             return null;
    }

  @Override
public Response alterar(UsuarioDTO usuarioDTO) {
    Usuario usuario = repository.findById(usuarioDTO.id());
    if (usuario == null) {
        return Response.status(Response.Status.NOT_FOUND)
                       .entity("Usuário não encontrado com ID: " + usuarioDTO.id())
                       .build();
    }

    if (usuarioDTO.nome() != null && !usuarioDTO.nome().equals(usuario.getNome())) {
        usuario.setNome(usuarioDTO.nome());
    }

    if (usuarioDTO.sobrenome() != null && !usuarioDTO.sobrenome().equals(usuario.getSobrenome())) {
        usuario.setSobrenome(usuarioDTO.sobrenome());
    }

    if (usuarioDTO.telefone() != null && !usuarioDTO.telefone().equals(usuario.getTelefone())) {
        usuario.setTelefone(usuarioDTO.telefone());
    }

    if (usuarioDTO.cpf() != null && !usuarioDTO.cpf().equals(usuario.getCpf())) {
        usuario.setCpf(usuarioDTO.cpf());
    }

    if (usuarioDTO.email() != null && !usuarioDTO.email().equals(usuario.getEmail())) {
        usuario.setEmail(usuarioDTO.email());
    }

    if (usuarioDTO.idperfilUsuario() != null && !usuarioDTO.idperfilUsuario().equals(usuario.getPerfilUsuario())) {
        usuario.setPerfilUsuario(usuarioDTO.idperfilUsuario());
    }

    repository.persist(usuario);

    return Response.ok().entity(UsuarioResponseDTO.valueOf(usuario)).build();
}


    // @Override
    // public List<UsuarioResponseDTO> findByAll() {
    //     return repository.listAll().stream()
    //         .map(e -> UsuarioResponseDTO.valueOf(e)).toList();
    // }
    
}
